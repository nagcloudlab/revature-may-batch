package com.example;

import com.example.service.TransferService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.example"})
public class Application {
    public static void main(String[] args) {

        //---------------------------------------------------------
        // init / booting
        //---------------------------------------------------------
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Application.class, args);

        System.out.println("-".repeat(100));
        //----------------------------------------------------------
        // Use
        //----------------------------------------------------------
        try {
            TransferService transferService = applicationContext.getBean(TransferService.class);
            System.out.println(transferService.getClass());

            transferService.transfer(500, "2", "1");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //------------------------------------------------------------
        // Destroy
        //------------------------------------------------------------
        System.out.println("-".repeat(100));
        applicationContext.close();

    }
}
