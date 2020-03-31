package com.dao.impl;

import com.pojo.Book;
import com.pojo.Orders;
import com.dao.OrderDao;
import com.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Wan Yu on 2020/3/31
 */
public class OrderDaoImpl implements OrderDao {

    public void addOrder(Orders orders) {

        try{
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "insert into orders(ID, User_name, User_address, User_tel, User_CID, Book_id, Book_number, Status, Good_price) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object param[] = {orders.getId(),orders.getUserName(), orders.getUserAddress(), orders.getUserTel(), orders.getUserCid(), orders.getBookId(), orders.getBookNumber(), orders.getStatus(), orders.getGoodsPrice()};
            queryRunner.update(sql, param);

        }  catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Orders findOrderByID(String id) {
        try {
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "select * from orders where ID = ?";
            return queryRunner.query(sql, id, new BeanHandler<Orders>(Orders.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



}
