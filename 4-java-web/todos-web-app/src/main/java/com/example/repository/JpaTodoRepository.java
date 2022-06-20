package com.example.repository;

import com.example.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaTodoRepository implements TodoRepository {

    EntityManagerFactory emf;

    public JpaTodoRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Todo todo) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(todo);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Todo> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        List<Todo> todos = entityManager.createQuery("from Todo").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return todos;
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

       entityManager.remove(entityManager.find(Todo.class,id));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
