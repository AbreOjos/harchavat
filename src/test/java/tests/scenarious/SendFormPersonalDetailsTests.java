package tests.scenarious;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pom.forms.PersonalDetails;
import pom.forms.sendform.SendForm;
import tests.TestBase;

import static constants.EnglishHebrewConstants.*;

public class SendFormPersonalDetailsTests extends TestBase {
    private static final Logger log = Logger.getLogger(SendFormPersonalDetailsTests.class);

    protected void personalDetailsNotFilledFields() {
        log.info("All fields on Personal Area page unfilled and not exists on Send Form page");

        SendForm sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.idContains(userId), String.format("Instead ID '%s' found '%s'",
                userId, sendForm.getId().get(0).getText()));
//        Assert.assertTrue(sendForm.firstNameContains(userFirstName), String.format("Instead First Name '%s' found '%s'",
//                userFirstName, sendForm.getFirstName().get(0).getText()));
//        Assert.assertTrue(sendForm.familyNameContains(userFamilyName), String.format("Instead Family Name '%s' found '%s'",
//                userFamilyName, sendForm.getFamilyName().get(0).getText()));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getCellularPhone(), 0,
                "An empty field 'Cellular Phone' appeared on a Send Form page");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getLandlinesPhone(), 0,
                "An empty field 'Landlines Phone' appeared on a Send Form page");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getEmail(), 0,
                "An empty field 'Email' appeared on a Send Form page");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getSpouseIsraeliCitizen(), 0,
                "An empty field 'Spouse Israeli Citizen' appeared on a Send Form page");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getSpouseId(), 0,
                "An empty field 'Spouse ID' appeared on a Send Form page");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getSpousePassport(), 0,
                "An empty field 'Spouse Passport' appeared on a Send Form page");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getSpouseCountry(), 0,
                "An empty field 'Spouse Country' appeared on a Send Form page");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getSpouseState(), 0,
                "An empty field 'Spouse State' appeared on a Send Form page");
    }

    protected void israeliBachelor() throws InterruptedException {
        log.info("Person Israeli, bachelor, has phones and email");

        String correctPhoneNumber = "123456789";
        String correctCellularNumber = "987654321";
        String correctEmail = "abc@def.com";

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.checkAgreement();
        personalDetails.enterPhone(correctPhoneNumber);
        personalDetails.enterCellular(correctCellularNumber);
        personalDetails.enterEmail(correctEmail);
        personalDetails.checkCanSendEmail();
        personalDetails.chooseIsraeli();
        personalDetails.chooseMaritalStatusBachelor();

        SendForm sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.landlinesPhoneContains(correctPhoneNumber),
                String.format("Instead of landlines phone '%s' found '%s'", correctPhoneNumber, sendForm.getLandlinesPhone().get(0).getText()));

        Assert.assertTrue(sendForm.cellularPhoneContains(correctCellularNumber),
                String.format("Instead of cellular phone '%s' found '%s'", correctCellularNumber, sendForm.getCellularPhone().get(0).getText()));

        Assert.assertTrue(sendForm.emailContains(correctEmail),
                String.format("Instead of email '%s' found '%s'", correctEmail, sendForm.getEmail().get(0).getText()));

        Assert.assertTrue(sendForm.israelCitizenContains(YES),
                String.format("Instead of Israeli Citizen '%s' found '%s'", YES, sendForm.getIsraeliCitizen().get(0).getText()));

        Assert.assertTrue(sendForm.maritalStatusContains(BACHELOR),
                String.format("Instead of Marital Status '%s' found '%s'", YES, sendForm.getMaritalStatus().get(0).getText()));

    }

    protected void expatriateMarriedIsraeli() throws InterruptedException {
        log.info("Expatriate married on Israeli");

        String correctPhoneNumber = "123456789";
        String correctSpouseId= "325969987";

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.checkAgreement();
        personalDetails.enterPhone(correctPhoneNumber);
        personalDetails.chooseExpatriate();
        personalDetails.chooseMaritalStatusMarried();

        personalDetails.chooseSpouseIsraeli();
        personalDetails.deleteSpouseIdentity();
        personalDetails.enterSpouseIdentity(correctSpouseId);

        SendForm sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.landlinesPhoneContains(correctPhoneNumber),
                String.format("Instead of landlines phone '%s' found '%s'", correctPhoneNumber, sendForm.getLandlinesPhone().get(0).getText()));

        Assert.assertTrue(sendForm.israelCitizenContains(NO),
                String.format("Instead of Israeli Citizen '%s' found '%s'", NO, sendForm.getIsraeliCitizen().get(0).getText()));

        Assert.assertTrue(sendForm.spouseIsraeliCitizenContains(YES),
                String.format("Instead of Israeli Citizen '%s' found '%s'", YES, sendForm.getSpouseIsraeliCitizen().get(0).getText()));

        Assert.assertTrue(sendForm.spouseIdContains(correctSpouseId),
                String.format("Instead of spouse ID '%s' found '%s'", correctSpouseId, sendForm.getSpouseId().get(0).getText()));
    }

    protected void israeliSpouseAllianceExpatriate() throws InterruptedException {
        log.info("Israeli in spouse alliance with expatriate");

        String correctPhoneNumber = "123456789";
        String correctSpousePassport= "325969987";

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.checkAgreement();
        personalDetails.enterPhone(correctPhoneNumber);
        personalDetails.chooseIsraeli();
        personalDetails.chooseMaritalStatusSpousalAlliance();

        personalDetails.chooseSpouseExpatriate();
        personalDetails.deleteSpousePassport();
        personalDetails.deleteSpouseState();
        personalDetails.enterSpousePassport(correctSpousePassport);
        personalDetails.chooseStateSpouseUsa();

        SendForm sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.landlinesPhoneContains(correctPhoneNumber),
                String.format("Instead of landlines phone '%s' found '%s'", correctPhoneNumber, sendForm.getLandlinesPhone().get(0).getText()));

        Assert.assertTrue(sendForm.israelCitizenContains(YES),
                String.format("Instead of Israeli Citizen '%s' found '%s'", YES, sendForm.getIsraeliCitizen().get(0).getText()));

        Assert.assertTrue(sendForm.spouseIsraeliCitizenContains(NO),
                String.format("Instead of Israeli Citizen '%s' found '%s'", NO, sendForm.getSpouseIsraeliCitizen().get(0).getText()));

        Assert.assertTrue(sendForm.spousePassportContains(correctSpousePassport),
                String.format("Instead of spouse passport '%s' found '%s'", correctSpousePassport, sendForm.getSpousePassport().get(0).getText()));

        Assert.assertTrue(sendForm.spouseCountryContains(USA),
                String.format("Instead of spouse country '%s' found '%s'", USA, sendForm.getSpouseCountry().get(0).getText()));

        Assert.assertTrue(sendForm.spouseStateContains(NOT_YET_REPORTED),
                String.format("Instead of spouse state '%s' found '%s'", NOT_YET_REPORTED, sendForm.getSpouseState().get(0).getText()));
    }

    protected void expatriatePolygamyExpatriate() throws InterruptedException {
        log.info("Expatriate polygamy alliance with expatriate");

        String correctPhoneNumber = "123456789";
        String correctSpousePassport= "325969987";
        String correctSpouseState = "ABCDEF";

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.checkAgreement();
        personalDetails.enterPhone(correctPhoneNumber);
        personalDetails.chooseExpatriate();
        personalDetails.chooseMaritalStatusPolygamy();

        personalDetails.chooseSpouseExpatriate();
        personalDetails.deleteSpousePassport();
        personalDetails.deleteSpouseState();
        personalDetails.enterSpousePassport(correctSpousePassport);
        personalDetails.chooseStateSpouseUsa();
        personalDetails.enterSpouseState(correctSpouseState);

        SendForm sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.landlinesPhoneContains(correctPhoneNumber),
                String.format("Instead of landlines phone '%s' found '%s'", correctPhoneNumber, sendForm.getLandlinesPhone().get(0).getText()));

        Assert.assertTrue(sendForm.israelCitizenContains(NO),
                String.format("Instead of Israeli Citizen '%s' found '%s'", NO, sendForm.getIsraeliCitizen().get(0).getText()));

        Assert.assertTrue(sendForm.spouseIsraeliCitizenContains(NO),
                String.format("Instead of Israeli Citizen '%s' found '%s'", NO, sendForm.getSpouseIsraeliCitizen().get(0).getText()));

        Assert.assertTrue(sendForm.spousePassportContains(correctSpousePassport),
                String.format("Instead of spouse passport '%s' found '%s'", correctSpousePassport, sendForm.getSpousePassport().get(0).getText()));

        Assert.assertTrue(sendForm.spouseCountryContains(USA),
                String.format("Instead of spouse country '%s' found '%s'", USA, sendForm.getSpouseCountry().get(0).getText()));

        Assert.assertTrue(sendForm.spouseStateContains(correctSpouseState),
                String.format("Instead of spouse state '%s' found '%s'", correctSpouseState, sendForm.getSpouseState().get(0).getText()));

    }
}
