package tests.firefox;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.SendFormRealEstateTests;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.FIREFOX})
public class FirefoxSendFormRealEstateTests extends SendFormRealEstateTests {
    private static final Logger log = Logger.getLogger(FirefoxSendFormRealEstateTests.class);

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

        prepareEmptyRealEstateDetails();
    }

    public void testMultiRealEstateWithoutTenants() throws Exception {
        multiRealEstateWithoutTenants();
    }

    public void testRealEstateWithMultiTenants() throws Exception {
        realEstateWithMultiTenants();
    }

}
