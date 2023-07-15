package sele;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Launch1 {
    public static void main(String[] args) {
        System.out.println("Hi");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.udemy.com/home/my-courses/learning/");

        System.out.println( driver.getTitle());
        System.out.println(driver.getPageSource());
        driver.quit();

    }
}
