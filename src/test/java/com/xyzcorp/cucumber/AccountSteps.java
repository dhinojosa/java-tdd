import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountSteps {
    @Given("^an empty account$")
    public void anEmptyAccount() throws Throwable {
        throw new PendingException();
    }

    @When("^a deposit of \\$(\\d+) is made$")
    public void aDepositOf$IsMade(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should have a balance of \\$(\\d+)$")
    public void iShouldHaveABalanceOf$(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
