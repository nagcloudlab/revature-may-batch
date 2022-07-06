package com.example;

/*
 s/w
    2 types of tasks
    - computation
    - io
 */

import java.util.Scanner;

public class ConcurrentApp {

    public static void io() {
        System.out.println(Thread.currentThread().getName() + " started IO");
        System.out.println("enter your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
        System.out.println(Thread.currentThread().getName() + " finished IO");
    }

    public static void computation() {
        System.out.println(Thread.currentThread().getName() + " started Computation");
        for (int i = 0; i < 100; i++) {
            System.out.println("i->" + i);
        }
        System.out.println(Thread.currentThread().getName() + " finished Computation");
    }

    public static void main(String[] args) {

        long pid = ProcessHandle.current().pid();
        System.out.println(pid);

        System.out.println(Thread.currentThread().getName() + " start..");

        Runnable ioTask = () -> {
            io();
        };
        Thread ioThread = new Thread(ioTask,"IO");

        Runnable compTask = () -> {
            computation();
        };
        Thread compThread = new Thread(compTask,"COMPUTATION");

        ioThread.start(); // it become independent execution
        compThread.start();


//        System.out.println(Thread.currentThread().getName() + " end");

    }
}
