import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1hw {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //Maximize the window.
        driver.manage().window().maximize();

        //Open google home page https://www.google.com/
        driver.get("https://www.google.com/");

        //Verify that title is Google.
        System.out.println(driver.getTitle().equals("Google") ? "Title is Google" : "Title is not Google");

        driver.close();
    }
}
