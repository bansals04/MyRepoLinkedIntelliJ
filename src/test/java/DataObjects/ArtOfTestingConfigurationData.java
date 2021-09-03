package DataObjects;

import DataModels.ArtOfTesting;
//This is DesignData or ConfigurationData file

public class ArtOfTestingConfigurationData {

    public static ArtOfTesting Datset1= Datset1();
    public static ArtOfTesting Datset2= Datset2();

    public static ArtOfTesting Datset1(){
        ArtOfTesting artOfTesting = new ArtOfTesting();
        artOfTesting.TextBox = "I am T111";
        artOfTesting.Gender= "female";
        artOfTesting.TestingType = "Automation";
        artOfTesting.TestingDropdown = "Manual";
        return artOfTesting;
    }

    public static ArtOfTesting Datset2(){
        ArtOfTesting artOfTesting = new ArtOfTesting();
        artOfTesting.TextBox = "I am T222";
        artOfTesting.Gender = "male";
        artOfTesting.TestingType = "Performance";
        artOfTesting.TestingDropdown = "Database";
        return artOfTesting;
    }


}
