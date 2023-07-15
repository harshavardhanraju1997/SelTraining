package odSel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class MegItvw1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://app.gohighlevel.com/");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("megna@testmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test123!");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[text()=' Settings ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()=' Calendars ']")).click();
        Thread.sleep(7000);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        WebElement iframes = driver.findElement(By.xpath("(//iframe[@name='calendar-app'])[2]"));
        driver.switchTo().frame(iframes);
        driver.findElement(By.xpath("//button[@id='calendar-settings-headers-btn-primary']")).click();
        driver.quit();




    }
}
