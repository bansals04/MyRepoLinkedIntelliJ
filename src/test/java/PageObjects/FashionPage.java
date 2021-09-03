package PageObjects;

import Resources.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FashionPage {
    WebDriver driver;
    PropertiesFile propertiesFile= new PropertiesFile();


    @FindBy(xpath = "//img[@src='https://images-na.ssl-images-amazon.com/images/G/31/img21/Fashion/Flip/AW21/AFPage/WomenSBC/Eng/womens-collections-copy-2_02._SY530_QL85_.jpg']")

    WebElement fashion;

    public FashionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFootWearImage(){
        fashion.click();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle,propertiesFile.getFootwearTitle());

    }
}
