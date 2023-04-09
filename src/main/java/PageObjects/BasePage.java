package PageObjects;

import Utilities.Utils;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BasePage extends DriverFactory {

    CommonPage commonPage= new CommonPage(DriverFactory.getDefaultDriver());

  //  private static Properties properties;
  //  private final String propertyFilePath= "src/test/resources/properties/config.properties";
    static Utils utils=new Utils();


    public BasePage(WebDriver webDriver) {
       this.driver = driver;
   // properties= utils.read(propertyFilePath);
   }

        //properties= utils.read(propertyFilePath);
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

//public  List readFromInputFiles() {
//    File folder = new File(readFromPropertiesFile("input_file"));
//    System.out.println("folder" + folder);
//    File[] listOfFiles = folder.listFiles();
//    System.out.println("listOfFiles" + listOfFiles);
//
//
//    List regNumbers = null;
//    for (int i = 0; i < listOfFiles.length; i++) {
//        if (listOfFiles[i].isFile()) {
//            System.out.println("File " + listOfFiles[i].getName());
//            if (listOfFiles[i].getName().contains("car_input")) {
//                System.out.println("abc...." + readFromPropertiesFile("input_file") + "/" + listOfFiles[i]);
////utils.readContent(readFromPropertiesFile("input_file")+listOfFiles[i]);
//                regNumbers = utils.getRegistrationNumbers(readFromPropertiesFile("input_file") + "/" + listOfFiles[i].getName());
//            }
//        } else if (listOfFiles[i].isDirectory()) {
//            System.out.println("Directory " + listOfFiles[i].getName());
//        }
//    }
//    return regNumbers;
//}
//public static String constructInputFiles(){
//        String value=readFromPropertiesFile("input_file");
//
//        value=value+
//
//}

//    public  String readFromPropertiesFile(String key) {
//        System.out.println("key"+key);
//        String value = properties.getProperty(key);
//        System.out.println("............"+value);
//        if(value != null) return value;
//        else throw new RuntimeException("key not specified in the Configuration.properties file.");
//    }
    //private final String inputFilePath= "src/test/resources/testData/car_input.txt";

//    public static String getInputFileContent() {
//        String url = properties.getProperty("url");
//        System.out.println("............"+url);
//        if(url != null) return url;
//        else throw new RuntimeException("url not specified in the Configuration.properties file.");
//    }

    public void openApplication(String key) {
     // String url = null;
        String  url= utils.readFromPropertiesFile(key);
        commonPage.getPage(url);
      //  driver.get(readFromPropertiesFile("url"));
    }

        public void quitBrowser(){
            commonPage.quit();


            // driver.quit();
}
}
