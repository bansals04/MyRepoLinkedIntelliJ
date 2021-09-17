package Test;


import Test.Selenium.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class TakeElementScreenshot extends BaseClass {

    @Test
    public void new1() throws IOException {

        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
      //  driver.findElement(By.id("login"));
        WebElement ee = driver.findElement(By.id("user-name"));
        System.out.println("sdcw");

        String path = "C:\\Users\\shubhi.bansal\\IdeaProjects\\Maven003\\src\\test\\java\\Screenshots\\cap.png";
        File src= driver.findElement(By.id("user-name")).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File(path));


    }

    @Test
    public void shiftZeroInIntegerArray(){
        int[] a = {1,0,9,0,5,7,0,8};

        int length = a.length;
        int count =0;
        for(int i=0; i<length; i++){
            if(a[i]!=0){
                a[count++] = a[i];

            }
        }
        while(count<length)
            a[count++] = 0;

        System.out.println(Arrays.toString(a));

    }
}
