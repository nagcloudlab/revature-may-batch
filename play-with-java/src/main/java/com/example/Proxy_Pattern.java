package com.example;

class TransferService {
//    @Transactional
//    @AllowdRoles()
    void transfer1() {
        System.out.println("transfer1()");
    }

    void transfer2() {
        System.out.println("transfer2()");
    }
}

class RoleBasedSecuriyCheck {
}

class TransactionManager {
}

class Metrics {
}

class TransferServiceProxy {

   private TransferService transferService = new TransferService();

    TransactionManager transactionManager = new TransactionManager();
    RoleBasedSecuriyCheck roleBasedSecuriyCheck = new RoleBasedSecuriyCheck();
    Metrics metrics = new Metrics();

    void transfer1() {
//        roleBasedSecuriyCheck
//        transactionManager
        transferService.transfer1();
//        transactionManager
//        metrics
    }

    void transfer2() {
        transferService.transfer2();
    }
}


public class Proxy_Pattern {
    public static void main(String[] args) {

        TransferServiceProxy transferService = new TransferServiceProxy();
        transferService.transfer1();


    }
}
