package Runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"StepDefinitions"
        },
        format = {
                "pretty", "html:target/cucumberHtmlReport",
                "html:target/cucumberHtmlReport",
                "pretty:target/cucumber-json-report.json"
        }
)
public class TestRunner {

}