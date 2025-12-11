package bankingService;

import bankingService.model.Account;
import bankingService.service.AccountService;
import bankingService.service.AccountServiceImpl;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

//        Test avec menu
//        BankingMenu bankingMenu = new BankingMenu(account);
//        bankingMenu.start();

        AccountService accountService=new AccountServiceImpl(account);
        accountService.deposit(1000);
        sleepMs(1000);// 1 seconde de decalage pour tester affichage des dates
        accountService.deposit(2000);
        sleepMs(1000);
        accountService.withdraw(500);
        sleepMs(1000);
        accountService.printStatement();

    }

    private static void sleepMs(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}