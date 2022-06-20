package com.example;

import com.example.entity.Employee;
import com.example.entity.EmployeePK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    public static void main(String[] args) {

        Employee employee = new Employee();
//        employee.setId(123);
        EmployeePK employeePK=new EmployeePK();
        employeePK.setE_id(1);
        employeePK.setD_id(22);
        employee.setEmployeePK(employeePK);
        employee.setName("tom");

        // insert employee entity

        // Using JPA API

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(employee);


        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
