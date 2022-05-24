package com.example.oo;

interface I1 {
    void m1();

    void m2();
}

interface I2 extends I1 {
    void m3();
}

interface I {
}

interface I3 extends I, I2 {
}

class C1 implements I1 {

    public void m1() {

    }

    public void m2() {

    }
}

class C2 implements I2 {

    public void m1() {

    }

    public void m2() {
    }

    public void m3() {

    }
}

public class InterfaceSyntax {
}
