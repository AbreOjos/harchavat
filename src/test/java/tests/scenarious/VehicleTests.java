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

        String firstLicense = "12345678";
        String thirdLicense = "87654321";
        String error = "License Number";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();
        addTwoVehicles(vehicle);

        vehicle.choosePrivateVehicle(0);
        vehicle.chooseHeavyVehicle(1);
        vehicle.chooseAnotherVehicle(2);

        needFillErrorMessage(
                vehicle::getNeedFillLicenseErrorMessage,
                basePage::clickMenuVehicle,
                vehicle::enterCarLicense,
                vehicle::deleteVehicle,
                firstLicense, thirdLicense, error);
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

        String firstAnotherVehicle = "First Another Vehicle";
        String thirdAnotherVehicle = "Third Another Vehicle";
        String error = "Vehicle Details";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();
        addTwoVehicles(vehicle);

        vehicle.chooseAnotherVehicle(0);
        vehicle.chooseAnotherVehicle(1);
        vehicle.chooseAnotherVehicle(2);

        needFillErrorMessage(
                vehicle::getNeedFillVehicleDetailsErrorMessage,
                basePage::clickMenuVehicle,
                vehicle::enterAnotherCarTypeDetails,
                vehicle::deleteVehicle,
                firstAnotherVehicle, thirdAnotherVehicle, error);
    }

    protected void needFillUsageDetailsErrorMessage() {

        String firstAnotherUsage = "First Another Usage";
        String thirdAnotherUsage = "Third Another Usage";
        String error = "Usage Details";

        Vehicle vehicle = basePage.clickMenuVehicle();
        vehicle.chooseHaveVehicle();
        addTwoVehicles(vehicle);

        vehicle.chooseAircraftVehicle(0);
        vehicle.chooseAnotherVehicle(1);
        vehicle.chooseCommercialVehicle(2);

        vehicle.chooseAnotherUsage(0);
        vehicle.chooseAnotherUsage(1);
        vehicle.chooseAnotherUsage(2);

        needFillErrorMessage(
                vehicle::getNeedFillUsageDetailsErrorMessage,
                basePage::clickMenuVehicle,
                vehicle::enterAnotherUsageDetails,
                vehicle::deleteVehicle,
                firstAnotherUsage, thirdAnotherUsage, error);
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

    // == private methods ==
    private void addTwoVehicles(Vehicle vehicle) {
        vehicle.addVehicle();
        vehicle.addVehicle();
    }

}
