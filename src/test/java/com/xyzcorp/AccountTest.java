package com.xyzcorp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void testANewAccount() {
        Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void testADeposit() {
        Account account = new Account();
        account.deposit(100);
        assertThat(account.getBalance()).isEqualTo(100);
    }

    @Test
    public void testADepositWithMoneyAlreadyInit() {
        Account account = new Account(50);
        account.deposit(150);
        assertThat(account.getBalance()).isEqualTo(200);
    }

    @Test
    public void testAWithdrawal() {
        Account account = new Account();
        account.withdrawal(100);
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void testAWithdrawalWithInitialAmount() {
        Account account = new Account(500);
        account.withdrawal(100);
        assertThat(account.getBalance()).isEqualTo(400);
    }
}


