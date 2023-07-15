package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Slider {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get("https://jqueryui.com/slider/");
        WebElement frame =driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(frame);
        WebElement slider=driver.findElement(By.xpath("//div[@id='slider']/span"));
        Actions act=new Actions(driver);
        JavascriptExecutor j = (JavascriptExecutor) driver;
//        j.executeScript ("document.getElementsByClassName('ui-slider-handle ui-corner-all ui-state-default').setAttribute('style', "+ "'left: 65%;')");
//        j.executeScript("document.getElementsByClassName('ui-slider-handle ui-corner-all ui-state-default ui-state-focus ui-state-hover ui-state-active').setAttribute('style', 'left: 65%;')");
        act.clickAndHold(slider).dragAndDropBy(slider,900,0).build().perform();

        Thread.sleep(2000);
    }
}
