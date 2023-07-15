package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hi");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement element = driver.findElement(By.xpath("//input[@id='photo']"));
        Scroll.scrollToElement(driver,element);

        element.sendKeys("C:\\Users\\manoh\\OneDrive\\Documents\\MANJU SIGN (1).jpeg");
        Thread.sleep(2000);


        driver.quit();


    }
}
