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

    protected void editVehicles() {
        log.info("Create vehicle, go to Send Form, click Edit, check that data on Vehicle page not lost");

        String anotherVehicle = "Another vehicle";
        String anotherUsage = "Another usage";
        String firstLicense = "12345678";
        String secondLicense = "12-345-67";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();

        vehicle.addVehicle();

        vehicle.choosePrivateVehicle(0);
        vehicle.chooseAnotherVehicle(1);

        vehicle.deleteAnotherCarTypeDetails(1);
        vehicle.enterAnotherCarTypeDetails(1, anotherVehicle);

        vehicle.choosePrivateUsage(0);
        vehicle.chooseAnotherUsage(1);

        vehicle.deleteAnotherUsageDetails(1);
        vehicle.enterAnotherUsageDetails(1, anotherUsage);

        vehicle.deleteCarLicense(0);
        vehicle.enterCarLicense(0, firstLicense);
        vehicle.deleteCarLicense(1);
        vehicle.enterCarLicense(1, secondLicense);

        // go to Send Form, click Edit, return to Vehicle
        SendForm sendForm = basePage.clickMenuSendForm();
        vehicle = sendForm.clickBtnEditVehicles();

        // check that data wasn't lost
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getListVehicles(), 2,
                String.format("Expected %d vehicles on Vehicle page, but found %d", 2, vehicle.getListVehicles().size()));

        // check first vehicle
        Assert.assertTrue(vehicle.chosenPrivateVehicle(0), "Private vehicle not chosen");
        Assert.assertTrue(vehicle.chosenUsagePrivate(0), "Private usage not chosen");
        AssertionsHarchavat.assertCompareTwoStringsAfterNormalization(vehicle.getCarLicense(0), firstLicense,
                String.format("Expected %s car license, found %s", firstLicense, vehicle.getCarLicense(0)));

        // check second vehicle
        Assert.assertTrue(vehicle.chosenAnotherVehicle(1), "Another vehicle not chosen");
        AssertionsHarchavat.assertCompareTwoStringsAfterNormalization(vehicle.getAnotherCarTypeDetails(1), anotherVehicle,
                String.format("Expected %s car type, found %s", anotherVehicle, vehicle.getAnotherCarTypeDetails(1)));
        Assert.assertTrue(vehicle.chosenUsageAnother(1), "Another usage not chosen");
        AssertionsHarchavat.assertCompareTwoStringsAfterNormalization(vehicle.getAnotherUsageDetails(1), anotherUsage,
                String.format("Expected %s car type, found %s", anotherUsage, vehicle.getAnotherUsageDetails(1)));
        AssertionsHarchavat.assertCompareTwoStringsAfterNormalization(vehicle.getCarLicense(1), secondLicense,
                String.format("Expected %s car license, found %s", secondLicense, vehicle.getCarLicense(1)));

    }

    protected void multiVehicles() {
        log.info("Add and delete a few vehicles, check that data does not loss");

        String anotherVehicle = "Another vehicle";
        String anotherUsage = "Another usage";
        String firstLicense = "12345678";
        String secondLicense = "12-345-67";
        String thirdLicense = "123-45-678";

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
        vehicle.enterCarLicense(0, firstLicense);
        vehicle.deleteCarLicense(1);
        vehicle.enterCarLicense(1, secondLicense);
        vehicle.deleteCarLicense(2);
        vehicle.enterCarLicense(2, thirdLicense);

        SendForm sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getVehicle(), 3,
                String.format("Expected %d vehicles on Send Form page, but found %d", 3, sendForm.getVehicle().size()));

        Assert.assertTrue(sendForm.vehiclePrivate(0), "First vehicle not private");
        Assert.assertTrue(sendForm.vehicleAircraft(1), "Second vehicle not aircraft");
        Assert.assertTrue(sendForm.typeVehicleContainsText(2, anotherVehicle), String.format("Third vehicle not '%s'", anotherVehicle));

        Assert.assertTrue(sendForm.licenseVehicleContainsText(0, firstLicense), String.format("First vehicle license not '%s'", firstLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(1, secondLicense), String.format("Second vehicle license not '%s'", secondLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(2, thirdLicense), String.format("Third vehicle license not '%s'", thirdLicense));

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

        Assert.assertTrue(sendForm.licenseVehicleContainsText(0, firstLicense), String.format("First vehicle license not '%s'", firstLicense));
        Assert.assertTrue(sendForm.licenseVehicleContainsText(1, thirdLicense), String.format("Second vehicle license not '%s'", thirdLicense));

        Assert.assertTrue(sendForm.usageVehiclePrivate(0), "First vehicle usage not private");
        Assert.assertTrue(sendForm.usageVehicleBusiness(1), "Second vehicle usage not business");

    }

}
