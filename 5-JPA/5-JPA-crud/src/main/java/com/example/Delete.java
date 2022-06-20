package com.example;

import com.example.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Delete {

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Todo todo=entityManager.find(Todo.class,3); // MANAGED
        entityManager.remove(todo); // REMOVED


        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
