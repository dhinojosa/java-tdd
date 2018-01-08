package com.xyzcorp.cucumber;

import com.xyzcorp.Account;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountSteps {

    @Inject
    private AccountWorld accountWorld;

    @Given("^an empty account$")
    public void anEmptyAccount() throws Throwable {
        accountWorld.account = new Account(0);
    }

    @When("^I make a deposit of (\\d+)$")
    public void iMakeADepositOf(int deposit) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        accountWorld.account.deposit(deposit);
    }

    @Then("^the account in question should have (\\d+) dollar$")
    public void theAccountInQuestionShouldHaveDollar(int result) throws
    Throwable {
        assertThat(accountWorld.account.getBalance()).isEqualTo(100);
    }
}
