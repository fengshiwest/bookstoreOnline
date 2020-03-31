package com.dao.impl;

import com.dao.BookDao;
import com.pojo.Book;
import com.utils.JDBCUtil;

import java.beans.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * Created by Wan Yu on 2020/3/11
 */
public class BookDaoImpl implements BookDao {

    //添加书籍
    public void addBook(Book book){
        try{
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "insert into book(ID, Name, Author, Language, Category, Cdrom, Commend, Content, Price, On_Sale_Time, Good_Price, Publish_name, Publish_address, Book_Num) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object param[] = {book.getId(), book.getName(), book.getAuthor(), book.getLanguage(), book.getCategory(), book.getCdrom(), book.getCommend(), book.getContent(), book.getPrice(), book.getOnSaleTime(), book.getGoodPrice(), book.getPublishName(), book.getPublishAddress(), book.getBookNum()};
            queryRunner.update(sql, param);

        }  catch (SQLException e){
            e.printStackTrace();
        }

    }

    //按id查找书籍
    public Book findBookByID(String id){
        try {
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "select * from book where ID = ?";
            return queryRunner.query(sql, id, new BeanHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //按书名查找书籍
    public List<Book> findBookByName(String name){
        try {
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "select * from book where Name = ?";
            return queryRunner.query(sql, name, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    //按作者查找书籍
    public List<Book> findBookByAuthor(String author){
        try {
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "select * from book where Author = ?";
            return queryRunner.query(sql, author, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    //删除书籍
    public void deleteBook(String id) {
        try {
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "delete from book where ID = ?";
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    //更新书籍
    public  void updateBook(String id, Book book) {

        try{
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "update book set Name=?, Author=?, Language=?, Category=?, Cdrom=?, Commend=?, Content=?, Price=?, On_Sale_Time=?, Good_Price=?, Publish_name=?, Publish_address=?, Book_Num=? where id = " + id;
            Object param[] = {book.getName(), book.getAuthor(), book.getLanguage(), book.getCategory(), book.getCdrom(), book.getCommend(), book.getContent(), book.getPrice(), book.getOnSaleTime(), book.getGoodPrice(), book.getPublishName(), book.getPublishAddress(), book.getBookNum()};
            queryRunner.update(sql, param);

        }  catch (SQLException e){
            e.printStackTrace();
        }
    }






}
