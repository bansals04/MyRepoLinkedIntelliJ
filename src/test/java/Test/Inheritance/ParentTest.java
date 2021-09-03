package Test.Inheritance;

import org.testng.annotations.Test;

public class ParentTest {

    @Test
    public String IReturn(String str){
        String ret = "Parent class : "+ str + "I am Concatinated";
        return ret;
    }
}
