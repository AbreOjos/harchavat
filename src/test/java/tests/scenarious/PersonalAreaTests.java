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
                "An error messages 'enter phone number' did not appeared after returning to Personal Details page");

        // enter cellular phone, check that both error messages disappeared
        personalDetails.enterCellular("123456789");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 0,
                "An error messages 'enter phone number' did not disappeared when cellular phone entered");

        // clean cellular, check that both error messages reappears
        personalDetails.deleteCellular();
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 2,
                "An error messages 'enter phone number' did not appeared after cleaning cellular phone");

        // enter landlines phone, check that both error messages disappeared
        personalDetails.enterPhone("123456789");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 0,
                "An error messages 'enter phone number' did not disappeared when landlines phone entered");

        // clean landlines, check that both error messages reappears
        personalDetails.deletePhone();
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 2,
                "An error messages 'enter phone number' did not appeared after cleaning landlines phone");

        // enter both numbers, check that messages disappeared
        personalDetails.enterCellular("123456789");
        personalDetails.enterPhone("123456789");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 0,
                "An error messages 'enter phone number' did not disappeared when both phones entered");

        // remove only one number check that the messages did not appeared
        personalDetails.deleteCellular();
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 0,
                "An error messages 'enter phone number' appeared when cellular phone deleted and landlines not deleted");

        personalDetails.enterCellular("123456789");
        personalDetails.deletePhone();
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getPhoneMissingErrorMessage(), 0,
                "An error messages 'enter phone number' appeared when landlines phone deleted and cellular not deleted");

    }

    protected void marriedSpouseIdMissingErrorMessage() {
        log.info("Married Spouse ID missing error message");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusMarried();

        spouseIdMissingErrorMessage(personalDetails);
    }

    protected void marriedSpouseIdFormat() {
        log.info("Married spouse ID correct and incorrect formats");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusMarried();

        spouseIdFormat(personalDetails);
    }

    protected void spousalAllianceSpouseIdMissingErrorMessage() {
        log.info("Spousal Alliance Spouse ID missing error message");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusSpousalAlliance();

        spouseIdMissingErrorMessage(personalDetails);
    }

    protected void spousalAllianceSpouseIdFormat() {
        log.info("Spousal Alliance spouse ID correct and incorrect formats");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusSpousalAlliance();

        spouseIdFormat(personalDetails);
    }

    protected void polygamySpouseIdMissingErrorMessage() {
        log.info("Polygamy Spouse ID missing error message");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusPolygamy();

        spouseIdMissingErrorMessage(personalDetails);
    }

    protected void polygamyAllianceSpouseIdFormat() {
        log.info("Polygamy spouse ID correct and incorrect formats");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusPolygamy();

        spouseIdFormat(personalDetails);
    }

    protected void marriedSpousePassportMissingErrorMessage() {
        log.info("Married Spouse passport missing error message");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusMarried();

        spousePassportMissingErrorMessage(personalDetails);
    }

    protected void marriedSpousePassportFormat() {
        log.info("Married spouse passport correct and incorrect formats");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusMarried();

        spousePassportFormat(personalDetails);
    }

    protected void spousalAllianceSpousePassportMissingErrorMessage() {
        log.info("Spousal Alliance Spouse passport missing error message");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusSpousalAlliance();

        spousePassportMissingErrorMessage(personalDetails);
    }

    protected void spousalAllianceSpousePassportFormat() {
        log.info("Spousal Alliance spouse passport correct and incorrect formats");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusSpousalAlliance();

        spousePassportFormat(personalDetails);
    }

    protected void polygamySpousePassportMissingErrorMessage() {
        log.info("Polygamy Spouse passport missing error message");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusPolygamy();

        spousePassportMissingErrorMessage(personalDetails);
    }

    protected void polygamyAllianceSpousePassportFormat() {
        log.info("Polygamy spouse passport correct and incorrect formats");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusPolygamy();

        spousePassportFormat(personalDetails);
    }

    // == help methods ==
    protected void prepareEmptyPhoneAndEmailFields() {
        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.deleteCellular();
        personalDetails.deletePhone();
        personalDetails.deleteEmail();
        personalDetails.clickBtnSave();
    }

    // == private methods ==
    private void spouseIdMissingErrorMessage(PersonalDetails personalDetails) {
        personalDetails.chooseSpouseIsraeli();
        personalDetails.enterSpouseIdentity("123");
        personalDetails.deleteSpouseIdentity();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getSpouseIdNeedToFillErrorMessage(), 1,
                "An error messages 'need to fill spouse ID' did not appeared after deleting a spouse ID");
    }

    private void spouseIdFormat(PersonalDetails personalDetails) {
        String incorrectSpouseId = "abcdef";
        String tooLongSpouseId = "1234567890";
        String correctSpouseId = "123456789";

        log.info(String.format("Enter the incorrect spouse ID '%s', find the error message", incorrectSpouseId));

        personalDetails.chooseSpouseIsraeli();
        personalDetails.enterSpouseIdentity(incorrectSpouseId);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getSpouseIdOnlyDigitalErrorMessage(), 1,
                String.format("An error message not appeared when the incorrect spouse ID '%s' entered.", incorrectSpouseId));

        log.info(String.format("Enter too long spouse ID '%s', check that another error message appeared", tooLongSpouseId));

        personalDetails.deleteSpouseIdentity();
        personalDetails.enterSpouseIdentity(tooLongSpouseId);
        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getSpouseIdTooLongErrorMessage(), 1,
                String.format("An error message not appeared when too long spouse ID '%s' entered", tooLongSpouseId));

        log.info(String.format("Enter correct spouse ID '%s', check that an error messages did not appears", correctSpouseId));

        personalDetails.deleteSpouseIdentity();
        personalDetails.enterSpouseIdentity(correctSpouseId);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getSpouseIdOnlyDigitalErrorMessage(), 0,
                String.format("An error message 'Digital Only' appeared when the correct spouse ID '%s' entered", correctSpouseId));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getSpouseIdTooLongErrorMessage(), 0,
                String.format("An error message 'Too Long' appeared when the correct spouse ID '%s' entered", correctSpouseId));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getSpouseIdNeedToFillErrorMessage(), 0,
                String.format("An error messages 'need to fill spouse ID' appeared when the correct spouse ID '%s' entered", correctSpouseId));
    }

    private void spousePassportMissingErrorMessage(PersonalDetails personalDetails) {
        personalDetails.chooseSpouseExpatriate();
        personalDetails.enterSpousePassport("123");
        personalDetails.deleteSpousePassport();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getSpousePassportNeedToFillErrorMessage(), 1,
                "An error messages 'need to fill spouse ID' did not appeared after deleting a spouse ID");
    }

    private void spousePassportFormat(PersonalDetails personalDetails) {
        String incorrectSpousePassport = "abcdef";
        String correctSpousePassport = "123456789";

        log.info(String.format("Enter the incorrect spouse passport '%s', find the error message", incorrectSpousePassport));

        personalDetails.chooseSpouseExpatriate();
        personalDetails.enterSpousePassport(incorrectSpousePassport);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getSpousePassportIncorrectFormatErrorMessage(), 1,
                String.format("An error message not appeared when the incorrect spouse ID '%s' entered.", incorrectSpousePassport));

        log.info(String.format("Enter correct spouse Passport '%s', check that an error messages did not appears", correctSpousePassport));

        personalDetails.deleteSpousePassport();
        personalDetails.enterSpousePassport(correctSpousePassport);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getSpousePassportIncorrectFormatErrorMessage(), 0,
                String.format("An error message 'Wrong Passport Format' appeared when the correct spouse assport '%s' entered", correctSpousePassport));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(personalDetails.getSpousePassportNeedToFillErrorMessage(), 0,
                String.format("An error messages 'need to fill spouse passport' appeared when the correct spouse passport '%s' entered", correctSpousePassport));
    }


}
