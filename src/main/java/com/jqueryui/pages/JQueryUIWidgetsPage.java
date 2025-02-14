package com.jqueryui.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jqueryui.utils.DriverManager;

public class JQueryUIWidgetsPage {

	private WebDriver driver;

	@FindBy(linkText = "Accordion")
	WebElement accordianOptionWE;

	@FindBy(css = "iframe.demo-frame")
	WebElement iframeWE;

	@FindBy(css = "h3#ui-id-3")
	WebElement accordianSection2ElementWE;

	@FindBy(css = "h3#ui-id-5")
	WebElement accordianSection3ElementWE;

	@FindBy(linkText = "Autocomplete")
	WebElement autoCompleteOptionWE;

	@FindBy(css = "input#tags")
	WebElement tagsTextBoxWE;

	@FindBy(css = "li.ui-menu-item")
	List<WebElement> tagsMenuItemsWE;

	@FindBy(linkText = "Checkboxradio")
	WebElement checkBoxRadioOptionWE;

	@FindBy(xpath = "//label[@for='radio-2']")
	WebElement selectLocationRadioWE;

	@FindBy(xpath = "//label[@for='checkbox-4']")
	WebElement selectRatingChckBoxWE;

	@FindBy(xpath = "//label[@for='checkbox-nested-3']")
	WebElement selectBedTypeNestedChckBoxWE;

	@FindBy(css = "div.view-source")
	WebElement scrollTillViewSourceWE;

	@FindBy(linkText = "Controlgroup")
	WebElement controlGroupOptionWE;

	@FindBy(xpath = "//span[@id='car-type-button']/span[text()='Compact car']")
	WebElement carTypeDropDwnWE;

	@FindBy(css = "div#ui-id-4")
	WebElement compactCarOptionWE;

	@FindBy(xpath = "//label[@for='transmission-automatic']")
	WebElement automaticCarBulletWE;

	@FindBy(xpath = "//body[1]/div[1]/fieldset[1]/div[1]/span[2]/a[1]")
	WebElement numberOfCarsIconWE;

	@FindBy(linkText = "Datepicker")
	WebElement datePickerOptionWE;

	@FindBy(linkText = "Dialog")
	WebElement dialogOptionWE;

	@FindBy(xpath = "//span[text()='Basic dialog']")
	WebElement basicBoxDragBarWE;

	@FindBy(xpath = "//button[@title='Close']")
	WebElement closeIconButtonWE;

	public JQueryUIWidgetsPage() {

		this.driver = DriverManager.initDriver("browser");
		PageFactory.initElements(driver, this);
	}

	public void performAccordianOperation() {

		accordianOptionWE.click();
		driver.switchTo().frame(iframeWE);

		accordianSection2ElementWE.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		accordianSection3ElementWE.click();

	}

	public void autoCompleteOperation() {

		autoCompleteOptionWE.click();
		driver.switchTo().frame(iframeWE);

		tagsTextBoxWE.click();
		tagsTextBoxWE.sendKeys("a");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		List<WebElement> options = tagsMenuItemsWE;
		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("Asp")) {

				option.click();
				break;

			}

		}

	}

	public void checkBoxRadioOperation() {

		checkBoxRadioOptionWE.click();
		driver.switchTo().frame(iframeWE);

		selectLocationRadioWE.click();
		selectRatingChckBoxWE.click();

		Actions a = new Actions(driver);
		a.scrollToElement(selectBedTypeNestedChckBoxWE);
		selectBedTypeNestedChckBoxWE.click();

	}

	public void controlGroupOperation() throws InterruptedException {

		Actions a = new Actions(driver);
		// a.scrollToElement(scrollTillViewSourceWE);

		controlGroupOptionWE.click();
		driver.switchTo().frame(iframeWE);

		carTypeDropDwnWE.click();
		compactCarOptionWE.click();
		automaticCarBulletWE.click();
		numberOfCarsIconWE.click();

	}

	public void printDateUsingJs() {

		datePickerOptionWE.click();
		driver.switchTo().frame(iframeWE);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('datepicker').value='02/07/2025';");

	}

	public void performDialogBoxBasedOperations() throws InterruptedException {

		dialogOptionWE.click();
		driver.switchTo().frame(iframeWE);

		Actions a = new Actions(driver);
		a.dragAndDropBy(basicBoxDragBarWE, (int) 15.7, 134).build().perform();
		Thread.sleep(2000);
		
		closeIconButtonWE.click();

	}
}
