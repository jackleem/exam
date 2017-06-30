package com.free.exam.mutithread;

import com.free.exam.thread.Producer;
import com.free.exam.thread.Consumer;
import com.free.exam.thread.Storage;
import org.springframework.stereotype.Component;

/**
 * Created by Li Yu on 2017/6/27.
 */
@Component
public class ThreadStateStudy {

    public void test(){
        Storage storage = new Storage();
        Runnable producer1 = new Producer("IBM",storage);
        Runnable producer2 = new Producer("华为",storage);
        Runnable producer3 = new Producer("Google",storage);
        Runnable producer4 = new Producer("CMCC",storage);
        Runnable consumer1 = new Consumer("小明",storage);
        Runnable consumer2 = new Consumer("小红",storage);
        Runnable consumer3 = new Consumer("小兰",storage);
        Runnable consumer4 = new Consumer("阿紫",storage);

        Thread proThread1 = new Thread(producer1);
        Thread proThread2 = new Thread(producer2);
        Thread proThread3 = new Thread(producer3);
        Thread proThread4 = new Thread(producer4);
        Thread conThread1 = new Thread(consumer1);
        Thread conThread2 = new Thread(consumer2);
        Thread conThread3 = new Thread(consumer3);
        Thread conThread4 = new Thread(consumer4);

        proThread1.start();
        proThread2.start();
        proThread3.start();
        proThread4.start();
        conThread1.start();
        conThread2.start();
        conThread3.start();
        conThread4.start();
    }
}
