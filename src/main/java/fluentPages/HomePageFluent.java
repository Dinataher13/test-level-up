package fluentPages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

public class HomePageFluent {
    WebDriver driver;
    Wait<WebDriver> wait;


    //Constructor
    public  HomePageFluent (WebDriver driver){

        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    // Locators

    By searchBoxTxt = By.id("searchbox_input");
    By duckDuckLogo = By.xpath("//div[@id= '__next']//section[@class='header_headerLeft__gTUAg header_headerSection__C99zW']//img");

    //Functions
    public HomePageFluent navigation (String URL){
        driver.navigate().to(URL);
        return this;
    }


    public ResultPageFluent search (String searchQuery){
        driver.findElement(searchBoxTxt).sendKeys(searchQuery, Keys.ENTER);
        return new ResultPageFluent(driver);

    }
    public void checkPageTitle ( String expectedTitle){

        wait.until(d -> {
            String actualTitle = driver.getTitle();
             Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println(actualTitle);
            return true;
        });
    }

    public void checkLogoVisibility (){
        wait.until(d -> {
            boolean pageLogo = driver.findElement(duckDuckLogo).isDisplayed();
            Assert.assertTrue(pageLogo);
            return true;
        });
    }


}
