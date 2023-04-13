package PageObjects;

import factory.DriverFactory;
import org.openqa.selenium.By;

import java.util.Properties;

import static PageObjects.BasePage.utils;

public class ResultsPage {
    private static Properties properties;
    private final String propertyFilePath = "src/test/resources/properties/locators.properties";
    CommonPage commonPage = new CommonPage(DriverFactory.getDefaultDriver());

    public ResultsPage() {
        properties = utils.read(propertyFilePath);
    }

    public String getPageTitle() {
        String title = commonPage.getTitle();
        return title;
    }
    public String getResults(String searchSuccess, String searchFailure) throws InterruptedException {
        return commonPage.getSearchResults(By.cssSelector(properties.getProperty(searchSuccess)),
                By.cssSelector(properties.getProperty(searchFailure)));
    }

    public Boolean compareResultWithOutputFile(String path, String result) {
        return utils.compareresultsWithOutputFile(path, result);

    }
}
