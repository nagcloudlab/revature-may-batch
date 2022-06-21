package com.example.com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {


    public String username;
    public String password;

}
