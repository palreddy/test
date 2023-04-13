package PageObjects;

import Utilities.Utils;
import factory.DriverFactory;

public class BasePage  {
    static Utils utils = new Utils();
    CommonPage commonPage = new CommonPage(DriverFactory.getDefaultDriver());

    public void openApplication(String key) {
        String url = utils.readFromPropertiesFile(key);
        commonPage.getPage(url);
    }
    public void quitBrowser() {
        commonPage.quit();
    }
    public void implicitWait() {
        commonPage.implicitWait();
    }
}
