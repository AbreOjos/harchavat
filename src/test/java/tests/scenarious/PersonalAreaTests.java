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

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneErrorMessage(), 1,
                String.format("An error message not appeared when forbidden char '%s' entered to a Phone field.", forbiddenChars));

    }

    protected void forbiddenCharactersCellularPhoneNumber(String forbiddenChars) {
        log.info(String.format("Enter the characters '%s' to a Cellular Number field, find the error message", forbiddenChars));

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.enterCellular(forbiddenChars);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneErrorMessage(), 1,
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

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getStandardErrorMessage(), 1,
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

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getStandardErrorMessage(), 1,
                String.format("An error message not appeared when the correct email '%s' deleted from an Email field.", correctMail));
    }

}
