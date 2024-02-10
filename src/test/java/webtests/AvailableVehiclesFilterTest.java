package webtests;

import core.BaseSeleniumClass;
import org.junit.jupiter.api.Test;
import pages.StartPage;

import static Constants.ProjectConstants.*;

public class AvailableVehiclesFilterTest extends BaseSeleniumClass {

    @Test
    public void checkErrorStateForIncorrectEmail() {
        StartPage startPage = new StartPage();
        startPage
                .fillLocationData(NEW_SOUTH_WALES_STATE, WALES_POST_CODE)
                .clickOnFilterButton()
                .clickOnPreOwnedTab()
                .openColorFilterAndChooseColor(BRILLANTBLUE_METALLIC)
                .checkAmountOfVehicleCards(1);
    }
}
