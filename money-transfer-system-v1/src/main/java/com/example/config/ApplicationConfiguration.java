package com.example.config;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = {"com.example"})
@Import({DataSourceConfiguration.class})
@PropertySource("classpath:transfer.properties")
public class ApplicationConfiguration {


//    @Value("#{environment['daily.limit']}")
    // - or -
//    @Value("${daily.limit}")
//    int maxTransfersPerDay;

//    @Bean
//    @Description("Provides access to data from the Accounts table")
//    public AccountRepository accountRepository(DataSource dataSource) {
//        return new JdbcAccountRepository(dataSource);
//    }

//    @Bean("transferService")
//    @Scope("singleton")
////    @Profile("dev")
//    @Lazy(false)
//    @Description("Handles all transfer related use-cases")
//    public TransferService transferService1(AccountRepository  accountRepository) {
//        return new UPITransferService(accountRepository);
//    }


}
