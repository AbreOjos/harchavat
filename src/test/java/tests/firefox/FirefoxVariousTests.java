package tests.firefox;

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

@Test(groups = {RunMode.FIREFOX})
public class FirefoxVariousTests extends VariousTests {
    private static final Logger log = Logger.getLogger(FirefoxVariousTests.class);

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

        prepareEmptyVariousDetails();
    }

    public void testCheckMenuIcons() {
        checkMenuIcons();
    }

    // non work incomes tests
    public void testNeedFillTypeIncomeErrorMessageNonWorkIncomes() {
        needFillTypeIncomeErrorMessageNonWorkIncomes();
    }

    public void testNeedFillIncomeSourceErrorMessageNonWorkIncomes() {
        needFillIncomeSourceErrorMessageNonWorkIncomes();
    }

    public void testNeedFillAnnualIncomeErrorMessageNonWorkIncomes() {
        needFillAnnualIncomeErrorMessageNonWorkIncomes();
    }

    public void testNeedFillPayerNameErrorMessageNonWorkIncomes() {
        needFillPayerNameErrorMessageNonWorkIncomes();
    }

    public void testNeedFillTikNikiumErrorMessageNonWorkIncomes() {
        needFillTikNikiumErrorMessageNonWorkIncomes();
    }

    public void testNeedFillCityErrorMessageNonWorkIncomes() {
        needFillCityErrorMessageNonWorkIncomes();
    }

    public void testNeedFillStreetErrorMessageNonWorkIncomes() {
        needFillStreetErrorMessageNonWorkIncomes();
    }

    public void testNeedFillHouseNumErrorMessageNonWorkIncomes() {
        needFillHouseNumErrorMessageNonWorkIncomes();
    }

    public void testNeedFillCountryErrorMessageNonWorkIncomes() {
        needFillCountryErrorMessageNonWorkIncomes();
    }

    public void testAnnualIncomeTwentyCharsMaxErrorMessageNonWorkIncomes() {
        annualIncomeTwentyCharsMaxErrorMessageNonWorkIncomes();
    }

    public void testCityFifteenCharsMaxErrorMessageNonWorkIncomes() {
        cityFifteenCharsMaxErrorMessageNonWorkIncomes();
    }

    public void testStreetFifteenCharsMaxErrorMessageNonWorkIncomes() {
        streetFifteenCharsMaxErrorMessageNonWorkIncomes();
    }

    public void testTikNikuimContainsDigitsOnlyErrorMessageNonWorkIncomes() {
        tikNikuimContainsDigitsOnlyErrorMessageNonWorkIncomes();
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersIncomeSourceNonWorkIncomes(String forbiddenChars) {
        forbiddenCharactersIncomeSourceNonWorkIncomes(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersPayerNameNonWorkIncomes(String forbiddenChars) {
        forbiddenCharactersPayerNameNonWorkIncomes(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersHouseNumNonWorkIncomes(String forbiddenChars) {
        forbiddenCharactersHouseNumNonWorkIncomes(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersStateNonWorkIncomes(String forbiddenChars) {
        forbiddenCharactersStateNonWorkIncomes(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersCityNonWorkIncomes(String forbiddenChars) {
        forbiddenCharactersCityNonWorkIncomes(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersStreetNonWorkIncomes(String forbiddenChars) {
        forbiddenCharactersStreetNonWorkIncomes(forbiddenChars);
    }


    // Abroad Bank Account tests
    public void testNeedFillCountryErrorMessageAbroadBankAccount() {
        needFillCountryErrorMessageAbroadBankAccount();
    }

    public void testNeedFillCityErrorMessageAbroadBankAccount() {
        needFillCityErrorMessageAbroadBankAccount();
    }

    public void testNeedFillBankNameErrorMessageAbroadBankAccount() {
        needFillBankNameErrorMessageAbroadBankAccount();
    }

}
