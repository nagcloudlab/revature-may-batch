package com.example.playwithtesting.repository;

import com.example.playwithtesting.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


/*
    Vincent
 */

public interface AccountRepository extends JpaRepository<Account,String> {

    Account findByUsername(String username);

}
