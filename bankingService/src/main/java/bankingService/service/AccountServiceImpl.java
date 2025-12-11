package bankingService.service;

import bankingService.model.Account;
import bankingService.model.Transaction;
import bankingService.model.TypeTransaction;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private Account account;
    public AccountServiceImpl(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(int amount) {
        if(amount<=0){
            throw new IllegalArgumentException("Le montant doit etre superieur a 0");
        }
        this.account.setBalance(account.getBalance()+amount);
        this.account.addTransaction(new Transaction(account.getBalance(),amount, TypeTransaction.Deposit));
    }

    @Override
    public void withdraw(int amount) {
        if(amount<=0){
            throw new IllegalArgumentException("Le montant doit etre superieur a 0");
        }
        if(this.account.getBalance()<amount){
            throw new IllegalArgumentException("Fonds insuffisants");
        }
        this.account.setBalance(account.getBalance()-amount);
        this.account.addTransaction(new Transaction(account.getBalance(),amount, TypeTransaction.Withdrawal));
    }

    @Override
    public void printStatement() {

        if(this.account.getTransactions().isEmpty()){
            System.out.println("Aucun Transaction enregistrer pour instant");
            return;
        }

        System.out.println("DATE | AMOUNT | BALANCE");

        //afficher les transaction de plus recent a plus ancienne
        List<Transaction> transactions = account.getTransactions()
                                                .stream()
                                                .sorted((t1,t2)->t2.date().compareTo(t1.date()))
                                                .toList();

        StringBuilder sb = new StringBuilder();

        for (Transaction t : transactions) {

            int displayedAmount = (t.typeTransaction() == TypeTransaction.Withdrawal) ? -t.amount() :  t.amount();

            sb.append(t.getDate())
                    .append(" | ")
                    .append(displayedAmount)
                    .append(" | ")
                    .append(t.balance());

            System.out.println(sb);
            sb.setLength(0);
        }
    }

}
