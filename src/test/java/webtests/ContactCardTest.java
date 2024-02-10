package webtests;

import core.BaseSeleniumClass;
import org.junit.jupiter.api.Test;
import pages.CarParametersPage;
import pages.StartPage;

import static Constants.ProjectConstants.*;

public class ContactCardTest extends BaseSeleniumClass {

   @Test
    public void checkErrorStateForIncorrectEmail() {
        StartPage startPage = new StartPage();
        startPage
                .clickOnYourStateDropdown()
                .chooseStateOptionFromList(NEW_SOUTH_WALES_STATE)
                .inputPostCode(WALES_POST_CODE)
                .choosePrivatePurpose()
                .clickOnContinueButton()
                .clickOnFilterButton()
                .clickOnPreOwnedTab()
                .clickOnColourFilter()
                .clickOnColourDropdown()
                .clickOnColour(BRILLANTBLUE_METALLIC)
                .clickOnSorting()
                .clickOnPriceDescOption()
                .clickOnFirstCarCard();

        CarParametersPage carParameters = new CarParametersPage();
        String carData = carParameters.getWin() + "\n" + carParameters.getModelYear();
        carParameters.saveDataToFile(carData);

        carParameters
                .clickOnEnquireNowButton()
                .fillContactForm("First", "Last", "fake.com", "0441234567", WALES_POST_CODE)
                .checkErrorStateIsDisplayed(INCORRECT_EMAIL_ERROR);
    }

}
