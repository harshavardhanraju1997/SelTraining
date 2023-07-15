package odSel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlight {

    void highlightElement(WebDriver driver, WebElement element) {


        JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 5px solid red;');", element);
        js.executeScript("arguments[0].removeAttribute('style','')", element);
//        js.executeScript("arguments[0].setAttribute('style','border: 5px solid red;');", element);
    }
}
