package Test;

import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;

public class ReadFileTest {

    public static String path = "C:\\Users\\shubhi.bansal\\IdeaProjects\\Maven003\\src\\test\\java\\TestData\\ReadMe.txt";

    BufferedReader br = null;

    @Test
    public void ReaderTest() throws IOException {

        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(path));
            String curLine = br.readLine();

            while (curLine != null) {
                String[] words = curLine.toLowerCase().split(" ");
                for (String word : words) {
                    if (hashMap.containsKey(word)) {
                        hashMap.put(word, hashMap.get(word) + 1);
                    } else {
                        hashMap.put(word, 1);
                    }
                }
                curLine = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(hashMap);
        hashMap.forEach((k, v) -> System.out.println(k + " : " + v));

    }
}
