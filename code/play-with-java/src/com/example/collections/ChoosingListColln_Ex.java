package com.example.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ChoosingListColln_Ex {

    public static void main(String[] args) {
        compareListColln(new Vector<>());
        compareListColln(new ArrayList<>());
        compareListColln(new LinkedList<>());
    }

    public static void compareListColln(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
