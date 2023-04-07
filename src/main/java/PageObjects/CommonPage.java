package PageObjects;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CommonPage extends DriverFactory {
    public CommonPage(WebDriver webDriver) {
        this.driver = driver;

    }

    public void webdriverWait(By by) {
    WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10L));
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
}
    public void click(By by) {
        driver.findElement(by).click();
    }
    public void enter(By by,String key) {
        driver.findElement(by).sendKeys(key);
    }
}
