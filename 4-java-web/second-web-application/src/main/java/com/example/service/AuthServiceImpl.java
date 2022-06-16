package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;

public class AuthServiceImpl implements AuthService{

    UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean authenticate(String username, String password) {
        User user= userRepository.findByUserId(username);
        if(user==null)
            return false;
        if(user.getPassword().equals(password))
            return true;
        return false;
    }
}
