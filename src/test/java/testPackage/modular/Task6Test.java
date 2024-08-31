package testPackage.modular;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.HomePage;

import java.time.Duration;

public class Task6Test {
    WebDriver driver;
    Wait<WebDriver> wait;
    HomePage homePage;
    CheckBoxPage checkBoxPage;

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
        homePage.navigation("http://the-internet.herokuapp.com/checkboxes");

    }

    @Test
    public void task6 (){
        checkBoxPage = new CheckBoxPage(driver);
        wait.until(d -> {
            boolean checkBox1IsSelected = checkBoxPage.getCheckBox1Status();
            boolean checkBox2IsSelected = checkBoxPage.getCheckBox2Status();
            Assert.assertTrue(checkBox1IsSelected);
            Assert.assertTrue(checkBox2IsSelected);
            return true;
        });

    }

    @AfterMethod
            public void tearDown(){
              driver.quit();
    }
}
