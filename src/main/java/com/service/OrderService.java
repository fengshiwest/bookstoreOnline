package com.service;

import com.pojo.Book;
import com.pojo.Cart;
import com.pojo.Orders;
import com.pojo.Users;

import java.util.List;

/**
 * Created by Wan Yu on 2020/3/11
 * 订单管理
 */
public interface OrderService {

    //添加书籍到购物车
    void addBookToCart(Cart cart, Book book);

    //从购物车移出书籍
    void deleteBookFromCart(Cart cart, Book book);

    //生成订单
    void createOrder(Orders orders);





}
