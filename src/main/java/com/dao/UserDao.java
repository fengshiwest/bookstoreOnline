package com.dao;

import com.pojo.Users;

/**
 * Created by Wan Yu on 2020/3/11
 */
public interface UserDao {

    //添加用户
    void addUser(Users users);

    //查询用户
    Users findUserByID(String id);

    //删除用户
    void deleteUser(String id);

    //更新用户
    void updateUser(String id, Users users);

    //查询密码 用于用户登录
    String queryPassword(Users users);

    //更改密码 用户用户更改密码
    void changePassword(Users users, String password);
}
