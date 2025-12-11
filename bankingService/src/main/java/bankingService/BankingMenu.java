package bankingService;

import bankingService.model.Account;
import bankingService.service.AccountService;
import bankingService.service.AccountServiceImpl;

import java.util.Scanner;

public class BankingMenu {

    private Account account;
    private AccountService accountService;
    public BankingMenu(Account account) {
        this.account = account;
        accountService = new AccountServiceImpl(account);
        start();
    }

    public void start(){
      try (Scanner scanner = new Scanner(System.in)) {

        while (true) {
            System.out.println("\n====== BANKING SYSTEM MENU ======");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Statement");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> handleDeposit(scanner);
                case "2" -> handleWithdraw(scanner);
                case "3" -> accountService.printStatement();
                case "4" -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
    }

    private void handleDeposit(Scanner scanner) {
    try {
        System.out.print("Saisissez le montant: ");
        int amount = Integer.parseInt(scanner.nextLine());

        accountService.deposit(amount);
        System.out.println("Depot reussi!");

    } catch (NumberFormatException e) {
        System.out.println("Saisissez une valeur valide");
    }catch (Exception e){
        System.out.println("Depot Impossible : "+e.getMessage());
    }

}

    private void handleWithdraw(Scanner scanner) {
    try {
        System.out.print("Saisissez le montant: ");
        int amount = Integer.parseInt(scanner.nextLine());

        accountService.withdraw(amount);
        System.out.println("Retrait reussi");

    } catch (NumberFormatException e) {
        System.out.println("Saisissez une valeur valide");
    } catch (Exception e) {
        System.out.println("Retrait impossible : " + e.getMessage());
    }
}

}
