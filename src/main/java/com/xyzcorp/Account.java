package com.xyzcorp;

public class Account {
    private double balance;

    public Account(double balance) {
      this.balance = balance;
    }

    public void deposit(double deposit) {
       this.balance += deposit;
    }

    public double getBalance() {
        return balance;
    }
}
