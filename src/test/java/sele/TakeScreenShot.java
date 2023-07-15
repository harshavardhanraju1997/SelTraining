package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.plaf.TableHeaderUI;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class TakeScreenShot {
    public static void main(String[] args) throws IOException, InterruptedException {
        Calendar calendar = Calendar.getInstance();
//        calendar.get(calendar.Hour);
        String timeDate = Integer.toString(calendar.get(Calendar.HOUR)) +
                Integer.toString(calendar.get(Calendar.MINUTE)) +
                        Integer.toString(calendar.get(Calendar.SECOND)) +
                                Integer.toString(calendar.get(Calendar.DATE)) +
                                        Integer.toString(calendar.get(Calendar.MONTH)) +
                                                Integer.toString(calendar.get(Calendar.YEAR));
        System.out.println(timeDate);



        System.out.println(calendar.get(Calendar.MONTH));
        // gets hour in 24h format
        // gets hour in 12h format

        Date date = new Date();
        System.out.println(date);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Duration t = driver.manage().timeouts().getPageLoadTimeout();
        System.out.println(t);
        System.out.println(driver.manage().timeouts().getPageLoadTimeout());
        TakesScreenshot ss = (TakesScreenshot) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
//        Date date = new Date();

        File fileTook = ss.getScreenshotAs(OutputType.FILE);

       File fileDest=new File("./Screenshots/"+timeDate+".jpg");
        FileUtils.copyFile(fileTook, fileDest);
        Thread.sleep(2);
    }
}
