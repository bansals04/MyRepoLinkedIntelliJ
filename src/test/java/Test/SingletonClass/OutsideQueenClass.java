package Test.SingletonClass;

import org.testng.annotations.Test;

public class OutsideQueenClass {

    Queen obj = Queen.queen;
    Queen obj1 = Queen.queen;

    @Test
    public void methodQueen(){
        System.out.println(obj);
        System.out.println(obj1);
    }
}
