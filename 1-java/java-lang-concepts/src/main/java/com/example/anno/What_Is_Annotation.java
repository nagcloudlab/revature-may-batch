package com.example.anno;

import java.util.ArrayList;
import java.util.List;

class Super {
    public void abc() {
        System.out.println("Super:abc()");
    }
}

class Sub extends Super {

    @Override
    public void abc() {
        System.out.println("Sub:abc()");
    }

}


class Lib{
    /**
     *  2010
     *
     *  im recommending go with m11()
     */
    @Deprecated
    static void m1(){
        System.out.println("m1()");
    }

    /**
     * 2022
     */

    static void m11(){
        System.out.println("m11()");
    }
}


public class What_Is_Annotation {
    public static void main(String[] args) {

        Sub sub = new Sub();
        sub.abc();

        Lib.m1();
        Lib.m11();

        List<String> list1 = new ArrayList<String>();

        @SuppressWarnings("rawtypes")
        List list2=new ArrayList();

    }
}
