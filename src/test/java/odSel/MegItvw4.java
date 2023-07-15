package odSel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MegItvw4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://app.gohighlevel.com/");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("megna@testmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test123!");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[text()=' Calendars ']")).click();

        driver.findElement(By.xpath("//button[text()=' Book Appointment ']")).click();

        WebElement frame=driver.findElement(By.xpath("//iframe[@name='calendar-app']"));
        driver.switchTo().frame(frame);

        WebElement searchBox=driver.findElement(By.xpath("//input[@type='text' and @placeholder='Search by name, email, phone or company']"));
        searchBox.click();

        searchBox.sendKeys("test1");

        driver.findElement(By.xpath(" //div[text()='testbook@gmail.com']")).click();

        driver.findElement(By.xpath(" //div[text()='cale']/../..")).click();

        driver.findElement(By.xpath("//div[text()='TestCalendar']")).click();

        driver.findElement(By.xpath("//span[text()='Custom']")).click();

        driver.findElement(By.xpath("//div[@id='custom-start-time']/input")).click();
        driver.findElement(By.xpath("//div[@class='vc-highlights vc-day-layer']/../following-sibling::div[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='(eg) Appointment with Bob']")).click();
        driver.findElement(By.xpath("//div[@id='custom-end-time']/input")).click();
        driver.findElement(By.xpath("//div[@class='vc-highlights vc-day-layer']/../preceding-sibling::div[1]")).click();
        driver.findElement(By.xpath("//button/span[text()='Book Appointment']")).click();
       String alertText= driver.switchTo().alert().getText();
        System.out.println(alertText);
        Thread.sleep(2000);
        driver.quit();




    }
}
