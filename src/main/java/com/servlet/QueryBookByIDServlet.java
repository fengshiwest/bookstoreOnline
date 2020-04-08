package com.servlet;

import com.google.gson.Gson;
import com.pojo.Book;
import com.service.impl.BookServiceImpl;
import com.service.impl.OrderServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wan Yu on 2020/4/6
 */
public class QueryBookByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        findByID(req, resp);
        doGet(req,resp);
    }

    private void findByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            response.setContentType("text/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            BookServiceImpl bookService = new BookServiceImpl();
            Book book =  bookService.findBookByID(request.getParameter("ID"));
            PrintWriter out = response.getWriter();

            Gson  gson = new Gson();
            String bookJSON = gson.toJson(book);
            out.println(bookJSON);
            //response.sendError(200,bookJSON);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
            throw new RuntimeException(e);
        }

    }
}
