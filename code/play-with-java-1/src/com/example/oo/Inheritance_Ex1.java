package com.example.oo;

// how to re-use obj's state variable through inheritance

class Employee {

    private int id;
    private String name;
    private double salary;
    private String address;

    Employee(int id, String name) {
        if (id > 0)
            this.id = id;
        if (name != null)
            this.name = name;
    }

    Employee(int id, String name, double salary, String address) {
        this(id, name);
        this.salary = salary;
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }
}

class Trainer extends Employee {
    String techSkills;

    public Trainer(int id, String name) {
        super(id, name);
    }

    public Trainer(int id, String name, double salary, String address) {
        super(id, name, salary, address);
    }

    public String toString() {
        return "Trainer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                ", address='" + getAddress() + '\'' +
                ", techSkills='" + techSkills + '\'' +
                '}';
    }
}

class HR extends Employee {
    HR(int id, String name) {
        super(id, name);
    }
}

public class Inheritance_Ex1 {

    public static void main(String[] args) {

        Trainer trainer = new Trainer(101, "Nag", 100.00, "india");
        trainer.techSkills = "java";
        System.out.println(trainer);


    }

}
