package com.jqueryui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerFromCalender {

	public static void main(String[] args) throws InterruptedException {
		
		// Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/"); // Change URL to your application
        driver.manage().window().maximize();
        
        // Switch to iframe if calendar is inside an iframe (Only for jQuery UI example)
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        
        // Select the date dynamically
        selectDate(driver, "15", "July", "2025");

        // Close browser
        Thread.sleep(3000);
        driver.quit();
    }

    public static void selectDate(WebDriver driver, String day, String month, String year) {
        // Click to open the calendar (for popup calendar)
        driver.findElement(By.id("datepicker")).click();

        // Select the correct year
        while (true) {
            String displayedYear = driver.findElement(By.className("ui-datepicker-year")).getText();
            if (displayedYear.equals(year)) {
                break;
            }
            driver.findElement(By.className("ui-datepicker-next")).click(); // Click Next if year doesn't match
        }

        // Select the correct month
        while (true) {
            String displayedMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
            if (displayedMonth.equals(month)) {
                break;
            }
            driver.findElement(By.className("ui-datepicker-next")).click(); // Click Next if month doesn't match
        }

        // Select the date
        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));
        for (WebElement e : days) {
            if (e.getText().equals(day)) {
                e.click();
                break;
            }
        }
 

	}

}
