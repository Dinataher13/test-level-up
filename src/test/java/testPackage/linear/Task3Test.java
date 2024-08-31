package testPackage.linear;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task3Test {
    WebDriver driver;
    Wait<WebDriver> wait;

    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        driver.navigate().to("https://duckduckgo.com/");
    }

    @Test
    public void task3 (){
        By serachTxt = By.id("searchbox_input");
        driver.findElement(serachTxt).sendKeys("Selenium WebDriver", Keys.ENTER);
        wait.until(d -> {
            By firstResult = By.xpath("(//article//h2//a)[1]");
            String actualResult = driver.findElement(firstResult).getAttribute("href");
            System.out.println(actualResult);
            return true;
        });


    }

    @Test
    public void task4 (){
        By serachTxt = By.id("searchbox_input");
        driver.findElement(serachTxt).sendKeys("TestNG", Keys.ENTER);
        wait.until(d -> {
            By firstResult = By.xpath("(//article//h2)[4]");
            String actualResult = driver.findElement(firstResult).getText();
            String expectedTitle = "TestNG Tutorial";
            System.out.println(actualResult);
            Assert.assertEquals(actualResult,expectedTitle);
            return true;
        });


    }

    @AfterMethod
    public void tearDown (){
        driver.quit();

    }
}
