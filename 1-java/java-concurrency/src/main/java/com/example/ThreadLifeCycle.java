package com.example;

public class ThreadLifeCycle {
    public static void main(String[] args) {

        Runnable task = () -> {
            // -> Running
            String tName = Thread.currentThread().getName();
            for (int i = 0; i < 100; i++) {
                System.out.println(tName + " -> " + i);
            }
            // -> DEAD
        };

        Thread thread1 = new Thread(task, "Alberto");  // New
        Thread thread2 = new Thread(task, "Benny");
        Thread thread3 = new Thread(task, "Bryce");

        thread1.start(); // New -> Ready-To-Run / Runnable
        thread2.start();
        thread3.start();

    }
}
