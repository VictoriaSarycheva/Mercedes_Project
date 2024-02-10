package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static Constants.ProjectConstants.SAVE_DOCUMENT_URL;

public class CarParametersPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[contains(@data-test-id, 'dcp-vehicle-details-list-item-11')]" +
            "//*[contains(@class, 'dcp-vehicle-details-list-item__value')]")
    private WebElement winParameter;

    @FindBy(xpath = "//*[contains(@data-test-id, 'dcp-vehicle-details-list-item-1')]" +
            "//*[contains(@class, 'dcp-vehicle-details-list-item__value')]")
    private WebElement modelYearParameter;

    @FindBy(xpath = "//button[text() = ' Enquire Now ']")
    private WebElement enquireButton;


    public CarParametersPage() {
        PageFactory.initElements(driver, this);
    }

    public String getWin() {
        String win = winParameter.getText();
        return win;
    }

    public String getModelYear() {
        String year = modelYearParameter.getText();
        return year;
    }

    public ContactDetailsPage clickOnEnquireNowButton() {
        enquireButton.click();
        return new ContactDetailsPage();
    }

    public static void saveDataToFile(String data) {
        String filePath = SAVE_DOCUMENT_URL;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            System.out.println("Data saved to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to save data to file: " + e.getMessage());
        }
    }
}
