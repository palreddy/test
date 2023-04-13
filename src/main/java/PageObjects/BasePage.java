package PageObjects;

import Utilities.Utils;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BasePage extends DriverFactory {

    CommonPage commonPage= new CommonPage(DriverFactory.getDefaultDriver());

  static Utils utils=new Utils();


    public BasePage(WebDriver driver) {
       this.driver = driver;


   }

       public void openApplication(String key) {
        String  url= utils.readFromPropertiesFile(key);
        commonPage.getPage(url);
    }

        public void quitBrowser(){
            commonPage.quit();



}
public void implicitWait(){
    commonPage.implicitWait();


}


}
