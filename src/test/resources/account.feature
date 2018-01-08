Feature: We are maintaining an account, with deposits and withdrawals and the
  math of course needs to add up.
  Scenario: From an account of 0, we will be adding 100.00 dollars
    Given an account with a 0 balance
    When the account gets a deposit of 100 dollars
    Then the account should have 100 dollars