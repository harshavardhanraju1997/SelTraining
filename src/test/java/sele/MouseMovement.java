package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseMovement {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://www.spicejet.com/");
        WebElement infoElement = driver.findElement(By.xpath("//div[text()='Add-ons']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(infoElement).build().perform();
       Thread.sleep(1);
       driver.findElement((By.xpath("(//div[text()='Extra Seat'])[1]"))).click();
        Thread.sleep(1);



    }
}
