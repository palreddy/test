package Runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"StepDefinitions"  // predefined step definitions package
                // "info.seleniumcucumber.userStepDefintions" // user step definitions package
        },
       format = {
               "pretty", "html:target/cucumberHtmlReport",
                "html:target/cucumberHtmlReport",     //  for html result
                "pretty:target/cucumber-json-report.json"   // for json result
       }
)
public class TestRunner {


//        @AfterClass
//        public static void tearDownClass() {
//                // Close web driver
//                BaseScenario.quitDriver();
//        }
}