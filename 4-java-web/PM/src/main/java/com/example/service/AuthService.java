package com.example.service;

public interface AuthService {

    boolean authenticate(String username,String password);
    void register(String username,String password);

}
