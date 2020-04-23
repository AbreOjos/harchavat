package tests.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.RunMode;
import tests.scenarious.VehicleTests;

@Test(groups = {RunMode.EDGE})
public class EdgeVehicleTests extends VehicleTests {
    private static final Logger log = Logger.getLogger(EdgeVehicleTests.class);

    @BeforeClass(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpClass() {

        WebDriverManager.edgedriver().setup();

    }


    @BeforeMethod(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpMethod() {

        createEdgeDriver();

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
