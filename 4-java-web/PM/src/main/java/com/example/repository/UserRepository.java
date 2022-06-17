package com.example.repository;

import com.example.entity.User;

public interface UserRepository {

    User findByUserId(String username);
    void save(User user);

}
