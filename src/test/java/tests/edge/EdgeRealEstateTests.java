package tests.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.RunMode;
import tests.scenarious.RealEstateTests;
import utils.dataprovider.NEDataProvider;

@Test(groups = {RunMode.EDGE})
public class EdgeRealEstateTests extends RealEstateTests {
    private static final Logger log = Logger.getLogger(EdgeRealEstateTests.class);

    @BeforeClass(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpClass() {

        WebDriverManager.edgedriver().setup();

    }


    @BeforeMethod(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpMethod() {

        createEdgeDriver();

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
