package com.example;

import java.util.concurrent.TimeUnit;

public class WaitNotify_Ex {

    static Object key = new Object();
    static String numberType = "odd";

    public static void main(String[] args) {

        Runnable evenNumberTask = () -> {
            for (int i = 1; i <= 50; i++) {
                synchronized (key) {
                    if (i % 2 == 0) {
                        try {
                            if (!numberType.equals("even")) {
                                key.wait();
                            }
                            TimeUnit.SECONDS.sleep(2);
                            System.out.println(i);
                            numberType = "odd";
                            key.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Runnable oddNumberTask = () -> {
            for (int i = 1; i <= 50; i++) {
                synchronized (key) {
                    if (i % 2 != 0) {
                        try {
                            if (!numberType.equals("odd")) {
                                key.wait();
                            }
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println(i);
                            numberType="even";
                            key.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Thread t1 = new Thread(evenNumberTask);
        Thread t2 = new Thread(oddNumberTask);

        t1.start();
        t2.start();


    }

}
