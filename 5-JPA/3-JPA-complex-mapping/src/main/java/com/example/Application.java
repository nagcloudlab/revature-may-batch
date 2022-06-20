package com.example;

import com.example.entity.Address;
import com.example.entity.AddressType;
import com.example.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Application {

    public static void main(String[] args) {

//        Employee employee = new Employee();
////        employee.setId(123);
//        employee.setName("tom");
//
//        Address homeAddress = new Address();
//        homeAddress.setStreet("home-street-1");
//        homeAddress.setCity("home-city-1");
//        homeAddress.setCountry("home-country-1");
//        homeAddress.setType(AddressType.HOME);
//
//        Address officeAddress = new Address();
//        officeAddress.setStreet("offi-street-1");
//        officeAddress.setCity("offi-city-1");
//        officeAddress.setCountry("offi-country-1");
//        officeAddress.setType(AddressType.OFFICE);
//
//        employee.setAddresses(List.of(homeAddress,officeAddress));


        // insert employee entity

        // Using JPA API

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

//        entityManager.persist(employee);

        Employee e=entityManager.find(Employee.class,1);
        System.out.println(e.getId());
        System.out.println(e.getName());
//        e.getAddresses().forEach(System.out::println);
        System.out.println("-".repeat(50));
        e.getAddresses().forEach(System.out::println);


        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
