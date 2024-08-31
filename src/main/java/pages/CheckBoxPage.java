package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage {
    WebDriver driver;

    public CheckBoxPage (WebDriver driver){
        this.driver = driver;
    }

    //Locators

    By checkBox1 = By.xpath("//*[@id='checkboxes'][text()=' checkbox 1']");
    By checkBox2 = By.xpath("//*[@id='checkboxes']/input[2]");

    // Functions

    public boolean getCheckBox1Status (){
         return driver.findElement(checkBox1).isSelected();
    }

    public boolean getCheckBox2Status (){
        return driver.findElement(checkBox2).isSelected();
    }




}
