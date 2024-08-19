package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2Test {
    @Test
    public void basicTests1 (){

        WebDriver driver;
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        boolean googleLogo = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
        Assert.assertTrue(googleLogo);
        driver.quit();
    }
}
