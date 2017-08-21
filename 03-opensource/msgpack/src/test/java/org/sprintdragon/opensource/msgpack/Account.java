package org.sprintdragon.opensource.msgpack;

/**
 * Created by wangdi on 17-5-2.
 */
public class Account {
    private double balance;
    private String details;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Account [balance=" + balance + ", details=" + details + "]";
    }
}
