package tests.iexplorer;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.SendFormRealEstateTests;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.IEXPLORER})
public class IExplorerSendFormRealEstateTests extends SendFormRealEstateTests {
    private static final Logger log = Logger.getLogger(IExplorerSendFormRealEstateTests.class);

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

        prepareEmptyRealEstateDetails();
    }

    public void testMultiRealEstateWithoutTenants() throws Exception {
        multiRealEstateWithoutTenants();
    }

    public void testRealEstateWithMultiTenants() throws Exception {
        realEstateWithMultiTenants();
    }

}
