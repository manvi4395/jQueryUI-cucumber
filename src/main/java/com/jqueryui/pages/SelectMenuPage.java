package com.jqueryui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jqueryui.utils.DriverManager;

public class SelectMenuPage {

	private WebDriver driver;

	@FindBy(css = "iframe.demo-frame")
	WebElement iframeWE;

	@FindBy(linkText = "Selectmenu")
	WebElement selectMenuOptionWE;

	@FindBy(linkText = "Tooltip")
	WebElement toolTipOptionWE;

	@FindBy(css = "span#speed-button")
	WebElement speedOptionsWE;

	@FindBy(css = "span#files-button")
	WebElement filesOptionsWE;

	@FindBy(css = "span#number-button")
	WebElement numberOptionsWE;

	@FindBy(css = "span#salutation-button")
	WebElement salutationOptionsWE;

	@FindBy(css = "select#speed")
	List<WebElement> speedDropdownOptionsWE;

	@FindBy(css = "select#files")
	List<WebElement> filesDropdownOptionsWE;

	@FindBy(css = "select#number")
	List<WebElement> numberDropdownOptionsWE;

	@FindBy(css = "select#salutation")
	List<WebElement> salutationDropdownOptionsWE;

	public SelectMenuPage() {

		this.driver = DriverManager.initDriver("browser");
		PageFactory.initElements(driver, this);

	}

	public void selectMenu(String speed, String file, String number, String title) throws InterruptedException {

		Actions action = new Actions(driver);
		action.scrollToElement(toolTipOptionWE);

		selectMenuOptionWE.click();
		driver.switchTo().frame(iframeWE);

		speedOptionsWE.click();

		List<WebElement> selectedSpeeds = speedDropdownOptionsWE;
		for (WebElement s : selectedSpeeds) {

			if (s.getText().equals(speed)) {

				s.click();
				Thread.sleep(4000);
				break;
			}

		}

		/*
		 * filesOptionsWE.click();
		 * 
		 * List<WebElement> selectedFiles = filesDropdownOptionsWE; for (WebElement f :
		 * selectedFiles) {
		 * 
		 * if (f.getText().equals(file)) {
		 * 
		 * f.click(); break;
		 * 
		 * }
		 * 
		 * }
		 * 
		 * numberOptionsWE.click();
		 * 
		 * List<WebElement> selectedNumbers = numberDropdownOptionsWE; for (WebElement n
		 * : selectedNumbers) {
		 * 
		 * if (n.getText().equals(number)) {
		 * 
		 * n.click(); break; }
		 * 
		 * }
		 * 
		 * salutationOptionsWE.click();
		 * 
		 * List<WebElement> selectedTitles = salutationDropdownOptionsWE; for
		 * (WebElement t : selectedTitles) {
		 * 
		 * if (t.getText().equals(number)) {
		 * 
		 * t.click(); break; }
		 * 
		 * }
		 */
	}

}
