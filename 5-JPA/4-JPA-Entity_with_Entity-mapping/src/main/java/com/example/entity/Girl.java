package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Girl {
    @Id
    private int id;
    private String name;
    @OneToOne(mappedBy = "girl",targetEntity =Boy.class)
    private Boy boy;

}
