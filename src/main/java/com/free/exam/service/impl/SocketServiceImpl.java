package com.free.exam.service.impl;

import com.free.exam.model.User;
import com.free.exam.service.SocketService;
import com.free.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Li Yu on 2017/6/6.
 */
@Component
public class SocketServiceImpl implements SocketService {

    @Autowired
    private UserService userService;

    @Override
    public void getServerAndListen() {
        try{
            ServerSocket serverSocket = new ServerSocket(5209);
            System.out.println("Server start!");
            Socket server = serverSocket.accept();

            char chars[] = new char[1024];
            int len = 0;
            StringBuilder stringBuilder = new StringBuilder();

            BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));

            while((len = br.read(chars))!=-1){
                stringBuilder.append(new String(chars, 0 ,len));
            }
            System.out.println("Receive from client message=: " + stringBuilder);
            String userName = stringBuilder.toString();
            User user = userService.getUserByName(userName);

            Writer writer = new OutputStreamWriter(server.getOutputStream());
            writer.write(user.toString());
            writer.flush();

            writer.close();
            br.close();
            server.close();
            serverSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
