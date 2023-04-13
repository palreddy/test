package PageObjects;

import factory.DriverFactory;
import org.openqa.selenium.By;

import java.util.Properties;

import static PageObjects.BasePage.utils;

public class ResultsPage {
    CommonPage commonPage= new CommonPage(DriverFactory.getDefaultDriver());
    BasePage basePage= new BasePage(DriverFactory.getDefaultDriver());
    private static Properties properties,propertiesLocator;
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
    public String getResults(String searchSuccess, String searchFailure) throws InterruptedException {

        return   commonPage.getSearchResults(By.cssSelector(properties.getProperty(searchSuccess)),
                By.cssSelector(properties.getProperty(searchFailure)));

    }

    public Boolean compareResultWithOutputFile(String path, String result) {
          String propertyFilePathForConfig= "src/test/resources/properties/config.properties";
       // propertiesLocator= utils.read(propertyFilePathForConfig);
     //   System.out.println("propertiesLocator...."+propertiesLocator);
        System.out.println("path..in page class...*****..."+path);
        System.out.println("comparision result"+ utils.compareresultsWithOutputFile(path,result));

        return utils.compareresultsWithOutputFile(path,result);

    }




}
