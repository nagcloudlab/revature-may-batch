package com.example.exception;

// checked
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class AccountBalanceException extends Exception {
    public AccountBalanceException(String message) {
        super(message);
    }
}

//---------------------------------------------------------------
// Team-1 : transfer-service module   ( third-party )
//---------------------------------------------------------------

class TransferService {
    public long transfer(double amount, String sourceAccNumber, String destinationAccNumber) throws AccountBalanceException, AccountNotFoundException {
        // load source account details

        if (sourceAccNumber.equals("13"))
            throw new AccountNotFoundException("not found ");


        double sourceAccBalance = 1000.00;
        // check balance in source
        if (sourceAccBalance < amount)
            throw new AccountBalanceException("no enough balance - " + sourceAccBalance);

        // debit
        // credit
        // update accounts
        return 121212;
    }
}

//---------------------------------------------------------------
// Team-2 : ticket-booking module
//---------------------------------------------------------------

class TicketBooking {
    TransferService transferService = new TransferService();

    public void bookTicket(int ticketId, double ticketAmount, String sourceAccNumber) {
        try {
            // step-1 : intiate transfer
            transferService.transfer(ticketAmount, sourceAccNumber, "1111222");
            // step-2 : if transfer success confirm ticket
            System.out.println("ticket confirmed..");
        } catch (AccountNotFoundException e) {
            //...
            System.out.println("Ex- " + e.getMessage());
        } catch (AccountBalanceException e) {
//            // step-3 : if transfer failed relase ticket
            System.out.println("Ex- " + e.getMessage());
////            e.printStackTrace();
        }
    }
}


public class App {
    public static void main(String[] args) {

        TicketBooking ticketBooking = new TicketBooking();
        ticketBooking.bookTicket(12, 10000.00, "22112211");

    }
}
