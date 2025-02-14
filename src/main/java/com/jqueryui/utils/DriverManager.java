package com.jqueryui.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverManager {

	private static WebDriver driver;

	public DriverManager() {
	}

	public static WebDriver initDriver(String browser) {

		if (driver == null) {

			switch (browser.toLowerCase()) {

			case "chrome":

				String projectPath = System.getProperty("user.dir");

				System.setProperty("webdriver.chrome.driver",
						projectPath + "/src/test/resources/Drivers/chromedriver.exe");

				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				System.out.println("Browser is chrome");
				break;

			case "firefox":

				String projectPathFire = System.getProperty("user.dir");

				System.setProperty("webdriver.gecko.driver",
						projectPathFire + "/src/test/resources/Drivers/geckodriver.exe");

				driver = new FirefoxDriver();
				System.out.println("Browser is firefox");
				break;

			default:

				throw new IllegalArgumentException("Unsupported browser:" + browser);

			}

		}

		return driver;

	}

	/*
	 * public static WebDriver getDriver() {
	 * 
	 * return driver;
	 * 
	 * }
	 */

	public static void quitDriver() {

		if (driver != null) {

			driver.quit();
			driver = null;
		}

	}

}
