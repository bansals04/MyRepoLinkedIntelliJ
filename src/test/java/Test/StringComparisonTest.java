package Test;

import Test.Selenium.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringComparisonTest extends BaseClass {



    @Test
    public void compareStrings() {

        String ipString = "WK21L099";
        String opString = "WK21L100";

        int flag=0;
        int len = opString.length();
        String firstHalf =ipString.substring(0, len-3);
        System.out.println();
        System.out.println("First half of intput string : " + firstHalf);

        String lastThreeDigits = ipString.substring(len - 3);
        System.out.println("Last half of input is: "+lastThreeDigits);

        int ii = Integer.parseInt(lastThreeDigits);
        String incrementedNumber =String.format("%04d", ++ii);

        String finalOutput= firstHalf+incrementedNumber;
        System.out.println("Final EXPECTED output is: " +finalOutput);

        if(ipString.length()!=finalOutput.length()) {
            System.out.println("String has different lengths");
        }
            for (int i=0; i<=len-1; i++){
                if(opString.charAt(i)!= finalOutput.charAt(i)){
                    flag = 1;
                }
            }

        if(flag==0) {
            System.out.println("flag is 0");
            System.out.println("String is incremented 1 successfully");
        }
        else {
            System.out.println("flag is 1");
            System.out.println("String is NOT incremented 1 successfully..FIX the strings");
        }

    }

}
