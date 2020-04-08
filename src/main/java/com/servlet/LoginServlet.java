package com.servlet;

import com.pojo.Users;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wan Yu on 2020/4/6
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            String id = req.getParameter("ID");
            String password = req.getParameter("Password");
            UserServiceImpl userService = new UserServiceImpl();
            Users users = userService.userLogin(id, password);
            if(users == null) {
                resp.sendError(400,"{\"message\":\"fail\"}");
                System.out.println("用户名或密码不正确");
                return;
            }
            resp.sendError(200,"{\"message\":\"success\"}");
            System.out.println("登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录失败");
            throw new RuntimeException(e);
        }

        doGet(req,resp);
    }
}
