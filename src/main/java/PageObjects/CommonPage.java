package PageObjects;

import Utilities.Utils;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class CommonPage extends DriverFactory {
    private Utils utils = new Utils();
    public CommonPage(WebDriver webDriver) {
        this.driver = driver;
    }

    public void getPage(String key) {
        driver.get(key);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void quit() {
        driver.quit();
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void enter(By by, String key) {
        driver.findElement(by).sendKeys(key);
    }

    public String getSearchResults(By searchSucess, By searchFailure) throws InterruptedException {
        String result;
        Thread.sleep(2000);
        if ((driver.getPageSource().contains("Sorry, we couldn't find a car with that registration. " +
                "Please re-enter your registration number")) ||
                (driver.getPageSource().contains("Our history checks show the MOT has expired."))) {
            result = driver.findElement(searchFailure).getText();
        } else {
            result = driver.findElement(searchSucess).getText();
            result = utils.formattedResult(result);
        }
        return result;
    }
}
