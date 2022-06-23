package com.example;

import java.util.concurrent.TimeUnit;

class House {

    private Object key1=new Object();
    private Object key2=new Object();

    public  void room1() {
      synchronized(key1){
          String tName = Thread.currentThread().getName();
          System.out.println(tName + " entering in room-1");
          try {
              TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println(tName + " leaving in room-1");
      }
    }

    public  void room2() {
      synchronized(key2){
          String tName = Thread.currentThread().getName();
          System.out.println(tName + " entering in room-2");
          try {
              TimeUnit.SECONDS.sleep(6);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println(tName + " leaving in room-2");
      }
    }

}


public class Synchronization {
    public static void main(String[] args) {

        House house1=new House();

        Runnable task1 = house1::room1;
        Runnable task2 = house1::room2;

        Thread thread1 = new Thread(task1, "Tom");
        Thread thread2 = new Thread(task2, "Jerry");

        thread1.start();
        thread2.start();

    }
}
