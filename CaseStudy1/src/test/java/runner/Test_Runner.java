package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src\\test\\resources\\FeatureFiles"},
glue = {"Stepdefinition"},
monochrome = true, 
strict = true,
plugin = {"html:testOutput/cucumber.html",
		"junit:testOutput/cucumber.xml",
		"json:testOutput/cucumber.json"}
)
public class Test_Runner extends AbstractTestNGCucumberTests{
	

}
