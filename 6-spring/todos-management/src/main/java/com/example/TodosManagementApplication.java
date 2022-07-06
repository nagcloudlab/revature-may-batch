package com.example;

import com.example.entity.Todo;
import com.example.entity.TodoType;
import com.example.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
// - or-
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class TodosManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosManagementApplication.class, args);
	}

}
