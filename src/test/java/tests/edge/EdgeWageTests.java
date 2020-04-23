package tests.edge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.RunMode;
import tests.scenarious.WageTests;
import utils.dataprovider.NEDataProvider;

@Test(groups = {RunMode.EDGE})
public class EdgeWageTests extends WageTests {
    private static final Logger log = Logger.getLogger(EdgeWageTests.class);

    @BeforeClass(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpClass() {

        WebDriverManager.edgedriver().setup();

    }


    @BeforeMethod(groups = {RunMode.EDGE}, alwaysRun = true)
    public void setUpMethod() {

        createEdgeDriver();

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
