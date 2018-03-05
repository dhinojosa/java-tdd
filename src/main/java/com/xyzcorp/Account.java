package com.xyzcorp;

public class Account {
    private int balance;

    public Account(int initialAmount) {
        this.balance = initialAmount;
    }

    public Account() {

    }

    public int getBalance() {
       return balance;
    }

    public void deposit(int amount) {
       this.balance += amount;
    }

    public void withdrawal(int amount) {
        if (amount <= balance) {
            this.balance -= amount;
        }
    }
}
