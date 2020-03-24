package tests.chrome;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import readresources.drivers.WebDrivers;
import tests.RunMode;
import tests.scenarious.PersonalAreaTests;
import utils.dataprovider.NEDataProvider;

import java.net.URISyntaxException;

@Test(groups = {RunMode.CHROME})
public class ChromePersonalAreaTests extends PersonalAreaTests {
    private static final Logger log = Logger.getLogger(ChromePersonalAreaTests.class);

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

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        prepareEmptyPhoneAndEmailFields();
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

    public void testCheckMenuIcons() {
        checkMenuIcons();
    }
}
