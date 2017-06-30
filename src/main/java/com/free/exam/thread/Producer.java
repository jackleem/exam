package com.free.exam.thread;

import com.free.exam.model.Product;

/**
 * Created by Li Yu on 2017/6/27.
 */
public class Producer implements Runnable {
    private String name;
    private Storage storage;

    public Producer(String name, Storage storage){
        this.name = "生产者:"+name;
        this.storage = storage;
    }

    @Override
        public void run() {
        try{
            while(true){
                Product product = new Product((int)(Math.random()*10000)+"");
                System.out.println(name+"准备生产:("+product.toString()+").");
                storage.push(product);
                System.out.println(name+"已生产入库:("+product.toString()+").");
                System.out.println("===========");
                Thread.sleep(500);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
