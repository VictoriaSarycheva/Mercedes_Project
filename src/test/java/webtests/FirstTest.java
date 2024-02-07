package webtests;

import core.BaseSeleniumClass;
import org.junit.jupiter.api.Test;
import pages.StartPage;

public class FirstTest extends BaseSeleniumClass {


    @Test
    public void checkTicket() {
        StartPage startPage = new StartPage();
        startPage
                .clickOnYourStateDropdown()
                .chooseStateOptionFromList()
                .inputPostCode("2007")
                .choosePrivatePurpose();
    }

}
