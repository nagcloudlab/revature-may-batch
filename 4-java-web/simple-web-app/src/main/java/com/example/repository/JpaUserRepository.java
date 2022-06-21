package com.example.repository;

import com.example.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {

    private EntityManagerFactory emf;

    public JpaUserRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Optional<User> findByUserId(String username) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, username);
        em.close();
        if (user == null)
            return Optional.empty();
        else
            return Optional.of(user);
    }
}
