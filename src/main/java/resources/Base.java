package resources;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public Properties prop;

    public WebDriver initDriver() throws IOException {
    prop = new Properties();
    FileInputStream fis = new FileInputStream("C:\\Users\\IN-LT-69\\intelliJDemo\\src\\main\\java\\resources\\data.properties");
    prop.load(fis);
    String browser = prop.getProperty("browser");
    if(browser.equals("chrome")){
        //ChromeDriver Code
        System.setProperty("webdriver.chrome.driver","E:\\Software\\Selenium Driver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }else if(browser.equals("firefox")){
        //FirefoxDriver Code
        System.setProperty("webdriver.gecko.driver","E:\\Software\\Selenium Driver\\geckodriver-v0.20.1-win32\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
}

    public void getScreenshot(String result) throws IOException {
      File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\IN-LT-69\\intelliJDemo\\screenshot\\"+result+"_failedSCN_Screenshot.png"));
    }

}
