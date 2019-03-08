package com.howtodoinjava;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.LoginPage;
import resources.Base;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;


public class HomePage extends Base {

    private LoginPage lgnPage;
    private static Logger log = LogManager.getLogger(HomePage.class.getName());

    @BeforeTest
    public void init() throws IOException {
        driver = initDriver();
        log.debug("Driver is being Initialized..");
        driver.get(prop.getProperty("url"));
        log.info("Opened URL");
        driver.manage().window().maximize();
        System.out.println("GIT Add Sample Test!");
    }

    @Test(dataProvider = "getData")
    public void navigateToHomePage(String userName, String password) {
        lgnPage = new LoginPage(driver);
        lgnPage.getUserId().sendKeys(userName);
        log.info("Entered username");
        lgnPage.getPassword().sendKeys(password);
        lgnPage.getSignIn().click();
        log.debug("Clicked on Sign In..");
        String welcome = lgnPage.getWelcomeMessage().getText();
        log.info(welcome);
        log.error("No Text found");
        lgnPage.getBack().click();
        System.out.println("GIT Another new step!");

    }
    @AfterTest
     public void tearDown(){
        driver.close();
        log.info("Browser Closed");
        driver = null;
        System.out.println("GIT Final Step!");
        System.out.println("Few more steps");
    }

    @DataProvider
    public  Object[][] getData(){
        Object[][]  data = new Object[2][2];
        //data entry
        data[0][0] = "admin";
        data[0][1] = "12345";

        data[1][0] = "admin123";
        data[1][1] = "12345";
        return data;
    }

}
