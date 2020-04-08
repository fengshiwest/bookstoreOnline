package com.servlet;

import com.pojo.Book;
import com.pojo.Orders;
import com.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by Wan Yu on 2020/4/8
 */
public class CreatOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            response.setContentType("text/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            Orders orders = new Orders();
            orders.setId(getTimeAsID());
            orders.setBookId();

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

    public static long getTimeAsID() {
        Calendar c = Calendar.getInstance();
        String year=String.valueOf(c.get(Calendar.YEAR));
        String month = c.get(Calendar.MONTH)+1 > 10 ? String.valueOf(c.get(Calendar.MONTH)+1) : "0" + String.valueOf(c.get(Calendar.MONTH)+1);
        String day = c.get(Calendar.DAY_OF_MONTH) > 10 ? String.valueOf(c.get(Calendar.DAY_OF_MONTH)) : "0" + c.get(Calendar.DAY_OF_MONTH);
        String hour = c.get(Calendar.HOUR_OF_DAY) > 10 ? String.valueOf(c.get(Calendar.HOUR_OF_DAY)) : "0" + c.get(Calendar.HOUR_OF_DAY);
        String minute = c.get(Calendar.MINUTE) > 10 ? String.valueOf(c.get(Calendar.MINUTE)) : "0" + c.get(Calendar.MINUTE);
        String second = c.get(Calendar.SECOND) > 10 ? String.valueOf(c.get(Calendar.SECOND)) : "0" + c.get(Calendar.SECOND);
        return Long.parseLong(year + month + day + hour + minute + second);
    }


}
