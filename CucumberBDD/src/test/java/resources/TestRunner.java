package resources;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "src/test/java/feature",   // Path to your .feature files
	    glue = "stepDefinitions",                   // Package with step definition files
	    plugin = {
	        "pretty", 
	        "html:target/cucumber-reports.html", 
	        "json:target/cucumber.json"
	    },
	    monochrome = true,
	    dryRun = false
	)

public class TestRunner extends AbstractTestNGCucumberTests {
}
