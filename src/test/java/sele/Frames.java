package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Frames {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        Duration t=driver.manage().timeouts().getPageLoadTimeout();
        System.out.println(t);
        System.out.println(driver.manage().timeouts().getPageLoadTimeout());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        Actions act=new Actions(driver);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
       WebElement frame= driver.findElement(By.xpath("//iframe[@id='courses-iframe']"));
       Scroll.scrollToElement(driver,frame);
//        act.scrollToElement(frame);
       driver.switchTo().frame(frame);
       Thread.sleep(1);
       driver.findElement(By.xpath("  (//a[text()='More '])[1]")).click();
        driver.findElement(By.xpath("     (//a[text()='About us'])[1]")).click();
        Thread.sleep(1);
        driver.switchTo().defaultContent();
        Scroll.scrollToElement(driver,driver.findElement(By.xpath("//legend[text()='Radio Button Example']")));
        Thread.sleep(1);


    }
}
