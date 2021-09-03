package Test;

import Resources.PropertiesFile;
import Test.Selenium.BaseClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.UUID;

public class MySqlTest extends BaseClass {

    static String id ="3";
    static String name = "Geeta";
    static String address = "California";


    PropertiesFile pf;
    Connection c;


    @Test(enabled = true)
    public void SQLTest(){


        pf=new PropertiesFile();

        try {
            c = DriverManager.getConnection(pf.universalGetProp("jdbcURL"), pf.universalGetProp("mysqluser"), pf.universalGetProp("mysqlpwd"));
            Statement stmt = c.createStatement();
            String query = "select * from shubhidb.t1";
            ResultSet rs =  stmt.executeQuery(query);
            System.out.println(rs);

            while (rs.next()){

               System.out.println();
               String id =rs.getString("id");
               String name =rs.getString("name");
               String address =rs.getString("address");

               System.out.println(id + "  "+name +"  "+ address);

               if(((this.id).equals(rs.getString("id")))
                       && ((this.name).equals(rs.getString("name"))
                       && ((this.address).equals(rs.getString("address"))))){
                   System.out.println("California record found");
                   break;
               }
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Test(enabled = true)
    public void insertMySQqL() throws SQLException {
        pf=new PropertiesFile();

        Connection con =DriverManager.getConnection(pf.universalGetProp("jdbcURL"), pf.universalGetProp("mysqluser"), pf.universalGetProp("mysqlpwd"));

        String a= RandomStringUtils.randomNumeric(2); //It will everytime generate a random integer of 2-digit, which is passed as ID in sql table.

        String query = "INSERT INTO `shubhidb`.`t1` (`id`, `name`, `address`) VALUES ('" +a+ "', 'Chirag', 'LogAngles')";

        PreparedStatement ps =con.prepareStatement(query);
        ps.executeUpdate();
        con.close();
    }



    @Test
    public void randomInt(){
        UUID uuid= UUID.randomUUID();
        System.out.println(uuid);
    }


}
