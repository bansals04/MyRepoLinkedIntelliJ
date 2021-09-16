package Test;

import Test.Selenium.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

import java.util.HashMap;
import java.util.Map;


public class SeleniumTest extends BaseClass {

    @Test
    void TestSel(){
        System.out.println("Selenium class- MET1");
    }

    //https://www.saucedemo.com

    @Test
    public void testCssValues(){
        driver.get("https://www.saucedemo.com");
        String backgroundColor =driver.findElement(By.id("login-button")).getCssValue("background-color");
        String border =driver.findElement(By.id("login-button")).getCssValue("border");
        String color =driver.findElement(By.id("login-button")).getCssValue("color");

        String align = driver.findElement(By.className("login_logo")).getCssValue("text-align");

        System.out.println("backgroundColor______" + backgroundColor);
        System.out.println("border_________" + border);
        System.out.println("color______" + color);
        Assert.assertEquals(align, "center");

        Color vv  = Color.fromString(driver.findElement(By.id("login-button")).getCssValue("background-color"));
        System.out.println(vv);
    }


    public boolean sumInIntArray(){
        int[] arr = {1,2,5,4};
        int sumShallBe = 3;
        int count =0;

        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i= 0; i<arr.length; i++){
            int diff = sumShallBe- arr[i];
            System.out.println(hashMap + "+++++++++++++++++++++++" + "Now i value is");
            if(hashMap.containsKey(diff)){
                return true;
            }
            else {
                hashMap.put(arr[i], i);
            }
        }
        return false;
    }


    @Test
    public void tt(){
        boolean b = sumInIntArray();
        System.out.println(b);
    }


    @Test
    public void sumInIntArray11() {
        int[] arr = {1, 0, 6, 5, 4};
        int sumShallBe = 3;
        int count =0;
        int case1=0;

        System.out.println("Length of array___" + arr.length );
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            count ++;
            int diff = sumShallBe-arr[i];

            if(hashMap.containsKey(diff)){
                System.out.println("Two number with sum " + sumShallBe + " exists.");
                case1 = 1;
                System.out.println("I am case1 value" + case1);
                break;
            }
            else {
                hashMap.put(arr[i], i);
            }
        }

        if(case1 !=1) {
            System.out.println("Two number with sum " + sumShallBe + " DO NOT exists.");

        }
    }
}
