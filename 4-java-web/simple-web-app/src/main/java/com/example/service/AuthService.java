package com.example.service;

import com.example.entity.User;

public interface AuthService {

    User authenticate(String username, String password);

}
