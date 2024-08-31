package testPackage.linear;

import com.google.common.base.Verify;
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
        driver.navigate().to("https://duckduckgo.com/");
        boolean duckDuckLogo = driver.findElement(By.xpath("//section[@class='header_headerLeft__gTUAg header_headerSection__C99zW shrink']/a/img")).isDisplayed();
        Assert.assertTrue(duckDuckLogo);
        driver.quit();
    }
}
