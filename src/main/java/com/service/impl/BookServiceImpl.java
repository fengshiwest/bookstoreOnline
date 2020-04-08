package com.service.impl;

import com.dao.BookDao;
import com.pojo.Book;
import com.utils.DaoFactory;

import java.util.List;

/**
 * Created by Wan Yu on 2020/4/6
 */
public class BookServiceImpl {
    private BookDao bookDao = DaoFactory.getInstance().createDao("com.dao.impl.BookDaoImpl",BookDao.class);


    //添加书
    public void addBook(Book book){
        bookDao.addBook(book);
    }

    //查询书byID
    public Book findBookByID(String id) {
        return bookDao.findBookByID(id);
    }

    //ByAuthor
    public List<Book> findBookByAuthor(String author) {
        return bookDao.findBookByAuthor(author);
    }

}
