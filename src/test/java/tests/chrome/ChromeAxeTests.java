package tests.chrome;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.AxeTests;

import java.net.URISyntaxException;

@Test(groups = {RunMode.CHROME_AXE})
public class ChromeAxeTests extends AxeTests {

    @BeforeClass(groups = {RunMode.CHROME_AXE}, alwaysRun = true)
    public void setUpClass() throws URISyntaxException {

        if (osName().equals("windows")) {
            System.setProperty("webdriver.chrome.driver", WebDrivers.getChromeDriverWindows().toString());
        } else if (osName().equals("unix")) {
            System.setProperty("webdriver.chrome.driver", WebDrivers.getChromeDriverUnix().toString());
        }

    }


    @BeforeMethod(groups = {RunMode.CHROME_AXE}, alwaysRun = true)
    public void setUpMethod() {

        createChromeDriver();

        super.setUpMethod();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testPersonalDetailsPage() {
        personalDetailsPage();
    }

    public void testVehiclesDetailsPage() {
        vehiclesDetailsPage();
    }

    public void testWageDetailsPage() {
        wageDetailsPage();
    }

    public void testRealEstateDetailsPage() {
        realEstateDetailsPage();
    }

    public void testVariousDetailsPage() {
        variousDetailsPage();
    }

    public void testSendFormDetailsPage() {
        sendFormDetailsPage();
    }
}
