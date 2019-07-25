package com.xreal.service;

import com.xreal.entity.User;
import com.xreal.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getById(long id) {
        return userDao.getNameById(id);
    }

    public int insert() {
        User user = new User();
        user.setUsername("insert");
        return userDao.insert(user);
    }
}