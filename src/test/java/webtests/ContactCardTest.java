package webtests;

import core.BaseSeleniumClass;
import org.junit.jupiter.api.Test;
import pages.CarParametersPage;
import pages.StartPage;

import static constants.ProjectConstants.*;

public class ContactCardTest extends BaseSeleniumClass {

   @Test
    public void checkErrorStateForIncorrectEmail() {
        StartPage startPage = new StartPage();
        startPage
                .fillLocationData(NEW_SOUTH_WALES_STATE, WALES_POST_CODE)
                .clickOnFilterButton()
                .clickOnPreOwnedTab()
                .openColorFilterAndChooseColor(BRILLANTBLUE_METALLIC)
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
