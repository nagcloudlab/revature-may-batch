package com.example.basics.scope;

class Person {

    static int count; // class scope

    String name;
//    int count = 0; // instance / obj scope

    public Person(String name) {
        this.name = name;
    }

    public void sayHello() {
//        int count = 0; // local scope
        count++;
        System.out.println("hello (" + count + ") from - " + this.name);
    }
}


public class VariableScope {
    public static void main(String[] args) {

        Person person1 = new Person("Tom");
        Person person2 = new Person("Jerry");

        person1.sayHello();
        person1.sayHello();
        person2.sayHello();

        person1 = null; // we lost obj's reference , obj become garbage


        System.out.println(Person.count);
    }
}
