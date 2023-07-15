package odSel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.SQLOutput;
import java.time.Duration;

public class MegItvw2 {
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
        driver.findElement(By.xpath("//span[text()=' Calendars ']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()=' Book Appointment ']")).click();
        Thread.sleep(3000);
        WebElement frame=driver.findElement(By.xpath("//iframe[@name='calendar-app']"));
        driver.switchTo().frame(frame);
        Thread.sleep(2000);
        WebElement searchBox=driver.findElement(By.xpath("//input[@type='text' and @placeholder='Search by name, email, phone or company']"));
        searchBox.click();
        Thread.sleep(900);
        searchBox.sendKeys("test1");
        Thread.sleep(9000);
        driver.findElement(By.xpath(" //div[text()='testbook@gmail.com']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(" //div[text()='cale']/../..")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='TestCalendar']")).click();
        driver.findElement(By.xpath(" //div[@id='slot-picker-standard']/div")).click();

        WebElement time=driver.findElement(By.xpath("//div[@class='n-base-select-option__content' and text()='9:00 am - 9:30 am']"));
        time.click();
        WebElement selectedTime=driver.findElement(By.xpath(" (//div[@class='n-base-selection-input']//div)[2]"));
        String timeInterval=selectedTime.getText();
//        timeInterval.replace(" am", "");
//        timeInterval.replaceAll(":", "");
    String k[]= timeInterval.split(" - ");
   String start= k[0].replace(" am", "");
        String end= k[1].replace(" am", "");
       start= start.replace(":", "");
       end= end.replace(":", "");
    int startTime=Integer.parseInt(start);
    int endTime=Integer.parseInt(end);
    int timeGap=startTime-endTime;
    timeGap=Math.abs(timeGap);
        System.out.println("Time gap: "+timeGap);






        driver.quit();




    }
}
