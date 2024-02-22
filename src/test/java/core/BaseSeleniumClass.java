package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static java.time.Duration.ofSeconds;

abstract public class BaseSeleniumClass {
    //protected WebDriver driver;
    protected RemoteWebDriver driver;
    protected String remote_url = System.getProperty("RemoteUrl");
    protected String browserName = System.getProperty("browser");
    //protected String browserName = System.getenv().getOrDefault("BROWSER", "chrome");

    @BeforeEach
    /*public void setupDriver() {
        driver = browserName.equalsIgnoreCase("firefox")
                ? new FirefoxDriver()
                : new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        BaseSeleniumPage.setDriver(driver);
    }*/

    public void setupDriver() throws MalformedURLException {
        if (browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.setHeadless(true);
            chromeOptions.addArguments("--headless=new");
            driver = new RemoteWebDriver(new URL(remote_url), chromeOptions);
            //driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(ofSeconds(10));
            BaseSeleniumPage.setDriver(driver);
        }
        if (browserName.equalsIgnoreCase("FireFox")) {
            FirefoxOptions fireFoxOptions = new FirefoxOptions();
            //fireFoxOptions.setHeadless(true);
            fireFoxOptions.addArguments("--headless=new");
            driver = new RemoteWebDriver(new URL(remote_url), fireFoxOptions);
            //driver = new FirefoxDriver(fireFoxOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(ofSeconds(10));
            BaseSeleniumPage.setDriver(driver);
        }
    }

    @AfterEach
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
        //driver.close();
    }
}
