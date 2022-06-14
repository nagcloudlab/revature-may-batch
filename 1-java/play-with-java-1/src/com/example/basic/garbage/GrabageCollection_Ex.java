package com.example.basic.garbage;

import java.util.concurrent.TimeUnit;

class Box {
    int number; // 32
}

public class GrabageCollection_Ex {

    public static void main(String[] args) throws InterruptedException {

        Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());

        for (int i = 0; i < 1000000; i++) {
            Box box = new Box();
        }
        System.out.println(runtime.freeMemory());

        System.gc();

        TimeUnit.SECONDS.sleep(5);

        System.out.println(runtime.freeMemory());// 🤐


    }

}
