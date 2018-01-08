package com.xyzcorp;

public class Account {
    private double balance;

    public Account(int initialBalance) {
    }

    public void deposit(double i) {
        this.balance = i;
    }

    public double getBalance() {
        return this.balance;
    }
}
