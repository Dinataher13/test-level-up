package fluentPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

public class ResultPageFluent {

    WebDriver driver;
    Wait<WebDriver> wait;

    //constructor

    public ResultPageFluent (WebDriver driver){
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    // Locators
    By anyResult;
    By resultLink;

    //Functions


    public void checkResultLink(int i, String expectedLink) {
        resultLink = By.xpath("(//article)[" + i + "]//h2/a");
        wait.until(d -> {
        String actualLink = driver.findElement(resultLink).getAttribute("href");
        Assert.assertEquals(actualLink, expectedLink);
        return true;
    });

    }
    public void checkResultText(int i, String expectedText) {
        anyResult = By.xpath("(//article)["+i+"]//h2");
        wait.until(d -> {
            String actualText = driver.findElement(anyResult).getText();
            Assert.assertEquals(actualText, expectedText);
            return true;
        });
    }

}
