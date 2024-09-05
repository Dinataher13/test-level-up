package testPackage.Fluent;

import fluentPages.HomePageFluent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2Fluent {
    WebDriver driver;

    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
    }

    @Test
public void checkLogoDisplay (){
        new HomePageFluent(driver)
                .navigation("https://duckduckgo.com/")
                .checkLogoVisibility();
    }
    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
