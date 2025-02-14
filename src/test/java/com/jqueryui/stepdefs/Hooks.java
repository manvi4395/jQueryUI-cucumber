package com.jqueryui.stepdefs;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.jqueryui.utils.ConfigReader;
import com.jqueryui.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	/*
	 * ---- Hooks file should be in the same package as of the step definition ----
	 */

	private WebDriver driver;

	public Hooks() {

		String browser = ConfigReader.getProperty("browser");
		this.driver = DriverManager.initDriver(browser);

	}

	/*
	 * @Before public void setUp() {
	 * 
	 * String browser = ConfigReader.getProperty("browser");
	 * DriverManager.initDriver(browser); // DriverManager.getDriver();
	 * System.out.println("We are in hooks"); }
	 */

	@After
	public void takeScreenshotAfterStep(Scenario scenario) {
	
		
		if (scenario.isFailed()) {

			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName() + "_Failed");
		} else {

			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName() + "_Passed");
		}

		DriverManager.quitDriver();

	}

}
