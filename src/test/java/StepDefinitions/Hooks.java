package StepDefinitions;

import PageObjects.BasePage;
import org.junit.After;
import org.junit.Before;


public class Hooks {
    private BasePage basePage = new BasePage();

    @Before
    public void implicitWait() {
        basePage.implicitWait();
    }
    @After
    public void quitBrowser() {
        basePage.quitBrowser();
    }
}
