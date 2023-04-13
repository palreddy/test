package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ErrorHandler;

import java.util.concurrent.TimeUnit;

public abstract class DriverFactory {
    public static long DEFAULT_WAIT = 20;
    // public String getPageTitle(){ return webdriver.getTitle();}
    protected static WebDriver driver;
    protected WebDriver webdriver;

    public static WebDriver getDefaultDriver() {
        if (driver != null) {
            return driver;
        }

        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver");
        DesiredCapabilities capabilities;
        capabilities = new DesiredCapabilities(new FirefoxOptions());
        // capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        driver = chooseDriver(capabilities);
        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT,
                TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver chooseDriver(DesiredCapabilities capabilities) {
        String preferredDriver = System.getProperty("browser", "Firefox");
        boolean headless = System.getProperty("Headless", "true").equals("true");

        switch (preferredDriver.toLowerCase()) {
            case "chrome":
                final ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

                ChromeDriver driver = new ChromeDriver();

                ErrorHandler handler = new ErrorHandler();
                handler.setIncludeServerErrors(false);
                driver.setErrorHandler(handler);
                return driver;

            default:
                FirefoxOptions options = new FirefoxOptions();
                if (headless) {
                    options.addArguments("-headless", "-safe-mode");
                }
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
                final FirefoxDriver firefox = new FirefoxDriver();
                return firefox;
        }
    }

}
