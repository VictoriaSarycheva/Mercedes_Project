package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class StartPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[contains(text(), 'Your state')]//ancestor::wb-select")
    private WebElement yourStateDropdown;

    @FindBy(xpath = "//option[text()='New South Wales']")
    private WebElement stateOption;

    @FindBy(xpath = "//input[contains(@aria-labelledby, 'postal-code-hint')]")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//*[contains(text(), 'Private')]//ancestor::wb-radio-control")
    private WebElement privatePurpose;

    @FindBy(xpath = "//button//*[contains(text(), 'Continue')]")
    private WebElement continueButton;

    @FindBy(xpath = "//wb-control-error[text() = ' Please enter a valid Postal Code. ']")
    private WebElement postCodeError;

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
        checkPostCodeIsEnteredCorrect();
        return this;
    }

    public StartPage choosePrivatePurpose() {
        privatePurpose.click();
        return this;
    }

    public AvailableVehiclesPage clickOnContinueButton() {
        continueButton.click();
        return new AvailableVehiclesPage();
    }

    public void checkPostCodeIsEnteredCorrect() {
        List<WebElement> elements = driver.findElements(xpath("//wb-control-error[text() = ' Please enter a valid Postal Code. ']"));

        if (!elements.isEmpty()) {
            postalCodeInput.clear();
            postalCodeInput.sendKeys("2007");
        }
    }
}
