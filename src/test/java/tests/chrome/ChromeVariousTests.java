package tests.chrome;

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

    public void testNeedFillBankNumErrorMessageAbroadBankAccount() {
        needFillBankNumErrorMessageAbroadBankAccount();
    }

    public void testNeedFillBranchNameErrorMessageAbroadBankAccount() {
        needFillBranchNameErrorMessageAbroadBankAccount();
    }

    public void testNeedFillBranchNumErrorMessageAbroadBankAccount() {
        needFillBranchNumErrorMessageAbroadBankAccount();
    }

    public void testNeedFillAccountNumErrorMessageAbroadBankAccount() {
        needFillAccountNumErrorMessageAbroadBankAccount();
    }

    public void testNeedFillNumOfPartnersErrorMessageAbroadBankAccount() {
        needFillNumOfPartnersErrorMessageAbroadBankAccount();
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersStateAbroadBankAccounts(String forbiddenChars) {
        forbiddenCharactersStateAbroadBankAccounts(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersCityAbroadBankAccounts(String forbiddenChars) {
        forbiddenCharactersCityAbroadBankAccounts(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersBankNameAbroadBankAccounts(String forbiddenChars) {
        forbiddenCharactersBankNameAbroadBankAccounts(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersBankNumAbroadBankAccounts(String forbiddenChars) {
        forbiddenCharactersBankNumAbroadBankAccounts(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersBranchNameAbroadBankAccounts(String forbiddenChars) {
        forbiddenCharactersBranchNameAbroadBankAccounts(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersBranchNumAbroadBankAccounts(String forbiddenChars) {
        forbiddenCharactersBranchNumAbroadBankAccounts(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersAccountNumAbroadBankAccounts(String forbiddenChars) {
        forbiddenCharactersAccountNumAbroadBankAccounts(forbiddenChars);
    }

    public void testPartnersNumContainsDigitsOnlyErrorMessageAbroadBankAccounts() {
        partnersNumContainsDigitsOnlyErrorMessageAbroadBankAccounts();
    }

    public void testBankNumTenCharsMaxErrorMessageNonWorkIncomes() {
        bankNumTenCharsMaxErrorMessageNonWorkIncomes();
    }


    // Digital Coin test
    public void testNeedFillCoinTypeErrorMessageDigitalCoins() {
        needFillCoinTypeErrorMessageDigitalCoins();
    }

    public void testNeedFillAnotherCoinErrorMessageDigitalCoins() {
        needFillAnotherCoinErrorMessageDigitalCoins();
    }

    public void testNeedFillAmountOfCoinsErrorMessageDigitalCoins() {
        needFillAmountOfCoinsErrorMessageDigitalCoins();
    }

    public void testNeedFillPublicKeyErrorMessageDigitalCoins() {
        needFillPublicKeyErrorMessageDigitalCoins();
    }

    public void testNeedFillDidYouSellCoinsErrorMessageDigitalCoins() {
        needFillDidYouSellCoinsErrorMessageDigitalCoins();
    }

    public void testNeedFillAmountCoinsSoldErrorMessageDigitalCoins() {
        needFillAmountCoinsSoldErrorMessageDigitalCoins();
    }

    public void testNeedFillTotalSalesErrorMessageDigitalCoins() {
        needFillTotalSalesErrorMessageDigitalCoins();
    }

    public void testNeedFillDidYouBuyWithCoinsErrorMessageDigitalCoins() {
        needFillDidYouBuyWithCoinsErrorMessageDigitalCoins();
    }

    public void testNeedFillHowManyCoinsUsedErrorMessageDigitalCoins() {
        needFillHowManyCoinsUsedErrorMessageDigitalCoins();
    }

    public void testNeedFillTotalUsedValueErrorMessageDigitalCoins() {
        needFillTotalUsedValueErrorMessageDigitalCoins();
    }

    public void testNumberOfCoinsFieldFormat() {
        numberOfCoinsFieldFormat();
    }

    public void testPublicKeyFormat() {
        publicKeyFormat();
    }

    public void testCoinsSellFormat() {
        coinsSellFormat();
    }

    public void testTotalSellFormat() {
        totalSellFormat();
    }

    public void testHowManyCoinsUsedFieldFormat() {
        howManyCoinsUsedFieldFormat();
    }

    public void testTotalUsedFormat() {
        totalUsedFormat();
    }


    // Stocks tests
    public void testNeedFillCompanyNameErrorMessageStocks() {
        needFillCompanyNameErrorMessageStocks();
    }

    public void testNeedFillCompanySourceErrorMessageStocks() {
        needFillCompanySourceErrorMessageStocks();
    }

    public void testNeedFillCompanyNumErrorMessageStocks() {
        needFillCompanyNumErrorMessageStocks();
    }

    public void testNeedFillCompanyPercentageErrorMessageStocks() {
        needFillCompanyPercentageErrorMessageStocks();
    }

    public void testNeedFillCountryErrorMessageStocks() {
        needFillCountryErrorMessageStocks();
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersCompanyNameStocks(String forbiddenChars) {
        forbiddenCharactersCompanyNameStocks(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersCompanyNumStocks(String forbiddenChars) {
        forbiddenCharactersCompanyNumStocks(forbiddenChars);
    }

    public void testPercentageFieldFormat() {
        percentageFieldFormat();
    }

    public void testCompanyNumberFormat() {
        companyNumberFormat();
    }

}
