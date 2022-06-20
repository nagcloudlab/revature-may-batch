package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Boy {
    @Id
    private int id;
    private String name;
    @OneToOne
    @JoinColumn(name="g_id")
    private Girl girl;
}
