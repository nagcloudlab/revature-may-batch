package com.example.generics;

interface Food {
}

class Veg implements Food {
}

class NonVeg implements Food {
}

// generic class
class Box<E extends Food> {
    E item;
}


public class Ex1 {

    public static void main(String[] args) {

        Box<Veg> vegBox = new Box<>();
        vegBox.item = new Veg();

        Box<NonVeg> nonVegBox = new Box<>();
        nonVegBox.item = new NonVeg();

        Box<Food> foodBox = new Box<>();
        foodBox.item = new NonVeg();


    }

}
