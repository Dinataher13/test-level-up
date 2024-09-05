package testPackage.Fluent;

import fluentPages.HomePageFluent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task4Fluent {
    WebDriver driver;


    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
    }

    @Test
    public void checkTheFourthResultText (){
        new HomePageFluent(driver).navigation("https://duckduckgo.com/")
                .search("TestNG")
                .checkResultText(4, "TestNG Tutorial");
    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
