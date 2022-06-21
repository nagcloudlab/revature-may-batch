package com.example.repository;

import com.example.entity.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUserId(String username);

}
