package com.example.oo;

class A extends Object {
    int x;

    A(int x) {
        super();
        this.x = x;
        System.out.println("Im A constructor");
    }

}

class B extends A {
    B(int x) {
        super(x);
        System.out.println("Im B constructor");
    }
}

class C extends B {
    C(int x) {
        super(x);
        System.out.println("Im C constructor");
    }
}

public class ConstructorExecutionFlow {
    public static void main(String[] args) {

        C c = new C(10);

    }
}
