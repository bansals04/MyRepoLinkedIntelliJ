package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;


import java.util.Random;

public class GenerateRandomEmail {



    @Test(priority = -2)
    public void RandomEmail(){

      String a=RandomStringUtils.randomNumeric(2);
      String b= RandomStringUtils.randomAlphabetic(5);

        System.out.println(a);
        System.out.println(b);

      String finalString = a.toString() + b.toString() + "@gmail.com";
      System.out.println(finalString);



        String ipString = "WK21H008";

        String opString ="WK21H008";

        Assert.assertEquals(ipString.toString() , opString.toString());

        int length = opString.length();
        StringBuilder sb = new StringBuilder(opString);
        sb.reverse();

        char temp;

        for (int i=0; i <3; i++){
            temp = sb.charAt(i);

        }

        int numberInEnd =0;
    }

    @Test
    public void FactWithoutForLoop(){
        int fact=4;
        int answer = ff(fact);
        System.out.println("factorial of 4 is : "+answer);

    }

    public int ff(int n){

        return (n==0 || n==1) ? 1 : n * ff(n-1);
    }
    //below test are to verfy the priorty execution
    @Test(priority = -2)
    public void StringCheck(){
        String abc= "shubhi";
        String s = new String("shubhi");
        String x = "shubhi";

        System.out.println(abc.equals(s)); //true
        System.out.println(abc==s);//false
        System.out.println(abc==x); //true;
    }


    @Test(priority = -1)
    public void A1(){
        System.out.println("I am a1");
    }


    @Test(priority = -3)
    public void A2(){
        System.out.println("I am a2");
    }


    @Test(priority = 2)
    public void A3(){
        System.out.println("I am a3");
    }


    @Test(priority = 1)
    public void A4(){
        System.out.println("I am a4");
    }
}
