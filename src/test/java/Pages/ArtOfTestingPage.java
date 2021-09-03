package Pages;

import DataModels.ArtOfTesting;
import Test.InterfacesPractice.LambdaTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ArtOfTestingPage {

    WebDriver driver;

    public ArtOfTestingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void fillFormArtOfTesting(String textValue, String gender, String testingType, String testingDropdownnValue){
        WebElement we = driver.findElement(By.id("fname"));
        we.sendKeys(textValue);
        WebElement submitButton = driver.findElement(By.id("idOfButton"));
        submitButton.click();

        List<WebElement> ls= driver.findElements(By.xpath("//input[@name='gender']"));
        for(WebElement w : ls){
            if(w.getAttribute("value").equals(gender)){
                w.click();
                Assert.assertTrue(w.isSelected());
            }
        }

        List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement selectCheckbox : checkbox){
            if(selectCheckbox.getAttribute("value").equals(testingType)){
                selectCheckbox.click();
                Assert.assertTrue(selectCheckbox.isSelected());
            }
        }

        //Select selewct = new Select();
        List<WebElement> testingDropdown = driver.findElements(By.xpath("//select[@id='testingDropdown']/option"));
        for (WebElement testDropdown :testingDropdown){
            if(testDropdown.getAttribute("value").equals(testingDropdownnValue)){
                testDropdown.click();
                Assert.assertTrue(testDropdown.isSelected());
            }
        }
       }

    public void selectRadioButton(ArtOfTesting artOfTesting){
        System.out.println(artOfTesting.TextBox);
        System.out.println(artOfTesting.TestingType);
        System.out.println(artOfTesting.Gender);


       }
}
