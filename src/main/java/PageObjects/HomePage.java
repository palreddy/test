package PageObjects;

import Utilities.Utils;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class HomePage  extends DriverFactory {
    CommonPage commonPage= new CommonPage(DriverFactory.getDefaultDriver());
    private final String propertyFilePath= "src/test/resources/properties/locators.properties";
    private static Properties properties;
    Utils utils=new Utils();
    public HomePage(WebDriver webDriver) {
        this.driver = driver;
        properties= utils.read(propertyFilePath);
    }

    public void enterRegistartionNumber() {
       // driver.findElement(By.id(properties.getProperty("reg-number-locator"))).sendKeys("xyz");
        commonPage.enter(By.id(properties.getProperty("reg-number-locator")),"xyz");

    }

    public void clickButton() {
        commonPage.click(By.cssSelector(properties.getProperty("consent-locator")));
        //commonPage.webdriverWait(By.cssSelector(properties.getProperty("start-valuation-locator")));
       // driver.findElement(By.cssSelector(properties.getProperty("start-valuation-locator"))).click();
        commonPage.click(By.cssSelector(properties.getProperty("start-valuation-locator")));
    }

}
