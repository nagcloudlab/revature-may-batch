package com.example.oo;

class Employee1 {

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
    Employee1(int id, String name, double salary/* argmunet variable */) {
        this(id, name, salary, null);
    }

    Employee1(int id, String name, double salary, String address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    // 3. method(s)  ( function which bound with an object )
    // a. class methods
    static void doTraining() {
        System.out.println(Employee1.tnrName + " giving training to all employees");
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


public class ClassObject {
    public static void main(String[] args) {

        Employee1.tnrName = "Ben";

        Employee1 e1 = new Employee1(101, "Tom", 1000.00);
        Employee1 e2 = new Employee1(102, "Jerry", 2000.00, "USA");


        Employee1.doTraining();

        e1.doLearnAndWork();
        System.out.println(e1.salary);

        e2.doLearnAndWork();
        System.out.println(e2.salary);


    }
}
