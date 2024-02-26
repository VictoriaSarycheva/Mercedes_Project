package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogType;

import static core.BaseSeleniumClass.browserName;
import static core.BaseSeleniumPage.driver;

public class TestListener implements TestWatcher {

    @SneakyThrows
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment("Fail screenshot", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));

        if (browserName.contains("Chrome")) {
            Allure.addAttachment("Fail logs: ",
                    String.valueOf(driver.manage().logs().get(LogType.BROWSER).getAll()));
            WebDriverManager.chromedriver().quit();
        } else {
            Allure.getLifecycle().addAttachment("Fail screenshot", "image/png", "png",
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            WebDriverManager.firefoxdriver().quit();
        }

        driver.quit();
    }

    @SneakyThrows
    @Override
    public void testSuccessful(ExtensionContext context) {
        Allure.getLifecycle().addAttachment("Passed test screenshot", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));

        if (browserName.contains("Chrome")) {
            Allure.addAttachment("Success logs: ",
                    String.valueOf(driver.manage().logs().get(LogType.BROWSER).getAll()));
            WebDriverManager.chromedriver().quit();
        } else {
            Allure.getLifecycle().addAttachment("Error screenshot", "image/png", "png",
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            WebDriverManager.firefoxdriver().quit();
        }

        driver.quit();
    }
}