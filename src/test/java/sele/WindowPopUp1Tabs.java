package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class WindowPopUp1Tabs {
    public static void main(String[] args) throws InterruptedException {
        String k=System. getProperty("user.dir");
        System.out.println(k);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement ot = driver.findElement(By.xpath("//a[@id='opentab']"));
        Highlight.highlightElement(driver, ot);
        System.out.println(driver.getWindowHandle());
        ot.click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        WebElement icon=driver.findElement(By.xpath("(//a[@href='https://www.qaclickacademy.com'])[1]"));

        driver.switchTo().window(tabs2.get(1));

        System.out.println(driver.getWindowHandle());

         icon=driver.findElement(By.xpath("(//a[@href='https://www.qaclickacademy.com'])[1]"));
        Highlight.highlightElement(driver, icon);

        Thread.sleep(100);
    }
}
