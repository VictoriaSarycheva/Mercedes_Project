package webtests;

import core.BaseSeleniumClass;
import org.junit.jupiter.api.Test;
import pages.StartPage;

import static Constants.ProjectConstants.BRILLANTBLUE_METALLIC;
import static Constants.ProjectConstants.NEW_SOUTH_WALES_STATE;

public class AvailableVehiclesFilterTest extends BaseSeleniumClass {

    @Test
    public void checkErrorStateForIncorrectEmail() {
        StartPage startPage = new StartPage();
        startPage
                .clickOnYourStateDropdown()
                .chooseStateOptionFromList(NEW_SOUTH_WALES_STATE)
                .inputPostCode("2007")
                .choosePrivatePurpose()
                .clickOnContinueButton()
                .clickOnFilterButton()
                .clickOnPreOwnedTab()
                .clickOnColourFilter()
                .clickOnColourDropdown()
                .clickOnColour(BRILLANTBLUE_METALLIC)
                .checkAmountOfVehicleCards(1);
    }
}
