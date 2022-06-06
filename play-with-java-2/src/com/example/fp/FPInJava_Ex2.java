package com.example.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FPInJava_Ex2 {

    public static void main(String[] args) {

        List<String> box1 = new ArrayList<String>();
        box1.add("item-1");
        box1.add("item-2");
        box1.add("item-3");
        box1.add("item-4");

//        for (String item : box1) {
//            System.out.println(item.toUpperCase());
//        }

        // or

        box1.forEach(new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        });

        List<String> box2 = new ArrayList<String>();
        box2.add("item-1");
        box2.add("item-2");
        box2.add("item-3");

//        for (String item : box2) {
//            System.out.println(item.toUpperCase());
//        }

        // -or-

        box2.forEach(item -> System.out.println(item.toUpperCase()));

        //-----------------------------------------------------

    }

}
