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
   public  static List registrationNumbers;
    static int  count=0;
   public static String actualResult="result not displayed on the page";
    public static  String expectedResult="results displayed on the page";



    //    @When("user gets the title of the page")
//    public void user_gets_the_title_of_the_page() {
//        title = loginPage.getLoginPageTitle();
//        System.out.println("Page title is: " + title);
//    }
    @Given("^I open a page$")
    public void i_open_a_page() throws Throwable {
//      List registrationNumbers=  basePage.readFromInputFiles();
//        basePage.openApplication("url");
//        Assert.assertEquals(basePage.readFromPropertiesFile("home-page-title"), resultsPage.getPageTitle());
//
//
//        for(int i=0;i<=registrationNumbers.size();i++){
//            System.out.println("registrationNumbers.get(i)"+registrationNumbers.get(i));
//            homePage.enterRegistartionNumber(registrationNumbers.get(i));
//            homePage.clickButton();
//
//            Assert.assertEquals(basePage.readFromPropertiesFile("results-page-title"), resultsPage.getPageTitle());
//          resultsPage.verifySearchStatus("car-result-failure");
//            if((resultsPage.verifySearchStatus("car-result-failure"))){
//                System.out.println("no search results");
//            }
//            else{
//                System.out.println("search results");
//
//                resultsPage.verifySearchStatus("car-result-failure");
//            }
//
//            //resultsPage.getsearchResult("car-result");
//
//        }
//
//
//
//
//      //  basePage .get("https://www.cazoo.co.uk/value-my-car/");
    }



    @Given("^I retrieve car registration numbers from the input file$")
    public void i_retrieve_car_registration_numbers_from_the_input_file() throws Throwable {
        registrationNumbers=   utils.readFromInputFiles();
        System.out.println("reg numbers list"+registrationNumbers);
        utils.writeToFile(registrationNumbers);

    }

    @When("^I search on the cazoo website$")
    public void i_search_on_the_cazoo_website() throws Throwable {
        basePage.openApplication("url");
        Assert.assertEquals(utils.readFromPropertiesFile("home-page-title"), resultsPage.getPageTitle());

        for(int i=count;i<=registrationNumbers.size();i++){
            System.out.println("registrationNumbers.get(i)"+registrationNumbers.get(i));
            homePage.enterRegistartionNumber(registrationNumbers.get(i));
            homePage.clickButton(count);

            Assert.assertEquals(utils.readFromPropertiesFile("results-page-title"), resultsPage.getPageTitle());
           // resultsPage.verifySearchStatus("car-result-failure");
            if((resultsPage.verifySearchStatus("car-result-failure"))){
                System.out.println("no search results");
                count=count+1;
                System.out.println("count after"+count);

                break;
            }
            else{
                System.out.println("search results");

                resultsPage.verifySearchStatus("car-result-success");
            String result=    resultsPage.getsearchResult("result");
            System.out.println("result on steps-------"+result);

            }




        }

        i_search_on_the_cazoo_website();



    }



}

