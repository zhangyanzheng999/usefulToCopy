package com.bosssoft.hr.train.jsp.example.controller;

import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.service.UserService;
import com.bosssoft.hr.train.jsp.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 11:21
 * @since
 **/
public class AddUserController extends HttpServlet {
    /**
     *  用户对象
     */
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        //校验参数合法性如果没问题才调用
        User user=new User();
        if (req.getParameter("xx")!=null && !req.getParameter("xx").equals("")){

            try{
//if            //if(saveUser(user))

            }catch (Exception ex){

            }
        }else{

             // 错误应答或者跳转错误页面
        }


    }

    private boolean saveUser(User user){

           return  userService.save(user);

    }
}
