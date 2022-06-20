package com.example;


import com.example.entity.Todo;
import com.example.entity.TodoType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Create {

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Todo todo=new Todo(); // New / Transient
        todo.setTitle("todo-4");
        todo.setType(TodoType.OFFICE);
        entityManager.persist(todo); // Managed State
        todo.setType(TodoType.OFFICE);
        entityManager.getTransaction().commit();
        entityManager.close();



    }

}
