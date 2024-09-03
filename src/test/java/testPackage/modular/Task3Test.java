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
import pages.CheckBoxPage;
import pages.HomePage;
import pages.ResultsPage;

import java.time.Duration;

public class Task3Test {
    WebDriver driver;
    Wait<WebDriver> wait;
    HomePage homePage;
    ResultsPage resultsPage;

    @BeforeMethod
    public void setUp(){
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
    public void task3 (){
        resultsPage = new ResultsPage(driver);
        String searchTxt  = "Selenium WebDriver";
        homePage.search(searchTxt);
        wait.until(d -> {
            String actualResult = resultsPage.getLinkText(1);
            Assert.assertEquals(actualResult,"https://www.selenium.dev/documentation/webdriver/");
            return true;
        });


    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
