package com.free.exam.service.impl;

import com.free.exam.dao.mapper.CountMapper;
import com.free.exam.model.User;
import com.free.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Li Yu on 2017/6/6.
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private CountMapper countMapper;

    @Override
    public List<User> getAllUsers() {
        List<User> users = countMapper.getAllUser();
        return users;
    }

    @Override
    public User getUserByName(String name) {
        User user = countMapper.getUserByName(name);
        return user;
    }
}
