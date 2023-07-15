package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Navigate {
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
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("Rahul: "+driver.getTitle());
        driver.get("https://jqueryui.com/droppable/");
        System.out.println("Jquery: "+driver.getTitle());
        driver.navigate().back();
        System.out.println("Rahul: "+driver.getTitle());
        driver.navigate().forward();
        System.out.println("Jquery: "+driver.getTitle());
        Thread.sleep(1);
    }
}
