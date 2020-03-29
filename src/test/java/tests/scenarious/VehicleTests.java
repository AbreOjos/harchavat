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

}
