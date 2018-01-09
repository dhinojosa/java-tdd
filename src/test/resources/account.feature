Feature: We as a bank, would like to correctly deposit and withdrawal.

  Scenario: If I have a account that starts at $0 and deposit $100 then I
  should have a balance of $100.
    Given an empty account
    When I make a deposit of 100
    Then the account in question should have 100 dollar

  Scenario: If I have a account that starts at -$10 and deposit $100 then I
  should have a balance of $100.
    Given an account of -10
    When I make a deposit of 100
    Then the account in question should have 89 dollar
    And a penalty of 11.