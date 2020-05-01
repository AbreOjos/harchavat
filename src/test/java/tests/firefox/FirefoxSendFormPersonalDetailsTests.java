package tests.firefox;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.SendFormPersonalDetailsTests;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.FIREFOX})
public class FirefoxSendFormPersonalDetailsTests extends SendFormPersonalDetailsTests {
    private static final Logger log = Logger.getLogger(FirefoxSendFormPersonalDetailsTests.class);

    @BeforeClass(groups = {RunMode.FIREFOX}, alwaysRun = true)
    public void setUpClass() throws URISyntaxException {

        if (MiscellaneousForInfra.osName().equals("windows")) {
            System.setProperty("webdriver.gecko.driver", WebDrivers.getFirefoxDriverWindows().toString());
        } else if (MiscellaneousForInfra.osName().equals("unix")) {
            System.setProperty("webdriver.gecko.driver", WebDrivers.getFirefoxDriverUnix().toString());
        }
    }


    @BeforeMethod(groups = {RunMode.FIREFOX}, alwaysRun = true)
    public void setUpMethod() {

        createFirefoxDriver();

        super.setUpMethod();

        prepareEmptyFieldsPersonalDetails();
    }

    public void testPersonalDetailsNotFilledFields() {
        personalDetailsNotFilledFields();
    }

    public void testIsraeliBachelor() throws InterruptedException {
        israeliBachelor();
    }

    public void testExpatriateMarriedIsraeli() throws InterruptedException {
        expatriateMarriedIsraeli();
    }

    public void testIsraeliSpouseAllianceExpatriate() throws InterruptedException {
        israeliSpouseAllianceExpatriate();
    }

    public void testExpatriatePolygamyExpatriate() throws InterruptedException {
        expatriatePolygamyExpatriate();
    }

}
