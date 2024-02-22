package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static java.time.Duration.ofSeconds;

abstract public class BaseSeleniumClass {
    //protected WebDriver driver;
    protected RemoteWebDriver driver;
    protected String remote_url_chrome = System.getProperty("RemoteUrl");

    @BeforeEach
    /*public void setupDriver() {
        String browserName = System.getenv().getOrDefault("BROWSER", "chrome");
        driver = browserName.equalsIgnoreCase("firefox")
                ? new FirefoxDriver()
                : new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        BaseSeleniumPage.setDriver(driver);
    }*/

    /*public void setupDriver() {
        String browserName = System.getenv().getOrDefault("BROWSER", "chrome");
        if(browserName.equalsIgnoreCase("firefox")){
            FirefoxOptions ffOptions = new FirefoxOptions();
            ffOptions.setHeadless(true);
            driver = new FirefoxDriver(ffOptions);
        } else {
            ChromeOptions chOptions = new ChromeOptions();
            chOptions.addArguments("--headless=new");
            driver = new ChromeDriver(chOptions);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        BaseSeleniumPage.setDriver(driver);
    }*/

    public void setupDriver() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.block_third_party_cookies", true);

        ChromeOptions chOptions = new ChromeOptions();
        //chOptions.addArguments("--headless=new");
        //chOptions.setExperimentalOption("prefs", prefs);
        //chOptions.addArguments("--block-third-party-cookies");
        chOptions.addArguments("--disable-cookies");
        chOptions.setHeadless(true);

        try {
            driver = new RemoteWebDriver(new URL(remote_url_chrome), chOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        //driver = new ChromeDriver(chOptions);
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
