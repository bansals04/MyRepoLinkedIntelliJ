package Test;


import Test.Selenium.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AlertTest extends BaseClass {



    @Test
    public void openPdfPath()  {
        driver.get("http://www.seleniumframework.com/Practiceform/");
        driver.findElement(By.id("alert")).click();

        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        System.out.println(text);

    }



}
