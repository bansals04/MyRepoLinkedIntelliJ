package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoPage {
        WebDriver driver;


       public SauceDemoPage(WebDriver driver){
            this.driver = driver;
           PageFactory.initElements(driver, this);
        }

        public void loginIntoPage(String username, String pwd){
           driver.findElement(By.id("user-name")).sendKeys(username);
           driver.findElement(By.id("password")).sendKeys(pwd);
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           driver.findElement(By.id("login-button")).click();
        }
}
