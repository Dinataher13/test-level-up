package testPackage.Fluent;

import fluentPages.HomePageFluent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1Fluent {
    WebDriver driver;

    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
    }

    @Test
    public void checkPageTitle (){
        new HomePageFluent(driver)
                .navigation("https://www.google.com/")
                .checkPageTitle("Google");

    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
