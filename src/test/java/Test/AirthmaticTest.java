package Test;

import org.testng.annotations.Test;

public class AirthmaticTest extends Hello {

    @Test
    void Math1(){
        System.out.println("Airthmatic class - MET1");
    }

    @Test
    void Math2(){
        System.out.println("Airthmatic class - MET2");
        int i=9;
        int j =i/9;
    }
}
