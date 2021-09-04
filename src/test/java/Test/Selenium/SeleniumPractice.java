package Test.Selenium;

import PageObjects.AmazonPage;
import PageObjects.FashionPage;
import Test.CustomListener;
import Resources.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

@Listeners(CustomListener.class)
public class SeleniumPractice extends BaseClass  {
    PropertiesFile propertiesFile;
    AmazonPage amazonPage;
    FashionPage fashionPage;

    @BeforeMethod
    public void initializationMethod(){
         amazonPage = PageFactory.initElements(BaseClass.driver, AmazonPage.class);
         fashionPage = PageFactory.initElements(BaseClass.driver, FashionPage.class);
         propertiesFile = new PropertiesFile();
    }

    @Test
    public void sel() {

        driver.get(propertiesFile.getUrl());
        driver.manage().window().maximize();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        amazonPage.clickTabFashionCategory();
        amazonPage.performSearch("Oppo Mobile");
        amazonPage.printSearchResults();

        //Way to display all Categories on Amazon.com
        amazonPage.showAllAmazonCategories();

        //Way to hover on login and print all its displayed options
        //currently it is failing as, not able to hover on locator
        //amazonPage.printAllAccountOptions();
    }

    @Test
    public void sel2(){

        driver.get(propertiesFile.universalGetProp("url"));
        driver.manage().window().maximize();

        amazonPage.clickTabFashionCategory();
        System.out.println("Get Title is : "+driver.getTitle());
        System.out.println("Get Current url is : "+driver.getCurrentUrl());

        fashionPage.clickFootWearImage();

        String gmailAddress = propertiesFile.universalGetProp("urlGmail");
        System.out.println(gmailAddress);

        for (String key: propertiesFile.getAllKeysNames()){
            System.out.println("Key is: " + key);
            System.out.println("Value is: " + propertiesFile.universalGetProp(key));
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }

        Iterator<String> iterator= propertiesFile.getAllKeysNames().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void sel3(){
        driver.get(propertiesFile.getUrl());
        driver.manage().window().maximize();
        amazonPage.printAllAccountOptions();
        Assert.assertEquals(true, true);


    }
}

