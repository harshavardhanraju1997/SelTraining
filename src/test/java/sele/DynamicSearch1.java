package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicSearch1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        WebDriver ffdriver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Selenium");
        Thread.sleep(3000);

        List<WebElement> search =driver.findElements(By.xpath("//ul/li"));
        System.out.println(search.size());
        for(int i=0;i<search.size();i++){
            System.out.println(search.get(i).getText());
            if(search.get(i).getText().equalsIgnoreCase("selenium tutorial")){
                search.get(i).click();
                break;
            }
        }
    }
}
