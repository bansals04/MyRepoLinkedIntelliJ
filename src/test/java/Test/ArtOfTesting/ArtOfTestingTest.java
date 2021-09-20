package Test.ArtOfTesting;

import DataModels.ArtOfTesting;
import Pages.ArtOfTestingPage;
import Test.Selenium.BaseClass;
import TestData.ArtOfTestingTestData;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ArtOfTestingTest extends BaseClass {
    ArtOfTestingPage artOfTestingPage;



    @BeforeMethod
    public void inMethod(){
        artOfTestingPage= PageFactory.initElements(BaseClass.driver, ArtOfTestingPage.class);
    }

    @Test(dataProvider = "ArtOfTestingDateset2", dataProviderClass = ArtOfTestingTestData.class)
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

     @Test
    public void findNumberOfCharinAString(){
        int num= 189287886;

        String s = "ABCDABCW";
        int length1= s.length();

         System.out.println(length1+ "___ length of string s");
        HashMap<Character, Integer> hmap = new HashMap<>();

        for(int i=0; i<=s.length()-1; i++){
            int val =1;
            if(hmap.containsKey(s.charAt(i))){

                hmap.put(s.charAt(i), ++val);
            }
            else{
                hmap.put(s.charAt(i), val);
            }
         }

        for(Map.Entry<Character, Integer> hh : hmap.entrySet()){
            System.out.println(hh);

        }
     }


     @Test(priority = -1)
    public void checkBrokenImage() throws IOException {
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> ls = driver.findElements(By.tagName("img"));
         System.out.println(ls.size()+ ": this is ls size()");

        for(WebElement oneImageLink : ls){
            if(oneImageLink != null) {

                CloseableHttpClient client = HttpClientBuilder.create().build();
                HttpGet request = new HttpGet(oneImageLink.getAttribute("src"));
                HttpResponse response = client.execute(request);

                if (response.getStatusLine().getStatusCode() != 200) {
                    System.out.println("response.getStatusLine() is :__    " + response.getStatusLine());
                    System.out.println("======================================================================================================");
                    System.out.println("response.getEntity() is :__    " + response.getEntity());
                    System.out.println("======================================================================================================");
                    System.out.println("response.getLocale() is :__    " + response.getLocale());
                    System.out.println("======================================================================================================");

                    System.out.println(oneImageLink.getAttribute("outerHTML") + " :  is broken............... ");
                }
            }
        }
     }
}
