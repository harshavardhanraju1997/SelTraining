package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpiceJetDate {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.spicejet.com/");
        WebElement a =driver.findElement(By.xpath("//div[text()='Departure Date']/parent::div//div[contains(text(),'2023')]"));
        String c=a.getAttribute("innerText");
        System.out.println(c);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].innerText = 'Sat, 10 Jul 2023'", a);
        Thread.sleep(2000);

        Thread.sleep(2000);
    }
}
