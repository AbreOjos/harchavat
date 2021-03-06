package tests.chrome;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.SendFormPersonalDetailsTests;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.CHROME})
public class ChromeSendFormPersonalDetailsTests extends SendFormPersonalDetailsTests {
    private static final Logger log = Logger.getLogger(ChromeSendFormPersonalDetailsTests.class);

    @BeforeClass(groups = {RunMode.CHROME}, alwaysRun = true)
    public void setUpClass() throws URISyntaxException {

        if (MiscellaneousForInfra.osName().equals("windows")) {
            System.setProperty("webdriver.chrome.driver", WebDrivers.getChromeDriverWindows().toString());
        } else if (MiscellaneousForInfra.osName().equals("unix")) {
            System.setProperty("webdriver.chrome.driver", WebDrivers.getChromeDriverUnix().toString());
        }

    }


    @BeforeMethod(groups = {RunMode.CHROME}, alwaysRun = true)
    public void setUpMethod() {

        createChromeDriver();

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
