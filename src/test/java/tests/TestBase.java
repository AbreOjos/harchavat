package tests;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
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
import pom.forms.realestates.RealEstate;
import pom.forms.various.Various;
import pom.forms.vehicles.Vehicle;
import pom.forms.wages.Wage;
import readresources.parameters.WebUiParameters;
import utils.functionalinterfaces.TriConsumer;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

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

    protected void createEdgeDriver() {
        log.info("Create Edge driver");

        driver = new EdgeDriver();
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
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

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
        vehicle.chooseDontHaveVehicle();
        vehicle.clickBtnSave();
    }

    protected void prepareEmptyWageDetails() {
        Wage wage = basePage.clickMenuWage();
        wage.chooseDontHaveWage();
        wage.clickBtnSave();

        basePage.clickMenuSendForm();
    }

    protected void prepareEmptyRealEstateDetails() {
        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseDontHaveRealEstate();
        realEstate.clickBtnSave();
    }

    protected void prepareEmptyVariousDetails() {
        Various various = basePage.clickMenuVarious();

        various.chooseDontHaveNonWorkIncomes();
        various.chooseDontHaveAbroadBankAccounts();
        various.chooseDontHaveDigitalCoins();
        various.chooseDontHaveStocks();
        various.chooseDontHavePartnerships();
        various.chooseDontHaveJewelry();
        various.chooseDontHaveArt();

        various.clickBtnSave();
    }

    // check error scenarios
    protected <T> void needFillErrorMessage(Function<Integer, List<WebElement>> getErrorMessage,
                                            Supplier<BasePage> clickMenu,
                                            BiConsumer<Integer, T> enterData,
                                            Consumer<Integer> deletePanel,
                                            T firstParam, T thirdParam, String error) {
        log.info(String.format("Check the error message 'need to fill %s'", error));

        basePage.clickMenuSendForm();
        clickMenu.get();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0), 1,
                String.format("Error message 'Need to Fill %s' did not appear on a first panel", error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(1), 1,
                String.format("Error message 'Need to Fill %s' did not appear on a second panel", error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(2), 1,
                String.format("Error message 'Need to Fill %s' did not appear on a third panel", error));


        enterData.accept(0, firstParam);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0), 0,
                String.format("Error message 'Need to Fill %s' did not disappear on a first panel after %s was entered", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(1), 1,
                String.format("Error message 'Need to Fill %s' disappeared on a second panel after %s was entered on a first panel", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(2), 1,
                String.format("Error message 'Need to %s' disappeared on a third panel after %s was entered on a first panel", error, error));


        enterData.accept(2, thirdParam);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0), 0,
                String.format("Error message 'Need to Fill %s' re-appeared on a first panel after %s was entered on a third panel", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(1), 1,
                String.format("Error message 'Need to Fill %s' disappeared on a second panel after %s was entered on a third panel", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(2), 0,
                String.format("Error message 'Need to Fill %s' did not disappear on a third panel after %s was entered", error, error));

        deletePanel.accept(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0), 0,
                String.format("Error message 'Need to Fill %s' re-appeared on a first panel after a third panel was deleted", error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(1), 1,
                String.format("Error message 'Need to Fill %s' disappeared on a second panel after a third panel was deleted", error));

        deletePanel.accept(1);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0), 0,
                String.format("Error message 'Need to Fill %s' re-appeared on a first panel after a last panel was deleted", error));
    }


    protected <T> void needFillErrorMessage(BiFunction<Integer, Integer, List<WebElement>> getErrorMessage,
                                            Supplier<BasePage> clickMenu,
                                            TriConsumer<Integer, Integer, T> enterData,
                                            BiConsumer<Integer, Integer> deleteSubPanel,
                                            T firstParam, T thirdParam, String error) {
        log.info(String.format("Check the error message 'need to fill %s'", error));

        basePage.clickMenuSendForm();
        clickMenu.get();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0, 0), 1,
                String.format("Error message 'Need to Fill %s' did not appear on a first subpanel", error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0, 1), 1,
                String.format("Error message 'Need to Fill %s' did not appear on a subpanel panel", error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0,2), 1,
                String.format("Error message 'Need to Fill %s' did not appear on a third subpanel", error));


        enterData.accept(0, 0, firstParam);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0, 0), 0,
                String.format("Error message 'Need to Fill %s' did not disappear on a first subpanel after %s was entered", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0, 1), 1,
                String.format("Error message 'Need to Fill %s' disappeared on a second subpanel after %s was entered on a first subpanel", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0, 2), 1,
                String.format("Error message 'Need to %s' disappeared on a third subpanel after %s was entered on a first subpanel", error, error));


        enterData.accept(0, 2, thirdParam);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0, 0), 0,
                String.format("Error message 'Need to Fill %s' re-appeared on a first subpanel after %s was entered on a third subpanel", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0, 1), 1,
                String.format("Error message 'Need to Fill %s' disappeared on a second subpanel after %s was entered on a third subpanel", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0, 2), 0,
                String.format("Error message 'Need to Fill %s' did not disappear on a third subpanel after %s was entered", error, error));

        deleteSubPanel.accept(0, 2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0, 0), 0,
                String.format("Error message 'Need to Fill %s' re-appeared on a first subpanel after a third subpanel was deleted", error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0, 1), 1,
                String.format("Error message 'Need to Fill %s' disappeared on a second subpanel after a third subpanel was deleted", error));

        deleteSubPanel.accept(0, 1);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0, 0), 0,
                String.format("Error message 'Need to Fill %s' re-appeared on a first subpanel after a last subpanel was deleted", error));
    }

    protected void needChooseErrorMessage(Function<Integer, List<WebElement>> getErrorMessage,
                                            Supplier<BasePage> clickMenu,
                                            Consumer<Integer> enterData,
                                            Consumer<Integer> deletePanel,
                                            String error) {
        log.info(String.format("Check the error message 'need to choose %s'", error));

        basePage.clickMenuSendForm();
        clickMenu.get();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0), 1,
                String.format("Error message 'Need to Choose %s' did not appear on a first panel", error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(1), 1,
                String.format("Error message 'Need to Choose %s' did not appear on a second panel", error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(2), 1,
                String.format("Error message 'Need to Choose %s' did not appear on a third panel", error));


        enterData.accept(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0), 0,
                String.format("Error message 'Need to Choose %s' did not disappear on a first panel after %s was entered", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(1), 1,
                String.format("Error message 'Need to Choose %s' disappeared on a second panel after %s was entered on a first panel", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(2), 1,
                String.format("Error message 'Need to Choose %s' disappeared on a third panel after %s was entered on a first panel", error, error));


        enterData.accept(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0), 0,
                String.format("Error message 'Need to Choose %s' re-appeared on a first panel after %s was entered on a third panel", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(1), 1,
                String.format("Error message 'Need to Choose %s' disappeared on a second panel after %s was entered on a third panel", error, error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(2), 0,
                String.format("Error message 'Need to Choose %s' did not disappear on a third panel after %s was entered", error, error));

        deletePanel.accept(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0), 0,
                String.format("Error message 'Need to Choose %s' re-appeared on a first panel after a third panel was deleted", error));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(1), 1,
                String.format("Error message 'Need to Choose %s' disappeared on a second panel after a third panel was deleted", error));

        deletePanel.accept(1);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(getErrorMessage.apply(0), 0,
                String.format("Error message 'Need to Choose %s' re-appeared on a first panel after a last panel was deleted", error));
    }
}
