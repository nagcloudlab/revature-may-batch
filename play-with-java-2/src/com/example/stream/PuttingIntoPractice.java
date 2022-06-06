package com.example.stream;

import com.example.model.Trader;
import com.example.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> tr2011 =
                transactions
                        .stream()
                        .filter(transaction -> transaction.getYear() == 2011)
                        //.sorted((t1,t2)->Integer.compare(t1.getValue(),t2.getValue()))
                        .sorted(Comparator.comparing(Transaction::getValue))
                        .collect(Collectors.toList());
        tr2011
                .forEach(System.out::println);

        System.out.println("-".repeat(50));

        // Query 2: What are all the unique cities where the traders work?
        List<String> cities =
                transactions
                        .stream()
                        .map(t -> t.getTrader().getCity())
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println(cities);
        System.out.println("-".repeat(50));

        // Query 3: Find all traders from Cambridge and sort them by name.
        List<Trader> traders =
                transactions
                        .stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(Comparator.comparing(Trader::getName))
                        .collect(Collectors.toList());
        traders
                .forEach(System.out::println);

        System.out.println("-".repeat(50));

        // Query 4: Return a string of all traders’ names sorted alphabetically.
        List<String> trNames =
                transactions
                        .stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(Collectors.toList());

        trNames
                .forEach(System.out::println);
        System.out.println("-".repeat(50));

        // Query 5: Are there any trader based in Milan?
        boolean milanBased =
                transactions
                        .stream()
                        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);
        System.out.println("-".repeat(50));

        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .forEach(trader -> trader.setCity("Cambridge"));

        transactions
                .forEach(System.out::println);
        System.out.println("-".repeat(50));

        // Query 7: What's the highest value in all the transactions?
        OptionalInt optional=
                transactions
                        .stream()
                        .mapToInt(Transaction::getValue)
                        .max();

        if(optional.isPresent()){
            System.out.println(optional.getAsInt());
        }

    }

}
