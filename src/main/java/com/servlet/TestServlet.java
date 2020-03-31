package com.servlet;

import com.pojo.Book;
import com.service.impl.OrderServiceImpl;

/**
 * Created by Wan Yu on 2020/3/18
 */

/*
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("json"));
        resp.sendError(200,"{\"message\":\"okk\"}");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println(req.getParameter("p1"));
    }
}
*/

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import java.util.List;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println(req.getParameter("FindByAuthor"));

//        System.out.println(req.getParameter("ID"));
//        System.out.println(req.getParameter("Name"));
//        System.out.println(req.getParameter("Author"));
//        System.out.println(req.getParameter("Language"));
//        System.out.println(req.getParameter("Category"));
//        System.out.println(req.getParameter("Cdrom"));
//        System.out.println(req.getParameter("Commend"));
//        System.out.println(req.getParameter("Content"));
//        System.out.println(req.getParameter("Price"));
//        System.out.println(req.getParameter("On_Sale_Time"));
//        System.out.println(req.getParameter("Good_Price"));
//        System.out.println(req.getParameter("Publish_name"));
//        System.out.println(req.getParameter("Publish_address"));
//        System.out.println(req.getParameter("Book_Num"));

        System.out.println("get");

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
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

            OrderServiceImpl service = new OrderServiceImpl();
            service.addBook(book);
            //request.setAttribute("message", "添加成功");
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            //request.setAttribute("message", "添加失败");
            System.out.println("添加失败");
        }
        //request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    private void findByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        try {
            OrderServiceImpl service = new OrderServiceImpl();
            Book book =  service.findBookByID(request.getParameter("FindByID"));
            request.setAttribute("book",book);
            request.getRequestDispatcher("test.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
            throw new RuntimeException(e);
        }

    }

    private void findByAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        try {
            OrderServiceImpl service = new OrderServiceImpl();
            List<Book> bookList =  service.findBookByAuthor(request.getParameter("FindByAuthor"));
            //System.out.println(bookList);
            request.setAttribute("bookList",bookList);
            request.getRequestDispatcher("test.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
            throw new RuntimeException(e);
        }

    }




    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("post");

        //add(request,response);
        //findByID(request, response);
        findByAuthor(request,response);

        doGet(request, response);
    }
}
