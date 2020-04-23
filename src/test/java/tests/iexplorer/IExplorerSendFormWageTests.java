package tests.iexplorer;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.SendFormWageTests;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.IEXPLORER})
public class IExplorerSendFormWageTests extends SendFormWageTests {
    private static final Logger log = Logger.getLogger(IExplorerSendFormWageTests.class);

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

        prepareEmptyWageDetails();
    }

    public void testCheckEmptyIsraelIncomeFields() {
        checkEmptyIsraelIncomeFields();
    }

    public void testCheckEmptyAbroadIncomeFields() {
        checkEmptyAbroadIncomeFields();
    }

    public void testCheckUnnecessaryIsraelIncomeFields() {
        checkUnnecessaryIsraelIncomeFields();
    }

    public void testCheckUnnecessaryAbroadIncomeFields() {
        checkUnnecessaryAbroadIncomeFields();
    }

    public void testMultiWages() {
        multiWages();
    }

}
