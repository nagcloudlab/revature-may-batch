package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex1 {

    public static void main(String[] args) {

        List<String> menu1 = new ArrayList<>();
        menu1.add("veg");
        menu1.add("nveg");
        menu1.add("veg");
        menu1.add("veg");
        menu1.add("nveg");

        // 1. imperative
//        Iterator<String> iterator1 = menu1.iterator();
//        while (iterator1.hasNext()) {
//            String item = iterator1.next();
//            if (item.equals("nveg")) {
//                iterator1.remove();
//            }
//        }

//        2. Declarative
        menu1.removeIf(e -> e.equals("nveg"));


        List<String> menu2 = new ArrayList<>();
        menu2.add("veg");
        menu2.add("nveg");
        menu2.add("veg");
        menu2.add("veg");
        menu2.add("nveg");


        // 2. imperative
//        Iterator<String> iterator2 = menu2.iterator();
//        while (iterator2.hasNext()) {
//            String item = iterator2.next();
//            if (item.equals("veg")) {
//                iterator2.remove();
//            }
//        }

        menu2.removeIf(e -> e.equals("veg"));

        System.out.println(menu1);
        System.out.println(menu2);

    }

}
