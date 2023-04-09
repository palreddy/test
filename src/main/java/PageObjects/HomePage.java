package PageObjects;

import Utilities.Utils;
import factory.DriverFactory;
import org.openqa.selenium.By;

import java.util.Properties;

public class HomePage   {
    CommonPage commonPage= new CommonPage(DriverFactory.getDefaultDriver());
    private final String propertyFilePath= "src/test/resources/properties/locators.properties";
    private static Properties properties;
    Utils utils=new Utils();
//    public HomePage(WebDriver webDriver) {
//        this.driver = driver;
//
//    }
    public HomePage() {
        properties= utils.read(propertyFilePath);
    }


    public void enterRegistartionNumber(Object o) {
       // driver.findElement(By.id(properties.getProperty("reg-number-locator"))).sendKeys("xyz");
        commonPage.enter(By.id(properties.getProperty("reg-number-locator")),o.toString());

    }

    public void clickButton(int count) {

        //System.out.println("....."+commonPage.verifyElementIsDisplayed(By.cssSelector(properties.getProperty("consent-locator"))));

           if (count==0) {
        //commonPage.getSize(By.cssSelector(properties.getProperty("consent-locator")));

               commonPage.click(By.cssSelector(properties.getProperty("consent-locator")));

           }
            //commonPage.webdriverWait(By.cssSelector(properties.getProperty("start-valuation-locator")));
            // driver.findElement(By.cssSelector(properties.getProperty("start-valuation-locator"))).click();
            commonPage.click(By.cssSelector(properties.getProperty("start-valuation-locator")));

    }

}
