package StepDefinitions;

import PageObjects.BasePage;
import cucumber.api.java.After;
import factory.DriverFactory;


public class Hooks {
    private BasePage basePage = new BasePage(DriverFactory.getDefaultDriver());

    @After
    public void quitBrowser() {
        basePage.quitBrowser();




    }
}
