package com.example;

import com.example.exception.AccountNotFoundException;
import com.example.service.TransferService;

public class Application {
    public static void main(String[] args) {

        //---------------------------------------------
        // init / booting
        //---------------------------------------------

        TransferService transferService = new TransferService();

        //---------------------------------------------
        // use
        //---------------------------------------------

        try {

            transferService.transfer(100.00, "1", "2");
            System.out.println("-".repeat(50));
            transferService.transfer(100.00, "2", "1");

        } catch (AccountNotFoundException anfe) {
            System.out.println(anfe.getMessage());
        }


    }
}
