package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ReadConfigFile {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        To go with Headless
//        options.addArguments("headless");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        Properties prop=new Properties();
        String rootPath=System.getProperty("user.dir");

        FileInputStream fis=new FileInputStream(rootPath+"/src/test/java/sele/config1.properties");
        Thread.sleep(1);
        prop.load(fis);
        System.out.println(prop.get("name"));
        Object c=prop.get("age");
        System.out.println(c);
        String url=prop.getProperty("URL");
        driver.get(url);

        System.out.println("Headless Execution Completed");

    }
}
