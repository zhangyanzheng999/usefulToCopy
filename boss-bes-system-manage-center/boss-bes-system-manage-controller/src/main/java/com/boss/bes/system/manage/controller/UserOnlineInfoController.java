package com.boss.bes.system.manage.controller;
import boss.bes.log.exception.code.enums.BaseCodeEnum;
import boss.bes.log.exception.type.AppException;
import boss.bes.log.exception.type.ServiceException;
import boss.bes.log.util.BuildResponse;
import boss.brs.xtrain.dataconvention.convention.CommonRequest;
import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import com.boss.bes.system.manage.mapper.UserMapper;
import com.boss.bes.system.manage.pojo.dto.UserOnlineInfoDTO;
import com.boss.bes.system.manage.pojo.dto.common.BaseDeleteDTO;
import com.boss.bes.system.manage.pojo.entity.User;
import com.boss.bes.system.manage.pojo.query.UserOnlineInfoPageQuery;
import com.boss.bes.system.manage.pojo.vo.UserOnlineInfoVO;
import com.boss.bes.system.manage.service.UserOnlineInfoService;
import com.boss.bes.system.manage.service.UserService;
import com.boss.bes.system.manage.util.ApplicationContextRegister;
import com.boss.bes.system.manage.util.BeanUtil;
import com.boss.bes.system.manage.util.WebsocketUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @author 小城大梦
 */
@RestController
@SuppressWarnings({"unchecked", "rawtypes"})
@RequestMapping("/education/bes/v1/system-manager-center/onlineUser")
@ServerEndpoint(value = "/education/bes/v1/system-manager-center/onlineUser/websocket/{id}")
public class UserOnlineInfoController {

    @Autowired
    UserOnlineInfoService userOnlineInfoService;

    @Autowired
    UserService userService;



    /**
     * 用来存在websocket数据
     */
    private static ConcurrentHashMap<Long, Session> webSocketSet = new ConcurrentHashMap<>();

    private static Logger log = LoggerFactory.getLogger(UserOnlineInfoController.class);

    /**
     * 连接建立成功调用的方法
     * 如果集合中已经存在一个相同的userId，则说明该用户已经在其它地方登陆，
     * 这时需要向前端发送消息1将前一次登陆下线
     * @param id  建立websocket连接时，由前端向后端传送用户的userId过来
     * @param session  建立session
     * @throws IOException  向前端发送信息使其下线的过程发生异常
     */
    @OnOpen
    public void onOpen(@PathParam(value = "id")Long id,Session session) throws IOException{
        //获取IP地址

        InetSocketAddress remoteAddress = WebsocketUtil.getRemoteAddress(session);
        String ip = String.valueOf(remoteAddress);
        //获取service
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        UserOnlineInfoService online = act.getBean(UserOnlineInfoService.class);
        UserMapper userMapper = act.getBean(UserMapper.class);

        User user = userMapper.getUserById(id);
        //设置在线用户数据
        UserOnlineInfoDTO userOnlineInfoDTO = new UserOnlineInfoDTO();
        userOnlineInfoDTO.setId(id);
        userOnlineInfoDTO.setName(user.getName());
        userOnlineInfoDTO.setCode(user.getCode());
        int result = 0;
        if(webSocketSet.get(id)!=null){
            webSocketSet.get(id).getBasicRemote().sendText("1");
            log.info("此用户此前已经在其它地方登陆过");
            result += online.update(userOnlineInfoDTO);
        }
        userOnlineInfoDTO.setIp(ip);
        result += online.insert(userOnlineInfoDTO);
        if(result ==0 ){
            log.info("建立连接出错");
        }
        webSocketSet.put(id,session);
    }


