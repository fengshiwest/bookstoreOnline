package com.dao;

import com.pojo.Orders;

import java.util.List;

/**
 * Created by Wan Yu on 2020/3/31
 */
public interface OrderDao {

    //添加订单
    void createOrder(Orders orders);

    //查询订单按编号
    Orders findOrderByID(String id);



}
