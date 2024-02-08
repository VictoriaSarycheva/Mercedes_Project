package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AvailableVehiclesPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[contains(@class, 'dcp-loading-spinner')]")
    private WebElement loaderSpinner;

    @FindBy(xpath = "//*[contains(@class, 'show')]")
    private WebElement filterButton;

    @FindBy(xpath = "//*[contains(text(), 'Pre-Owned')]//ancestor::wb-tab")
    private WebElement preOwnedTab;

    @FindBy(xpath = "//*[contains(@class, 'category-filter-row-headline__text') and text() = 'Colour']")
    private WebElement colourFilter;

    @FindBy(xpath = "//*[contains(text(), 'Colour')]" +
            "//ancestor::*[contains(@data-test-id, 'multi-select-dropdown-card-opener')]")
    private WebElement colourDropdown;

    @FindBy(xpath = "//*[contains(text(), ' BRILLANTBLUE metallic ')]" +
            "//ancestor::*[contains(@class, 'dcp-filter-pill')]")
    private WebElement colour;

    @FindBy(xpath = "//button[text() = ' Show more vehicles ']")
    private WebElement showMoreButton;

    @FindBy(xpath = "//*[contains(text(), 'Sorting')]//ancestor::wb-select")
    private WebElement sortingDropdown;

    @FindBy(xpath = "//option[text()=' Price (descending) ']")
    private WebElement priceDesc;

    @FindBy(xpath = "//*[contains(@class, 'dcp-cars-srp-results__tile')][1]")
    private WebElement firstCarCard;

    public AvailableVehiclesPage() {
        PageFactory.initElements(driver, this);
    }

    public AvailableVehiclesPage clickOnFilterButton() {
        filterButton.click();
        return this;
    }

    public AvailableVehiclesPage clickOnPreOwnedTab() {
        preOwnedTab.click();
        waitForElementToDisappear(driver, loaderSpinner);
        waitForElementDisplayed(driver, colourFilter);
        return this;
    }

    public AvailableVehiclesPage clickOnColourFilter() {
        scrollToElement(driver, colourFilter);
        colourFilter.click();
        return this;
    }

    public AvailableVehiclesPage clickOnColourDropdown() {
        scrollToElement(driver, colourDropdown);
        colourDropdown.click();
        return this;
    }

    public AvailableVehiclesPage clickOnColour() {
        scrollToElement(driver, showMoreButton);
        colour.click();
        return this;
    }

    public AvailableVehiclesPage clickOnSorting() {
        sortingDropdown.click();
        return this;
    }

    public AvailableVehiclesPage clickOnPriceDescOption() {
        priceDesc.click();
        return this;
    }

    public CarParametersPage clickOnFirstCarCard() {
        firstCarCard.click();
        return new CarParametersPage();
    }

    public static void waitForElementToDisappear(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        wait.until(invisibilityOf(element));
    }

    public static void waitForElementDisplayed(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        wait.until(visibilityOf(element));
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
