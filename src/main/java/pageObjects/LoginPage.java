package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    By userId = By.id("usr");
    By password = By.id("pwd");
    By logIn = By.xpath("//input[@type='submit']");
    By errorInfo = By.xpath("//h3[text()='ACCESS DENIED!']");
    By goBack = By.xpath("//*[@id=\"case_login\"]/a");
    By welcomeText = By.xpath("//h3[text()='WELCOME :)']");

    //Parameterized Constructor is used to pass on the life of the driver obj from HomePage to LandingPage.
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUserId(){
        return driver.findElement(userId);
    }

    public WebElement getPassword(){
        return driver.findElement(password);
    }

    public WebElement getSignIn(){
        return driver.findElement(logIn);
    }

    public WebElement getErrorMessage(){
        return driver.findElement(errorInfo);
    }

    public WebElement getBack(){
        return driver.findElement(goBack);
    }

    public WebElement getWelcomeMessage(){
        return driver.findElement(welcomeText);
    }
}
