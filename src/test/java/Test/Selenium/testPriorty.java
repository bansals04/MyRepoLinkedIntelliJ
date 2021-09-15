package Test.Selenium;
import org.testng.annotations.Test;

public class testPriorty {

    @Test(priority =1)
    public void w(){
        System.out.println("I am w");
    }

    @Test(priority =3)
    public void t2(){
        System.out.println("I am t2");
    }

    @Test(priority =1)
    public void t3(){
        System.out.println("I am t3");
    }

    @Test(priority =0)
    public void t4(){
        System.out.println("I am t4");
    }

}


