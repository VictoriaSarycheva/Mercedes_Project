package webtests;

import core.BaseSeleniumClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.StartPage;

import static Constants.ProjectConstants.*;

public class ChoosingLocationPopupTest extends BaseSeleniumClass {

    public static final String INCORRECT_POST_CODE = "200";

    private StartPage startPage;

    @BeforeEach
    public void prepare() {
        startPage = new StartPage();
        startPage
                .clickOnYourStateDropdown()
                .chooseStateOptionFromList(NEW_SOUTH_WALES_STATE);
    }

    @Test
    public void checkErrorStateForIncorrectPostalCode() {
        startPage
                .inputPostCode(INCORRECT_POST_CODE)
                .checkErrorMessageIsDisplayedAndContainsText(INCORRECT_POSTAL_CODE_ERROR);
    }

    @Test
    public void checkPostalCodeIsRemovedAfterChangingState() {
        startPage
                .inputPostCode(WALES_POST_CODE)
                .chooseStateOptionFromList(VICTORIA_STATE)
                .checkPostalCodeIsEmpty();
    }
}
