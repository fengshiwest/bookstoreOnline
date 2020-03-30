package com.service.impl;

import com.dao.BookDao;
import com.dao.UserDao;
import com.pojo.Book;
import com.service.OrderService;
import com.utils.DaoFactory;

/**
 * Created by Wan Yu on 2020/3/11
 */
public class OrderServiceImpl implements OrderService {
    private UserDao userDao = DaoFactory.getInstance().createDao("dao.impl.UserDaoImpl",UserDao.class);
    private BookDao bookDao = DaoFactory.getInstance().createDao("dao.impl.BookDaoImpl",BookDao.class);


    //添加书
    public void addBook(Book book){
        bookDao.addBook(book);
    }
}
