package com.example;

public class App {
    public static void main(String[] args) {


        System.getProperties()
                .forEach((k,v)->{
                    System.out.println(k+"->"+v);
                });


    }
}
