package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hi");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select se=new Select(dropDown);
        se.selectByIndex(2);
        Thread.sleep(1000);
        se.selectByVisibleText("Option1");
        Thread.sleep(1000);
        se.selectByValue("option3");
        Thread.sleep(1000);
        List<WebElement> list =se.getOptions();
         System.out.println(list.size());
        for (WebElement element : list) {
            System.out.println(element.getText());

        }
        driver.quit();


    }
}
