package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoosingLocationPage extends BaseSeleniumPage {

    @FindBy(xpath = "//wb-select//*[contains(text(), \"Your state\")]")
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
