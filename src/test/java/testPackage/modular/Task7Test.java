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
import pages.W3SchoolsPage;

import java.time.Duration;

public class Task7Test {
    WebDriver driver;
    Wait<WebDriver> wait;
    HomePage homePage;
    W3SchoolsPage w3SchoolsPage;

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
        homePage.navigation("https://www.w3schools.com/html/html_tables.asp");
    }
    @Test
    public void task7 (){
        w3SchoolsPage = new W3SchoolsPage(driver);
        wait.until(d -> {
            String companyName = w3SchoolsPage.getCompanyName();
            String countryName = w3SchoolsPage.getCountryName();
            System.out.println(companyName);
            System.out.println(countryName);
            Assert.assertEquals(companyName,"Ernst Handel");
            Assert.assertEquals(countryName,"Austria");
            return true;
        });

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
