package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pom.BasePage;
import pom.forms.PersonalDetails;
import pom.forms.vehicles.Vehicle;
import readresources.parameters.WebUiParameters;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.waitFewSecondsWarningDisabled;
import static constants.EnglishHebrewConstants.GINDIN;
import static constants.EnglishHebrewConstants.IGOR;

public abstract class TestBase {
    private static final Logger log = Logger.getLogger(TestBase.class);

    protected WebDriver driver;
    protected WebDriverWait wait;

    // WEB UI params
    protected static String hnURL;

    // DATABASE params
    protected static String dbIP;
    protected static String dbPort;
    protected static String dbUser;
    protected static String dbPass;

    // user details
    public static final String userFirstName = IGOR;
    public static final String userFamilyName = GINDIN;
    public static final String userId = "320959604";

    protected static String downloadDir;

    ////////// AXE ///////////////
    protected static final URL scriptUrl = TestBase.class.getResource("/axe.min.js");
    /////////////////////////////

    // protected members
    protected BasePage basePage;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {

        hnURL = WebUiParameters.getHnUrl();
        downloadDir = System.getProperty("downloadDir",
                System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
    }

    public void setUpMethod() {
        try {
            goToLoginPage();
//            loginTo();
            basePage = new BasePage(driver);
        } catch (Exception e) {
            log.error("Before method failed, the reason: " + e.getMessage());
        }
    }

    protected void goToLoginPage() {
        log.info(String.format("Open a browser, go to %s", hnURL));
        driver.get(hnURL);
        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
        driver.manage().window().maximize();
        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void createChromeDriver() {

        log.info("Create Chrome driver");

//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

//        capabilities.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
//        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        Map<String, Object> prefs = new HashMap<>();
//        prefs.put(CapabilityType.ACCEPT_SSL_CERTS, true);
//        prefs.put(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        prefs.put("download.default_directory", downloadDir);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        chromeOptions.setExperimentalOption("prefs", prefs);
//        chromeOptions.merge(capabilities);
        driver = new ChromeDriver(chromeOptions);

//        System.out.println("////////////////////");
//        System.out.println(chromeOptions.getExperimentalOption("prefs"));
//        System.out.println("////////////////////");

//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

    }

    protected void createFirefoxDriver() {

        log.info("Create Firefox driver");

//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
//        capabilities.setCapability("marionette", "true");
        FirefoxOptions firefoxOptions = new FirefoxOptions(); //.setLegacy(true);
        firefoxOptions.setCapability("strictFileInteractability", true);
//        firefoxOptions.merge(capabilities);
//        driver = new FirefoxDriver(firefoxOptions);
//        driver = new FirefoxDriver();
        driver = new FirefoxDriver(firefoxOptions);
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

    }

    protected void createInternetExplorerDriver() {

        log.info("Create InternetExplorer driver");

        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
//        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);

        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.merge(capabilities);
        driver = new InternetExplorerDriver(internetExplorerOptions);
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        if (driver != null) driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        if (driver != null) driver.quit();
    }

    // == help methods ==
    protected void prepareEmptyPhoneAndEmailFieldsPersonalDetails() {
        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();
        personalDetails.deleteCellular();
        personalDetails.deletePhone();
        personalDetails.deleteEmail();
        personalDetails.clickBtnSave();
    }

    protected void prepareEmptyVehicleDetails() {
        Vehicle vehicle = basePage.clickMenuVehicle();
//        vehicle.chooseHaveVehicle();
//        vehicle.deleteAllVehicles();
//        vehicle.chooseAnotherVehicle(0);
//        vehicle.chooseAnotherUsage(0);
//        vehicle.deleteCarLicense(0);
//        vehicle.deleteAnotherCarTypeDetails(0);
//        vehicle.enterAnotherUsageDetails(0, "aaa");
//        vehicle.deleteAnotherUsageDetails(0);
//        vehicle.clickBtnSave();
//        vehicle.chooseDontHaveVehicle();
        vehicle.chooseDontHaveVehicle();
        vehicle.clickBtnSave();
    }
}
