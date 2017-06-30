package com.free.exam.dao;

import com.free.exam.model.User;
import com.free.exam.orm.EzOrm;
import com.free.exam.orm.impl.EzOrmBaseDao;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Li Yu on 2017/6/13.
 */
@Component
public class UserDao extends EzOrmBaseDao<User> implements EzOrm<User> {

    @Override
    public boolean save(User entity) {
        return false;
    }

    @Override
    public List<User> getAll() {
        System.out.println("Test");
        List<User> users = super.getAll();
        return users;
    }

    @Override
    public User getById(Long id) {
        System.out.println("Test");
        User user = super.getById(id);
        return user;
    }

    @Override
    public boolean remove(User entity) {
        return false;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }
}
