package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;

import java.util.Optional;

public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User authenticate(String username, String password) {
        Optional<User> optional = userRepository.findByUserId(username);
        if (optional.isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = optional.get();
        if (user.getPassword().equals(password)) {
            return user;
        }else{
            throw new InvalidCredentialsException();
        }

    }
}
