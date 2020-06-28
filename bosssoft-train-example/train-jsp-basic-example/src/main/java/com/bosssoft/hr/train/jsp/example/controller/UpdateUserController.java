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
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 11:22
 * @since
 **/
public class UpdateUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String userName = req.getParameter("userName");
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        User user = new User(Integer.parseInt(userId), userName, userCode, userPassword);
        boolean result = modifyUser(user);

        resp.getWriter().print(result);
    }

    private boolean modifyUser(User user) {
        UserService userService = new UserServiceImpl();
        return userService.update(user);
    }
}
