package tests.scenarious;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pom.forms.vehicles.Vehicle;
import pom.forms.sendform.SendForm;
import tests.TestBase;

import static constants.EnglishHebrewConstants.NOT_YET_REPORTED;

public class SendFormVehicleTests extends TestBase {
    private static final Logger log = Logger.getLogger(SendFormVehicleTests.class);

    protected void checkEmptyVehicleFields() {
        log.info("Check that NOT_YET_REPORTED written when data about vehicle missed");

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();

        vehicle.chooseAnotherVehicle(0);
        vehicle.chooseAnotherUsage(0);

        SendForm sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.typeVehicleExists(0), "Empty field Type Vehicle missed on Send Form page");
        Assert.assertTrue(sendForm.licenseVehicleExists(0), "Empty field License Vehicle missed on Send Form page");
        Assert.assertTrue(sendForm.usageVehicleExists(0), "Empty field Usage Vehicle missed on Send Form page");

        Assert.assertTrue(sendForm.typeVehicleContainsText(0, NOT_YET_REPORTED),
                String.format("'%s' missed in Vehicle Type field", NOT_YET_REPORTED));

        Assert.assertTrue(sendForm.licenseVehicleContainsText(0, NOT_YET_REPORTED),
                String.format("'%s' missed in Vehicle License field", NOT_YET_REPORTED));

        Assert.assertTrue(sendForm.usageVehicleContainsText(0, NOT_YET_REPORTED),
                String.format("'%s' missed in Vehicle Usage field", NOT_YET_REPORTED));
    }

    protected void multiVehicles() {
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

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getVehicle(), 3,
                String.format("Expected %d vehicles on Send Form page, but found %d", 3, sendForm.getVehicle().size()));

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

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getVehicle(), 2,
                String.format("Expected %d vehicles on Send Form page, but found %d", 2, sendForm.getVehicle().size()));

        Assert.assertTrue(sendForm.vehiclePrivate(0), "First vehicle not private");
        Assert.assertTrue(sendForm.typeVehicleContainsText(1, anotherVehicle), String.format("Second vehicle not '%s'", anotherVehicle));

        Assert.assertTrue(sendForm.licenseVehicleContainsText(0, firstCorrectLicense), String.format("First vehicle license not '%s'", firstCorrectLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(1, thirdCorrectLicense), String.format("Second vehicle license not '%s'", thirdCorrectLicense));

        Assert.assertTrue(sendForm.usageVehiclePrivate(0), "First vehicle usage not private");
        Assert.assertTrue(sendForm.usageVehicleBusiness(1), "Second vehicle usage not business");

    }

}
