package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadedPage {
    WebDriver driver;

    // Constructor
    public FileUploadedPage (WebDriver driver){
        this.driver = driver;
    }


    //Locators
    By fileUploadedTxt = By.xpath("//div/h3[text()='File Uploaded!']");

    //Functions

    public String getFileUploadedText (){
        return driver.findElement(fileUploadedTxt).getText();

    }
}
