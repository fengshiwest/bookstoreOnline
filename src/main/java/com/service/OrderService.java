package com.service;

import com.pojo.Book;

import java.util.List;

/**
 * Created by Wan Yu on 2020/3/11
 * 订单管理
 */
public interface OrderService {

    //添加书
    void addBook(Book book);

    //查询书
    Book findBookByID(String id);

    List<Book> findBookByName(String name);

    List<Book> findBookByAuthor(String author);




}
