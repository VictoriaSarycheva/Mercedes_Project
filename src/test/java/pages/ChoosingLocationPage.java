package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ChoosingLocationPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[contains(text(), 'Your state')]//ancestor::wb-select")
    private WebElement yourState;

    public ChoosingLocationPage() {
        driver.get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo?sort=relevance-demo&assortment=vehicle");
        PageFactory.initElements(driver, this);
    }

    public ChoosingLocationPage clickOnYourStateDropdown() {
        yourState.click();
        return this;
    }
}
