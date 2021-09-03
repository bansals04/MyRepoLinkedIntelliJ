package Test.Inheritance;

import org.testng.annotations.Test;

public class ChildTest extends ParentTest{





    @Test
    public void CallingParent(){
        ChildTest c= new ChildTest();
        String s = c.IReturn("Well done");
        System.out.println(s);

    }

}
