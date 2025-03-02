package StepDefinitions;



import PageObjects.HomePage;
import PageObjects.ResultsPage;
import Utilities.Utils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ResultsSteps {
    public static String result;
    private Utils utils = new Utils();
    private ResultsPage resultsPage = new ResultsPage();
    private HomePage homePage = new HomePage();

    @Then("^I should verify the car details and confirm$")
    public void i_should_verify_the_car_details_and_confirm() throws Throwable {
        Assert.assertEquals(utils.readFromPropertiesFile("car_details"), resultsPage.getText("car details"));

//        homePage.clickButton("confirm-vehicle");
//        Assert.assertEquals(utils.readFromPropertiesFile("home-page-title"), resultsPage.getPageTitle());
//
//        Assert.assertEquals(utils.readFromPropertiesFile("car-worth"), resultsPage.getText("car worth"));
    }
}
