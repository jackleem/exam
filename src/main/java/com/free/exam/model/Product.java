package com.free.exam.model;

/**
 * Created by Li Yu on 2017/6/28.
 */
public class Product {
    private String name;

    public Product(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product: "+this.name;
    }
}
