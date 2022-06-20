package com.example;

import com.example.entity.Genre;
import com.example.entity.Movie;
import com.example.entity.Promotion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Using JPA API

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Movie movie=entityManager.find(Movie.class,4);
        System.out.println(movie.getTitle());
        movie.getGenres().forEach(g->{
            System.out.println(g.getName());
        });


        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
