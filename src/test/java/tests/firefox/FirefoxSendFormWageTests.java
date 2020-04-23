package tests.firefox;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.SendFormWageTests;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.FIREFOX})
public class FirefoxSendFormWageTests extends SendFormWageTests {
    private static final Logger log = Logger.getLogger(FirefoxSendFormWageTests.class);

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
