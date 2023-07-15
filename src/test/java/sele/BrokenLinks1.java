package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks1 {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.zlti.com/");
        String href="";
        List<WebElement> aLinks=driver.findElements(By.xpath("//a"));
        List<WebElement> availableLinks=new ArrayList<WebElement>();
        System.out.println(aLinks.size());
        for (WebElement aLink : aLinks){

           href= aLink.getAttribute("href");
            System.out.println(href);
            if(href!=null && href.contains("https://")){
                availableLinks.add(aLink);
            }
        }


        System.out.println(availableLinks.size());
        Thread.sleep(1);

        for (WebElement activeLink : availableLinks) {
            String url=activeLink.getAttribute("href");
//            System.out.println("===============================================================");
            System.out.println(url);
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.connect();
            int statusCode=connection.getResponseCode();
            String statusMessage=connection.getResponseMessage();
            System.out.println("Response Code is : "+statusCode);
            System.out.println("Response Message is : "+statusMessage);
            System.out.println("===============================================================");



        }
    }
}
