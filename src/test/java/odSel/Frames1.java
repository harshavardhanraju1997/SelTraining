package odSel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Frames1 {
    public static void main(String[] args) throws InterruptedException {

        Highlight h = new Highlight();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
        WebElement ele;
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        List<WebElement> k;
        k = driver.findElements(By.xpath("//iframe"));
        System.out.println(k.size());


        ele = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        h.highlightElement(driver, ele);
        driver.switchTo().frame(ele);

//        driver.switchTo().frame("///iframe[@title='W3Schools Free Online Web Tutorials']");
        ele = driver.findElement(By.xpath("//iframe[@title='W3Schools Free Online Web Tutorials']"));
        h.highlightElement(driver, ele);
        driver.switchTo().frame(ele);

      //  driver.switchTo().frame(ele);
        ele=driver.findElement(By.xpath("//a[@title='Menu']"));
        h.highlightElement(driver,ele);
        ele.click();

        driver.switchTo().defaultContent();
        Thread.sleep(1000);
    }
}