package com.example.oo;

//------------------------------------------------------------
// Top-Level coding : Interface  ( API )
//------------------------------------------------------------
interface Collection{
    void add(String data);
    void clear();
}
interface List extends Collection{
    void add(int idx, String data);
}
interface Set extends Collection{}


//------------------------------------------------------------
// Middle-Level coding : Abstract-class ( Partial implementations )
//------------------------------------------------------------

abstract class AbstractList implements List{
    public void clear() {}
}

//------------------------------------------------------------
// Bottom-Level coding : Concrete-class ( implementations )
//------------------------------------------------------------

class ArrayList extends AbstractList implements List{
    // Array
    public void add(String data) {}
    public void add(int idx, String data) {

    }

}
class LinkedList extends AbstractList implements List{
    // DLL
    public void add(String data) {}
    public void add(int idx, String data) {

    }
}


public class InterfaceVsAbstractClass_Ex1 {
    public static void main(String[] args) {

        List  list=new ArrayList();
        list.add("pizza");
        list.add("burger");
        list.clear();


    }
}
