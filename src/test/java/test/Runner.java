package test;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/test/resources/features"},
	glue= {"stepDefinitions", "support"},
	plugin = { "com.cucumber.listener.ExtentCucumberFormatter:report/cucumber-reports/TestReport.html"},
	monochrome = true
	)

public class Runner{
}