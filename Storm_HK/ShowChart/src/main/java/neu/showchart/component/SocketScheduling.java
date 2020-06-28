package neu.showchart.component;


import neu.showchart.service.SocketService;
import neu.showchart.socket.WebSocket;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

@Component
public class SocketScheduling {

    @Resource(name="SocketService")
    SocketService socketService;
    //最大数据数
    int allinfos=0;

    @Resource(name = "WebSocket")
    WebSocket webSocket;



    //3.添加定时任务
    @Scheduled(cron = "0/30 * * * * ?")
    public void sendMessage(){
        int curinfos=socketService.getAllInfoSize();
        if(curinfos>allinfos&&allinfos!=0){
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            webSocket.sendMessage(dateFormat.format(System.currentTimeMillis())+"   "+"有"+(curinfos-allinfos)+"条新的报警信息！");
        }
        allinfos=curinfos;
    }


}
