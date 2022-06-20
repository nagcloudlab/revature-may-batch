package com.example;

import com.example.entity.Employee;
import com.example.entity.Gender;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Application {

    public static void main(String[] args) {

//        Employee employee = new Employee();
//        employee.setId(1);
//        employee.setName("Tom");
//        employee.setSalary(1000.00);
//        employee.setGender(Gender.MALE);
//        employee.setDob(new Date());


        // insert employee entity

        // Using JPA API

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

//        entityManager.persist(employee);

        Employee employee=entityManager.find(Employee.class,1);
        System.out.println(employee);

        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
