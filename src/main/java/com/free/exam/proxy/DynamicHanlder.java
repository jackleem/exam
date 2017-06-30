package com.free.exam.proxy;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Li Yu on 2017/6/13.
 */
@Component
public class DynamicHanlder implements InvocationHandler {

    private Object obj;

    public Object bind(Object obj){
        this.obj = obj;

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //可以执行AOP编程
        System.out.println("Before calling "+method);
        Object result = method.invoke(obj, args);
        System.out.println("After calling "+method);
        return result;
    }
}
