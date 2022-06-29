package com.example;

import com.example.billing.Billing;
import com.example.config.ApplicationConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);


        Billing billing = applicationContext.getBean("ob", Billing.class);

        List<String> cart1 = List.of("123", "456");
        double totalPrice = billing.getTotalPrice(cart1);
        System.out.println(totalPrice);

        applicationContext.close();

    }
}
