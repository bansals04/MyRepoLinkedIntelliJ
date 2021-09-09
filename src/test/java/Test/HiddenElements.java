package Test;

import Test.Selenium.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HiddenElements extends BaseClass {


    @Test
    public void testHidden() throws InterruptedException {
        driver.get("https://courses.letskodeit.com/practice");
        WebElement hideElement = driver.findElement(By.id("hide-textbox"));
        hideElement.click();
        WebElement showElement = driver.findElement(By.id("show-textbox"));
        WebElement textField = driver.findElement(By.id("displayed-text"));


        Thread.sleep(900);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('displayed-text').style.display='block'");
        js.executeScript("document.getElementById('displayed-text').value='HELLO VISIBILITY'");
        showElement.click();
        Thread.sleep(900);
        textField.clear();
        Thread.sleep(900);

        WebElement hoverButton = driver.findElement(By.id("mousehover"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).build().perform();

        WebElement topButton= driver.findElement(By.xpath("//a[@href='#top']"));
        actions.click(topButton);

        Thread.sleep(900);
    }
}
