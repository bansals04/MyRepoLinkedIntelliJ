package Test;

import Test.Selenium.BaseClass;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class AutomatinInsiderTest extends BaseClass {


    @Test
    public void tabsTest() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.logfile", "C:\\Chromelog.txt");
        ((RemoteWebDriver) driver).setLogLevel(Level.INFO);

        driver.get("https://www.automationtestinginsider.com/");
        driver.manage().window().maximize();
        Thread.sleep(900);
        System.out.println("========================================================");


        List<WebElement> list1= driver.findElements(By.xpath("//div[@id='PageList2']//ul/li"));

        for (int i=1; i<list1.size(); i++){
            System.out.println(list1.get(i).getText());
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i=1; i<list1.size(); i++){
            if(list1.get(i).getText().equals("CONTACT US")){

                js.executeScript("arguments[0].scrollIntoView(true);",list1.get(i) );
                list1.get(i).click();
                System.out.println("========================================================");
                System.out.println(driver.getTitle());
                System.out.println("========================================================");
                System.out.println(driver.getCurrentUrl());
            }
        }

        Thread.sleep(900);

        driver.switchTo().frame("aswift_1");

        List <WebElement> ee= driver.findElements(By.xpath("//div[@id='stacked_layout']//div[contains(@class,'core-row')]"));
        System.out.println(ee);
        System.out.println("========================================================");
        System.out.println(ee.size() + ":  __List of images size");

        for (WebElement e : ee) {
            String classvalue = e.getAttribute("class");
            System.out.println(classvalue);
            System.out.println(" CLASS VALUE IS ABOVE PRINTED ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        //driver.findElements(By.xpath("//div[@id='stacked_layout']//div[contains(@class,'core-row')][1]//child::div"));


    }
}
