package sele;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlight {

    static void highlightElement(WebDriver driver, WebElement element) {
      /*  String bgColor=element.getCssValue("backgroundColor");

for (int i = 0; i < 10;i++) {

        }*/
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('style','background: green; border: 5px solid red;');", element);

        //To remove highlight
//        js.executeScript("arguments[0].removeAttribute('style','')", element);

    }
}
