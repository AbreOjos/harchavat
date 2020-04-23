package tests.iexplorer;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.RealEstateTests;
import utils.dataprovider.NEDataProvider;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.IEXPLORER})
public class IExplorerRealEstateTests extends RealEstateTests {
    private static final Logger log = Logger.getLogger(IExplorerRealEstateTests.class);

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

        prepareEmptyRealEstateDetails();
    }

    public void testCheckMenuIcons() throws Exception {
        checkMenuIcons();
    }

    public void testNeedFillRealEstateTypeErrorMessage() {
        needFillRealEstateTypeErrorMessage();
    }

    public void testNeedFillDateErrorMessage() throws Exception {
        needFillDateErrorMessage();
    }

    public void testNeedFillPropertyAreaErrorMessage() {
        needFillPropertyAreaErrorMessage();
    }

    public void testNeedFillOwnershipPercentageErrorMessage() {
        needFillOwnershipPercentageErrorMessage();
    }

    public void testNeedFillGushErrorMessage() {
        needFillGushErrorMessage();
    }

    public void testNeedFillHelkaErrorMessage() {
        needFillHelkaErrorMessage();
    }

    public void testNeedFillCityIsraeliErrorMessage() {
        needFillCityIsraeliErrorMessage();
    }

    public void testNeedFillStreetIsraeliErrorMessage() {
        needFillStreetIsraeliErrorMessage();
    }

    public void testNeedFillHouseNumberIsraeliErrorMessage() {
        needFillHouseNumberIsraeliErrorMessage();
    }

    public void testNeedFillCountryOverseaErrorMessage() {
        needFillCountryOverseaErrorMessage();
    }

    public void testNeedFillCityOverseaErrorMessage() {
        needFillCityOverseaErrorMessage();
    }

    public void testNeedFillStreetOverseaErrorMessage() {
        needFillStreetOverseaErrorMessage();
    }

    public void testNeedFillHouseNumberOverseaErrorMessage() {
        needFillHouseNumberOverseaErrorMessage();
    }

    public void testNeedFillUsageRealEstateErrorMessage() {
        needFillUsageRealEstateErrorMessage();
    }

    public void testNeedFillUsageDetailsErrorMessage() {
        needFillUsageDetailsErrorMessage();
    }

    public void testNeedFillPropertySplitErrorMessage() {
        needFillPropertySplitErrorMessage();
    }

    public void testNeedFillTenantIDErrorMessage() {
        needFillTenantIDErrorMessage();
    }

    public void testNeedFillTenantCountryErrorMessage() {
        needFillTenantCountryErrorMessage();
    }

    public void testNeedFillTenantPassportErrorMessage() {
        needFillTenantPassportErrorMessage();
    }

    public void testPropertyAreaContainsDigitsOnlyErrorMessage() {
        propertyAreaContainsDigitsOnlyErrorMessage();
    }

    public void testOwnershipPercentageIncorrectFormat() {
        ownershipPercentageIncorrectFormat();
    }

    public void testGushContainsDigitsOnlyErrorMessage() {
        gushContainsDigitsOnlyErrorMessage();
    }

    public void testHelkaContainsDigitsOnlyErrorMessage() {
        helkaContainsDigitsOnlyErrorMessage();
    }

    public void testTatHelkaIncorrectFormat() {
        tatHelkaIncorrectFormat();
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

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersExplainUsage(String forbiddenChars) {
        forbiddenCharactersExplainUsage(forbiddenChars);
    }

    public void testMonthlyRentTwentyCharsMaxErrorMessage() {
        monthlyRentTwentyCharsMaxErrorMessage();
    }

    public void testAmountPartitionsErrorMessages() {
        amountPartitionsErrorMessages();
    }

    public void testTenantIDErrorMessages() {
        tenantIDErrorMessages();
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenChars")
    public void testForbiddenCharactersTenantState(String forbiddenChars) {
        forbiddenCharactersTenantState(forbiddenChars);
    }

    public void testTenantPassportErrorMessages() {
        tenantPassportErrorMessages();
    }

}