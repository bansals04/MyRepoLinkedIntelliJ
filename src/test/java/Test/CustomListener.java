package Test;

import Test.Selenium.BaseClass;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Locale;

public class CustomListener extends BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  " + "Taking screenshot of failed TestCase : " + result +"   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  ");
        failed(result);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  " +result.getMethod().getMethodName().toUpperCase(Locale.ROOT) +"IS PASSED" + "  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

}
