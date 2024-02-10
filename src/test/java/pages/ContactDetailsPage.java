package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Constants.ProjectConstants.FALSE_RESULT;
import static java.lang.String.format;

public class ContactDetailsPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[text()=' First Name ']/following-sibling::input")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[text()=' Last Name ']/following-sibling::input")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[text()=' E-Mail ']/following-sibling::input")
    private WebElement emailInput;

    @FindBy(xpath = "//*[text()=' Phone ']/following-sibling::input")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[text()=' Postal Code ']/following-sibling::input")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//*[contains(@name, 'alert-circle')]")
    private WebElement alertCircle;

    @FindBy(xpath = "//wb-control-error")
    private WebElement errorMessage;

    public ContactDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public ContactDetailsPage inputFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public ContactDetailsPage inputLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public ContactDetailsPage inputEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public ContactDetailsPage inputPhoneNumber(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    public ContactDetailsPage inputPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
    return this;
    }

    public ContactDetailsPage fillContactForm(String firstName, String lastName, String email, String phone, String postalCode) {
        inputFirstName(firstName);
        inputLastName(lastName);
        inputEmail(email);
        inputPhoneNumber(phone);
        inputPostalCode(postalCode);
        return this;
    }

    public ContactDetailsPage checkErrorStateIsDisplayed(String errorText) {
        waitForElementDisplayed(errorMessage);
        alertCircle.isDisplayed();
        String actualText = errorMessage.getText();
        assert actualText.equals(errorText) : format(FALSE_RESULT, errorText, actualText);
        return this;
    }
}
