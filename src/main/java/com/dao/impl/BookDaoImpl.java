package com.dao.impl;

import com.dao.BookDao;
import com.pojo.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wan Yu on 2020/3/11
 */
public class BookDaoImpl implements BookDao {

    //添加书籍
    public void addBook(Book book){

    }

    //按id查找书籍
    public Book findBookByID(String id){
        Book book = new Book();

        return book;
    }

    //按书名查找书籍
    public List<Book> findBookByName(String name){
        List<Book> bookList = new ArrayList<Book>();

        return bookList;

    }

    //按作者查找书籍
    public List<Book> findBookByAuthor(String author){
        List<Book> bookList = new ArrayList<Book>();

        return bookList;

    }




}
