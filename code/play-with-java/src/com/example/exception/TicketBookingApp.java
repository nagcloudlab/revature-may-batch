package com.example.exception;

class AccountBalanceException extends RuntimeException{
    public AccountBalanceException(String message) {
        super(message);
    }
}

//-------------------------------------------------------------
// Transfer Module
//-------------------------------------------------------------

class TransferService {
    public long transfer(double amount, String srcAccNumber, String targetAccNumber) {
        // Load source account details
        double srcAccountBalance = 1000.00;
        if (srcAccountBalance < amount) {
            throw new AccountBalanceException("no enough balance");
        }
        // debit
        // credit
        // accounts get update to database
        return 1213423434;
    }
}


//-------------------------------------------------------------
// Transfer Booking Module
//-------------------------------------------------------------

class TicketBooking {

    TransferService transferService = new TransferService();

    public void bookTicket(String sourceAccNumber, double amount) {
        try {
            long txnId = transferService.transfer(amount, sourceAccNumber, "1111");
            System.out.println("Tickets confirmed  with txn-ID - " + txnId);
        } catch (AccountBalanceException e) {
            // release ticket
            // notify end-user abt transfer..
            System.out.println("Ex - " + e.getMessage());
        }
    }
}


public class TicketBookingApp {
    public static void main(String[] args) {

        TicketBooking ticketBooking = new TicketBooking();
        ticketBooking.bookTicket("1", 10000.00);

    }
}
