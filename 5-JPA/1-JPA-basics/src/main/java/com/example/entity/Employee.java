package com.example.entity;

// JPA
import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name="rev_employees")
public class Employee {
    @Id
    @Column(name="emp_id")
    private int id;
    @Column(name="emp_name")
    private String name;
    @Column(name="emp_salary")
    private double salary;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Lob // large object
    private byte[] profilePic;
    @Lob
    private String profile;
    @Transient
    private String nonTableField;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                ", dob=" + dob +
                ", profilePic=" + Arrays.toString(profilePic) +
                ", profile='" + profile + '\'' +
                ", nonTableField='" + nonTableField + '\'' +
                '}';
    }
}
