package com.example.web.rest;

import com.example.entity.Todo;
import com.example.entity.TodoType;
import com.example.exceptions.NotFoundException;
import com.example.repository.TodoRepository;
import com.example.web.dto.HttpError;
import com.example.web.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin(value = "*")
//@RequestMapping(value = "/api/todos")
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

        //
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        if (todo.isPresent()) {
            Todo todoEntity = todo.get();
            TodoDto todoDto = new TodoDto();
            todoDto.setId(todoEntity.getId());
            todoDto.setTitle(todoEntity.getTitle());
            todoDto.setCompleted(todoEntity.isCompleted());
            todoDto.setType(todoEntity.getType());
            return todoDto;
        } else {
            throw new NotFoundException("todo not exist");
        }
    }


    @RequestMapping(
            value = "/api/todos",
            method = RequestMethod.POST,
            consumes = {"application/json"}
    )
    public ResponseEntity<?> addTodo(
            @RequestBody TodoDto todoDto
    ) {

        if (todoDto.getTitle().trim().isEmpty()) {
            HttpError httpError = new HttpError("todo title cannot be empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpError);
        }

        Todo todoEntity = new Todo();
        todoEntity.setTitle(todoDto.getTitle());
        todoEntity.setType(todoDto.getType());
        todoEntity = todoRepository.save(todoEntity);

        todoDto.setId(todoEntity.getId());
        todoDto.setTitle(todoEntity.getTitle());
        todoDto.setCompleted(todoEntity.isCompleted());
        todoDto.setType(todoEntity.getType());


        return ResponseEntity.status(HttpStatus.CREATED).body(todoDto);


    }


    @RequestMapping(
            value = "/api/todos/{id}",
            method = RequestMethod.PATCH
    )
    public ResponseEntity<?> updateTodo(
            @PathVariable("id") int id,
            @RequestBody TodoDto todoDto
    ) {

        Todo todoEntity = todoRepository.findById(id).orElseThrow(() -> new NotFoundException("todo not exist"));
        if (!todoDto.getTitle().isEmpty())
            todoEntity.setTitle(todoDto.getTitle());
        if (todoDto.getType() != null)
            todoEntity.setType(todoDto.getType());
        todoEntity = todoRepository.save(todoEntity);
        todoDto = new TodoDto();
        todoDto.setId(todoEntity.getId());
        todoDto.setTitle(todoEntity.getTitle());
        todoDto.setCompleted(todoEntity.isCompleted());
        todoDto.setType(todoEntity.getType());
        return ResponseEntity.ok(todoDto);
    }


    @RequestMapping(
            value="/api/todos/{id}"
    )
    public ResponseEntity<?> deleteTodo(
            @PathVariable("id") int id
    ){
        todoRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {NotFoundException.class})
    public HttpError notFoundHandler(NotFoundException exception) {
        return new HttpError(exception.getMessage());
    }


}
