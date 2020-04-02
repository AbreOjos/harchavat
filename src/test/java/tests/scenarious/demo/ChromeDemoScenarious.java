package tests.scenarious.demo;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.chrome.ChromeSendFormVehicleTests;

import java.net.URISyntaxException;

@Test(groups = {RunMode.CHROME})
public class ChromeDemoScenarious extends DemoScenarious {

    private static final Logger log = Logger.getLogger(ChromeSendFormVehicleTests.class);

    @BeforeClass(groups = {RunMode.CHROME}, alwaysRun = true)
    public void setUpClass() throws URISyntaxException {

        if (osName().equals("windows")) {
            System.setProperty("webdriver.chrome.driver", WebDrivers.getChromeDriverWindows().toString());
        } else if (osName().equals("unix")) {
            System.setProperty("webdriver.chrome.driver", WebDrivers.getChromeDriverUnix().toString());
        }

    }


    @BeforeMethod(groups = {RunMode.CHROME}, alwaysRun = true)
    public void setUpMethod() {

        createChromeDriver();

        super.setUpMethod();

        prepareEmptyPhoneAndEmailFieldsPersonalDetails();
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
}
