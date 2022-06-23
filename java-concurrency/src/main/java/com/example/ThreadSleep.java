package com.example;

import java.util.concurrent.TimeUnit;

public class ThreadSleep {
    public static void main(String[] args) {

        Runnable task1=()->{
            int i=0;
            while (i<10) {
                try {
//                    Thread.sleep(1000);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                i++;
            }
        };

        Thread thread=new Thread(task1,"NT");
        thread.start();

    }
}
