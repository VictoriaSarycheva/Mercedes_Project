package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

abstract public class BaseSeleniumClass {
    protected WebDriver driver;

    @BeforeEach
    public void setupDriver() {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "test_utils/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        BaseSeleniumPage.setDriver(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
