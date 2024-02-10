package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import static java.time.Duration.ofSeconds;

abstract public class BaseSeleniumClass {
    protected WebDriver driver;

    @BeforeEach
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "test_utils/drivers/chromedriver");

        String browserName = System.getenv().getOrDefault("BROWSER", "chrome");
        driver = browserName.equalsIgnoreCase("firefox")
                ? new FirefoxDriver()
                : new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        BaseSeleniumPage.setDriver(driver);
    }

    private WebDriver turnoffFirefoxCookies() {
        FirefoxOptions ops=new FirefoxOptions();
        FirefoxProfile profile=new FirefoxProfile();
        profile.setPreference("network.cookie.cookieBehavior", 2);
        ops.setProfile(profile);

        WebDriver driver = new FirefoxDriver(ops);
        return driver;
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
        driver.quit();
    }
}
