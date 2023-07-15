package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        WebElement ad=driver.findElement(By.xpath("//button[@id='display-other-button']"));
        ad.click();
       WebElement enableBtn=driver.findElement(By.xpath("//button[@id='hidden']"));
       wait.until(ExpectedConditions.visibilityOf(enableBtn));
        String k=enableBtn.getText();
        System.out.println(k);
        Thread.sleep(3000);


    }
}
