package PageObjects;

import Utilities.Utils;
import factory.DriverFactory;
import org.openqa.selenium.By;

import java.util.Properties;

public class HomePage {
    private static Properties properties;
    private final String propertyFilePath = "src/test/resources/properties/locators.properties";
    CommonPage commonPage = new CommonPage(DriverFactory.getDefaultDriver());
    Utils utils = new Utils();

    public HomePage() {
        properties = utils.read(propertyFilePath);
    }

    public void enterRegistartionNumber(String regNumber) {
        commonPage.enter(By.id(properties.getProperty("reg-number-locator")), regNumber);
    }

    public void clickButton() {
        if (commonPage.getPageSource().contains("Accept All")) {
            commonPage.click(By.cssSelector(properties.getProperty("consent-locator")));
        }
        commonPage.click(By.cssSelector(properties.getProperty("start-valuation-locator")));
    }
}
