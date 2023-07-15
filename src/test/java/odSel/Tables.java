package odSel;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Tables {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
        driver.get("https://money.rediff.com/gainers");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr"));
       for (int i=0; i<rows.size(); i++){
           System.out.println(rows.get(i).getText());
      File o=     ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(o, new File("./ss/testFull"+i+".jpg"));
       File s=rows.get(i).getScreenshotAs(OutputType.FILE);

           FileUtils.copyFile(s, new File("./ss/test"+i+".jpg"));
           /*List<WebElement> cols= driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr["+i+"]//td"));
//           System.out.println(cols.size());
           for (int j=1; j< cols.size(); j++){
               System.out.print(cols.get(j).getText() +"   ");
           }
           System.out.println();*/
       }
        driver.close();

    }
}
