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
public class RegisterServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=UTF-8");
        try {

            Users users = new Users();
            users.setId(Integer.parseInt(req.getParameter("ID")));
            users.setLogname(req.getParameter("Logname"));
            users.setPassword(req.getParameter("Password"));
            users.setEmail(req.getParameter("Email"));
            users.setGender(Long.parseLong(req.getParameter("Gender")));
            users.setSelfinfo(req.getParameter("Selfinfo"));
            users.setAdmin(Long.parseLong(req.getParameter("Admin")));

            UserServiceImpl userService = new UserServiceImpl();
            userService.userRegister(users);
            //resp.sendError(200,"{\"message\":\"success\"}");

            System.out.println("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            //response.sendError(200,"{\"message\":\"fail\"}");
            System.out.println("注册失败");

        }
        doGet(req,resp);
    }
}
