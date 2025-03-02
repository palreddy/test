package StepDefinitions;

import PageObjects.BasePage;
import PageObjects.HomePage;
import PageObjects.ResultsPage;
import Utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class HomeSteps {

    public static List registrationNumberList;
    private BasePage basePage = new BasePage();
    private HomePage homePage = new HomePage();
    private Utils utils = new Utils();
    private ResultsPage resultsPage = new ResultsPage();

    private static final Logger log = LoggerFactory.getLogger(HomeSteps.class);


    @Given("I login to the library API service")
    public void i_login_to_the_library_api_service() {
        basePage.openApplication("baseURL");
    }

    @Given("^I retrieve car registration numbers from the input file$")
    public void i_retrieve_car_registration_numbers_from_the_input_file() throws Throwable {
        registrationNumberList = utils.readFromInputFiles();
        for (int i = 1; i < registrationNumberList.size() + 1; i++) {
            String propertyKey = "regNumber" + i;
            System.setProperty(propertyKey, registrationNumberList.get(i - 1).toString().replaceAll("\\s+", ""));
        }
    }
    @When("^I search on the cazoo website with first \"(.*?)\" registration number$")
    public void i_search_on_the_cazoo_website_with_first_registration_number(String regNumberCount) throws Throwable {
        basePage.openApplication("baseURL");
        Assert.assertEquals(utils.readFromPropertiesFile("home-page-title"), resultsPage.getPageTitle());
        homePage.enterCarDetails(System.getProperty("regNumber" + regNumberCount));

        homePage.enterCarDetails("milage");
        homePage.enterCarDetails("postcode");
        homePage.clickButton("accept");
        homePage.clickButton("start-valuation");

    }
}

