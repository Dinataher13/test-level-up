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
import pages.DragAndDropPage;
import pages.HomePage;

import java.time.Duration;

public class Test9Test {
    WebDriver driver;
    Wait<WebDriver> wait;
    HomePage homePage;
    DragAndDropPage dragAndDropPage;

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
        homePage.navigation("https://jqueryui.com/resources/demos/droppable/default.html");

    }
    @Test
    public void task9 (){
        dragAndDropPage = new DragAndDropPage(driver);
        wait.until(d -> {
            dragAndDropPage.dragAndDrop();
            return true;
        });

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
