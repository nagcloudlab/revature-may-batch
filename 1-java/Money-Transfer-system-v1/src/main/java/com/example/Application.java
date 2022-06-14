package com.example;

import com.example.exception.AccountNotFoundException;
import com.example.service.TransferService;
import org.apache.log4j.Logger;

public class Application {

    private static final Logger LOGGER = Logger.getLogger("mts");  // singleton object

    public static void main(String[] args) {

        //---------------------------------------------
        // init / booting
        //---------------------------------------------

        TransferService transferService = new TransferService();

        System.out.println("-".repeat(50));

        //---------------------------------------------
        // use
        //---------------------------------------------
        try {
            transferService.transfer(100.00, "1", "2");
            System.out.println("-".repeat(25));
            transferService.transfer(100.00, "1", "2");
        } catch (AccountNotFoundException anfe) {
//            System.out.println("Ex- transfer failed - " + anfe.getMessage());
            LOGGER.error("Transfer failed - " + anfe.getMessage());
        }

        System.out.println("-".repeat(50));


    }
}
