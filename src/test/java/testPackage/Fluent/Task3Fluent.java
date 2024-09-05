package testPackage.Fluent;

import fluentPages.HomePageFluent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task3Fluent {
    WebDriver driver;


    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
    }

    @Test
    public void checkTheFirstResultLink (){
        new HomePageFluent(driver)
                .navigation("https://duckduckgo.com/")
                .search("Selenium WebDriver")
                .checkResultLink(1,"https://www.selenium.dev/documentation/webdriver/");
    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
