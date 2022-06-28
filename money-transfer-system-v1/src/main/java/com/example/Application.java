package com.example;

import com.example.config.ApplicationConfiguration;
import com.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {


        //---------------------------------------------------------
        // init / booting
        //---------------------------------------------------------
        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        System.out.println("-".repeat(100));
        //----------------------------------------------------------
        // Use
        //----------------------------------------------------------

        try {
            TransferService transferService = applicationContext.getBean(TransferService.class);
            System.out.println(transferService.getClass());

            transferService.transfer(100.00, "1", "2");

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
