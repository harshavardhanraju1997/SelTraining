package collections;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileDownload {
    public static void main(String[] args) throws InterruptedException {
        // Setting chrome driver path
        WebDriverManager.chromedriver().setup();

        // Setting new download directory path
        Map<String, Object> prefs = new HashMap<String, Object>();
        String k=File.separator;
        System.out.println(k);

        // Use File.separator as it will work on any OS
        prefs.put("download.default_directory",System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");

        // Adding cpabilities to ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");

        // Printing set download directory
//        System.out.println(options.getExperimentalOption("prefs"));

        // Launching browser with desired capabilities
        WebDriver driver= new ChromeDriver(options);

        // URL loading
        driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_html_download_link2");

        WebElement frame1=driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//a/img")).click();
        Thread.sleep(1);
    }
}
