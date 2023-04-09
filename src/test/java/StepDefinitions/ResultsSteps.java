package StepDefinitions;

import cucumber.api.java.en.Then;


public class ResultsSteps {
    HomeSteps homeSteps=new HomeSteps();
    @Then("^I should retrieve the results and compare with the output file$")
    public void i_should_retrieve_the_results_and_compare_with_the_output_file() throws Throwable {
        //Assert.assertEquals(HomeSteps.expectedResult,HomeSteps.actualResult);
      //  homeSteps.i_search_on_the_cazoo_website();

    }
}
