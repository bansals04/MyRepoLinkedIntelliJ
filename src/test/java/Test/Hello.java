package Test;

import TestData.LoginTestData;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Hello{

    @Test(dataProvider = "userNames", dataProviderClass = LoginTestData.class)
    void callME(String a, String b){
        System.out.println("Test.Hello class or Base class- MET1");
        System.out.println(a);
        System.out.println(b);

    }

    @Test
    void callME2(){
        System.out.println("Test.Hello class- MET2");
    }

    @Test
    void callME3(){
        System.out.println("Test.Hello class- MET3");
    }
}