package tests.firefox;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.PersonalDetailsTests;
import utils.dataprovider.NEDataProvider;
import utils.utilitiesForInfra.MiscellaneousForInfra;

import java.net.URISyntaxException;

@Test(groups = {RunMode.FIREFOX})
public class FirefoxPersonalDetailsTests extends PersonalDetailsTests {
    private static final Logger log = Logger.getLogger(FirefoxPersonalDetailsTests.class);

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

        prepareEmptyPhoneAndEmailFieldsPersonalDetails();
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenCharsPhoneNumber")
    public void testForbiddenCharactersPhoneNumber(String forbiddenChars) {
        forbiddenCharactersPhoneNumber(forbiddenChars);
    }

    @Test(dataProviderClass = NEDataProvider.class, dataProvider = "forbiddenCharsPhoneNumber")
    public void testForbiddenCharactersCellularPhoneNumber(String forbiddenChars) {
        forbiddenCharactersCellularPhoneNumber(forbiddenChars);
    }

    public void testIncorrectMailFormat() {
        incorrectMailFormat();
    }

    public void testCorrectMailFormat() {
        correctMailFormat();
    }

    public void testPhonesMissingErrorMessage() {
        phonesMissingErrorMessage();
    }

    public void testPhoneNumbersTooLongErrorMessages() {
        phoneNumbersTooLongErrorMessages();
    }

    public void testMarriedSpouseIdMissingErrorMessage() {
        marriedSpouseIdMissingErrorMessage();
    }

    public void testMarriedSpouseIdFormat() {
        marriedSpouseIdFormat();
    }

    public void testSpousalAllianceSpouseIdMissingErrorMessage() {
        spousalAllianceSpouseIdMissingErrorMessage();
    }

    public void testSpousalAllianceSpouseIdFormat() {
        spousalAllianceSpouseIdFormat();
    }

    public void testPolygamySpouseIdMissingErrorMessage() {
        polygamySpouseIdMissingErrorMessage();
    }

    public void testPolygamyAllianceSpouseIdFormat() {
        polygamyAllianceSpouseIdFormat();
    }

    public void testMarriedSpousePassportMissingErrorMessage() {
        marriedSpousePassportMissingErrorMessage();
    }

    public void testMarriedSpousePassportFormat() {
        marriedSpousePassportFormat();
    }

    public void testSpousalAllianceSpousePassportMissingErrorMessage() {
        spousalAllianceSpousePassportMissingErrorMessage();
    }

    public void testSpousalAllianceSpousePassportFormat() {
        spousalAllianceSpousePassportFormat();
    }

    public void testPolygamySpousePassportMissingErrorMessage() {
        polygamySpousePassportMissingErrorMessage();
    }

    public void testPolygamyAllianceSpousePassportFormat() {
        polygamyAllianceSpousePassportFormat();
    }

    public void testCheckMenuIcons() throws InterruptedException {
        checkMenuIcons();
    }

    public void testCheckDownloadedFormForSeparates() {
        checkDownloadedFormForSeparates();
    }
}
