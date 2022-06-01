package com.example.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex4 {

    public static void main(String[] args) {


        List<String> menu = new ArrayList<>();
        menu.add("nveg");
        menu.add("nveg");
        menu.add("veg");
        menu.add("nveg");
        menu.add("veg");


        // way-1
//        Iterator<String> iterator = menu.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if (item.equals("nveg"))
//                iterator.remove();
//        }

        //way-2
        menu.removeIf(item -> item.equals("nveg"));

        System.out.println(menu);


    }

}
