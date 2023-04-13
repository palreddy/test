package StepDefinitions;

import PageObjects.BasePage;
import PageObjects.HomePage;
import PageObjects.ResultsPage;
import Utilities.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import factory.DriverFactory;
import org.junit.Assert;

import java.util.List;


public class HomeSteps {

    private static String title;
    private BasePage basePage = new BasePage(DriverFactory.getDefaultDriver());
    private HomePage homePage = new HomePage();
    private Utils utils = new Utils();

    private ResultsPage resultsPage= new ResultsPage();
   public  static List registrationNumberList;

    static int  count=0;
   public static String actualResult="result not displayed on the page";
    public static  String expectedResult="results displayed on the page";








    @Given("^I retrieve car registration numbers from the input file$")
    public void i_retrieve_car_registration_numbers_from_the_input_file() throws Throwable {
        registrationNumberList=   utils.readFromInputFiles();

        for(int i=1;i<registrationNumberList.size()+1;i++) {
            String  propertyKey="regNumber"+i;
            System.setProperty(propertyKey, registrationNumberList.get(i-1).toString());
        }


    }




    @When("^I search on the cazoo website with first \"(.*?)\" registration number$")
    public void i_search_on_the_cazoo_website_with_first_registration_number(String regNumberCount) throws Throwable {
        basePage.openApplication("url");
        Assert.assertEquals(utils.readFromPropertiesFile("home-page-title"), resultsPage.getPageTitle());
        homePage.enterRegistartionNumber(System.getProperty("regNumber"+regNumberCount));
        homePage.clickButton(new Integer(regNumberCount));
        Assert.assertEquals(utils.readFromPropertiesFile("results-page-title"), resultsPage.getPageTitle());

    }
}

