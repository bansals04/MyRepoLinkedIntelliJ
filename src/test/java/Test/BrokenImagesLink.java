package Test;

import Test.Selenium.BaseClass;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenImagesLink extends BaseClass {



    @Test
    public void readFile() throws IOException {
        String strLine;
        BufferedReader br = new BufferedReader(new java.io.FileReader("C://abc.txt"));
        while((strLine = br.readLine()) != null){

            System.out.println("Line is - " + strLine);
        }
    }

    @Test
    public void brokenImage() throws IOException {
        // Another way of doing this methos is in method >> ArtOfTestingTest.java > checkBrokenImage()
        driver.get("https://the-internet.herokuapp.com/broken_images");
        int brokenImagesCount=0;
        List<WebElement> ls = driver.findElements(By.tagName("img"));
        System.out.println(ls.size()+ ": this is ls size()");

        for(WebElement oneImageLink : ls) {
            if (oneImageLink != null) {

                CloseableHttpClient client = HttpClientBuilder.create().build();
                String src = oneImageLink.getAttribute("src");
                System.out.println("I am TEXT________" +oneImageLink.getText());

                URL url = new URL(src);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("User-Agent", "");
                int statusCode = httpURLConnection.getResponseCode();
                if(statusCode!=200){
                     brokenImagesCount= brokenImagesCount +1;
                    System.out.println("I am broken src____" + src );
                    System.out.println("I am broken URL_______" + url);
                }

            }
        }
    }

}
