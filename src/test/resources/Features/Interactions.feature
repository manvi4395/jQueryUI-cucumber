#author: manvi4399@gmail.com
#Summary: TO perform different UI demos for jQuery application


@jQueryUIDemos
Feature: Perform different combination of jQuery UI Demos

	Background:
		Given user navigates to the jQuery UI demos application
		When user verify the title of the page
	
	@Interactions
	Scenario: User performs different UI Interactions
		And user performs Draggable interaction
		And user performs Droppable interaction
		And user performs Resizable interaction
		And user performs Selectable interaction
		Then user performs Sortable interaction  
		
	@Widgets
		Scenario: User performs different UI widgets operations
		And user performs Accordian operation
		And user performs Autocomplete operation
		And user performs CheckBoxRadio operation
		And user performs ControlGroup operation
		And user performs DatePicker operation
		And user performs Dialog operation
		And user performs ProgressBar operation
		And user performs SelectMenu operation
		Then user validate ToolTip message
	