package testPackage.linear;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1Test {

    @Test
            public void task1 (){

        WebDriver driver;
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        String expectedTitle = "Google";
       String title = driver.getTitle();
       Assert.assertEquals(expectedTitle,title);
        System.out.println(title);
        driver.quit();
    }



}
