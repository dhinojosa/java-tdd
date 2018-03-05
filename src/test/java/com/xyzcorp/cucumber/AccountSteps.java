package com.xyzcorp.cucumber;

import com.xyzcorp.Account;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

//Glue Code
public class AccountSteps {

    @Inject
    private AccountWorld accountWorld;

    @Given("^a new account$")
    public void aNewAccount() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       this.accountWorld.account = new Account();
    }

    @When("^a deposit of \\$(\\d+) is made$")
    public void aDepositOf$IsMade(int deposit) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       this.accountWorld.account.deposit(deposit);
    }

    @Then("^the balance should be \\$(\\d+)$")
    public void theBalanceShouldBe$(int expected) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(this.accountWorld.account.getBalance()).isEqualTo(expected);
    }

    @Given("^an account with \\$(\\d+)$")
    public void anAccountWith$(int initialBalance) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.accountWorld.account = new Account(initialBalance);
    }

    @When("^a withdrawal of \\$(\\d+) is made$")
    public void aWithdrawalOf$IsMade(int withdrawal) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.accountWorld.account.withdrawal(withdrawal);
    }
}
