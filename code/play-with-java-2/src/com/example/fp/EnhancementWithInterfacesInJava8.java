package com.example.fp;


interface L {
    void add(); // 1998

    void clear(); // 1998

    // jdk 1.8 , interface with default methods i.e with body
    default void forEach() {

    }

    static void staMethod() {
        //..
    }
}

class AL implements L {
    public void add() {

    }

    public void clear() {

    }
}

class LL implements L {
    public void add() {

    }

    public void clear() {

    }
}


public class EnhancementWithInterfacesInJava8 {
    public static void main(String[] args) {


    }
}
