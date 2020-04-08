package com.servlet;

import com.pojo.Book;
import com.service.impl.BookServiceImpl;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wan Yu on 2020/4/6
 */
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        add(req, resp);
        doGet(req,resp);
    }


    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            response.setContentType("text/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            Book book = new Book();
            book.setId(Integer.parseInt(request.getParameter("ID")));
            book.setName(request.getParameter("Name"));
            book.setAuthor(request.getParameter("Author"));
            book.setLanguage(Long.parseLong(request.getParameter("Language")));
            book.setCategory(Long.parseLong(request.getParameter("Category")));
            book.setCdrom(Long.parseLong(request.getParameter("Cdrom")));
            book.setCommend(Long.parseLong(request.getParameter("Commend")));
            book.setContent(request.getParameter("Content"));
            book.setPrice(Double.parseDouble(request.getParameter("Price")));
            book.setOnSaleTime(request.getParameter("On_Sale_Time"));
            book.setGoodPrice(Long.parseLong(request.getParameter("Good_Price")));
            book.setPublishName(request.getParameter("Publish_name"));
            book.setPublishAddress(request.getParameter("Publish_address"));
            book.setBookNum(Long.parseLong(request.getParameter("Book_Num")));

            BookServiceImpl bookService = new BookServiceImpl();
            bookService.addBook(book);
            //response.sendError(200,"{\"message\":\"success\"}");

            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            //response.sendError(200,"{\"message\":\"fail\"}");
            System.out.println("添加失败");
        }
    }
}
