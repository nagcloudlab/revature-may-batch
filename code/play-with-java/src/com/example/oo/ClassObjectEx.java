package com.example.oo;

import java.io.File;
import java.util.Scanner;

class Employee {

    int id; // obj variable
    String name;
    double salary;
    String address;

    Employee(int id, String name, double salary/* argmunet variable */) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }


}


public class ClassObjectEx {
    public static void main(String[] args) {

        Employee e1  = new Employee(101, "Tom", 1000.00 /*parameter*/);
        Employee e2 =new Employee(102,"Jerry",2000.00);
        e2.address="US";

        System.out.println(e1);
        System.out.println(e2);


    }
}
