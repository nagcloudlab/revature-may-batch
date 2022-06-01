package com.example.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterateListColln_Ex {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("C");
        list.add("B");
        list.add("D");
        list.add("F");
        list.add("E");


        // hw to iterate list colln ?

//        way-1 : traditional loops
//        for (int i = 0; i < list.size(); i++) {
//            String e = list.get(i);
//            System.out.println(e);
//        }

        // way-2 : iterator

//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String ele = iterator.next();
//            System.out.println(ele);
//        }


//        // way-3 : Enhanced for Loop  ( JDK 1.5 )
//        for (String ele : list) {
//            System.out.println(ele);
//        }


    }

}
