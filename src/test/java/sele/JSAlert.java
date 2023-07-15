package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class JSAlert {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hi");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       WebElement element= driver.findElement(By.xpath("//input[@id='alertbtn']"));
       element.click();
       Alert  at =driver.switchTo().alert();
//       at.accept();
        String k=at.getText();
        System.out.println(k);
        at.dismiss();

       Thread.sleep(2000);




        driver.quit();


    }
}
