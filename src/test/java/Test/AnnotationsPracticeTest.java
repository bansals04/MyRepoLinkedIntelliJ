package Test;

import org.testng.annotations.*;

public class AnnotationsPracticeTest {

    @Test
    public void t1(){
        System.out.println("I am method 1");
    }

    @Test
    public void t2(){
        System.out.println("I am method 2");
    }

    @Test
    public void t3(){
        System.out.println("I am method 3");
    }


    @BeforeMethod
    public void BM(){
        System.out.println("I am BEFORE Method");
    }

    @BeforeClass
    public void BC(){
        System.out.println("I am BEFORE Class");
    }

    @BeforeTest
    public void BT(){
        System.out.println("I am BEFORE Test");
    }


    @AfterClass
    public void B1C(){
        System.out.println("I am AFTER Class");
    }

    @AfterTest
    public void B1T(){
        System.out.println("I am AFTER Test");
    }
}
