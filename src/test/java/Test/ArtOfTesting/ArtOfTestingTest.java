package Test.ArtOfTesting;

import DataModels.ArtOfTesting;
import Pages.ArtOfTestingPage;
import Test.Selenium.BaseClass;
import TestData.ArtOfTestingTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;


public class ArtOfTestingTest extends BaseClass {
    ArtOfTestingPage artOfTestingPage;



    @BeforeMethod
    public void inMethod(){
        artOfTestingPage= PageFactory.initElements(BaseClass.driver, ArtOfTestingPage.class);
    }

    //@Test(dataProvider = "ArtOfTestingDateset2", dataProviderClass = ArtOfTestingTestData.class)
    public void Test1(ArtOfTesting artOfTestData) throws InterruptedException {
        driver.get("https://artoftesting.com/samplesiteforselenium#");

        artOfTestingPage.fillFormArtOfTesting(artOfTestData.TextBox, artOfTestData.Gender, artOfTestData.TestingType, artOfTestData.TestingDropdown);

        Boolean w = driver.findElement(By.cssSelector("#idOfButton[style]")).isDisplayed();
        Assert.assertTrue(w);

        Thread.sleep(9000);
     }


     @Test(dataProvider="userLists", dataProviderClass = ArtOfTestingTestData.class)
        public void userTest(int key, String val){

         System.out.println(key);

         System.out.println(val);
         System.out.println("wedw");

     }
}
