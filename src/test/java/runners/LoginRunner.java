package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature/Login.feature",
        glue = "stepDefinition",
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-reports.html"}
)
public class LoginRunner extends AbstractTestNGCucumberTests{
	
}
