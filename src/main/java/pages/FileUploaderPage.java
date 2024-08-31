package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage {
    WebDriver driver;

    // Constructor
    public FileUploaderPage (WebDriver driver){
        this.driver = driver;
    }

    //Locators
    By chooseFileBtn = By.id("file-upload");
    By uploadBtn = By.id("file-submit");

    //Functions

    public void uploadImage (){
        driver.findElement(chooseFileBtn).sendKeys("/Users/dina/Desktop/384443901_6648514425266939_2487045429112459668_n.jpg");
    }

    public void clickUpload (){
        driver.findElement(uploadBtn).click();
    }
}
