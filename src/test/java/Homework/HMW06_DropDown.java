package Homework;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.Authenticator;
import java.sql.Driver;
import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HMW06_DropDown {
    /*
   Go to URL: https://the-internet.herokuapp.com/dropdown
   Create method selectByIndexTest and Select Option 1 using index .
   Create method selectByValueTest Select Option 2 by value.
   Create method selectByVisibleTextTest Select Option 1 value by visible text.
   Create method printAllTest Print all dropdown value.
   Verify the dropdown has Option 2 text.
   Create method printFirstSelectedOptionTest Print first selected option.
   Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
    */

    static WebDriver driver;
    static Select select;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


  /*  @Test
    public void checkBox1Test(){
        driver.get("https://demoqa.com/radio-button");
        WebElement var2 = driver.findElement(By.xpath());

        select = new Select(driver.findElement(checkBox));
        driver.findElement(checkBox).click();
        boolean isSelected = select.getFirstSelectedOption().isSelected();
        Assert.assertTrue(isSelected);
    }

   */

    @Test
    public void herOkuAppTest() {

        driver.get("https://demoqa.com/radio-button");
        WebElement pupUp = driver.findElement(By.xpath("//p[text()='İzin ver']"));
pupUp.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement checkBox= driver.findElement(By.xpath("//input[@id='yesRadio']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox);
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));

        select = new Select(checkBox);
        boolean isSelected = select.getFirstSelectedOption().isSelected();
        System.out.println(isSelected);


/*

        select = new Select(dropdownList);

        selectByIndexTest(dropdownList, 0);
        //selectByValueTest(dropdownList, "1");
        //selectByVisibleTextTest(dropdownList, "Please select an option");

        System.out.println(select.getFirstSelectedOption().getText());//Option 1
        System.out.println(select.getFirstSelectedOption().isSelected()); //true









    /*



        printAllTest(dropdownList);

        printFirstSelectedOptionTest(dropdownList);

        select = new Select(dropdownList);
        List<WebElement> list = select.getOptions();
        Assert.assertNotEquals("Expected Is Not Equal Actual", 4, list.size());

     */

    }


    public static void selectByIndexTest(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index); }

    public static void selectByValueTest(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);   }

    public static void selectByVisibleTextTest(WebElement element, String text) {
        select = new Select(element);
        select.selectByVisibleText(text);   }

    public static void printAllTest(WebElement element) {
        select = new Select(element);

        List<WebElement> allOptions = select.getOptions();
        //size test
        System.out.println("options.size() = " + allOptions.size()); //options.size() = 3
        int numberOfDropdownOptions = allOptions.size();
        Assert.assertEquals("Expected Is Not Equal Actual", 3, numberOfDropdownOptions);
        for (WebElement eachOption : allOptions) {
            System.out.println(eachOption.getText()); //webElement old icin getText dedik
        } }

    public void printFirstSelectedOptionTest(WebElement element){
        select = new Select(element);
        System.out.println(select.getFirstSelectedOption().getText());
    }
}

