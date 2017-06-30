package com.free.exam.thread;

import com.free.exam.model.Product;

/**
 * Created by Li Yu on 2017/6/27.
 */
public class Consumer implements Runnable{
    private String name;
    private Storage storage;

    public Consumer(String name, Storage storage){
        this.name = "消费者:"+name;
        this.storage = storage;
    }

    @Override
    public void run() {
        try{
            while(true){
                System.out.println(name+"准备消费产品");
                Product product = storage.pop();
                System.out.println(name+"已经消费产品:("+product.toString()+").");
                System.out.println("==========");
                Thread.sleep(5000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
