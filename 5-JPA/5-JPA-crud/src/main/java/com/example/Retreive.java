package com.example;

import com.example.entity.Todo;
import com.example.entity.TodoType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Retreive {

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        /*

            we can select data with JPA in 4 ways

            1- by primary key
            2- by JPQL ( java persistence query language )
            3- by Criteria API
            4- by Native ( database specific ) SQL

         */

//        1- by primary key
        Todo todo=entityManager.find(Todo.class,3);
        System.out.println(todo);
        todo.setTitle("todo one");



//      4- by Native ( database specific ) SQL
//        String sql = "select * from todos";
//        Query query = entityManager.createNativeQuery(sql);
//        List<Object> todos = query.getResultList();

//        2- by JPQL ( java persistence query language )
//        String jpql="from Todo";
//        Query query= entityManager.createQuery(jpql);
//        query.setFirstResult(0);
//        query.setMaxResults(2);
////        query.setParameter("todoType",TodoType.HOME);
//        List<Todo> todos=query.getResultList();
//        todos
//                .forEach(System.out::println);


        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
