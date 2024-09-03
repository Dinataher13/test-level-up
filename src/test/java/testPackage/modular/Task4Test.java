package testPackage.modular;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultsPage;

import java.time.Duration;

public class Task4Test {
    WebDriver driver;
    Wait<WebDriver> wait;
    HomePage homePage;
    ResultsPage resultsPage;

    @BeforeMethod
    public void setUp (){
        driver = new FirefoxDriver();
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
    public void task4 (){
        resultsPage = new ResultsPage(driver);
        String searchQuery = "TestNG";
        homePage.search(searchQuery);
        wait.until(d -> {
        String expectedResult = "TestNG Tutorial";
        String resultText = resultsPage.getResultText(4);
        Assert.assertEquals(resultText,expectedResult);
            return true;
        });

    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }



}


