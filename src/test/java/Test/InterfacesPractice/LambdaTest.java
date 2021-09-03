package Test.InterfacesPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest{



    public String trim(String data)
    {
        Int2 trim = (obj) -> { return obj.trim(); };

        return trim.getTrimmedString(data);
    }


    @DataProvider(name = "data")
    public Object[][] getData()
    {List<String> dataList = new ArrayList<>();
        {
            dataList.add("Tomato");
            dataList.add(" Cucumber");
            dataList.add("Onion ");
            dataList.add(" Vegetable that you like ");
        }


        Object[][] data =
                {
                {"veg1", trim(dataList.get(0))},
                {"veg2", trim(dataList.get(1))},
                {"veg3", trim(dataList.get(2))},
                {"veg4", trim(dataList.get(3))},
                };

        return data;
    }


    @Test(dataProvider = "data")
    public void test(String vegId, String vegVal)
    {
        System.out.println("Vegetable ID: " + vegId + " : " + "Vegetable Name: " + vegVal);
    }
}
