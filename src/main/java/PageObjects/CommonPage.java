package PageObjects;

import Utilities.Utils;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
        return  driver.getTitle();

    }
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public String getText(By by) {
       return driver.findElement(by).getText();

    }

    public String getPageSource() {
       return driver.getPageSource();
    }

    public void quit() {
        driver.quit();
    }
    public boolean verifyElementIsDisplayed(By by) {
       return  driver.findElement(by).isDisplayed();
    }


    public void webdriverWait(By by) {
    WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10L));
    //wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        //  wait.until(EC.frame_to_be_available_and_switch_to_it((by)));

    }

    public void webdriverWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
    }
//    WebDriverWait wait = new WebDriverWait(driver, 30);
//
//    wait.until(new ExpectedCondition<Boolean>() {
//        public Boolean apply(WebDriver wdriver) {
//            return ((JavascriptExecutor) driver).executeScript(
//                    "return document.readyState"
//            ).equals("complete");
//        }
//    });

    public void click(By by) {
        driver.findElement(by).click();
    }
    public void enter(By by,String key) {
        driver.findElement(by).sendKeys(key);
    }
    public String getSearchResults(By searchSucess,By searchFailure) throws InterruptedException {
        driver.getPageSource().length();
        System.out.println( driver.getPageSource().lines().toArray().toString());
        String result;
       Thread.sleep(2000);
        System.out.println(driver.getPageSource().contains("Sorry, we couldn't find a car with that registration. Please re-enter your registration number"));

        System.out.println(driver.getPageSource().contains("Our history checks show the MOT has expired."));

       // webdriverWait(flex);
        if ((driver.getPageSource().contains("Sorry, we couldn't find a car with that registration. Please re-enter your registration number")) ||
                (driver.getPageSource().contains("Our history checks show the MOT has expired."))) {
            result=  driver.findElement(searchFailure).getText();
            System.out.println("failure"+result);

        }
        else {
            result=   driver.findElement(searchSucess).getText();
            utils.orderResult(result);
            System.out.println("success"+result);
        }

        return result;
    }

}
