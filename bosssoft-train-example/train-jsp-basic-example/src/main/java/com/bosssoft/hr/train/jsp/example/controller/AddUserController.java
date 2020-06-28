package com.bosssoft.hr.train.jsp.example.controller;

import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.service.UserService;
import com.bosssoft.hr.train.jsp.example.service.UserServiceImpl;


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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        User user = new User(null, userName, userCode, userPassword);
        boolean result = addUser(user);
        try {
            resp.getWriter().print(result);
        } catch (IOException e) {
            req.getRequestDispatcher("err.jsp").forward(req, resp);
        }
    }


    private boolean addUser(User user) {
        UserService userService = new UserServiceImpl();
        return userService.save(user);
    }

}
