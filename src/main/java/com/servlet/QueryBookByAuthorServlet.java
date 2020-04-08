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
import java.util.List;
import java.util.Map;

/**
 * Created by Wan Yu on 2020/4/6
 */
public class QueryBookByAuthorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        findByAuthor(req, resp);
        doGet(req,resp);
    }

    private void findByAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {

            response.setContentType("text/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            BookServiceImpl bookService = new BookServiceImpl();
            List<Book> bookList =  bookService.findBookByAuthor(request.getParameter("Author"));

            PrintWriter out = response.getWriter();
            Map<String,Object> bookListMap = new HashMap<String, Object>();

            bookListMap.put("BookList",bookList);

            Gson gson = new Gson();
            String bookJSON = gson.toJson(bookListMap);
            out.println(bookJSON);
            //response.sendError(200,bookJSON);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
            throw new RuntimeException(e);
        }

    }
}
