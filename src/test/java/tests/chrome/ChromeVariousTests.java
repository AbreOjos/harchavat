package tests.chrome;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.VariousTests;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.CHROME})
public class ChromeVariousTests extends VariousTests {
    private static final Logger log = Logger.getLogger(ChromeVariousTests.class);

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

        prepareEmptyVariousDetails();
    }

    public void testCheckMenuIcons() {
        checkMenuIcons();
    }

    // non work incomes tests
    public void testNeedFillTypeIncomeErrorMessage() {
        needFillTypeIncomeErrorMessage();
    }

    public void testNeedFillIncomeSourceErrorMessage() {
        needFillIncomeSourceErrorMessage();
    }

    public void testNeedFillAnnualIncomeErrorMessage() {
        needFillAnnualIncomeErrorMessage();
    }

    public void testNeedFillPayerNameErrorMessage() {
        needFillPayerNameErrorMessage();
    }

    public void testNeedFillTikNikiumErrorMessage() {
        needFillTikNikiumErrorMessage();
    }

    public void testNeedFillCityErrorMessage() {
        needFillCityErrorMessage();
    }

    public void testNeedFillStreetErrorMessage() {
        needFillStreetErrorMessage();
    }

    public void testNeedFillHouseNumErrorMessage() {
        needFillHouseNumErrorMessage();
    }

    public void testNeedFillCountryErrorMessage() {
        needFillCountryErrorMessage();
    }

    public void testAnnualIncomeTwentyCharsMaxErrorMessage() {
        annualIncomeTwentyCharsMaxErrorMessage();
    }

//    public void testCityFifteenCharsMaxErrorMessage() {
//        cityFifteenCharsMaxErrorMessage();
//    }

}
