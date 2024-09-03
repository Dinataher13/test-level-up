package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    //Constructor
    public  HomePage (WebDriver driver){
        this.driver = driver;
    }

    // Locators

    By searchBoxTxt = By.id("searchbox_input");

    //Functions
    public void navigation (String URL){
        driver.navigate().to(URL);
    }

    public String getScreenTitle (){
        return driver.getTitle();
    }

    public void search (String searchQuery){
        driver.findElement(searchBoxTxt).sendKeys(searchQuery, Keys.ENTER);
        
    }



}
