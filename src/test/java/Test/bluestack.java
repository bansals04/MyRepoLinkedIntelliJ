package Test;

import Test.Selenium.BaseClass;
import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

public class bluestack extends BaseClass  {
    WebDriver ldriver;

    @BeforeTest
    public void setBrowser(ITestContext context){
        String localPath = System.getProperty("user.dir") + "\\src\\test\\java\\";
        System.setProperty("webdriver.gecko.driver", localPath+ "Drivers\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/csv, application/ris, text/csv, data:image/png, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
        ldriver= new FirefoxDriver(firefoxOptions);
        context.setAttribute("lp", localPath);
    }

    @Test
    public void testBlueStack(ITestContext context) throws InterruptedException, IOException {
        ldriver.get("https://www.bluestacks.com/");
        ldriver.manage().window().maximize();
        File file = ldriver.findElement(By.cssSelector("span.so-button.download-bs5")).getScreenshotAs(OutputType.FILE);
        WebElement downloadIcon= ldriver.findElement(By.cssSelector("span.so-button.download-bs5"));
        String localPath= (String) context.getAttribute("lp");
        String path = localPath +"Screenshots\\Bluestack.png";
        FileHandler.copy(file, new File(path));



        File f = new File(localPath+ "Screenshots\\BluestackPage.png");
        if(f.exists()){
            System.out.println("File exists");
        }
        else {
            System.out.println("File not exists, I am taking screenshot");
            File page = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
            String pathToPageImage = localPath+ "Screenshots\\BluestackPage.png";
            FileHandler.copy(page, new File(pathToPageImage));
        }
        ldriver.findElement(By.cssSelector("span.so-button.download-bs5")).click();
        //ldriver.findElement(By.xpath("//span[normalize-space(@class)='so-button download-bs5']")).click();
        // Above line is also WORKING FINE CORRECTLY. iT SHOWCASE THE "normalize space" method.

        Thread.sleep(9000);
        System.out.println("test");

        File f1 = new File( "C:\\Users\\shubhi.bansal\\Downloads\\BlueStacksMicroInstaller_5.2.120.1002_native_7ad5e0515a389d93d340137981562c3b_0.exe");
        if(f1.exists()){
            System.out.println("File downloaded exists");
        }
        else{
            System.out.println("File not get downloaded");
        }

        //Above test is pending.
        //listCountries is pending to compare from database.
        //PDF get download directly in chrome only. how to setCapability in ChromeOptions to fix this.
    }

    //@Test
    public void downloadCSV(){
        ldriver.get("https://support.staffbase.com/hc/en-us/articles/360007108391-CSV-File-Examples");
        WebElement we = ldriver.findElement(By.xpath("//a[@href='https://support.staffbase.com/hc/en-us/article_attachments/360009197031/username.csv']"));
        we.click();

        System.out.println("Test in csv downloading");
    }



}
