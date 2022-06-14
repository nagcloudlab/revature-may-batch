package com.example.oo;


class Mob {
}

class Iphone extends Mob {
}  // IS-A

class Person {
    Mob mob; // HAS-A
}


public class Has_A_vs_Is_A_Ex {
    public static void main(String[] args) {
        Person person = new Person();
        person.mob = new Iphone();
    }
}
