package webtests;

import core.BaseSeleniumClass;
import org.junit.jupiter.api.Test;
import pages.ChoosingLocationPage;

public class FirstTest extends BaseSeleniumClass {

    @Test
    public void checkTicket() {
        ChoosingLocationPage abc = new ChoosingLocationPage();
        abc.clickOnYourStateDropdown();
    }
}
