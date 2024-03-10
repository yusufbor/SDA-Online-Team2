package Homework;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HMW09_Iframe {
    //Go to URL: http://demo.guru99.com/test/guru99home/
    //Find the number of iframes on the page.
    //Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
    //Exit the iframe and return to the main page.

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test1() {
        driver.get("http://demo.guru99.com/test/guru99home/");

        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total Frames --" + size); //Total Frames --8

        // click on the link in 3.iframe
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("/html/body/a")).click();

        // switchTo main page
        driver.switchTo().defaultContent();
    }

    @Test
    public void iFrameTest() throws InterruptedException {
        // Go to URL: http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");

        // Find the number of iframes on the page.
        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        System.out.println("iframe sayisi) = " + iframeList.size()); //iframe sayisi) = 8

        // click on the link in 3.iframe
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("/html/body/a")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
    }
}

