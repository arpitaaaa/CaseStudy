package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\resources\\Features\\login2.feature"}, 
glue = {"StepDefinition"},
monochrome = true, // to make console readable
dryRun = false	,
strict = true,
// for reporting use below plugin
plugin = {"html:testOutput/cucumber.html",
		"junit:testOutput/cucumber.xml",
		"json:testOutput/cucumber.json"}
)

public class Test_Runner {
	

}
