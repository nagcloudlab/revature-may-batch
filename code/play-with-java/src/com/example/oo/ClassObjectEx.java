package com.example.oo;

import java.io.File;
import java.util.Scanner;

class Employee {

    // 1. Variables
    // a. class variables // one copy of data for all objects
    final static String COMPANY_NAME = "revature";
    static String tnrName;

    // b. obj/instance variables   // separate copy of data for every object
    final int id;
    String name;
    double salary;
    String address;

    // 2. constructor
    Employee(int id, String name, double salary/* argmunet variable */) {
        this(id, name, salary, null);
    }

    Employee(int id, String name, double salary, String address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    // 3. method(s)  ( function which bound with an object )
    // a. class methods
    static void doTraining() {
        System.out.println(Employee.tnrName + " giving training to all employees");
    }

    // b. obj/instance methods
    void doLearnAndWork() {
        System.out.println(this.name + " learning & working ");
        this.salary = salary + 100;
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

        Employee.tnrName = "Ben";

        Employee e1 = new Employee(101, "Tom", 1000.00);
        Employee e2 = new Employee(102, "Jerry", 2000.00, "USA");


        Employee.doTraining();

        e1.doLearnAndWork();
        System.out.println(e1.salary);

        e2.doLearnAndWork();
        System.out.println(e2.salary);


    }
}
