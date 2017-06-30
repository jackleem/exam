package com.free.exam.thread;

import com.free.exam.model.Product;


import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Li Yu on 2017/6/28.
 */
public class Storage {
    private BlockingQueue<Product> blockingQueue;
    private Queue<Product> queue;

    public Storage(){
        blockingQueue = new LinkedBlockingQueue<Product>(10);
    }

    public Product pop() throws Exception{
        //System.out.println(queue.peek().toString());
        return blockingQueue.take();
    }

    public void push(Product product) throws Exception{
        blockingQueue.put(product);
    }
}
