package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[contains(text(), 'Your state')]//ancestor::wb-select")
    private WebElement yourStateDropdown;

    @FindBy(xpath = "//option[text()='New South Wales']")
    private WebElement stateOption;

    @FindBy(xpath = "//input[contains(@aria-labelledby, 'postal-code-hint')]")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//*[contains(text(), 'Private')]//ancestor::wb-radio-control")
    private WebElement privatePurpose;



    public StartPage() {
        driver.get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo?sort=relevance-demo&assortment=vehicle");
        PageFactory.initElements(driver, this);
    }

    public StartPage clickOnYourStateDropdown() {
        yourStateDropdown.click();
        return this;
    }

    public StartPage chooseStateOptionFromList() {
        stateOption.click();
        return this;
    }
    public StartPage inputPostCode(String postCode) {
        postalCodeInput.sendKeys(postCode);
        return this;
    }public

    StartPage choosePrivatePurpose() {
        privatePurpose.click();
        return this;
    }

}
