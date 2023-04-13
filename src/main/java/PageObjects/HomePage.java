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


    public void enterRegistartionNumber(String regNumber) {
       // driver.findElement(By.id(properties.getProperty("reg-number-locator"))).sendKeys("xyz");
        commonPage.enter(By.id(properties.getProperty("reg-number-locator")),regNumber);

    }
    public void clickButton() {
        commonPage.click(By.cssSelector(properties.getProperty("consent-locator")));
        commonPage.click(By.cssSelector(properties.getProperty("start-valuation-locator")));


    }


    public void clickButton(int count) {

        if(commonPage.getPageSource().contains("Accept All")){

            commonPage.click(By.cssSelector(properties.getProperty("consent-locator")));

        }


         //  if (count==1) {

        //commonPage.getSize(By.cssSelector(properties.getProperty("consent-locator")));

          //     commonPage.click(By.cssSelector(properties.getProperty("consent-locator")));

         //  }
            //commonPage.webdriverWait(By.cssSelector(properties.getProperty("start-valuation-locator")));
            // driver.findElement(By.cssSelector(properties.getProperty("start-valuation-locator"))).click();
            commonPage.click(By.cssSelector(properties.getProperty("start-valuation-locator")));

    }

}
