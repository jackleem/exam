package com.free.exam.service;

import com.free.exam.model.User;

import java.util.List;

/**
 * Created by Li Yu on 2017/6/6.
 */
public interface UserService {
    List<User> getAllUsers();
    User getUserByName(String name);
}
