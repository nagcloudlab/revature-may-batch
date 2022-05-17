package com.example.datatypes;

// class
class Employee {
    //1- instance aka object variables
    int id; // 32
    String name;
    double salary; // 64
    // 2. constructor
    public Employee() {
    }

}

public class ObjectTypes {
    public static void main(String[] args) {

        Employee e1 = new Employee(); // Object1
        e1.id = 101;
        e1.name = "Nag";
        e1.salary = 1000.00;

        Employee e2 = new Employee(); // Object2
        e2.id = 102;
        e2.name = "Indu";
        e2.salary = 2000.00;

        System.out.println(e1.name);
        System.out.println(e2.name);

    }
}
