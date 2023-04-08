package StepDefinitions;

import PageObjects.BasePage;
import PageObjects.HomePage;
import cucumber.api.java.en.Given;
import factory.DriverFactory;

import java.util.List;


public class HomeSteps {

    private static String title;
    private BasePage basePage = new BasePage(DriverFactory.getDefaultDriver());
    private HomePage homePage = new HomePage(DriverFactory.getDefaultDriver());



    //    @When("user gets the title of the page")
//    public void user_gets_the_title_of_the_page() {
//        title = loginPage.getLoginPageTitle();
//        System.out.println("Page title is: " + title);
//    }
    @Given("^I open a page$")
    public void i_open_a_page() throws Throwable {
      List registrationNumbers=  basePage.readFromInputFiles();
        basePage.openApplication();
        for(int i=0;i<=registrationNumbers.size();i++){
            System.out.println("registrationNumbers.get(i)"+registrationNumbers.get(i));
            homePage.enterRegistartionNumber(registrationNumbers.get(i));
            homePage.clickButton();
        }




      //  basePage .get("https://www.cazoo.co.uk/value-my-car/");
    }
    }