    @OnClose
    public void onClose(@PathParam(value = "id")Long id){
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        UserOnlineInfoService online = act.getBean(UserOnlineInfoService.class);

        if(webSocketSet.get(id)!=null){
            log.info("userId为 {} 的用户断开连接",id);
            webSocketSet.remove(id);
            UserOnlineInfoDTO userOnlineInfoDTO = new UserOnlineInfoDTO();
            userOnlineInfoDTO.setId(id);
            int result = online.update(userOnlineInfoDTO);
            if(result ==0){
                log.info("断开连接更新出错");
            }
        }else{
            log.info("id为空");
        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("webSocket发生错误！");
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        //服务器是tomcat的时候需要配置
        return new ServerEndpointExporter();
    }

    /**
     * 多个用户强制下线
     * @param commonRequest
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/offlineUserOnlineInfo")
    public CommonResponse<String> offlineUserOnlineInfo(@RequestBody CommonRequest<List<UserOnlineInfoDTO>> commonRequest){

        List<UserOnlineInfoDTO> userOnlineInfoDTOList = commonRequest.getBody();
        int result = userOnlineInfoService.updateList(userOnlineInfoDTOList);
        if(result == userOnlineInfoDTOList.size()){
            for(UserOnlineInfoDTO userOnlineInfoDTO : userOnlineInfoDTOList){
                Session session = webSocketSet.get(userOnlineInfoDTO.getId());
                if(session!=null){
                    try {
                        webSocketSet.get(userOnlineInfoDTO.getId()).getBasicRemote().sendText("2");
                    } catch (IOException e) {
                        throw new AppException(BaseCodeEnum.BASE_DATA_UPDATE_EXCEPTION);
                    }
                }
            }
            return BuildResponse.build("200","LogOutSuccess");
        }else if(result==0){
            return BuildResponse.build("26001","LogOutDefeat");
        }else{
            return BuildResponse.build("26002","multioperate");
        }
    }

    /**
     * 下线单个用户
     * @param commonRequest 前端请求
     * @return 返回给前端的数据
     */
    @PostMapping(value = "/update")
    public CommonResponse<String> update(@RequestBody CommonRequest<BaseDeleteDTO> commonRequest) {
        UserOnlineInfoDTO dto = new UserOnlineInfoDTO();

        BeanUtil.copyData(commonRequest.getBody(),dto);
        int status = userOnlineInfoService.getByPrimaryKey(dto.getId()).getStatus();
        if(status==1){
            return BuildResponse.build("26001","用户已下线，无需重复");
        }
        int result = userOnlineInfoService.update(dto);
        if(result == 1){
            Session session = webSocketSet.get(dto.getId());
            if(session!=null){
                try {
                    webSocketSet.get(dto.getId()).getBasicRemote().sendText("2");
                } catch (IOException e) {
                    throw new AppException(BaseCodeEnum.BASE_DATA_UPDATE_EXCEPTION);
                }
            }
            return BuildResponse.build("200","LogOutSuccess");
        }else{
            return BuildResponse.build("26002","LogOutDefeat");
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端的消息:{}" , message);
    }

    /**
     * 添加
     * @param commonRequest 前端请求
     * @return 返回给前端的数据
     */
    @PostMapping(value = "/add")
    public CommonResponse<String> add(@RequestBody CommonResponse<UserOnlineInfoVO> commonRequest){
        UserOnlineInfoDTO dto = new UserOnlineInfoDTO();
        BeanUtil.copyData(commonRequest.getBody(),dto);
        try{
            userOnlineInfoService.insert(dto);

        }catch (ServiceException e){
            log.info(e.getMessage());
        }
        return BuildResponse.build("200",null);
    }



    /**
     * 按条件查询
     * @param commonRequest 前端请求
     * @return 返回给前端的数据
     */
    @PostMapping(value = "/queryByCondition")
    public CommonResponse<PageInfo<UserOnlineInfoVO>> queryByCondition(@RequestBody CommonResponse<UserOnlineInfoPageQuery> commonRequest){

        PageInfo<UserOnlineInfoVO> userOnlineInfoVOPageInfo = userOnlineInfoService.queryByCondition(commonRequest.getBody());
        return BuildResponse.build("200",userOnlineInfoVOPageInfo);

    }

    @PostMapping(value = "/queryWithPage")
    public CommonResponse<PageInfo<UserOnlineInfoVO>> queryAll(@RequestBody CommonRequest<UserOnlineInfoPageQuery> commonRequest){

        PageInfo<UserOnlineInfoVO> userOnlineInfoVOPageInfo = userOnlineInfoService.queryWithPage(commonRequest.getBody());
        return BuildResponse.build("200",userOnlineInfoVOPageInfo);
    }


}
