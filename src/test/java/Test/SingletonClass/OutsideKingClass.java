package Test.SingletonClass;

import org.testng.annotations.Test;

public class OutsideKingClass {

    King king = King.method1("shubhi");

    @Test
    public void method1(){
        System.out.println(king);
        System.out.println(king.toString());
        //below line will print null
        System.out.println(king.nameField);
    }


}
