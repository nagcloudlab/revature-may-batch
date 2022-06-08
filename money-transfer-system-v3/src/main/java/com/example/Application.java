package com.example;

import com.example.entity.Transaction;
import com.example.entity.TxnType;
import com.example.exceptions.AccountNotFoundException;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JdbcTransactionRepository;
import com.example.repository.TransactionRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;
import org.apache.log4j.Logger;

import java.util.List;

public class Application {

    private static final Logger LOG = Logger.getLogger("mts"); // singleton

    public static void main(String[] args) {

        //---------------------------------------------------------------------------
        // init
        //---------------------------------------------------------------------------
        AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
        TransactionRepository jdbcTransactionRepository = new JdbcTransactionRepository();

        TransferService transferService = new TransferServiceImpl(jdbcAccountRepository, jdbcTransactionRepository);
        System.out.println("-".repeat(50));

        //-----------------------------------------------------------------------------
        // use
        //-----------------------------------------------------------------------------
//        try {
//            transferService.transfer(100.00, "1", "11");
//        } catch (AccountNotFoundException anfe) {
//            LOG.error("Transfer failed - " + anfe.getMessage());
//        }
//        System.out.println("-".repeat(50));
        //---------------------------------------------------------------------------------

        List<Transaction> transactionList = jdbcTransactionRepository.findAll();

        transactionList
                .stream()
                .filter(txn -> txn.getType() == TxnType.CREDIT)
                .forEach(System.out::println);

        //----------------------------------------------------------------------------------


    }
}
