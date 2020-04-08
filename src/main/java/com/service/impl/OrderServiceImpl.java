package com.service.impl;

import com.dao.BookDao;
import com.dao.OrderDao;
import com.dao.UserDao;
import com.pojo.Book;
import com.pojo.Cart;
import com.pojo.Orders;
import com.pojo.Users;
import com.service.OrderService;
import com.utils.DaoFactory;
import java.util.Calendar;

import java.util.List;

/**
 * Created by Wan Yu on 2020/3/11
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = DaoFactory.getInstance().createDao("com.dao.impl.OrderDaoImpl",OrderDao.class);

    public void addBookToCart(Cart cart, Book book) {
        cart.addToCart(book);
    }

    public void deleteBookFromCart(Cart cart, Book book) {
        cart.deleteFromCart(book);
    }

    public void createOrder(Orders orders) {
        orderDao.createOrder(orders);
    }

}
