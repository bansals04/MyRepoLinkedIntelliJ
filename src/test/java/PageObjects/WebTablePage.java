package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablePage {

    WebDriver driver;

    public void WebTablePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@Summary='Sample Table']")
    WebElement table;

    @FindBy(xpath = "//table[@Summary='Sample Table']//thead[1]//tr[1]//th")  List<WebElement> tableHeaderNames;
    @FindBy(xpath = "//table[@Summary='Sample Table']//tbody[1]//tr") List<WebElement> rowsList;
    @FindBy(xpath = "//table[@Summary='Sample Table']//tfoot[1]//tr[1]") List<WebElement> footer;

    public List<WebElement> getRowsList(){
        return rowsList;
    }


}
