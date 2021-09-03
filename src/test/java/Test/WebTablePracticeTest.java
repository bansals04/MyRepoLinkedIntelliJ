package Test;

import PageObjects.WebTablePage;
import Resources.PropertiesFile;
import Test.Selenium.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class WebTablePracticeTest extends BaseClass {

    WebTablePage webTablePage;


    @BeforeMethod
    public void initilizeMet()
    {
        webTablePage = PageFactory.initElements(BaseClass.driver, WebTablePage.class);
    }

    @Test
    public void assignmentTest() {

        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.manage().window().maximize();
        List<WebElement> rowsList = webTablePage.getRowsList();

        String[] structuresFinal = new String[5];

        for (int i = 0; i <= rowsList.size() - 1; i++) {
            WebElement rowHeader = rowsList.get(i).findElement(By.tagName("th"));
            structuresFinal[i] = rowHeader.getText();
        }

        System.out.println(Arrays.asList(structuresFinal));

    }

//code to find duplicated list values
//       WebElement we= driver.findElement(By.id("1"));
//        Actions ac = new Actions(driver);
//        ac.click(we);
//        List<WebElement> e2 = driver.findElements(By.xpath("a"));
//
//        for (WebElement e3 : e2) {
//            System.out.println(e3.getText());
//
//            for (int i =0; i<=e2.size(); i++){
//                String[] listCountries = e3.getText();
//            }
//
//            if(listCountries(i).getText().exists(StringCountries))
//                    String[] CopiedCountry=listCountries(i).getText ;
//
//            if(listCountries(i).getText().exists(StringCountries)==false)
//            String[] uniqueCountries = listCountries(i).getText ;
//        }




}
