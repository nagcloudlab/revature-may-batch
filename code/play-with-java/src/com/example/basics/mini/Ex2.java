package com.example.basics.mini;


class MyClass {

    static int staVar = 1;
    int insVar = 2;

    static void staMethod(MyClass ref) {
        System.out.println(staVar);
        MyClass r = new MyClass();
        System.out.println(r.insVar);
    }

    void insMethod() {
        System.out.println(staVar);
        System.out.println(insVar);
    }

}

public class Ex2 {

    public static void main(String[] args) {

        MyClass myIns = new MyClass();
        myIns.insMethod();

        MyClass.staMethod(myIns);

    }

}
