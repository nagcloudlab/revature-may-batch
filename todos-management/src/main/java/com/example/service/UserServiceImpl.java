package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(String username, String password, String name) {

        // check is user already exist
        User dbUser = userRepository.findByUsername(username);
        if (dbUser != null) {
            throw new IllegalStateException("User already exist");
        }
        // hash password

        // save the user indo
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);

        userRepository.save(user);

    }
}
