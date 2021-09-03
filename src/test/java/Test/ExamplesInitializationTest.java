package Test;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ExamplesInitializationTest {

    List<String> ls = new ArrayList<>();

    int[] abc = {1,2,3};

    HashMap<String, Integer> hs = new HashMap<>();

    String[] st = {"qq", "rr", "ee"};

    @Test
    public void exampleInitilization(){
        ls.add("I am a String1");
        ls.add("I am a String2");
        System.out.println(ls.get(1));

        System.out.println(Arrays.toString(abc));
        System.out.println(abc[1]);

        hs.put("Val1", 44);
        hs.put("Val2", 55);
        System.out.println(hs);

        System.out.println(st[1]);


        ArrayList<String> str = new ArrayList<>();
        str.add("case1");
        str.add("case2");
        str.add("case3");

        str.forEach((ww) -> {  System.out.println(ww);  });

        List<Integer> k = new ArrayList<>();
        k.add(9);
        k.add(22);
        k.add(24);
        k.forEach((qa) -> System.out.println(qa));


    }
}
