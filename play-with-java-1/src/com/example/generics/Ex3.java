package com.example.generics;

class NewBox<E> {
    E item;
}

public class Ex3 {
    public static void main(String[] args) {

        NewBox<Integer> newBox = new NewBox<Integer>();
        newBox.item =123;

    }
}
