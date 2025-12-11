package bankingService.model;

import java.util.LinkedList;
import java.util.UUID;

public class Account {
    private UUID accountNumber;
    private int balance=0;
    private LinkedList<Transaction> transactions=new LinkedList<>();

    public Account() {
        this.accountNumber = UUID.randomUUID();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
