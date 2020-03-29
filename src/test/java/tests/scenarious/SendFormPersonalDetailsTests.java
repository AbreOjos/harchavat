package tests.scenarious;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pom.forms.SendForm;
import tests.TestBase;

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
}
