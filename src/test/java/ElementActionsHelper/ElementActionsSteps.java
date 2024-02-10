package ElementActionsHelper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ElementActionsSteps {

    public static void waitForElementToDisappear(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        wait.until(invisibilityOf(element));
    }

    public static void waitForElementDisplayed(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        wait.until(visibilityOf(element));
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
