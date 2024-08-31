package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class W3SchoolsPage {
    WebDriver driver;

    // Constructor
    public  W3SchoolsPage (WebDriver driver){
        this.driver = driver;
    }

    // Locators

    By countryName = By.xpath("//*[@id='customers']//tr[4]/td[3]");
    By companyName = By.xpath("//*[@id='customers']//tr[4]/td[1]");

    // Functions

    public String getCompanyName (){
        return driver.findElement(companyName).getText();

    }

    public String getCountryName (){

       return driver.findElement(countryName).getText();
    }

}

