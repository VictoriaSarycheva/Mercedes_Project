package mainPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.profile.cookie_controls_mode", 1);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);

       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--block-third-party-cookies");
        WebDriver driver = new ChromeDriver(options);*/

        driver.get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo?sort=relevance-demo&assortment=vehicle");
    }
}
