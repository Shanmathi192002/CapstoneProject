package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature/Home.feature",
        glue = "stepDefinition",
        tags="@home",
<<<<<<< HEAD
	plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-reports.html"}
)
public class HomeRunner extends AbstractTestNGCucumberTests{
	
}
=======
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-reports.html"}
)
public class HomeRunner extends AbstractTestNGCucumberTests{
	
}
>>>>>>> ef3c05e (Initial commit - Uploading Bookswagon Automation project)
