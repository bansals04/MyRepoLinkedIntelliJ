package Test;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IncedoTest {
/*
    int[] input={2,2,3,4,5,6,6}
    q1: write integer array with unique elements from input array
    int[] output={2,3,4,5,6}

    q2: Occurrence of each integer in input array
    {2:2},{3:1},{4:1},{5:1},{6:2}

    q3: Print last repeated character from input
    out:6

*/
    int[] input={2,2,8,4,5,3,6,7,3,8};

    @Test
    public void intarray(){


        System.out.println(Arrays.toString(input));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] redundantArray = new int[input.length];
        int[] outputArray;
        int val=0;

        for (int i=0; i<= input.length-1; i++){
            if(hashMap.containsKey(input[i])){
                System.out.println("key already exists at position number: "+i + ". Value is " + input[i]);
                redundantArray[val++] = input[i];
            }
            else {
                hashMap.put(input[i], i);
            }
        }
        System.out.println(Arrays.toString(redundantArray) + " This is redundant array");
        System.out.println();
        int dd = duplicacyRemoved();
        System.out.println(dd+ " : Length of array");
        for(int h=0; h<dd; h++){
            System.out.println(input[h] + " Hello");
        }
    }

    public int duplicacyRemoved(){
        //input={2,2,3,4,5,6,6};
        int len = input.length;

        int b=0;

        for(int j =0; j<len-1; j++){

            if(input[j] != input[j+1]){

                input[b++] = input[j];

                System.out.println(Arrays.toString(input));
            }
        }
        input[b++] = input[len-1];
        return b;
    }


    @Test
    public void oddEven(){
        int[] arr = {1,2,3,4,5,6,2,7,8};

        int len = arr.length;

        System.out.println("length of arr is: " + len);
        HashMap<Integer, String > hmap = new HashMap<>();
        for (int i =0; i<=len-1; i++){
            if(arr[i]%2==0){
                hmap.put(arr[i], "even");
            }
            else{
                hmap.put(arr[i], "odd");
            }
        }

        System.out.println(hmap);
    }


    @Test
    public void StringPalindrome(){
        String pali= "asxsax";

        int l= pali.length();
        int flag =0;
        for (int i=0; i<=l-1; i++){
            if(pali.charAt(i)!=pali.charAt(l-1-i)){
                flag= 1;
            }
        }

        if(flag==0){
            System.out.println("String is palidrome");
        }
        else{
            System.out.println("String is NOT palindrome");
        }
    }


    @Test
    public void numberPalindrome(){

       int abc= 5225;
        int n  = abc;

        int reversed=0;

        while(n != 0){
            int reminder = n%10;
            System.out.println("I am reminder  __" + reminder);
            System.out.println();


            reversed = reversed * 10 + reminder;
            System.out.println("I am reversed  __" + reversed);
            System.out.println();


            n/= 10;
            System.out.println("I am n  __" + n);
            System.out.println();

        }

        if (abc==reversed){
            System.out.println("Number is palindrome");
        }
        else{
            System.out.println("Number is NOT palindrome");
        }


    }

    @Test
    public void missingNumberinArray(){
        int checkTill = 12;
        int[] miss= {1,2,4,5,7,8,9,11};
        int l = miss.length;
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<=l-1; i++){
            list.add(miss[i]);
        }
        System.out.println(list);

      while(checkTill>=1){
            if(!list.contains(checkTill)){
                System.out.println("Missing number is " + checkTill);
            }
            checkTill--;
        }
    }
}
