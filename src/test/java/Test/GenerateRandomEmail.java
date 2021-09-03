package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;


import java.util.Random;

public class GenerateRandomEmail {



    @Test
    public void randomEmail(){

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
}
