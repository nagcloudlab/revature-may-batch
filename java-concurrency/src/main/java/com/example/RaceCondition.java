package com.example;

import java.util.concurrent.TimeUnit;

class CounterBox {
    private long count = 0;

    public synchronized void increment() {
        count++; // read existing value on count memory , increment by 1, write value back to memory
    }

    public long get() {
        return count;
    }
}

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {

        CounterBox cb = new CounterBox(); // shared resource for many threads

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                cb.increment();
            }
        };

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
        }
        for (Thread thread : threads) {
            thread.start();
        }

        TimeUnit.SECONDS.sleep(4);

        System.out.println(cb.get()); //  100000

    }
}
