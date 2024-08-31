package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public  HomePage (WebDriver driver){
        this.driver = driver;
    }


    public void navigation (String URL){
        driver.navigate().to(URL);
    }

    public String getScreenTitle (){
        return driver.getTitle();
    }




}
