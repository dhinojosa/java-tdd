package com.xyzcorp.cucumber;

import com.xyzcorp.Account;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountDefinitionsTest {

    @Inject
    private AccountWorld accountWorld;

    @Given("^an account with a (\\d+) balance$")
    public void anAccountWithABalance(int balance) throws Throwable {
        accountWorld.account = new Account(balance);
    }

    @When("^the account gets a deposit of (\\d+) dollars$")
    public void theAccountGetsADepositOfDollars(int deposit) throws Throwable {
        accountWorld.account.deposit(deposit);
    }

    @Then("^the account should have (\\d+) dollars$")
    public void theAccountShouldHaveDollars(int result) throws Throwable {
        assertThat(accountWorld.account.getBalance()).isEqualTo(result);
    }
}
