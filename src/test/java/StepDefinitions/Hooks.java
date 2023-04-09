package StepDefinitions;

import PageObjects.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import factory.DriverFactory;


public class Hooks {
    private BasePage basePage = new BasePage(DriverFactory.getDefaultDriver());
    @Before
    public void implicitWait(){
        basePage.implicitWait();
    }

    @After
    public void quitBrowser() {
        basePage.quitBrowser();




    }
}
