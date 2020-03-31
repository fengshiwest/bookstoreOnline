package com.dao.impl;

import com.dao.UserDao;
import com.pojo.Users;
import com.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by Wan Yu on 2020/3/17
 */
public class UserDaoImpl implements UserDao {
    public void addUser(Users users) {
        try{
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "insert into Users(ID, Logname, Password, Email, Gender, Selfinfo, Admin) values(?, ?, ?, ?, ?, ?, ?)";
            Object param[] = {users.getId(),users.getLogname(),users.getPassword(),users.getEmail(),users.getGender(),users.getSelfinfo(),users.getAdmin()};
            queryRunner.update(sql, param);

        }  catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Users findUserByID(String id) {
        try {
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "select * from users where ID = ?";
            return queryRunner.query(sql, id, new BeanHandler<Users>(Users.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public void deleteUser(String id) {
        try {
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "delete from users where ID = ?";
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public void updateUser(String id, Users users) {
        try{
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "update users set Logname=?, Password=?, Email=?, Gender=?, Selfinfo=?, Admin=? where  = " + id;
            Object param[] = {users.getLogname(), users.getPassword(), users.getEmail(), users.getGender(), users.getSelfinfo(), users.getAdmin()};
            queryRunner.update(sql, param);

        }  catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String queryPassword(Users users) {
        try {
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "select Password from users where ID = ?";
            return queryRunner.query(sql, users.getId(), new BeanHandler<String>(String.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void changePassword(Users users, String password) {
        try{
            QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
            String sql = "update users set Password=? where  = " + users.getId();
            queryRunner.update(sql, password);

        }  catch (SQLException e){
            e.printStackTrace();
        }
    }
}
