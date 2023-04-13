package StepDefinitions;

import PageObjects.BasePage;
import factory.DriverFactory;
import org.junit.After;
import org.junit.Before;


public class Hooks {
    private BasePage basePage = new BasePage(DriverFactory.getDefaultDriver());
   // public WebDriver driver;
//    public Hooks() {
//        this.driver = DriverFactory.getDefaultDriver();
//    }
    @Before

    public void implicitWait(){
     //driver=   basePage.getDriver();
        basePage.implicitWait();

    }

    @After
    public void quitBrowser() {
        basePage.quitBrowser();




    }
}
