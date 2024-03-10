package Homework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownTask {
    public WebDriver driver;
    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");

    }
    @Test
    public void DropDown(){
        // Find the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("oldSelectMenu"));
        System.out.println(dropdownElement.getText().contains("Black"));


        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Get all the options of the dropdown
        List<WebElement> options = dropdown.getOptions();


        // Options size
        int optionsSize = options.size();
        System.out.println("Options size: " + optionsSize);

        // Print all options
        System.out.println("Options:");
        for (WebElement option : options) {
 //           System.out.println(option.getText());
        }

        List<String> optionsText = dropdown.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        System.out.println(optionsText);
        System.out.println(optionsText.size());
        boolean hasBlackOption = optionsText.contains("Black");
        System.out.println(hasBlackOption);
        Assert.assertTrue(hasBlackOption);

 /*
        // Verify if the dropdown has the option "Black"
        boolean isBlackPresent = false;
        for (WebElement option : options) {
            if (option.getText().equals("Black")) {
                isBlackPresent = true;
                break;
            }
        }

        if (isBlackPresent) {
            System.out.println("The dropdown has the option 'Black'");
        } else {
            System.out.println("The dropdown does not have the option 'Black'");
        }

        // Print the first selected option
        WebElement firstSelectedOption = dropdown.getFirstSelectedOption();
        System.out.println("First selected option: " + firstSelectedOption.getText());

*/

        // Select the option "Yellow"
        dropdown.selectByVisibleText("Yellow");
    }
    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

}
