package com.example.com.example.repository;

import com.example.com.example.entity.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUserId(String username);

}
