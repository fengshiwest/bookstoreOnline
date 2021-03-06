package com.servlet;

import com.pojo.Orders;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wan Yu on 2020/4/8
 */
public class CreatOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        createOrder(req, resp);
        doGet(req,resp);

    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.setContentType("text/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            String orderID = request.getParameter("orderID");
            String userAddress = request.getParameter("userAddress");
            String userTel = request.getParameter("userTel");

            if(userAddress.equals("") || userTel.equals("")){
                System.out.println("请完善订单信息！");
                return;
            }

            OrderServiceImpl orderService = new OrderServiceImpl();
            Orders order = orderService.findOrderByID(orderID);

            orderService.createOrder(order,userAddress, userTel);
            System.out.println("订单生成成功");

            //response.sendError(200,"{\"message\":\"success\"}");

        } catch (Exception e) {
            e.printStackTrace();
            //response.sendError(200,"{\"message\":\"fail\"}");
            System.out.println("订单生成失败");
        }
    }




}
