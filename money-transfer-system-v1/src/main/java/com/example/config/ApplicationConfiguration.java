package com.example.config;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;


@Configuration
@Import({DataSourceConfiguration.class})
public class ApplicationConfiguration {

    @Bean
    @Description("Provides access to data from the Accounts table")
    public AccountRepository accountRepository(DataSource dataSource) {
        return new JdbcAccountRepository(dataSource);
    }

    @Bean("transferService")
    @Description("Handles all transfer related use-cases")
    public TransferService transferService1(AccountRepository  accountRepository) {
        return new UPITransferService(accountRepository);
    }


}
