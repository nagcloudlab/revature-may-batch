package com.example;

import com.example.exception.AccountNotFoundException;
import com.example.repository.AccountRepository;
import com.example.repository.InMemoryAccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;
import org.apache.log4j.Logger;

public class Application {

    private static final Logger LOGGER = Logger.getLogger("mts");  // singleton object

    public static void main(String[] args) {


        //---------------------------------------------------------------------------
        // init
        //---------------------------------------------------------------------------
        AccountRepository inMemoryAccountRepository = new InMemoryAccountRepository();
        AccountRepository jdbcAccountRepository = new JdbcAccountRepository();

        TransferService transferService = new TransferServiceImpl(jdbcAccountRepository);
        System.out.println("-".repeat(50));

        //-----------------------------------------------------------------------------
        // use
        //-----------------------------------------------------------------------------
        try {
            transferService.transfer(100.00, "1", "11");
        } catch (AccountNotFoundException anfe) {
            LOGGER.error("Transfer failed - " + anfe.getMessage());
        }
        System.out.println("-".repeat(50));


    }
}
