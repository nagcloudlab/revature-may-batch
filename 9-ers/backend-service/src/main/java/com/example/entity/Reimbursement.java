package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="reimbursements")
public class Reimbursement {

    @Id
    @GeneratedValue
    private int id;
    private double amount;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
