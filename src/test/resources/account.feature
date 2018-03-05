Feature: As a bank of glorious mean, I want to ensure that when a deposit and
  a withdrawal is made that it does so accurately.

  Scenario: If we have an account with no money and add $100 then we should
  have a $100 dollar balance.
    Given a new account
    When a deposit of $100 is made
    Then the balance should be $100

  Scenario: If we have an account with a balance of $100 and we deposit $30
  then we should have $130 balance
    Given an account with $100
    When a deposit of $30 is made
    Then the balance should be $130

  Scenario: If we have an account with a balance of $250 and we withdraw $50
    then we should have $200
    Given an account with $250
    When a withdrawal of $50 is made
    Then the balance should be $200