package com.jqueryui.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.jqueryui.utils.DriverManager;

public class JQueryUIWidgetsPage2 {

	private WebDriver driver;

	@FindBy(linkText = "Progressbar")
	WebElement progressbarOptionWE;

	@FindBy(css = "iframe.demo-frame")
	WebElement iframeWE;

	@FindBy(css = "div#progressbar")
	WebElement progressBarWE;

	@FindBy(linkText = "Slider")
	WebElement sliderOptionWE;

	@FindBy(css = "span.ui-slider-handle")
	WebElement sliderHandleWE;

	@FindBy(linkText = "Tooltip")
	WebElement toolTipOptionWE;

	@FindBy(xpath = "//a[text()='Tooltips']")
	WebElement toolTipsHoverWE;

	@FindBy(css = "input#age")
	WebElement ageTextBoxHoverWE;

	public JQueryUIWidgetsPage2() {

		this.driver = DriverManager.initDriver("browser");
		PageFactory.initElements(driver, this);

	}

	public void getStatusOfDeterminateProgressBar() {

		progressbarOptionWE.click();
		driver.switchTo().frame(iframeWE);

		// check progress status
		String progress;
		/*
		 * do { Thread.sleep(1000); progress = progressBarWE.getText();
		 * System.out.println("Current Progress: " +progress);
		 * 
		 * }while(!progress.equals("100%"));
		 * 
		 * System.out.println("Done");
		 */

		progress = progressBarWE.getDomAttribute("aria-valuenow"); // to get the default progress status
		System.out.println("CURRENT PROGRESS: " + progress);

	}

	public void getStatusOfIndeterminateProgressBar() {

		/*
		 * This is the bar which doesn't show progress in %. Mentioning here for
		 * practice. Will not use this method in our project for now. Will use Explicit
		 * wait to wait for Loader to disappear using
		 * ExpectedConditions.invisibilityOf().
		 */

		// get the WE of loader , let's take progressBarWE here
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(progressBarWE));
		System.out.println("LOADING COMPLETED");

	}

	public void performToolTipOperation() {

		toolTipOptionWE.click();
		driver.switchTo().frame(iframeWE);

		// Get the tooltip text from the 'title' attribute
		String toolTipsMessageText = toolTipsHoverWE.getDomAttribute("title");
		System.out.println("TOOL TIP TEXT:" + toolTipsMessageText);

		// Validate the tooltip text
		Assert.assertEquals(toolTipsMessageText, "That's what this widget is");

		Actions action = new Actions(driver);
		action.moveToElement(ageTextBoxHoverWE);
		
		String ageMessageText = ageTextBoxHoverWE.getDomAttribute("title");
		System.out.println("AGE TEXT MESSAGE: " + ageMessageText);

		// Validate the ageTextbox text
		Assert.assertEquals(ageTextBoxHoverWE.getDomAttribute("title"), "We ask for your age only for statistical purposes.");
		

	}

}
