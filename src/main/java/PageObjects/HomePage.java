package PageObjects;

import Driver.DriverFactory;
import Utilities.Utils;
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

    public void enterCarDetails(String detail) {
        switch(detail) {
            case "milage":
                commonPage.enter(By.name(properties.getProperty("milage-locator")), utils.readFromPropertiesFile(detail));
                break;
            case "postcode":
                commonPage.enter(By.name(properties.getProperty("postcode-locator")), utils.readFromPropertiesFile(detail));
                break;
            default:
                commonPage.enter(By.name(properties.getProperty("reg-number-locator")), detail);
                break;
        }
    }

    public void clickButton(String x) {
        switch (x) {
            case "accept":

                if (commonPage.getPageSource().contains("Accept")) {
                    commonPage.click(By.id(properties.getProperty("consent-locator")));
                }
                    break;
                    case "confirm-vehicle":

                        if (commonPage.getPageSource().contains("This is my vehicle")) {
                            commonPage.click(By.xpath(properties.getProperty("confirm-vehicle-locator")));
                        }
                        System.out.println("confirm-vehicle");
                            break;

                            case "start-valuation":

                            commonPage.click(By.cssSelector(properties.getProperty("start-valuation-locator")));
                                System.out.println("start-valuation");
                            break;
                        }
                }
        }
