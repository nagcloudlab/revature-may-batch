package com.example.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "todos")
public class Todo {

    private ObjectId id;
    private String title;
    private boolean completed;

}
