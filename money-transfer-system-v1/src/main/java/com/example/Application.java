package com.example;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        //init
//        AccountRepository jdbcAccountRepository=new JdbcAccountRepository();
//        AccountRepository jpaAccountRepository=new JpaAccountRepository();//
//        UPITransferService transferService = new UPITransferService(jpaAccountRepository);


        ConfigurableApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("mony-transfer-system.xml");

        System.out.println("-".repeat(50));

        TransferService transferService = applicationContext.getBean("transferService", TransferService.class);

        // use
        transferService.transfer(100.00, "1", "2");
        System.out.println();
        transferService.transfer(200.00, "1", "2");

        System.out.println("-".repeat(50));

        // destroy
        applicationContext.close();

    }
}
