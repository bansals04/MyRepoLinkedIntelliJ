package Resources;


import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesFile {
    Properties p;


    public PropertiesFile() {
         p = new Properties();

        try {
            InputStream in = new FileInputStream("C:\\Users\\shubhi.bansal\\IdeaProjects\\Maven003\\src\\test\\java\\Resources\\config.properties");
            p.load(in);
        } catch (FileNotFoundException io) {
            System.out.println(io);
            io.printStackTrace();

            try {
                PrintWriter pw = new PrintWriter(new File("C:\\Users\\shubhi.bansal\\IdeaProjects\\StackTrace.txt"));
                io.printStackTrace(pw);
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException iioException) {
            iioException.printStackTrace();
            iioException.getMessage();
        }
    }

    public String getUrl(){
        String url =p.getProperty("url");
        return url;
    }

    public String getFootwearTitle(){
        String footwearTitle = p.getProperty("footwearTitle");
        return footwearTitle;
    }

    public String universalGetProp(String keyName){
        return p.getProperty(keyName);
    }

    public Set<String> getAllKeysNames(){
        return p.stringPropertyNames();
    }

    public boolean checkIfKeyExists(String key){
        return p.containsKey(key);
    }

}
