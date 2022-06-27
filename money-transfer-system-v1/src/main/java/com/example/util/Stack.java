package com.example.util;

import java.util.ArrayList;

public class Stack<E> {

    private ArrayList<E> arrayList=new ArrayList<>();

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public void push(E e) {
        arrayList.add(e);
    }

    public int size() {
        return arrayList.size();
    }

}
