package testPackage.modular;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class Task2Test {
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
        homePage.navigation("https://duckduckgo.com/");

    }
    @Test
    public void task2 (){
        wait.until(d -> {
            boolean duckDuckLogo = driver.findElement(By.xpath("//div[@id= '__next']//section[@class='header_headerLeft__gTUAg header_headerSection__C99zW']//img")).isDisplayed();
            Assert.assertTrue(duckDuckLogo);
            return true;
        });

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
