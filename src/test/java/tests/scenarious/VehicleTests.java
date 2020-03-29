package tests.scenarious;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import pom.forms.vehicles.Vehicle;
import tests.TestBase;

public class VehicleTests extends TestBase {
    private static final Logger log = Logger.getLogger(VehicleTests.class);

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

    protected void needFillLicenseErrorMessage() {
        log.info("Add a few vehicles, play with 'need to fill license' error messages");

        String correctLicense = "12345678";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();
        vehicle.addVehicle();
        vehicle.addVehicle();

        vehicle.choosePrivateVehicle(0);
        vehicle.chooseHeavyVehicle(1);
        vehicle.chooseAnotherVehicle(2);

        basePage.clickMenuPersonalDetails();
        vehicle = basePage.clickMenuVehicle();

        // check error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillLicenseErrorMessage(0), 1,
                "Error message 'Need to Fill License Number' did not appear on a first panel");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillLicenseErrorMessage(1), 1,
                "Error message 'Need to Fill License Number' did not appear on a second panel");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillLicenseErrorMessage(2), 1,
                "Error message 'Need to Fill License Number' did not appear on a third panel");

        vehicle.enterCarLicense(1, correctLicense);

        // recheck error messages
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillLicenseErrorMessage(0), 1,
                "Error message 'Need to Fill License Number' disappear from a first panel instead of a second panel");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillLicenseErrorMessage(1), 0,
                "Error message 'Need to Fill License Number' did not disappear from a second panel");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillLicenseErrorMessage(2), 1,
                "Error message 'Need to Fill License Number' disappear from a third panel instead of a second panel");

        vehicle.deleteVehicle(1);

        // recheck remains messages
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillLicenseErrorMessage(0), 1,
                "Error message 'Need to Fill License Number' disappear from a first panel after removing one of the vehicles");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillLicenseErrorMessage(1), 1,
                "Error message 'Need to Fill License Number' disappear from a second panel after removing one of the vehicles");

        vehicle.enterCarLicense(0, correctLicense);
        vehicle.enterCarLicense(1, correctLicense);

        // recheck remains messages
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillLicenseErrorMessage(0), 0,
                "Error message 'Need to Fill License Number' did not disappear from a first panel");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillLicenseErrorMessage(1), 1,
                "Error message 'Need to Fill License Number' did not disappear from a second panel");
    }

    protected void incorrectLicenseErrorMessage() {
        log.info("Add a few vehicles, play with 'incorrect license' error messages");

        String correctLicense = "12345678";
        String incorrectLicense = "abcdef";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();
        vehicle.addVehicle();
        vehicle.addVehicle();

        vehicle.chooseAircraftVehicle(0);
        vehicle.chooseVesselVehicle(1);
        vehicle.chooseCommercialVehicle(2);

        vehicle.enterCarLicense(0, incorrectLicense);
        vehicle.enterCarLicense(1, incorrectLicense);
        vehicle.enterCarLicense(2, incorrectLicense);

        // check error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(0), 1,
                "Error message 'Incorrect License Number' did not appear on a first panel");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(1), 1,
                "Error message 'Incorrect License Number' did not appear on a second panel");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(2), 1,
                "Error message 'Incorrect License Number' did not appear on a third panel");

        vehicle.deleteCarLicense(1);
        vehicle.enterCarLicense(1, correctLicense);

        // recheck error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(0), 1,
                "Error message 'Incorrect License Number' disappear on a first panel after correct license entered on second panel");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(1), 0,
                "Error message 'Incorrect License Number' did not disappear on a second panel after correct license entered");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(2), 1,
                "Error message 'Incorrect License Number' disappear on a third panel after correct license entered on second panel");

        vehicle.deleteVehicle(1);

        // recheck error messages on remain panels
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(0), 1,
                "Error message 'Incorrect License Number' disappear on a first panel after a former second panel was deleted");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(1), 1,
                "Error message 'Incorrect License Number' disappear on a second panel after after a former second panel was deleted");

        vehicle.deleteCarLicense(0);
        vehicle.enterCarLicense(0, correctLicense);
        vehicle.deleteCarLicense(1);
        vehicle.enterCarLicense(1, correctLicense);

        // recheck error messages on remain panels
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(0), 0,
                "Error message 'Incorrect License Number' did not disappear on a first panel after correct license entered");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(1), 0,
                "Error message 'Incorrect License Number' did not disappear on a second panel after correct license entered");
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

    protected void needFillUsageDetailsErrorMessage() {
        log.info("Add a few vehicles, play with 'need to fill usage details' error messages");

        String usageDetails = "abcde";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();
        vehicle.addVehicle();
        vehicle.addVehicle();

        vehicle.chooseAircraftVehicle(0);
        vehicle.chooseAnotherVehicle(1);
        vehicle.chooseCommercialVehicle(2);

        vehicle.chooseCommercialUsage(0);
        vehicle.choosePrivateUsage(1);
        vehicle.chooseAnotherUsage(2);

        basePage.clickMenuPersonalDetails();
        vehicle = basePage.clickMenuVehicle();

        // check error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillUsageDetailsErrorMessage(0), 0,
                "Error message 'Need to Fill Usage Details' appear on a first panel - not Another usage");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillUsageDetailsErrorMessage(1), 0,
                "Error message 'Need to Fill Usage Details' appear on a second panel - not Another usage");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillUsageDetailsErrorMessage(2), 1,
                "Error message 'Need to Fill Usage Details' did not appear on a third panel - Another usage");

        vehicle.deleteVehicle(1);

        // recheck error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillUsageDetailsErrorMessage(0), 0,
                "Error message 'Need to Fill Usage Details' appear on a first panel - not Another usage");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillUsageDetailsErrorMessage(1), 1,
                "Error message 'Need to Fill Usage Details' disappear from a second panel - Another usage");

        vehicle.deleteAnotherUsageDetails(1);
        vehicle.enterAnotherUsageDetails(1, usageDetails);

        // recheck error messages on every panel
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillUsageDetailsErrorMessage(0), 0,
                "Error message 'Need to Fill Usage Details' appear on a first panel - not Another usage");
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getNeedFillUsageDetailsErrorMessage(1), 0,
                "Error message 'Need to Fill Usage Details' did not disappear from a second panel after usage details filling");
    }

    protected void correctLicenseFormats() {
        log.info("Checking different correct license formats");

        String firstCorrectLicense = "12345678";
        String secondCorrectLicense = "12-345-67";
        String thirdCorrectLicense = "123-45-678";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();
        vehicle.addVehicle();
        vehicle.addVehicle();

        vehicle.chooseAircraftVehicle(0);
        vehicle.chooseAnotherVehicle(1);
        vehicle.chooseAnotherVehicle(2);

        vehicle.enterCarLicense(0, firstCorrectLicense);
        vehicle.enterCarLicense(1, secondCorrectLicense);
        vehicle.enterCarLicense(2, thirdCorrectLicense);

        basePage.clickMenuPersonalDetails();
        vehicle = basePage.clickMenuVehicle();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(0), 0,
                String.format("Error message 'Incorrect License Number' appear after correct license '%s' entered", firstCorrectLicense));
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(1), 0,
                String.format("Error message 'Incorrect License Number' appear after correct license '%s' entered", secondCorrectLicense));
        AssertionsHarchavat.assertListContainsExactNumberOfElements(vehicle.getLicenseIncorrectErrorMessage(2), 0,
                String.format("Error message 'Incorrect License Number' appear after correct license '%s' entered", thirdCorrectLicense));
    }

}
