package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class PhantomJS {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new PhantomJSDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement op =driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
        Highlight.highlightElement(driver,op);
        op.click();
        Set<String> wid =driver.getWindowHandles();
        Iterator<String> itr= wid.iterator();
        //itr.next points to first window that is opened by selenium
        String parentWindowId=itr.next();
        System.out.println("Parent Window ID "+parentWindowId);
        Highlight.highlightElement(driver,op);
        Scroll.scrollToElement(driver,op);
        op.click();
        Thread.sleep(100);
        String childWindowId1=itr.next();
        System.out.println("Child Window ID "+childWindowId1);
        //driver.getWindowHandle give the info about current window
        System.out.println("Current Window ID "+driver.getWindowHandle());

        driver.switchTo().window(childWindowId1);
        System.out.println("Current Window ID "+driver.getWindowHandle());
        WebElement childWindowEle=driver.findElement(By.xpath("//input[@id='lastName']"));
        Scroll.scrollToElement(driver,childWindowEle);
        Highlight.highlightElement(driver,childWindowEle);

        driver.switchTo().window(parentWindowId);
        System.out.println("Current Window ID "+driver.getWindowHandle());
        WebElement defaultWindowEle=driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
        Scroll.scrollToElement(driver,defaultWindowEle);
        Highlight.highlightElement(driver,defaultWindowEle);


        Thread.sleep(100);
    }
}
