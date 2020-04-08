package com.service.impl;

import com.pojo.Users;
import com.service.UserService;

import com.dao.UserDao;
import com.utils.DaoFactory;

/**
 * Created by Wan Yu on 2020/4/6
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = DaoFactory.getInstance().createDao("dao.impl.UserDaoImpl",UserDao.class);

    public void userRegister(Users users) {
        userDao.userRegister(users);
    }

    public Users userLogin(String id, String password) {
        return userDao.userLogin(id, password);
    }

    public Users userQuery(String id) {
        return userDao.userQuery(id);
    }
}
