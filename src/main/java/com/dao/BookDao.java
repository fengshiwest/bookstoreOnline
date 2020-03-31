package com.dao;

import com.pojo.Book;
import java.util.List;

/**
 * Created by Wan Yu on 2020/3/11
 */
public interface BookDao {

    //添加书籍
    void addBook(Book book);

    //按id查找书籍
    Book findBookByID(String id);

    //按书名查找书籍
    List<Book> findBookByName(String name);

    //按作者查找书籍
    List<Book> findBookByAuthor(String author);

    //删除书籍
    void deleteBook(String id);

    //更新书籍信息
    void updateBook(String id, Book book);



}
