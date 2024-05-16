package Tests;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TestBase {
    public static WebDriver driver;
    public WebDriverWait wait;
    JavascriptExecutor executor;
    @BeforeClass
    public void openUrl()
    {
        // ChromeOptions options=new ChromeOptions();
        // options.addArguments("--remote-allow-origins=*");
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://admin-demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void closeUrl()
    {
        driver.quit();
    }
    @AfterMethod
    public void take_screenShot(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus())
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot...");
            TakesScreenshot sc=(TakesScreenshot) driver;
            File photo=sc.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(photo,new File("./screenshots/"+result.getName()+".png"));
        }
    }
}