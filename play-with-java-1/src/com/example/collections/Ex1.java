package com.example.collections;

import com.example.collections.custom.LinkedList;

import java.util.ArrayList;

public class Ex1 {

    public static void main(String[] args) {

        LinkedList<String> students = new LinkedList<>();
        students.add("Alberto");
        students.add("Andrew");
        students.add("Benny");
        students.add(2, "Nag");

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        String[] stringArray=new String[10];
        ArrayList<String> arrayList=new ArrayList<>(1000);
        arrayList.add("s1");




    }

}
