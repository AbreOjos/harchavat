package tests.iexplorer;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.SendFormPersonalDetailsTests;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.IEXPLORER})
public class IExplorerSendFormPersonalDetailsTests extends SendFormPersonalDetailsTests {
    private static final Logger log = Logger.getLogger(IExplorerSendFormPersonalDetailsTests.class);

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

        prepareEmptyPhoneAndEmailFieldsPersonalDetails();
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
