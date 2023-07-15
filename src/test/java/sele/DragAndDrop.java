package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://jqueryui.com/droppable/");
        WebElement frame =driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(frame);
        Thread.sleep(1);
        Actions act=new Actions(driver);
        WebElement dragElement = driver.findElement(By.xpath("//p[text()='Drag me to my target']/parent::div"));
        WebElement dropElement = driver.findElement(By.xpath(" //p[text()='Drop here']/parent::div"));
        act.clickAndHold(dragElement).moveToElement(dropElement).build().perform();

        Thread.sleep(1);



    }
}
