package com.servlet;

import com.google.gson.Gson;
import com.pojo.Users;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Wan Yu on 2020/4/6
 */
public class QueryUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=UTF-8");

        try {
            UserServiceImpl userService = new UserServiceImpl();
            Users user = userService.userQuery(req.getParameter("ID"));
            PrintWriter out = resp.getWriter();

            Gson gson = new Gson();
            String userJSON = gson.toJson(user);
            out.println(userJSON);
            //response.sendError(200,bookJSON);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
            throw new RuntimeException(e);
        }
    }
}
