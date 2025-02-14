package com.jqueryui.pages;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jqueryui.utils.DriverManager;

public class JQueryUIPage {

	private WebDriver driver;

	@FindBy(linkText = "Draggable")
	WebElement draggableOptionWE;

	@FindBy(xpath = "//h1[@class='entry-title']")
	WebElement draggableTitleWE;

	@FindBy(xpath = "//iframe[@class='demo-frame']")
	WebElement demoFrame;

	@FindBy(css = "div#draggable")
	WebElement sourceDragBoxWE;

	@FindBy(linkText = "Droppable")
	WebElement droppableOptionWE;

	@FindBy(css = "div#droppable")
	WebElement targetDropBoxWE;

	@FindBy(linkText = "Resizable")
	WebElement resizableOptionWE;

	@FindBy(css = "div#resizable div.ui-icon-gripsmall-diagonal-se")
	WebElement resizableDiagonalIconWE;

	@FindBy(linkText = "Selectable")
	WebElement selectableOptionWE;

	@FindBy(css = "li.ui-selectee")
	List<WebElement> allSelectableItemsWE; // if fetching more than 1 WE, write list<WebElement> instead of WebElement
	
	@FindBy(linkText = "Sortable")
	WebElement sortableOptionWE;
	
	@FindBy(xpath = "//ul[@id='sortable']/li")
	List<WebElement> sortItemsListWE;


	public JQueryUIPage() {

		this.driver = DriverManager.initDriver("browser");
		PageFactory.initElements(driver, this);
		
		/* Selenium method used to initialize all the @FindBy annotated WebElements in the current class
		 * Connects the WebDriver instance (provided as driver) to the WebElements so that they can interact with the web page.
		 * driver: Refers to the WebDriver instance (in this case, provided by the DriverManager class) that will 
		 * be used to interact with the web page. 
		 * this: Refers to the current instance of the JQueryUIPage class. It tells the PageFactory to look for WebElements in this class. 
		 *  */

	}

	public void performDragOperation() {

		draggableOptionWE.click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Assert.assertTrue(draggableTitleWE.isDisplayed());

		driver.switchTo().frame(demoFrame);
		Actions action = new Actions(driver);
		action.dragAndDropBy(sourceDragBoxWE, 297, 68).build().perform();

	}

	public void performDragAndDropOperation() {

		droppableOptionWE.click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.switchTo().frame(demoFrame);
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceDragBoxWE, targetDropBoxWE).build().perform();

	}

	public void performResizableOperation() {

		resizableOptionWE.click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.switchTo().frame(demoFrame);
		Actions action = new Actions(driver);
		// action.clickAndHold(resizableDiagonalIconWE).moveByOffset(550,
		// 296).release(resizableDiagonalIconWE).build().perform();
		action.dragAndDropBy(resizableDiagonalIconWE, 538, 138).build().perform();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}

	public void performSelectableOperation() {

		selectableOptionWE.click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.switchTo().frame(demoFrame);

		System.out.println("**************User will select items");
		// List of items to select (Dynamic input)
		List<String> itemsToSelect = Arrays.asList("Item 1", "Item 3", "Item 4", "Item 7");//items to be selected will be passed here
		//Never cast findElements() return value to List<String>
		
		// Locate all selectable elements
		List<WebElement> options = allSelectableItemsWE;
		Actions action = new Actions(driver);

		// Press Ctrl key and select multiple options
		action.keyDown(Keys.CONTROL);
		for (WebElement option : options) {

			if (itemsToSelect.contains(option.getText())) {

				action.click(option);
			}
		}

		action.keyUp(Keys.CONTROL).build().perform();
	}
	
	public void performSortableOperation() throws InterruptedException {
		
		sortableOptionWE.click();
		//// Switch to the iframe if the sortable elements are inside one
		driver.switchTo().frame(demoFrame);
		System.out.println("**************User will sort items");
		
		//// Locate the sortable items
		List<WebElement> sortableItems =  sortItemsListWE;
		
		Actions action = new Actions(driver);
		
		 // Select the last item and move it below the first item
		WebElement sourceElement1 = sortableItems.get(6);
		WebElement targetElement1 = sortableItems.get(1);
		
		// Select the last item then and move it below the third item
		WebElement sourceElement2 = sortableItems.get(5);
		WebElement targetElement2 = sortableItems.get(2);
		
		 // Perform drag and drop
		action.clickAndHold(sourceElement1).moveToElement(targetElement1).release().perform();
		action.clickAndHold(sourceElement2).moveToElement(targetElement2).release().perform();
		
		Thread.sleep(4000);
		
	}
}
