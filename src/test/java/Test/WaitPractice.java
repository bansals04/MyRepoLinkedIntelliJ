package Test;

import Test.Selenium.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class WaitPractice  extends BaseClass {

    @Test
    public void waitTests() throws InterruptedException {
        driver.get("https://www.flipkart.com/");
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //WebDriverWait explicitWait= new WebDriverWait(driver, 100);
       // exwait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ffd")));

        driver.findElement(By.xpath("//button[text()='✕']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
      //  js.executeScript("window.scrollBy(0,7000)");


        WebElement we = driver.findElement(By.xpath("//a[text()='Return Policy']"));
        js.executeScript("arguments[0].scrollIntoView(false)", we );

        we.click();
        String ReturnPolicyTitle = driver.getTitle();
        System.out.println(ReturnPolicyTitle);
        Assert.assertEquals(ReturnPolicyTitle, "Returnpolicy Store Online - Buy Returnpolicy Online at Best Price in India | Flipkart.com");
        Thread.sleep(900);
    }

    @Test
    public void fib(){
        String s= "KAYLqYAK";

        int l = s.length();
        int flag=0;
        for(int i =0; i<=(l-1)/2; i++){
            if(s.charAt(i)!=s.charAt(l-1-i)){
                flag =1;
            }
        }
        if(flag==0){
            System.out.println("String is palindrome");
        }
        else{
            System.out.println("String is NOT palindrome");
        }
    }

}
