package StepDefinitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ResultsSteps {
    @Then("^I should retrieve the results and compare with the output file$")
    public void i_should_retrieve_the_results_and_compare_with_the_output_file() throws Throwable {
        System.out.println("Actual results"+HomeSteps.actualResult);
        System.out.println("Actual results"+HomeSteps.expectedResult);

        Assert.assertEquals(HomeSteps.expectedResult,HomeSteps.actualResult);

    }
}
