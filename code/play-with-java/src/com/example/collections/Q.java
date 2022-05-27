package com.example.collections;

import java.util.ArrayList;

public class Q {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        for (String item : arrayList) {
        }

        java.util.LinkedList<String> linkedList = new java.util.LinkedList<>();
        for (String item : linkedList) {
        }

        LinkedList<String> customLinkedList = new LinkedList<>(); // custom linkedList
        customLinkedList.add("alberto");
        customLinkedList.add("andrew");
        customLinkedList.add("benny");

        for (String name : customLinkedList) {
            System.out.println(name);
        }

    }

}
