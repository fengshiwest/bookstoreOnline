package com.servlet;

import com.pojo.Book;
import com.pojo.Users;
import com.service.impl.BookServiceImpl;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wan Yu on 2020/4/8
 */
public class AddOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=UTF-8");

        try {
            String bookID = req.getParameter("BookID");
            int bookNum = Integer.parseInt(req.getParameter("BookNum"));

            BookServiceImpl bookService = new BookServiceImpl();
            OrderServiceImpl orderService = new OrderServiceImpl();
            Book book = bookService.findBookByID(bookID);

            Users users = new Users();

            orderService.addOrder(users,book,bookNum);

            System.out.println("已添加到订单");
            //response.sendError(200,"{\"message\":\"success\"}");

        } catch (Exception e) {
            e.printStackTrace();
            //response.sendError(200,"{\"message\":\"fail\"}");
            System.out.println("添加到订单失败");
        }

        doGet(req,resp);
    }


}
