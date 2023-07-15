package sele;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll {
    // Create instance of Javascript executor
public static void scrollToElement(WebDriver driver, WebElement element) {
    JavascriptExecutor je = (JavascriptExecutor) driver;
    // now execute query which actually will scroll until that element is not appeared on page.

    je.executeScript("arguments[0].scrollIntoView(true);",element);
}

}
