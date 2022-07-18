package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String empId;
    @JsonIgnore
    private String password;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobile;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name="user_id",unique = false)},
            inverseJoinColumns = {@JoinColumn(name="role_id",unique = false)}
            )
    private List<Role> roles;


}
