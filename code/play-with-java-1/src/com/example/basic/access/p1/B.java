package com.example.basic.access.p1;

public class B extends A{

    public void m2(){
//        System.out.println(pri); , we cant inherit private members
        System.out.println(de);
        System.out.println(pro);
        System.out.println(pub);
    }

}
