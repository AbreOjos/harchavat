package tests.iexplorer;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.VariousTests;
import utils.dataprovider.NEDataProvider;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.IEXPLORER})
public class IExplorerVariousTests extends VariousTests {
    private static final Logger log = Logger.getLogger(IExplorerVariousTests.class);

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

    public void testCityFifteenCharsMaxErrorMessage() {
        cityFifteenCharsMaxErrorMessage();
    }

    public void testStreetFifteenCharsMaxErrorMessage() {
        streetFifteenCharsMaxErrorMessage();
    }

    public void testTikNikuimContainsDigitsOnlyErrorMessage() {
        tikNikuimContainsDigitsOnlyErrorMessage();
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersIncomeSource(String forbiddenChars) {
        forbiddenCharactersIncomeSource(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersPayerName(String forbiddenChars) {
        forbiddenCharactersPayerName(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersHouseNum(String forbiddenChars) {
        forbiddenCharactersHouseNum(forbiddenChars);
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
