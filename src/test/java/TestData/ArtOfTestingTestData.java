package TestData;

import DataModels.ArtOfTesting;
import DataObjects.ArtOfTestingConfigurationData;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ArtOfTestingTestData {

    @DataProvider(name="ArtOfTestingDateset1")
    public static Object[][] dataForArtOfTesting1(){
        ArtOfTesting firstData = ArtOfTestingConfigurationData.Datset1;
        ArtOfTesting secondData = ArtOfTestingConfigurationData.Datset2;

        Object[][] testData = new Object[1][2];
        testData[0][0] = firstData;
        testData[0][1] = secondData;
        return testData;
    }

    @DataProvider(name="ArtOfTestingDateset2")
    public  static ArtOfTesting[][] dataForArtOfTesting2(){

        ArtOfTesting[][] testData = new ArtOfTesting[2][1];
        testData[0][0] = ArtOfTestingConfigurationData.Datset1();
        testData[1][0] = ArtOfTestingConfigurationData.Datset2();

        return  testData;

    }


    @DataProvider(name="userLists")
    public static Object[][] userListData(){
        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(1, "user1");
        hmap.put(2, "user2");
        hmap.put(3, "user3");

        Object[][] obj = new Object[hmap.size()][2];
        int i=0;
      for(Map.Entry<Integer, String> m1 : hmap.entrySet()){
          int keyval = m1.getKey();
          String val = m1.getValue();
                obj[i][0] = keyval;
                obj[i][1] = val;

                i++;
      }
        return obj;

    }
}
