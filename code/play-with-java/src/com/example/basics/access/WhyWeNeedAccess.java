package com.example.basics.access;

class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        if (id > 0)
            this.id = id;
        if (name != null)
            this.name = name;
        if (salary > 0 && salary < 10000.00)
            this.salary = salary;
    }

    // accessor / set/get methods
    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setSalary(double salary) {
        if (salary > 0 && salary < 10000.00)
            this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


}

public class WhyWeNeedAccess {
    public static void main(String[] args) {

        //----------------------------------------------------
        // modile-A where human programmer working
        //----------------------------------------------------
        Employee e1 = new Employee(101, "tom", 1000);

        //----------------------------------------------------
        // modile-B where alien programmer are working
        //----------------------------------------------------
//        e1.id=-1;
        e1.setName("Tom");
        e1.setSalary(500.00);

        System.out.println(e1.getId());
        System.out.println(e1.getName());
        System.out.println(e1.getSalary());

        System.out.println(e1);

        //--------------------------------------------------------
    }
}
