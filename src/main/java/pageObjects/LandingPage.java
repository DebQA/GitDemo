package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    WebDriver driver;
    By login = By.xpath("//a[text()=' LOGIN ']");

    //Parameterized Constructor is used to pass on the life of the driver obj from HomePage to LandingPage.
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogin(){
     return driver.findElement(login);
    }
}
