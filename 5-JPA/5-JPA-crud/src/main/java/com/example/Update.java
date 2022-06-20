package com.example;

import com.example.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Update {

    public static void main(String[] args) {


        // #req-1
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Todo todo = entityManager.find(Todo.class, 3);

        entityManager.getTransaction().commit();
        entityManager.close();

        // DETACHED
        todo.setTitle("todo-1");

        System.out.println("-".repeat(50));

        // #Req-2
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(todo);

        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
