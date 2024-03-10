package Homework;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PracLocator {

    static WebDriver driver;


    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.linkedin.com");
    }
    @Test
    public void id(){
        WebElement id = driver.findElement(By.id("session_key"));
        System.out.println("name : " + id);
    }
    @Test
    public void testMethod() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println("Title is: " +driver.getTitle());
        Assert.assertEquals("Google",title);
        driver.quit();
    }
}
