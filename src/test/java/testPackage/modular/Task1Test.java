package testPackage.modular;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class Task1Test {
    WebDriver driver;
    Wait<WebDriver> wait;
    HomePage homePage;

    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        homePage = new HomePage(driver);
        homePage.navigation("https://www.google.com/");

    }

    @Test
    public void task1 (){
        String title = homePage.getScreenTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(title,expectedTitle);
        System.out.println(title);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
