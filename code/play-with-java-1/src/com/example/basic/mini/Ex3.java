package com.example.basic.mini;

class Xyz {

    final static int staVar = 100;

    final int insVar;

    public Xyz(int insVar) {
        this.insVar = insVar;
    }

    public void m() {
        // local-scope
        final int localVar = 12;
    }

}

class Super {
    final void m() {
    }
}
class Sub extends Super {
//     void m(){}
}

class LT{}
class Hu extends LT{}
final class Adult extends Hu{}
//class C extends Adult{}

public class Ex3 {
    public static void main(String[] args) {

        final Xyz xyz1 = new Xyz(10);
        Xyz xyz2 = new Xyz(20);


    }
}
