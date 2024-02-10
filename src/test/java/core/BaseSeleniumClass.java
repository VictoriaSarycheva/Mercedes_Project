package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.time.Duration.ofSeconds;

abstract public class BaseSeleniumClass {
    protected WebDriver driver;

    @BeforeEach
    public void setupDriver() {
        String browserName = System.getenv().getOrDefault("BROWSER", "chrome");
        driver = browserName.equalsIgnoreCase("firefox")
                ? new FirefoxDriver()
                : new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        BaseSeleniumPage.setDriver(driver);
    }

    @AfterEach
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
        driver.close();
    }
}
