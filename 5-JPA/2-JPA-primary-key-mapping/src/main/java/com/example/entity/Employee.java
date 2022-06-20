package com.example.entity;

// JPA
import javax.persistence.*;

@Entity
public class Employee {

//    @Id
//    @GeneratedValue
//    private int id;

    @EmbeddedId
    private EmployeePK employeePK;

    private String name;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }


    public EmployeePK getEmployeePK() {
        return employeePK;
    }

    public void setEmployeePK(EmployeePK employeePK) {
        this.employeePK = employeePK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
