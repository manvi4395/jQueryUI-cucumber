package com.jqueryui.stepdefs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jqueryui.pages.JQueryUIPage;
import com.jqueryui.pages.JQueryUIWidgetsPage;
import com.jqueryui.pages.JQueryUIWidgetsPage2;
import com.jqueryui.pages.SelectMenuPage;
import com.jqueryui.utils.ConfigReader;
import com.jqueryui.utils.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JQueryUIDemosStepDef {

	// private WebDriver driver = DriverManager.getDriver();

	private WebDriver driver = DriverManager.initDriver("chrome");
	private JQueryUIPage jqueryUIPage = new JQueryUIPage();
	private JQueryUIWidgetsPage jQueryUIWidgetsPage = new JQueryUIWidgetsPage();
	private JQueryUIWidgetsPage2 jQueryUIWidgetsPage2 = new JQueryUIWidgetsPage2();
	private SelectMenuPage selectMenuPage = new SelectMenuPage();

	@Given("user navigates to the jQuery UI demos application")
	public void user_navigates_to_the_j_query_ui_demos_application() {

		System.out.println("**************We are inside first step");
		String baseURL = ConfigReader.getProperty("base.url");
		// DriverManager.getDriver().get(baseURL);
		driver.get(baseURL);

		System.out.println("**************User has landed on the current page");
	}

	@When("user verify the title of the page")
	public void user_verify_the_title_of_the_page() {

		String actualTitle = driver.getTitle();
		String expectedTitle = "jQuery UI";

		Assert.assertEquals(expectedTitle, actualTitle);

		System.out.println("**************The title of the page:" + actualTitle);
	}

	// ***************** Scenario 1 *****************

	@And("user performs Draggable interaction")
	public void user_performs_draggable_interaction() {

		jqueryUIPage.performDragOperation();
		System.out.println("**************User has performed the drag operation");
		driver.switchTo().defaultContent();

	}

	@And("user performs Droppable interaction")
	public void user_performs_droppable_interaction() {

		jqueryUIPage.performDragAndDropOperation();
		System.out.println("**************User has performed the drag and drop operation");
		driver.switchTo().defaultContent();
	}

	@And("user performs Resizable interaction")
	public void user_performs_resizable_interaction() {

		jqueryUIPage.performResizableOperation();
		System.out.println("**************User has performed the resizable operation");
		driver.switchTo().defaultContent();
	}

	@And("user performs Selectable interaction")
	public void user_performs_selectable_interaction() {

		jqueryUIPage.performSelectableOperation();
		System.out.println("**************User has performed the selectable operation");
		driver.switchTo().defaultContent();
	}

	@Then("user performs Sortable interaction")
	public void user_performs_sortable_interaction() throws InterruptedException {

		jqueryUIPage.performSortableOperation();
		System.out.println("**************User has performed the sortable operation");
		driver.switchTo().defaultContent();

	}

	// ***************** Scenario 2 *****************

	@And("user performs Accordian operation")
	public void user_performs_accordian_operation() {

		jQueryUIWidgetsPage.performAccordianOperation();
		System.out.println("**************User has performed the Accordian operation");
		driver.switchTo().defaultContent();
	}

	@And("user performs Autocomplete operation")
	public void user_performs_autocomplete_operation() {

		jQueryUIWidgetsPage.autoCompleteOperation();
		System.out.println("**************User has performed the Autocomplete operation");
		driver.switchTo().defaultContent();
	}

	@And("user performs CheckBoxRadio operation")
	public void user_performs_check_box_radio_operation(){
		
		jQueryUIWidgetsPage.checkBoxRadioOperation();
		System.out.println("**************User has performed the CheckBoxRadio operation");
		driver.switchTo().defaultContent();
	}

	@And("user performs ControlGroup operation")
	public void user_performs_control_group_operation() throws InterruptedException {
	
		jQueryUIWidgetsPage.controlGroupOperation();
		System.out.println("**************User has performed the ControlGroup operation");
		driver.switchTo().defaultContent();
	}

	@And("user performs DatePicker operation")
	public void user_performs_date_picker_operation() {
		
		jQueryUIWidgetsPage.printDateUsingJs();
		System.out.println("**************User has performed the DatePicker operation");
		driver.switchTo().defaultContent();
	}

	@And("user performs Dialog operation")
	public void user_performs_dialog_operation() throws InterruptedException {
		
		jQueryUIWidgetsPage.performDialogBoxBasedOperations();
		System.out.println("**************User has performed the Dialog operation");
		driver.switchTo().defaultContent();
	}

	@And("user performs ProgressBar operation")
	public void user_performs_progress_bar_operation() {

		jQueryUIWidgetsPage2.getStatusOfDeterminateProgressBar();
		System.out.println("**************User has performed the ProgressBar operation");
		driver.switchTo().defaultContent();
	}

	@And("user performs SelectMenu operation")
	public void user_performs_select_menu_operation() throws InterruptedException {
		
		//selectMenuPage.selectMenu("Faster", "ui.jQuery.js", "6", "Dr.");
		System.out.println("**************User has performed the SelectMenu operation");
		//driver.switchTo().defaultContent();
	}

	@Then("user validate ToolTip message")
	public void user_validate_ToolTip_message() {

		jQueryUIWidgetsPage2.performToolTipOperation();
		System.out.println("**************User has performed the ToolTip operation");
	}

}
