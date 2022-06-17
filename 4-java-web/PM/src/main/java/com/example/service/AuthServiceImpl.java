package com.example.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.entity.User;
import com.example.repository.UserRepository;

public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUserId(username);
        if (user == null)
            return false;
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
        if (result.verified)
            return true;
        return false;
    }

    @Override
    public void register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        user.setPassword(bcryptHashString);
        userRepository.save(user);
    }
}
