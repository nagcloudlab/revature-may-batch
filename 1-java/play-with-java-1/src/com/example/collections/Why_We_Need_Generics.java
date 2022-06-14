package com.example.collections;


class MyClass<E> {

    E item;

    public E getItem() {
        return item;
    }

}

public class Why_We_Need_Generics {

    public static void main(String[] args) {


        // we use generics, to create type-safety objects/methods

        MyClass<String> myClassWithStringItem = new MyClass();
        myClassWithStringItem.item = "hello";
//        myClassWithStringItem.item = 12; // error

    }

}
