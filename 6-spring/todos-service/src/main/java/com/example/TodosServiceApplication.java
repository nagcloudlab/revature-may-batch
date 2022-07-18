package com.example;

import com.example.entity.Todo;
import com.example.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodosServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodosServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TodoRepository todoRepository){
        return  args->{
//            Todo todo=new Todo();
//            todo.setTitle("finish revature training");
//            todoRepository.save(todo);

               todoRepository.findAll()
                       .forEach(System.out::println);

        };
    }

}
