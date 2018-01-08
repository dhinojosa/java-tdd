package com.xyzcorp.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountSteps {
    @Given("^an empty account$")
    public void anEmptyAccount() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I make a deposit of (\\d+)$")
    public void iMakeADepositOf(int deposit) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the account in question should have (\\d+) dollar$")
    public void theAccountInQuestionShouldHaveDollar(int result) throws
    Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
