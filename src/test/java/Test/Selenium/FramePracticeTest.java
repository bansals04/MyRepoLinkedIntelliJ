package Test.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class FramePracticeTest extends BaseClass {

    @FindBy(xpath = "//button[@data-testid='structured-search-input-search-button' and @type='button']") WebElement searchICON;
    @FindBy(id = "bigsearch-query-detached-query-suggestion-0") WebElement flexible;
    @FindBy(xpath = "//div[text()='Search']") WebElement ss;


    //@Test
    public void testFrame(){

        driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

        driver.switchTo().frame("frame1");
        
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello to Frame1 in page");

        driver.switchTo().frame("frame3");
        WebElement we = driver.findElement(By.id("a"));
        if(we.isSelected()){
            System.out.println("I am setting it as false");
            we.click();
        }else {
            System.out.println("I am setting it as true");
            we.click();
        }
        driver.switchTo().parentFrame();
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        textBox.sendKeys("Hello UPDATED to Frame1 in page");

        String keyseq =Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE);
        textBox.sendKeys(keyseq);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        WebElement dd = driver.findElement(By.id("animals"));
        Select select = new Select(dd);
        List<WebElement> st = select.getOptions();


        for (int i=0; i<=st.size()-1; i++){
            if(st.get(i).getText().equals("Big Baby Cat")){
                System.out.println();
                System.out.println("FOUND BIG BABY CAT++++++++++++++++++");
                break;
            }
        }

        select.selectByValue("big baby cat");
        System.out.println("********************FINISHED**************");
    }

    @Test
    public void switchTabsTest() throws InterruptedException {
        driver.get("https://www.airbnb.co.in/");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@name='query']")).click();

        driver.findElement(By.xpath("//li[@id='bigsearch-query-detached-query-suggestion-0' and @role='option']")).click();
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> we = driver.findElements(By.xpath("//div[@itemprop='itemList']//span[starts-with(@id,'title_')]"));
        for (WebElement a: we){
            if(a.getText().equals("Thirunelly, Kerala")){
                js.executeScript("arguments[0].click()", a);
              //  a.click();
            }
        }






    }

    //@Test
    public void tabsTest() throws InterruptedException {

        driver.get("https://www.google.co.in");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String css = "input[name='q']";
        WebElement we= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
        we.sendKeys("test", Keys.ENTER);

        List<WebElement> wslist = driver.findElements(By.xpath("//h1[text()='Search Results']/following::div[@id='rso']//h3"));
        System.out.println(wslist.size() + " : is the size of wslist");
        String mainWindowHandle = driver.getWindowHandle();


        Assert.assertTrue(wslist.size()!=0);
        for (int i=0; i<=wslist.size()-1 ; i++){
            System.out.println(wslist.get(i).getText());
            System.out.println();

            }

        Actions ac = new Actions(driver);
        for (int i=0; i<=wslist.size()-1 ; i++){
            if(wslist.get(i).getText().equals("Speedtest by Ookla - The Global Broadband Speed Test")){
                ac.keyDown(Keys.CONTROL).build().perform();
                wslist.get(i).click();
                ac.keyUp(Keys.CONTROL).build().perform();
                break;
            }
        }

        String getCurURL= driver.getCurrentUrl();
        System.out.println(getCurURL);
        String getTitle = driver.getTitle();
        System.out.println(getTitle);
        Set<String> st = driver.getWindowHandles();

        System.out.println(st.size());

        for (String s1 :st){
            if(!s1.equals(mainWindowHandle)){
                driver.switchTo().window(s1);
            }
        }



        System.out.println("SEARCHED+++++++++++++++++++++++++++++");
        driver.get("https://artoftesting.com/samplesiteforselenium#");
        String curTitle = driver.getTitle();
        System.out.println(curTitle + ": is cur Title");
        String windowHandle1=driver.getWindowHandle();
        System.out.println(windowHandle1);

        driver.findElement(By.xpath("//a[text()='This is a link']")).click();
        String curTitle1 = driver.getTitle();
        System.out.println(curTitle1 + ": is cur Title1");
        String windowHandle2=driver.getWindowHandle();
        System.out.println(windowHandle2);


    }
}
