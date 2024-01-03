package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags="", features="C:\\Users\\35193\\eclipse-workspace\\SeleniumAutomationFramework\\NopCommerce\\src\\test\\resources\\Features\\Customer.feature",
		glue="stepDefinations",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output"}
		
		)
public class testRun  {

	
}
