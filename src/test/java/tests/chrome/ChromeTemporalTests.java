package tests.chrome;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.TemporalTests;

import java.net.URISyntaxException;

@Test(groups = {RunMode.CHROME})
public class ChromeTemporalTests extends TemporalTests {
    private static final Logger log = Logger.getLogger(ChromeTemporalTests.class);

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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testClickHeaderLinks() {
        clickHeaderLinks();
    }

    public void testClickSideMenu() {
        clickSideMenu();
    }

    public void testFillPersonalDetails() throws InterruptedException {
        fillPersonalDetails();
    }
}
