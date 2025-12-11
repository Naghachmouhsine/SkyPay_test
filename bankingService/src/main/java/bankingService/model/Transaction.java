package bankingService.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public record Transaction (int balance,int amount,TypeTransaction typeTransaction,Date date) {
    public Transaction(int balance, int amount, TypeTransaction typeTransaction) {
        this(balance, amount, typeTransaction, new Date());
    }

    public String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
        return sdf.format(this.date());
    }
}
