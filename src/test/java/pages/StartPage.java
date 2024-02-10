package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Constants.ProjectConstants.FALSE_RESULT;
import static Constants.ProjectConstants.START_PAGE_URL;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.xpath;

public class StartPage extends BaseSeleniumPage {

    public static final String STATE_XPATH = "//option[text() = '%s']";

    @FindBy(xpath = "//*[contains(@class, 'dcp-loader')]")
    private WebElement loadSpinner;

    @FindBy(xpath = "//*[contains(text(), 'Your state')]//ancestor::wb-select")
    private WebElement yourStateDropdown;

    @FindBy(xpath = "//input[contains(@aria-labelledby, 'postal-code-hint')]")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//*[contains(text(), 'Private')]//ancestor::wb-radio-control")
    private WebElement privatePurpose;

    @FindBy(xpath = "//button//*[contains(text(), 'Continue')]")
    private WebElement continueButton;

    @FindBy(xpath = "//wb-control-error")
    private WebElement errorMessage;

    public StartPage() {
        driver.get(START_PAGE_URL);
        PageFactory.initElements(driver, this);
        waitForElementToDisappear(loadSpinner);
    }

    public StartPage clickOnYourStateDropdown() {
        yourStateDropdown.click();
        return this;
    }

    public StartPage chooseStateOptionFromList(String stateName) {
        String xpath = String.format(STATE_XPATH, stateName);
        WebElement stateOption = driver.findElement(xpath(xpath));
        stateOption.click();
        return this;
    }

    public StartPage inputPostCode(String postCode) {
        postalCodeInput.click();
        postalCodeInput.sendKeys(postCode);
        driver.manage().timeouts().scriptTimeout(ofSeconds(3));
        return this;
    }

    public StartPage checkErrorMessageIsDisplayedAndContainsText(String errorText) {
        waitForElementDisplayed(errorMessage);
        assert errorMessage.getText().equals(errorText) : format(FALSE_RESULT, errorText, errorMessage.getText());
        return this;
    }

    public StartPage checkPostalCodeIsEmpty() {
        String inputValue = postalCodeInput.getAttribute("value");
        assert inputValue.equals("") : format(FALSE_RESULT, "", inputValue);
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
}
