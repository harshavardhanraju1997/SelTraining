package odSel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class TabsWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
        Set<String> winds =driver.getWindowHandles();
        Iterator<String> it =winds.iterator();



    }
}
