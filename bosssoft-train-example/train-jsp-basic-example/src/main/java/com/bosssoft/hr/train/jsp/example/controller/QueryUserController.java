package com.bosssoft.hr.train.jsp.example.controller;

import com.bosssoft.hr.train.jsp.example.pojo.Query;
import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.service.UserService;
import com.bosssoft.hr.train.jsp.example.service.UserServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 11:22
 * @since
 **/
public class QueryUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<User> users = findUsersByName(name);
        req.getSession().setAttribute("users", users);
        //给jquery一个返回值吧
        JSONArray jsonArray = JSONArray.fromObject(users);
        resp.getWriter().println(jsonArray);


    }

    /**
     * 根据名字模糊搜索
     *
     * @param name
     * @return
     */
    private List<User> findUsersByName(String name) {
        UserService userService = new UserServiceImpl();
        Query query = new Query(name);
        return userService.queryByCondition(query);
    }
}
