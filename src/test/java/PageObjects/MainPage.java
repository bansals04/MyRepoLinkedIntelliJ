package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
