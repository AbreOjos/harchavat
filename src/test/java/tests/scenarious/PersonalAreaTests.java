package tests.scenarious;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import pom.forms.PersonalDetails;
import tests.TestBase;

public class PersonalAreaTests extends TestBase {
    private static final Logger log = Logger.getLogger(PersonalAreaTests.class);

    protected void forbiddenCharactersPhoneNumber(String forbiddenChars) {
        log.info(String.format("Enter the characters '%s' to a Phone Number field, find the error message", forbiddenChars));

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.enterPhone(forbiddenChars);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneFormatErrorMessage(), 1,
                String.format("An error message not appeared when forbidden char '%s' entered to a Phone field.", forbiddenChars));

    }

    protected void forbiddenCharactersCellularPhoneNumber(String forbiddenChars) {
        log.info(String.format("Enter the characters '%s' to a Cellular Number field, find the error message", forbiddenChars));

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.enterCellular(forbiddenChars);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneFormatErrorMessage(), 1,
                String.format("An error message not appeared when forbidden char '%s' entered to a Cellular Phone field.", forbiddenChars));

    }

    protected void incorrectMailFormat() {
        String incorrectMail = "abcdef";

        log.info(String.format("Enter the incorrect mail '%s' to an Email field, find the error message", incorrectMail));

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.enterEmail(incorrectMail);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getStandardErrorMessage(), 1,
                String.format("An error message not appeared when the incorrect email '%s' entered to an Email field.", incorrectMail));

        log.info("Delete the incorrect mail from an Email field completely, check that another error message appeared.");

        personalDetails.deleteEmail();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getEmailNeedToFillErrorMessage(), 1,
                String.format("An error message not appeared when the incorrect email '%s' completely deleted from an Email field.", incorrectMail));
    }

    protected void correctMailFormat() {
        String correctMail = "abc@def.ghm";

        log.info(String.format("Enter the correct mail '%s' to an Email field, check that an error message does not appeared", correctMail));

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.enterEmail(correctMail);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getStandardErrorMessage(), 0,
                String.format("An error message appeared when the correct email '%s' entered to an Email field.", correctMail));

        log.info("Delete the correct mail from an Email field completely, check that an error message appeared.");

        personalDetails.deleteEmail();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getEmailNeedToFillErrorMessage(), 1,
                String.format("An error message not appeared when the correct email '%s' deleted from an Email field.", correctMail));
    }

    protected void phonesMissingErrorMessage() {
        log.info("Two 'enter phone' error messages appears, both disappears when any phone entered");

        basePage.clickMenuPersonalDetails();
        basePage.clickMenuWage();
        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        // after returning to PersonalDetails two 'enter phone' messages appears
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 2,
                "An error messages '' enter phone number did not appeared after returning to Personal Details page.");

        // enter cellular phone, check that both error messages disappeared
        personalDetails.enterCellular("123456789");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 0,
                "An error messages 'enter phone number' did not disappeared when cellular phone entered.");

        // clean cellular, check that both error messages reappears
        personalDetails.deleteCellular();
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 2,
                "An error messages 'enter phone number' did not appeared after cleaning cellular phone.");

        // enter landlines phone, check that both error messages disappeared
        personalDetails.enterPhone("123456789");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 0,
                "An error messages 'enter phone number' did not disappeared when landlines phone entered.");

        // clean landlines, check that both error messages reappears
        personalDetails.deletePhone();
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 2,
                "An error messages 'enter phone number' did not appeared after cleaning landlines phone.");

        // enter both numbers, check that messages disappeared
        personalDetails.enterCellular("123456789");
        personalDetails.enterPhone("123456789");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 0,
                "An error messages 'enter phone number' did not disappeared when both phones entered.");

        // remove only one number check that the messages did not appeared
        personalDetails.deleteCellular();
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 0,
                "An error messages 'enter phone number' appeared when cellular phone deleted and landlines not deleted.");

        personalDetails.enterCellular("123456789");
        personalDetails.deletePhone();
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 0,
                "An error messages 'enter phone number' appeared when landlines phone deleted and cellular not deleted.");

    }

    // == help methods ==
    protected void prepareEmptyPhoneAndEmailFields() {
        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.deleteCellular();
        personalDetails.deletePhone();
        personalDetails.deleteEmail();
        personalDetails.clickBtnSave();
    }

}
