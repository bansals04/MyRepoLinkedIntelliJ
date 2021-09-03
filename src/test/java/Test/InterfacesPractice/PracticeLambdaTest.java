package Test.InterfacesPractice;

import TestData.LoginTestData;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PracticeLambdaTest {



    @Test(dataProvider = "lambdapassing", dataProviderClass = LoginTestData.class)
    public void helloLambda(String a1, String a2, String a3){
        System.out.println("Hello lambda expression");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }


    public List<String> MarketNames(){
        List<String> ls = new ArrayList<>();
        ls.add("a");
        ls.add("b");

        String a= "sample string";
        return ls;

    }

    @Test
    public void aaa() {
        System.out.println("start of test method");
//        Int3 obj = (st) -> { return 654; };
//        System.out.println(obj.lamda1("vege"));


    }

}
