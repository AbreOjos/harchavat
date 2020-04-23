package tests.iexplorer;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.VehicleTests;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.IEXPLORER})
public class IExplorerVehicleTests extends VehicleTests {
    private static final Logger log = Logger.getLogger(IExplorerVehicleTests.class);

    @BeforeClass(groups = {RunMode.IEXPLORER}, alwaysRun = true)
    public void setUpClass() throws URISyntaxException {

        if (MiscellaneousForInfra.osName().equals("windows")) {
            System.setProperty("webdriver.ie.driver", WebDrivers.getIEDriverWindows().toString());
        } else {
            throw new RuntimeException(String.format("OS '%s' incompatible with a IE Web Driver",
                    MiscellaneousForInfra.osName()));
        }
    }


    @BeforeMethod(groups = {RunMode.IEXPLORER}, alwaysRun = true)
    public void setUpMethod() {

        createInternetExplorerDriver();

        super.setUpMethod();

        prepareEmptyVehicleDetails();
    }

    public void testCheckMenuIcons() {
        checkMenuIcons();
    }

    public void testNeedFillLicenseErrorMessage() {
        needFillLicenseErrorMessage();
    }

    public void testIncorrectLicenseErrorMessage() {
        incorrectLicenseErrorMessage();
    }

    public void testNeedFillVehicleDetailsErrorMessage() {
        needFillVehicleDetailsErrorMessage();
    }

    public void testNeedFillUsageDetailsErrorMessage() {
        needFillUsageDetailsErrorMessage();
    }

    public void testCorrectLicenseFormats() {
        correctLicenseFormats();
    }

}
