package com.example.collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetColln_Ex {

    public static void main(String[] args) {

//        Set<String> set = new TreeSet<>(); // sorted
//        Set<String> set = new HashSet<>();   // un-ordered
        Set<String> set = new LinkedHashSet<>();   // ordered
        set.add("E");
        set.add("C");
        set.add("A");
        set.add("B");
        set.add("D");
        set.add("A");
        set.add("Z");
        set.add("P");

        for (String item : set) {
            System.out.println(item);
        }


    }

}
