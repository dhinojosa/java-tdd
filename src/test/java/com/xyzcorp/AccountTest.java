package com.xyzcorp;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountTest {
   @Test
   public void testAccountOf0WithDeposit() {
      Account account = new Account(0);
      account.deposit(0);
      assertThat(account.getBalance()).isEqualTo(0);
   }

   @Test
   public void testAccountOf0WithDepositOf100() {
      Account account = new Account(0);
      account.deposit(100);
      assertThat(account.getBalance()).isEqualTo(100);
   }
}
