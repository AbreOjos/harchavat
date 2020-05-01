package tests.scenarious.demo;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.chrome.ChromeSendFormVehicleTests;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test
public class ChromeDemoScenarious extends DemoScenarious {

    private static final Logger log = Logger.getLogger(ChromeSendFormVehicleTests.class);

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws URISyntaxException {

        if (MiscellaneousForInfra.osName().equals("windows")) {
            System.setProperty("webdriver.chrome.driver", WebDrivers.getChromeDriverWindows().toString());
        } else if (MiscellaneousForInfra.osName().equals("unix")) {
            System.setProperty("webdriver.chrome.driver", WebDrivers.getChromeDriverUnix().toString());
        }

    }


    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() {

        createChromeDriver();

        super.setUpMethod();

        prepareEmptyFieldsPersonalDetails();
        prepareEmptyVehicleDetails();
    }

    public void testCheckMenuIcons() {
        checkMenuIcons();
    }

    public void testCheckDownloadedFormForSeparates() {
        checkDownloadedFormForSeparates();
    }

    public void testNeedFillVehicleDetailsErrorMessage() {
        needFillVehicleDetailsErrorMessage();
    }

    public void testExpatriatePolygamyExpatriate() throws InterruptedException {
        expatriatePolygamyExpatriate();
    }

    public void testSendFormMultiVehicles() {
        sendFormMultiVehicles();
    }


    // ==

    public void testMultiWages() {
        multiWages();
    }

    public void testCheckUnnecessaryIsraelIncomeFields() {
        checkUnnecessaryIsraelIncomeFields();
    }

    public void testMultiVehicles() {
        multiVehicles();
    }

    public void testIsraeliSpouseAllianceExpatriate() throws InterruptedException {
        israeliSpouseAllianceExpatriate();
    }
}
