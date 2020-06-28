package com.bosssoft.hr.train.jsp.example.controller;

import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.service.UserService;
import com.bosssoft.hr.train.jsp.example.service.UserServiceImpl;
import net.sf.json.JSONArray;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 11:22
 * @since
 **/
public class RemoveUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        boolean result = deleteUser(Integer.parseInt(id));
        JSONArray jsonArray=JSONArray.fromObject(result);
        resp.getWriter().println(jsonArray);
    }


    private boolean deleteUser(Integer id) {
        UserService userService = new UserServiceImpl();
        User user = new User(id, null);
        return userService.remove(user);
    }
}
