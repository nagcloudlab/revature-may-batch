package com.example;

import com.example.config.ApplicationConfiguration;
import com.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {


        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        System.out.println("-".repeat(50));

        TransferService transferService = applicationContext.getBean(TransferService.class);

        transferService.transfer(100.00,"1","2");

        // destroy
        applicationContext.close();

    }
}
