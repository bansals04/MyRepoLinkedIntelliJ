package TestData;

import Resources.PropertiesFile;
import Test.InterfacesPractice.Int3;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;



public class LoginTestData {

    @DataProvider(name = "userNames")
    public static Object[][] userName(){
        Object[][] testData = new Object[1][2];
        testData[0][0] = "Shubhi";
        testData[0][1] = "bansal";
        return testData;
    }

    @DataProvider(name= "userAndPwdValues")
    public static Object[][] userAndPwdValuesTestData(){
        PropertiesFile propertiesFile = new PropertiesFile();

        Object[][] ob= new Object[2][2];

        ob[0][0] = propertiesFile.universalGetProp("user1");
        ob[0][1] = propertiesFile.universalGetProp("pawd");

        ob[1][0] = propertiesFile.universalGetProp("user2");
        ob[1][1]= propertiesFile.universalGetProp("pawd");

        return ob;
    }

    @DataProvider(name= "ExcelValues")
    public static Object[][] ExcelTestData() throws Exception{
        String filepath = "C:\\Users\\shubhi.bansal\\IdeaProjects\\Maven003\\src\\test\\java\\TestData\\LoginUsersTestdata.xlsx";

        FileInputStream fr = new FileInputStream(filepath);
        XSSFWorkbook wholeExcel = new XSSFWorkbook(fr);

        XSSFSheet sheet = wholeExcel.getSheetAt(0);
        int totalRows = sheet.getLastRowNum();
        int totalColumns = sheet.getRow(1).getLastCellNum();

        //System.out.println( "Get physical number of rows: "+sheet.getPhysicalNumberOfRows());

        Object[][] objects = new Object[totalRows+1][totalColumns+1];

        for(int i=0; i<=totalRows; i++){
            XSSFRow row = sheet.getRow(i);
            for (int j=0; j<= totalColumns-1; j++){
                objects[i][j] =  row.getCell(j);
                objects[i][j] = objects[i][j].toString();
                //System.out.println(objects[i][j]);
            }
            //System.out.println();
        }

              return objects;
    }


    @DataProvider(name="lambdapassing")
    public Object[][] LambdaPassing1(){
        Object[][] o = new Object[1][3];
        o[0][0]= "Sd";
        o[0][1] = "wsed";
        String a1= trim("I am a String");
        o[0][2] = a1;

        return o;
    }


    public String trim(String abwc){
        System.out.println("Function trim calling started");
        Int3 n =(abc)->{return abc;  };
        System.out.println(n.lamda1("hello"));
        return abwc;
    }
}
