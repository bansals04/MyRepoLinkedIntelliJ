package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AmazonPage {
    WebDriver ldriver;

    @FindBy(xpath = "//a[@href='/gp/browse.html?node=6648217031&ref_=nav_cs_fashion_ad6f81eb5d474066bc9e5788a3c19a28']") WebElement fashionLocator;
    @FindBy(id = "twotabsearchtextbox") WebElement searchFieldLocator;
    @FindBy(id = "nav-search-submit-button") WebElement searchButtonLocator;
    @FindBy(xpath = "//div[@data-component-type='s-search-result']") List<WebElement> searchResultsList;
    @FindBy(xpath = "//a[@data-csa-c-type='link' and @tabindex='0']") List<WebElement> allCategoriesList;
    @FindBy(id = "nav-link-accountList") WebElement myAccountLocator;
    @FindBy(xpath = "//a[starts-with(@class,'nav-link')]") List<WebElement> myAccountOptions;


    public AmazonPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
    }

    public void clickTabFashionCategory(){
            fashionLocator.click();
    }

    public void performSearch(String searchCriteria){
        searchFieldLocator.sendKeys(searchCriteria);
        searchButtonLocator.click();
    }

    public void printSearchResults(){
        System.out.println("Size of search results of Oppo mobile is : " + searchResultsList.size());
        for (WebElement e : searchResultsList){
            System.out.println(e.getText());
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public void showAllAmazonCategories(){
        System.out.println("There are total " +allCategoriesList.size() + " categories on Amazon Dashboard page.");
        for (WebElement e : allCategoriesList){
            System.out.println(e.getText());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    public void printAllAccountOptions() {
        Actions actions = new Actions(ldriver);

        //WebElement e1 = ldriver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(myAccountLocator);

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> e2 = ldriver.findElements(By.xpath("//a[starts-with(@class,'nav-link')]"));
        System.out.println("My account hove has " + e2.size() + " Options.");
        for (WebElement e3 : e2){
            System.out.println(e3.getText());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        }

    }
}
