package com.example;

public class App {

    public static void main(String[] args) {


        System.getProperties()
                .forEach((key,value) -> {
                    System.out.println(key + "=" + value);
                });

    }
}
