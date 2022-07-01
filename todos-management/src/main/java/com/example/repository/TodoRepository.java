package com.example.repository;

import com.example.entity.Todo;
import com.example.entity.TodoType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo,Integer> {

//    @Query("from Todo where type=?1)
    List<Todo> findByType(TodoType type);
    //    @Query("from Todo where user.id=?1")
    List<Todo> findByUserId(int userId);



}
