package Homework;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTask01 {
    public static void main(String[] args) {


        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("http://demo.automationtesting.in/Alerts.html");

        // Click "Alert with OK"

        WebElement alertWithOkButton = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
        alertWithOkButton.click();

        // Switch to the alert and accept it
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        alert.accept();

        // Click "Alert with OK & Cancel"
        By alertWithOkAndCancelLink = By.xpath("//a[@href='#CancelTab']");
        driver.findElement(alertWithOkAndCancelLink).click();
        By alertWithOkAndCancelButton = By.xpath("//button[@onclick='confirmbox()']");
        driver.findElement(alertWithOkAndCancelButton).click();


        // Switch to the alert and dismiss it
        alert = driver.switchTo().alert();
        alert.dismiss();

        // Click "Alert with Textbox"
        By alertWithTextBoxLink = By.xpath("//a[@href='#Textbox']");
        driver.findElement(alertWithTextBoxLink).click();
        By alertWithTextBoxButton = By.xpath("//button[@onclick='promptbox()']");
        driver.findElement(alertWithTextBoxButton).click();


        // Switch to the alert and send keys to the text box
        alert.sendKeys("«Bootcamp» Taef");
        alert.accept();


        By message1 = By.xpath("//p[@id='demo1']");
        String actualMessage1 = driver.findElement(message1).getText();
        System.out.println(actualMessage1);
        Assert.assertEquals("Hello «Bootcamp» Taef How are you today",actualMessage1);

    }


}
