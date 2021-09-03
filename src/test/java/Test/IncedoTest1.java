package Test;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class IncedoTest1 {

    int[] input={2,2,8,4,5,3,6,7,3,8};

    @Test
    public void intarray1() {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<= input.length-1; i++){

            if(map.containsKey(input[i])){
                map.put(input[i], map.get(input[i]) +1);
            }
            else {
                map.put(input[i], 1);
            }
        }
        System.out.println(map);



    }
}
