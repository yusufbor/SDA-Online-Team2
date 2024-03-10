package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.JScriptUtilities;

public class JsExeTask extends TestBase{
    /*
   Go to URL: https://api.jquery.com/dblclick/
   Double click on the blue square at the bottom of the page
   Write the changed color on search box on the top of the page
   Click "jQuery in Action" at the bottom of the page.

    */
    @Test
    public void test(){

        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);
        WebElement colouredButton =driver.findElement(By.cssSelector("body>div"));

        JScriptUtilities.scrollIntoViewJS(driver,colouredButton);

        Actions actions = new Actions(driver);
        actions
                .doubleClick(colouredButton)
                .perform();

        String colorCode = colouredButton.getCssValue("background-color");

        driver.switchTo().defaultContent();

        JScriptUtilities.scrollAllUpByJS(driver);

        driver.findElement(By.name("s")).sendKeys(colorCode);

        JScriptUtilities.scrollDownByJS(driver);
        driver.findElement(By.xpath("//a[@href = 'https://www.manning.com/books/jquery-in-action-third-edition']")).click();

    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.linkedin.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert(\"hi SDA\");");
        driver.switchTo().alert().accept();
Thread.sleep(3000);
        //Scrolling down by Jscript
        //1) "window.scrollBy(horizantal,vertical);"
        js.executeScript("window.scrollBy(0,3000);");
Thread.sleep(3000);
        //2)  "window.scrollTo(x,y);"
        WebElement button = driver.findElement(By.id("bottom-cta-section__header"));
        int x = button.getLocation().getX();
        int y = button.getLocation().getY();
Thread.sleep(3000);
        //js.executeScript("window.scrollTo("+x+","+y+");");

        //3) executeScript("arguments[0].scrollIntoView();",element)
        js.executeScript("arguments[0].scrollIntoView();",button);

    }
}
