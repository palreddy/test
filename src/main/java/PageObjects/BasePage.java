package PageObjects;

import Utilities.Utils;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BasePage extends DriverFactory {


    private static Properties properties;
    private final String propertyFilePath= "src/test/resources/properties/config.properties";
    Utils utils=new Utils();

    public BasePage(WebDriver webDriver) {
            this.driver = driver;

        properties= utils.read(propertyFilePath);
           // PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(propertyFilePath));
//            properties = new Properties();
//            try {
//                properties.load(reader);
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
//        }
    }



    public static String getApplicationUrl() {
        String url = properties.getProperty("url");
        System.out.println("............"+url);
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    private final String inputFilePath= "src/test/resources/testData/car_input_v2.txt";

    public static String getInputFileContent() {
        String url = properties.getProperty("url");
        System.out.println("............"+url);
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public void openApplication() {

        driver.get(getApplicationUrl());
    }

        public void quitBrowser(){
            driver.quit();
}
}
