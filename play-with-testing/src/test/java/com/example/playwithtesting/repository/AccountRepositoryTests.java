package com.example.playwithtesting.repository;


import com.example.playwithtesting.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepositoryTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findAccountTest() {
        Account account = accountRepository.findByUsername("tom");
        assertEquals("tom", account.getUsername());
    }

    @Test
    public void findAccountNotExistTest() {
        Account account = accountRepository.findByUsername("tj");
        assertNull(account);
    }


}
