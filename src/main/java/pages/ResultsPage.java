package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage {
    WebDriver driver;

    //constructor

    public ResultsPage (WebDriver driver){
        this.driver = driver;
    }

    // Locators
    By firstResult = By.xpath("(//article)[1]//h2/a");
    By anyResult;
    By resultLink;

    //Functions
//    public String getFirstResultLink() {
//        return driver.findElement(firstResult).getAttribute("href");
//    }

    public String getLinkText(int i){
        resultLink = By.xpath("(//article)["+i+"]//h2/a");
        return driver.findElement(resultLink).getAttribute("href");
    }
    public String getResultText(int i) {
        anyResult = By.xpath("(//article)["+i+"]//h2");
        return driver.findElement(anyResult).getText();
    }
}
