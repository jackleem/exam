package com.free.exam.dao.mapper;

import com.free.exam.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Li Yu on 2017/6/6.
 */
@Component
public interface CountMapper {
    @Select("select * from user")
    public List<User> getAllUser();

    @Select("select * from user where name = #{0}")
    public User getUserByName(String name);
}
