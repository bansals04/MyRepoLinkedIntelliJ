package Test;


import Test.Selenium.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlertTest extends BaseClass {



    @Test
    public void testAlerts() throws InterruptedException {
        driver.get("http://www.seleniumframework.com/Practiceform/");
        driver.findElement(By.id("alert")).click();

        String text = driver.switchTo().alert().getText();
        Thread.sleep(900);
        driver.switchTo().alert().dismiss();

        System.out.println(text);
        String curHandle=driver.getWindowHandle();
        System.out.println(curHandle + "____Main window");

        driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
        Set<String> handles= driver.getWindowHandles();
        System.out.println(handles.size());
        for (String handle: handles){
            System.out.println(handle);
            if(!curHandle.equals(handle)){
                driver.switchTo().window(handle);

                System.out.println(driver.getWindowHandle() + "__I am opened dialog window");
                Thread.sleep(9000);
                driver.close();
                driver.switchTo().window(curHandle);
            }
        }
        System.out.println("I have closed the dialog");
        System.out.println(driver.getCurrentUrl() + "  __current url");
        System.out.println(driver.getTitle()+ "  __current Title");
        System.out.println(driver.getWindowHandle() + "  __current Window Handle");

        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello world how are you this morning");




    }


    @Test
    public void listVsSet(){
        List<String> list = new ArrayList<>();

        list.add("2");
        list.add("5");
        list.add("1");
        list.add("5");

        System.out.println(list);
        System.out.println(list.get(0));//Can access the list by index
        //LIST is ordered, indexed and can have duplicate values

        Set<String> ss = new HashSet<>();

        ss.add("2");
        ss.add("5");
        ss.add("1");
        ss.add("5");
        System.out.println(ss);
        //Set is unordered, unindexed. Set donot have duplicate values.

    }

}
