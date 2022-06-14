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
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount");
        double amount = scanner.nextDouble();

        scanner.nextLine(); // ill explain later

        System.out.println("Enter source account");
        String sourceAccNumber = scanner.nextLine();

        System.out.println("Enter target account");
        String targetAccNumber = scanner.nextLine();

        try {
            transferService.transfer(amount, sourceAccNumber, targetAccNumber);
        } catch (AccountNotFoundException anfe) {
            LOG.error("Transfer failed - " + anfe.getMessage());
        }
        System.out.println("-".repeat(50));
        //---------------------------------------------------------------------------------
//
//        List<Transaction> transactionList = jdbcTransactionRepository.findAll();
//
//        transactionList
//                .stream()
//                .filter(txn -> txn.getType() == TxnType.CREDIT)
//                .forEach(System.out::println);

        //----------------------------------------------------------------------------------

    }
}
