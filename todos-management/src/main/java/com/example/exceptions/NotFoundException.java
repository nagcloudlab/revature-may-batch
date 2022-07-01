package com.example.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String todo_not_exist) {
        super(todo_not_exist);
    }
}
