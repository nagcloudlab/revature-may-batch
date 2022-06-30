package com.example.repository;

import com.example.entity.Todo;
import com.example.entity.TodoType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo,Integer> {

//    @Query("from Todo where type=?1 and completed=?2")
    List<Todo> findByTypeAndCompleted(TodoType type,boolean completed);

}
