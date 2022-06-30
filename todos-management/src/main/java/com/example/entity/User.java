package com.example.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String name;



}
