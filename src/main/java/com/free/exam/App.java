package com.free.exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Li Yu on 2017/6/6.
 */
@SpringBootApplication
@MapperScan("com.cmsz.exam.dao.mapper")
public class App{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}