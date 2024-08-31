package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    WebDriver driver;

    // Constructor
    public DragAndDropPage (WebDriver driver){
        this.driver = driver;
    }


    // Locators
    By dragMeBtn = By.id("draggable");
    By dropHereBtn = By.id("droppable");


    // Functions
    public void dragAndDrop (){
        driver.findElement(dragMeBtn);
        driver.findElement(dropHereBtn);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(dragMeBtn),driver.findElement(dropHereBtn)).build().perform();

    }
}
