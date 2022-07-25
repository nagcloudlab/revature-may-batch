package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataWithH2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataWithH2Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args->{

            userRepository.findAll()
                    .forEach(System.out::println);

        };
    }


}
