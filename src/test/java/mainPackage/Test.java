package mainPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {

    public static void main(String[] args) {
        /*Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.block_third_party_cookies", true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);*/
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--block-third-party-cookies");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo?sort=relevance-demo&assortment=vehicle");
    }
}
