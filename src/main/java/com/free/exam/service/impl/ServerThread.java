package com.free.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import java.net.ServerSocket;

/**
 * Created by Li Yu on 2017/6/7.
 */
public class ServerThread implements Runnable {
    @Autowired
    private ServerSocket serverSocket;

    public ServerThread(ServerSocket serverSocket){

    }

    @Override
    public void run() {

    }
}
