package cucumberoptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
                plugin = {
                            "pretty",
                            "html:target/report/cucumber.html",
                            "json:target/report/cucumber.json"
                        },
                glue = {"stepdefinitions"})
public class testRunner {
    //tags = "@addPlace"
}
