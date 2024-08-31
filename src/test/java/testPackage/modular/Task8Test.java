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
import pages.FileUploadedPage;
import pages.FileUploaderPage;
import pages.HomePage;
import pages.W3SchoolsPage;

import java.time.Duration;

public class Task8Test {
    WebDriver driver;
    Wait<WebDriver> wait;
    HomePage homePage;
    FileUploaderPage fileUploaderPage;
    FileUploadedPage fileUploadedPage;

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
        homePage.navigation("http://the-internet.herokuapp.com/upload");
    }
    @Test
    public void task8 (){
        fileUploaderPage = new FileUploaderPage(driver);
        fileUploadedPage = new FileUploadedPage(driver);
        wait.until(d -> {
            fileUploaderPage.uploadImage();
            fileUploaderPage.clickUpload();
            String fileUploadedText = fileUploadedPage.getFileUploadedText();
            System.out.println(fileUploadedText);
            Assert.assertEquals(fileUploadedText,"File Uploaded!");
            return true;
        });

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
