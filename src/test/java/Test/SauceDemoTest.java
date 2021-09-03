package Test;

import PageObjects.SauceDemoPage;
import Resources.PropertiesFile;
import Test.Selenium.BaseClass;
import TestData.LoginTestData;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class SauceDemoTest extends BaseClass {

    SauceDemoPage sauceDemoPage;
    PropertiesFile propertiesFile = new PropertiesFile();

    /**
     * This method take data from config.properties file via Data Provider.
     * @param user
     * @param pawd
     */

    @Test(dataProvider="userAndPwdValues", dataProviderClass = LoginTestData.class)
    public void loginTestCase(String user, String pawd){
       sauceDemoPage = new SauceDemoPage(BaseClass.driver);
       driver.get(propertiesFile.universalGetProp("sauceDemoUrl"));
       driver.manage().window().maximize();
       sauceDemoPage.loginIntoPage(user,pawd);
    }


    /**
     * This method take data from excel file via Data Provider.
     * @param user
     * @param pawd
     * @param extra *I have to take this parameter. otherwise test get fail. This is coming from data provider, so we have to catch it.
     */
    @Test(dataProvider = "ExcelValues", dataProviderClass = LoginTestData.class)
    public void loginViaExceldataTestCase(String user, String pawd, String extra) {
        sauceDemoPage = new SauceDemoPage(BaseClass.driver);
        driver.get(propertiesFile.universalGetProp("sauceDemoUrl"));
        driver.manage().window().maximize();
        sauceDemoPage.loginIntoPage(user, pawd);
    }

    public void extraMethodToUnderstandExcelWorking() throws IOException {


        String filepath = "C:\\Users\\shubhi.bansal\\IdeaProjects\\Maven003\\src\\test\\java\\TestData\\LoginUsersTestdata.xlsx";

        FileInputStream fr = new FileInputStream(filepath);

        XSSFWorkbook wholeExcel = new XSSFWorkbook(fr);
        XSSFSheet sheet = wholeExcel.getSheetAt(0);

        int totalRows = sheet.getLastRowNum();
        int totalColumns = sheet.getRow(1).getLastCellNum();

        System.out.println( "Get physical number of rows: "+sheet.getPhysicalNumberOfRows());

        Object[][] objects = new Object[totalRows+1][totalColumns+1];

        System.out.println("total rows " + totalRows + "and Total columns are: " + totalColumns);

        for(int i=0; i<=totalRows; i++){
            XSSFRow row = sheet.getRow(i);
            for (int j=0; j<= totalColumns-1; j++){
                objects[i][j] =  row.getCell(j);
                System.out.println(objects[i][j]);
            }
            System.out.println();
        }
    }
}
