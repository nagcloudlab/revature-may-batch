package com.example.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private boolean completed;
    @Enumerated(EnumType.STRING)
    private TodoType type;

}
