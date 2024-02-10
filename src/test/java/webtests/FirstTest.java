package webtests;

import core.BaseSeleniumClass;
import org.junit.jupiter.api.Test;
import pages.CarParametersPage;
import pages.StartPage;

public class FirstTest extends BaseSeleniumClass {

    @Test
    public void checkErrorStateForIncorrectEmail() {
        StartPage startPage = new StartPage();
        startPage
                .clickOnYourStateDropdown()
                .chooseStateOptionFromList()
                .inputPostCode("2007")
                .choosePrivatePurpose()
                .clickOnContinueButton()
                .clickOnFilterButton()
                .clickOnPreOwnedTab()
                .clickOnColourFilter()
                .clickOnColourDropdown()
                .clickOnColour()
                .clickOnSorting()
                .clickOnPriceDescOption()
                .clickOnFirstCarCard();

        CarParametersPage carParameters = new CarParametersPage();
        String carData = carParameters.getWin() + "\n" + carParameters.getModelYear();
        carParameters.saveDataToFile(carData);

        carParameters
                .clickOnEnquireNowButton()
                .fillContactForm("First", "Last", "fake.com", "+441123456789", "2007")
                .checkErrorStateIsDisplayed();
    }

}
