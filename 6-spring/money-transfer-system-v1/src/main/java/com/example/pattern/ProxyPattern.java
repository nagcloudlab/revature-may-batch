package com.example.pattern;

// Main Logic
class Service {

    public void doUseCase1() {
        System.out.println("use-case-1");
    }

    public void doUseCase2() {
        System.out.println("use-case-2");
        throw new IllegalStateException();
    }
}

// cross-cutting-concern / Aspect
class TransactionManager {
    public void begin() {
        System.out.println("begin transaction");
    }

    public void commit() {
        System.out.println("commit transaction");
    }

    public void rollback() {
        System.out.println("rollback transaction");
    }
}

class ServiceProxy {

    private Service service = new Service(); // main component
    private TransactionManager transactionManager = new TransactionManager(); // Aspect ==> implementation of cross-cutting-concern

    public void doUseCase1() {
        try {
            transactionManager.begin(); // Join Point
            service.doUseCase1();
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
        }
    }

    public void doUseCase2() {
        try {
            transactionManager.begin();
            service.doUseCase2();
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
        }
    }

}

public class ProxyPattern {
    public static void main(String[] args) {

        ServiceProxy service = new ServiceProxy();
        service.doUseCase1();
        service.doUseCase2();

    }
}
