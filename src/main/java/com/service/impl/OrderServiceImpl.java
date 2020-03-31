package com.service.impl;

import com.dao.BookDao;
import com.dao.UserDao;
import com.pojo.Book;
import com.service.OrderService;
import com.utils.DaoFactory;

import java.util.List;

/**
 * Created by Wan Yu on 2020/3/11
 */
public class OrderServiceImpl implements OrderService {
    //private UserDao userDao = DaoFactory.getInstance().createDao("dao.impl.UserDaoImpl",UserDao.class);
    private BookDao bookDao = DaoFactory.getInstance().createDao("com.dao.impl.BookDaoImpl",BookDao.class);


    //添加书
    public void addBook(Book book){
        bookDao.addBook(book);
    }

    //查询书byID
    public Book findBookByID(String id) {
        return bookDao.findBookByID(id);
    }

    //ByName
    public List<Book> findBookByName(String name) {
        return bookDao.findBookByName(name);
    }

    //ByAuthor
    public List<Book> findBookByAuthor(String author) {
        return bookDao.findBookByAuthor(author);
    }



}
