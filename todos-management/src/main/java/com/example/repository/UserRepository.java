package com.example.repository;

import com.example.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String username);

}
