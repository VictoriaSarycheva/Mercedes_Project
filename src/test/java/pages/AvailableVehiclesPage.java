package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Constants.ProjectConstants.FALSE_RESULT;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class AvailableVehiclesPage extends BaseSeleniumPage {

    public static final String VEHICLE_COLOR = "//*[contains(text(), '%s')]" +
            "//ancestor::*[contains(@class, 'dcp-filter-pill')]";

    @FindBy(xpath = "//*[contains(@class, 'dcp-loader')]")
    private WebElement loadSpinner;

    @FindBy(xpath = "//*[contains(@class, 'dcp-header-location-text')]")
    private WebElement locationTag;

    @FindBy(xpath = "//*[contains(@class, 'show')]")
    private WebElement filterButton;

    @FindBy(xpath = "//*[contains(text(), 'Pre-Owned')]//ancestor::wb-tab")
    private WebElement preOwnedTab;

    @FindBy(xpath = "//*[contains(@class, 'category-filter-row-headline__text') and text() = 'Colour']")
    private WebElement colourFilter;

    @FindBy(xpath = "//*[contains(text(), 'Colour')]" +
            "//ancestor::*[contains(@data-test-id, 'multi-select-dropdown-card-opener')]")
    private WebElement colourDropdown;

    @FindBy(xpath = "//button[text() = ' Show more vehicles ']")
    private WebElement showMoreButton;

    @FindBy(xpath = "//*[contains(text(), 'Sorting')]//ancestor::wb-select")
    private WebElement sortingDropdown;

    @FindBy(xpath = "//option[text()=' Price (descending) ']")
    private WebElement priceDesc;

    @FindBy(xpath = "//*[contains(@class, 'dcp-cars-srp-results__tile')]")
    private List<WebElement> carCards;

    @FindBy(xpath = "//*[contains(@class, 'dcp-cars-srp-results__tile')][1]")
    private WebElement firstCarCard;

    public AvailableVehiclesPage() {
        PageFactory.initElements(driver, this);
    }

    public AvailableVehiclesPage clickOnFilterButton() {
        waitForElementDisplayed(filterButton);
        filterButton.click();
        return this;
    }

    public AvailableVehiclesPage clickOnPreOwnedTab() {
        preOwnedTab.click();
        waitForElementToDisappear(loadSpinner);
        waitForElementDisplayed(colourFilter);
        return this;
    }

    public AvailableVehiclesPage clickOnColourFilter() {
        scrollToElement(colourFilter);
        colourFilter.click();
        return this;
    }

    public AvailableVehiclesPage clickOnColourDropdown() {
        scrollToElement(colourDropdown);
        colourDropdown.click();
        return this;
    }

    public AvailableVehiclesPage clickOnColour(String color) {
        scrollToElement(showMoreButton);
        String xpath = String.format(VEHICLE_COLOR, color);
        WebElement vehicleColor = driver.findElement(xpath(xpath));
        vehicleColor.click();
        waitForElementToDisappear(loadSpinner);
        return this;
    }

    public AvailableVehiclesPage clickOnSorting() {
        scrollToElement(locationTag);
        sortingDropdown.click();
        return this;
    }

    public AvailableVehiclesPage clickOnPriceDescOption() {
        priceDesc.click();
        return this;
    }

    public CarParametersPage clickOnFirstCarCard() {
        waitForElementToDisappear(loadSpinner);
        firstCarCard.click();
        return new CarParametersPage();
    }

    public AvailableVehiclesPage checkAmountOfVehicleCards(int amount) {
        Integer amountOfCars = carCards.size();
        assert amountOfCars.equals(amount) : format(FALSE_RESULT, amount, amountOfCars);
        return this;
    }
}
