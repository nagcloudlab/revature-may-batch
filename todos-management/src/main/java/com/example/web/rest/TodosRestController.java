package com.example.web.rest;

import com.example.entity.Todo;
import com.example.entity.TodoType;
import com.example.repository.TodoRepository;
import com.example.web.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class TodosRestController {


    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(
            value = "/api/todos",
            method = RequestMethod.GET,
            produces = {
                    "application/json"
            },
            params = {"!t"}
    )
    public List<TodoDto> getTodos(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        Iterable<Todo> todos = todoRepository.findAll();
        // Pageable pageReq = PageRequest.of(page, size);
        // Iterable<Todo> todos = todoRepository.findAll(pageReq);
        return StreamSupport.stream(todos.spliterator(), false)
                .map(todoEntity -> {
                    TodoDto todoDto = new TodoDto();
                    todoDto.setId(todoEntity.getId());
                    todoDto.setTitle(todoEntity.getTitle());
                    todoDto.setCompleted(todoEntity.isCompleted());
                    todoDto.setType(todoEntity.getType());
                    return todoDto;
                })
                .collect(Collectors.toList());
    }




    @RequestMapping(
            value = "/api/todos",
            method = RequestMethod.GET,
            produces = {
                    "application/json"
            },
            params = {"t"}
    )
    public List<TodoDto> getTodosByType(
            @RequestParam(name = "t") String type,
            @RequestParam(name = "status", required = false) String completed
    ) {
        System.out.println(type);
        System.out.println(completed);
//        Iterable<Todo> todos = todoRepository.findAll();
        Iterable<Todo> todos = todoRepository.findByType(TodoType.valueOf(type.toUpperCase()));
        return StreamSupport.stream(todos.spliterator(), false)
                .map(todoEntity -> {
                    TodoDto todoDto = new TodoDto();
                    todoDto.setId(todoEntity.getId());
                    todoDto.setTitle(todoEntity.getTitle());
                    todoDto.setCompleted(todoEntity.isCompleted());
                    todoDto.setType(todoEntity.getType());
                    return todoDto;
                })
                .collect(Collectors.toList());
    }


    @RequestMapping(
            value = "/api/todos/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/json"
            }
    )
    public TodoDto getTodo(
            @PathVariable("id") int id
    ) {
        Optional<Todo> todo = todoRepository.findById(id);
        Todo todoEntity = todo.get();
        TodoDto todoDto = new TodoDto();
        todoDto.setId(todoEntity.getId());
        todoDto.setTitle(todoEntity.getTitle());
        todoDto.setCompleted(todoEntity.isCompleted());
        todoDto.setType(todoEntity.getType());
        return todoDto;
    }





}
