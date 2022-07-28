package com.example.playwithtesting.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="accounts")
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private String username;
    private String password;
}
