package com.servlet;

import com.google.gson.Gson;
import com.pojo.Orders;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wan Yu on 2020/4/8
 */
public class QueryAllUnfinishedOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {

            resp.setContentType("text/json;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");

            OrderServiceImpl orderService = new OrderServiceImpl();
            String userCID = req.getParameter("UserCID");
            List<Orders> orderList = orderService.findAllUnfinishedOrders();

            //PrintWriter out = resp.getWriter();

            Map<String,Object> orderListMap = new HashMap<String, Object>();

            orderListMap.put("OrderList",orderList);

            Gson gson = new Gson();
            String orderJSON = gson.toJson(orderListMap);

            //response.sendError(200,bookJSON);
            System.out.println("查询成功");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
            throw new RuntimeException(e);
        }
        doGet(req,resp);
    }

}
