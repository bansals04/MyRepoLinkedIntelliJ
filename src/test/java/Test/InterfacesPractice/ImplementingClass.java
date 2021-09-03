package Test.InterfacesPractice;

import org.testng.annotations.Test;

public class ImplementingClass implements Int1{

    @Test
    void Test2(){
        System.out.println("Implementing class - MET1");
       Test1();

    }

     public void Test1(){
        System.out.println("Implementing class - MET2");
    }
}
