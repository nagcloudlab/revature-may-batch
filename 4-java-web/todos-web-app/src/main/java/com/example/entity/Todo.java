package com.example.entity;

import javax.persistence.*;

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

    public TodoType getType() {
        return type;
    }

    public void setType(TodoType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", type=" + type +
                '}';
    }
}
