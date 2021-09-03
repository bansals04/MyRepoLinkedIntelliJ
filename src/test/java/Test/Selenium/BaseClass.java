package Test.Selenium;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;


import java.io.*;


public class BaseClass {

   public static WebDriver driver;


    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shubhi.bansal\\IdeaProjects\\Maven003\\src\\test\\java\\Drivers\\chromedriver.exe");
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

        //driver = new FirefoxDriver();
    }

    //@AfterClass
    public void closeBr(){
        driver.close();
    }

    /**
     * Method to take screenshots for failed TestCases
     */
    public void failed(ITestResult result){
        String methodName = result.getMethod().getMethodName();
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("C:\\Users\\shubhi.bansal\\IdeaProjects\\Maven003\\src\\test\\java\\Screenshots\\" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
