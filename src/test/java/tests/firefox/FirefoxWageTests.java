package tests.firefox;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.WageTests;
import utils.dataprovider.NEDataProvider;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.FIREFOX})
public class FirefoxWageTests extends WageTests {
    private static final Logger log = Logger.getLogger(FirefoxWageTests.class);

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

    public void testCheckMenuIcons() {
        checkMenuIcons();
    }

    public void testNeedFillTypeIncomeErrorMessage() {
        needFillTypeIncomeErrorMessage();
    }

    public void testNeedFillAnnualIncomeErrorMessage() {
        needFillAnnualIncomeErrorMessage();
    }

    public void testNeedFillEmployerNameErrorMessage() {
        needFillEmployerNameErrorMessage();
    }

    public void testNeedFillCityErrorMessage() {
        needFillCityErrorMessage();
    }

    public void testNeedFillStreetErrorMessage() {
        needFillStreetErrorMessage();
    }

    public void testNeedFillHouseNumberErrorMessage() {
        needFillHouseNumberErrorMessage();
    }

    public void testNeedFillTikNikuimErrorMessage() {
        needFillTikNikuimErrorMessage();
    }

    public void testNeedFillCountryErrorMessage() {
        needFillCountryErrorMessage();
    }

    public void testTikNikuimCorrectFormat() {
        tikNikuimCorrectFormat();
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersEmployerName(String forbiddenChars) {
        forbiddenCharactersEmployerName(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersHouseNumber(String forbiddenChars) {
        forbiddenCharactersHouseNumber(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersState(String forbiddenChars) {
        forbiddenCharactersState(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersCity(String forbiddenChars) {
        forbiddenCharactersCity(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersStreet(String forbiddenChars) {
        forbiddenCharactersStreet(forbiddenChars);
    }

}
