package com.example;

import com.example.exception.AccountNotFoundException;
import com.example.service.TransferService;
import org.apache.log4j.Logger;

public class Application {

    private static final Logger LOGGER = Logger.getLogger("mts");  // singleton object

    public static void main(String[] args) {
        TransferService transferService = new TransferService();
        System.out.println("-".repeat(50));
        try {
            transferService.transfer(100.00, "1", "11");
        } catch (AccountNotFoundException anfe) {
            LOGGER.error("Transfer failed - " + anfe.getMessage());
        }
        System.out.println("-".repeat(50));
    }
}
