package StepDefinitions;


import PageObjects.ResultsPage;
import Utilities.Utils;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ResultsSteps {
    HomeSteps homeSteps=new HomeSteps();
    public  static String result;
    private Utils utils = new Utils();
    private ResultsPage resultsPage= new ResultsPage();
    @Then("^I should retrieve the results and compare with the output file$")
    public void i_should_retrieve_the_results_and_compare_with_the_output_file() throws Throwable {
        result=   resultsPage.getResults("search-results-success","search-results-failure");
      //  resultsPage.compareResultWithOutputFile(utils.readFromPropertiesFile("output_file"),result);
      //  System.out.println("assertion"+resultsPage.compareResultWithOutputFile(result,"output_file"));
        Assert.assertEquals(true, resultsPage.compareResultWithOutputFile(utils.readFromPropertiesFile("output_file"),result));
      //  homeSteps.i_search_on_the_cazoo_website();

    }
}
