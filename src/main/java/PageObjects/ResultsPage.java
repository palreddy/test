package PageObjects;

import factory.DriverFactory;
import org.openqa.selenium.By;

import java.util.Properties;

import static PageObjects.BasePage.utils;

public class ResultsPage {
    CommonPage commonPage= new CommonPage(DriverFactory.getDefaultDriver());
    BasePage basePage= new BasePage(DriverFactory.getDefaultDriver());
    private static Properties properties;
    private final String propertyFilePath= "src/test/resources/properties/locators.properties";

    public ResultsPage() {
        properties= utils.read(propertyFilePath);
    }
    public String getPageTitle() {
        // driver.findElement(By.id(properties.getProperty("reg-number-locator"))).sendKeys("xyz");
      String title=  commonPage.getTitle();
return title;
    }

    public String getsearchResult(String key) {

        String  value= utils.readFromPropertiesFile(key);

     return   commonPage.getText(By.cssSelector(value));

    }

    public boolean verifySearchStatus(String key) {
        return   commonPage.verifyElementIsDisplayed(By.cssSelector(properties.getProperty(key)));

    }

}
