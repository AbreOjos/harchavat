package tests.scenarious.demo;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pom.forms.PersonalDetails;
import pom.forms.vehicles.Vehicle;
import pom.sendform.SendForm;
import tests.TestBase;

import static constants.EnglishHebrewConstants.NO;
import static constants.EnglishHebrewConstants.USA;

public class DemoScenarious extends TestBase {
    private static final Logger log = Logger.getLogger(DemoScenarious.class);

    protected void checkMenuIcons() {
        log.info("Check that Vehicle menu has icons: error, checked, without icon");

        String correctLicense = "12345678";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();
        vehicle.choosePrivateVehicle(0);
        basePage.clickMenuWage();
        vehicle = basePage.clickMenuVehicle();

        // check error icon
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getErrorIconMenu(), 1,
                "An error icon menu did not appears when there are empty mandatory fields");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getCheckCircleIconMenu(), 0,
                "A check-circle icon menu did not disappears when there are empty mandatory fields");

        vehicle.choosePrivateVehicle(0);
        vehicle.enterCarLicense(0, correctLicense);
        basePage.clickMenuWage();
        vehicle = basePage.clickMenuVehicle();

        // check check-circle icon
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getCheckCircleIconMenu(), 1,
                "A check-circle icon menu did not appears when mandatory fields contain correct values");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getErrorIconMenu(), 0,
                "An error icon menu did not disappears when mandatory fields contain correct values");

        vehicle.chooseDontHaveVehicle();
        basePage.clickMenuWage();
        vehicle = basePage.clickMenuVehicle();

        // check icons disappeared
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getCheckCircleIconMenu(), 0,
                "A check-circle icon menu appears when there are no vehicles");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getErrorIconMenu(), 0,
                "An error icon menu appears when there are no vehicles");
    }

    protected void checkDownloadedFormForSeparates() {
        log.info("Choose 'separated', click 'download' link, check that pdf opened in a separate tab");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.chooseMaritalStatusSeparated();

        personalDetails.clickDownloadLinkCheckSuffixAndReturn("pdf");
    }

    protected void needFillVehicleDetailsErrorMessage() {
        log.info("Add a few vehicles, play with 'need to fill vehicle details' error messages");

        String vehicleDetails = "abcde";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();
        vehicle.addVehicle();
        vehicle.addVehicle();

        vehicle.chooseAircraftVehicle(0);
        vehicle.chooseAnotherVehicle(1);
        vehicle.chooseCommercialVehicle(2);

        basePage.clickMenuPersonalDetails();
        vehicle = basePage.clickMenuVehicle();

        // check error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(0), 0,
                "Error message 'Need to Fill Vehicle Details' appear on a first panel - not Another vehicle");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(1), 1,
                "Error message 'Need to Fill Vehicle Details' did not appear on a second panel - Another vehicle");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(2), 0,
                "Error message 'Need to Fill Vehicle Details' appear on a third panel - not Another vehicle");

        vehicle.deleteVehicle(2);

        // recheck error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(0), 0,
                "Error message 'Need to Fill Vehicle Details' appear on a first panel - not Another vehicle");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(1), 1,
                "Error message 'Need to Fill Vehicle Details' did not appear on a second panel - Another vehicle");

        vehicle.deleteAnotherCarTypeDetails(1);
        vehicle.enterAnotherCarTypeDetails(1, vehicleDetails);

        // recheck error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(0), 0,
                "Error message 'Need to Fill Vehicle Details' appear on a first panel - not Another vehicle");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillVehicleDetailsErrorMessage(1), 0,
                "Error message 'Need to Fill Vehicle Details' did not disappear from a second panel after filling details");
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

    protected void sendFormMultiVehicles() {
        log.info("Add and delete a few vehicles, check that data does not loss");

        String anotherVehicle = "Another vehicle";
        String anotherUsage = "Another usage";
        String firstCorrectLicense = "12345678";
        String secondCorrectLicense = "12-345-67";
        String thirdCorrectLicense = "123-45-678";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();

        vehicle.addVehicle();
        vehicle.addVehicle();

        vehicle.choosePrivateVehicle(0);
        vehicle.chooseAircraftVehicle(1);
        vehicle.chooseAnotherVehicle(2);

        vehicle.deleteAnotherCarTypeDetails(2);
        vehicle.enterAnotherCarTypeDetails(2, anotherVehicle);

        vehicle.choosePrivateUsage(0);
        vehicle.chooseAnotherUsage(1);
        vehicle.chooseCommercialUsage(2);

        vehicle.deleteAnotherUsageDetails(1);
        vehicle.enterAnotherUsageDetails(1, anotherUsage);

        vehicle.deleteCarLicense(0);
        vehicle.enterCarLicense(0, firstCorrectLicense);
        vehicle.deleteCarLicense(1);
        vehicle.enterCarLicense(1, secondCorrectLicense);
        vehicle.deleteCarLicense(2);
        vehicle.enterCarLicense(2, thirdCorrectLicense);

        SendForm sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getVehicles(), 3,
                String.format("Expected %d vehicles on Send Form page, but found %d", 3, sendForm.getVehicles().size()));

        Assert.assertTrue(sendForm.vehiclePrivate(0), "First vehicle not private");
        Assert.assertTrue(sendForm.vehicleAircraft(1), "Second vehicle not aircraft");
        Assert.assertTrue(sendForm.typeVehicleContainsText(2, anotherVehicle), String.format("Third vehicle not '%s'", anotherVehicle));

        Assert.assertTrue(sendForm.licenseVehicleContainsText(0, firstCorrectLicense), String.format("First vehicle license not '%s'", firstCorrectLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(1, secondCorrectLicense), String.format("Second vehicle license not '%s'", secondCorrectLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(2, thirdCorrectLicense), String.format("Third vehicle license not '%s'", thirdCorrectLicense));

        Assert.assertTrue(sendForm.usageVehiclePrivate(0), "First vehicle usage not private");
        Assert.assertTrue(sendForm.usageVehicleContainsText(1, anotherUsage), String.format("Second vehicle usage not '%s'", anotherUsage));
        Assert.assertTrue(sendForm.usageVehicleBusiness(2), "Third vehicle usage not business");

        vehicle = basePage.clickMenuVehicle();

        vehicle.deleteVehicle(1);

        sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getVehicles(), 2,
                String.format("Expected %d vehicles on Send Form page, but found %d", 2, sendForm.getVehicles().size()));

        Assert.assertTrue(sendForm.vehiclePrivate(0), "First vehicle not private");
        Assert.assertTrue(sendForm.typeVehicleContainsText(1, anotherVehicle), String.format("Second vehicle not '%s'", anotherVehicle));

        Assert.assertTrue(sendForm.licenseVehicleContainsText(0, firstCorrectLicense), String.format("First vehicle license not '%s'", firstCorrectLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(1, thirdCorrectLicense), String.format("Second vehicle license not '%s'", thirdCorrectLicense));

        Assert.assertTrue(sendForm.usageVehiclePrivate(0), "First vehicle usage not private");
        Assert.assertTrue(sendForm.usageVehicleBusiness(1), "Second vehicle usage not business");

    }
}
