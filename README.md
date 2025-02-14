
# jQuery UI - Interactions and Widgets - Cucumber BDD Framework 

This project automates various jQuery UI interactions and widgets using the Cucumber BDD framework with Selenium WebDriver. The framework follows Behavior-Driven Development (BDD) principles, allowing tests to be written in Gherkin syntax, making them more readable and understandable.

The project automates the following jQuery UI components:

Drag and Drop – Automates draggable and droppable elements.
Sortable Lists – Verifies reordering of list items.

Resizable Elements – Tests resizing of elements dynamically.
Sliders – Automates slider movements and value selection.

Accordions – Ensures proper expansion and collapse of accordion panels.

Tooltips – Validates correct tooltip display on hover.

Date Pickers – Automates date selection and validations.


## Authors

- Manvi Sharma [LinkedIn](https://www.linkedin.com/in/manvisharma4/)


## Tech Stack

**Programming Langugage:** Java 21

**Test Framework:** Cucumber

**Build Tool:** Maven

**Browser Automation:** Selenium WebDriver

**Reporting:** Cucumber HTML Reports


## Features

•	Cucumber BDD Integration:
    Uses feature files written in Gherkin syntax to define UI interactions.
    Step definitions map each scenario to corresponding Selenium actions.

•	Selenium WebDriver for UI Automation:
    Automates complex interactions like drag-and-drop, sliders, and modals.

•	Page Object Model (POM) Implementation:
    Ensures clean code structure by separating UI elements from step definitions.

•	Hooks for Test Setup & Cleanup:
    Uses AppHooks for precondition and postcondition setups (browser initialization, screenshots, etc.).
    
•	Cross-Browser Compatibility:
    Supports execution on multiple browsers (Chrome, Firefox, Edge)
•	Reporting:
    Generates Cucumber HTML Reports for test execution results.
