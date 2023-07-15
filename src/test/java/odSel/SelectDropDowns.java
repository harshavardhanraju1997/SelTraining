package odSel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectDropDowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
        driver.get("https://www.wikipedia.org/");
        WebElement sel =driver.findElement(By.xpath("//select[@id='searchLanguage']"));
        Select s = new Select(sel);
        Thread.sleep(1000);
        s.selectByIndex(2);
        Thread.sleep(1000);
        s.selectByValue("bg");
        Thread.sleep(1000);
        s.selectByVisibleText("Eesti");
        Thread.sleep(1000);
     List<WebElement> langs=   driver.findElements(By.xpath("//select[@id='searchLanguage']/option"));
        System.out.println(langs.size());
        System.out.println(langs.toString());
        int count=1;
        System.out.println("------------------PRINTING LANGUAGES------------------");
        for (WebElement lang : langs) {
            System.out.println(count+" Language :"+lang.getText());
            count++;

        }
        List<WebElement> links=   driver.findElements(By.xpath("//a"));
        count=1;
        System.out.println("------------------PRINTING LINKS------------------");
        System.out.println(links.size());
        for(int i=0;i< links.size();i++) {
            System.out.println(count+" " +links.get(i).getAttribute("href"));
            count++;

        }
     List<WebElement> k=   sel.findElements(By.xpath("//a"));
        for (WebElement o : k) {
            System.out.println(o.getText());


        }

        driver.close();

    }
}
