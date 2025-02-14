package com.jqueryui.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src/test/resources/Features",
		glue = {"com.jqueryui.stepdefs"},
		monochrome = true,// Display console output in a readable format
		plugin = {
				"pretty",  
				"json:target/JSONReports/cucumber-reports.json",
				"html:target/HtmlReports/cucumber-reports.html"
				},
		tags = "@Widgets"
	
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
