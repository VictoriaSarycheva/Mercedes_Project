package webtests;

import core.BaseSeleniumClass;
import org.junit.jupiter.api.Test;
import pages.AvailableVehiclesPage;
import pages.CarParametersPage;
import pages.StartPage;

public class FirstTest extends BaseSeleniumClass {


    @Test
    public void checkTicket() {
        StartPage startPage = new StartPage();
        startPage
                .clickOnYourStateDropdown()
                .chooseStateOptionFromList()
                .inputPostCode("2007")
                .choosePrivatePurpose()
                .clickOnContinueButton();

        AvailableVehiclesPage vehiclesPage = new AvailableVehiclesPage();
        vehiclesPage
                .clickOnFilterButton()
                .clickOnPreOwnedTab()
                .clickOnColourFilter()
                .clickOnColourDropdown()
                .clickOnBlueColour()
                .clickOnSorting()
                .clickOnPriceDescOption()
                .clickOnFirstCarCard();

        CarParametersPage carParameters = new CarParametersPage();
        String carData = carParameters.getWin() + "\n" + carParameters.getModelYear();
        carParameters.saveDataToFile(carData);

        carParameters.clickOnOrderNowButton();
    }

}
