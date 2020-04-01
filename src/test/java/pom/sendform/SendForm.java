package pom.sendform;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static constants.BaseConstants.checkCircleIconSubElementMenu;
import static constants.BaseConstants.errorIconSubElementMenu;

public class SendForm extends BasePage {

    // == private members ==
    private Map<Integer, SendFormVehicleDetails> integerSendFormVehicleDetailsMap;

    // == constructors==
    public SendForm(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);

        recreateMapPanelsOnPage();
    }

    // == web-elements ==
    @FindBy(xpath = "(//*[@class='info-box'])[1]")
    private WebElement infoBoxPersonalDetails;
    @FindBy(xpath = "(//*[@class='info-box'])[2]")
    private WebElement infoBoxVehicles;
    @FindBy(xpath = "(//*[@class='info-box'])[3]")
    private WebElement infoBoxWages;
    @FindBy(xpath = "(//*[@class='info-box'])[4]")
    private WebElement infoBoxRealEstate;
    @FindBy(xpath = "(//*[@class='info-box'])[5]")
    private WebElement infoBoxVarious;

    // Personal Details elements
    @FindBy(xpath = "//span/strong[contains(text(),'תעודת זהות')]/..")
    private List<WebElement> id;
    @FindBy(xpath = "//span/strong[contains(text(),'שם פרטי')]/..")
    private List<WebElement> firstName;
    @FindBy(xpath = "//span/strong[contains(text(),'שם משפחה')]/..")
    private List<WebElement> familyName;
    @FindBy(xpath = "//span/strong[contains(text(),'טלפון נייד')]/..")
    private List<WebElement> cellularPhone;
    @FindBy(xpath = "//span/strong[contains(text(),'טלפון נייח')]/..")
    private List<WebElement> landlinesPhone;
    @FindBy(xpath = "//span/strong[contains(text(),'דואר אלקטרוני')]/..")
    private List<WebElement> email;
    @FindBy(xpath = "//span/strong[contains(text(),'תושב ישראל')]/..")
    private List<WebElement> israeliCitizen;
    @FindBy(xpath = "//span/strong[contains(text(),'סטטוס')]/..")
    private List<WebElement> maritalStatus;
    @FindBy(xpath = "//span/strong[contains(text(),'בן/בת הזוג תושב/ת ישראל')]/..")
    private List<WebElement> spouseIsraeliCitizen;
    @FindBy(xpath = "//span/strong[contains(text(),'תעודת זהות בן/בת הזוג')]/..")
    private List<WebElement> spouseId;
    @FindBy(xpath = "//span/strong[contains(text(),'מספר דרכון בן/בת הזוג')]/..")
    private List<WebElement> spousePassport;
    @FindBy(xpath = "//span/strong[contains(text(),'מדינת בן/בת זוג')]/..")
    private List<WebElement> spouseCountry;
    @FindBy(xpath = "//span/strong[contains(text(),'מחוז בן/בת זוג')]/..")
    private List<WebElement> spouseState;

    // Vehicle elements
    @FindBy(xpath = "(//*[@class='info-box'])[2]//ul/li")
    private List<WebElement> vehicles;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    // == getters ==
    public WebElement getBtnSubmit() {
        return btnSubmit;
    }

    public List<WebElement> getId() {
        return id;
    }

    public List<WebElement> getFirstName() {
        return firstName;
    }

    public List<WebElement> getFamilyName() {
        return familyName;
    }

    public List<WebElement> getCellularPhone() {
        return cellularPhone;
    }

    public List<WebElement> getLandlinesPhone() {
        return landlinesPhone;
    }

    public List<WebElement> getEmail() {
        return email;
    }

    public List<WebElement> getIsraeliCitizen() {
        return israeliCitizen;
    }

    public List<WebElement> getMaritalStatus() {
        return maritalStatus;
    }

    public List<WebElement> getSpouseIsraeliCitizen() {
        return spouseIsraeliCitizen;
    }

    public List<WebElement> getSpouseId() {
        return spouseId;
    }

    public List<WebElement> getSpousePassport() {
        return spousePassport;
    }

    public List<WebElement> getSpouseCountry() {
        return spouseCountry;
    }

    public List<WebElement> getSpouseState() {
        return spouseState;
    }

    public List<WebElement> getVehicles() {
        return vehicles;
    }


    // == pubic methods ==

    // menu icons
    public List<WebElement> getErrorIconMenu() {
        return getMenuSendForm().findElements(errorIconSubElementMenu);
    }

    public List<WebElement> getCheckCircleIconMenu() {
        return getMenuSendForm().findElements(checkCircleIconSubElementMenu);
    }

    // methods info-box Personal Details
    public boolean idContains(String text) {
        return id.get(0).getText().contains(text);
    }

    public boolean firstNameContains(String text) {
        return firstName.get(0).getText().contains(text);
    }

    public boolean familyNameContains(String text) {
        return familyName.get(0).getText().contains(text);
    }

    public boolean cellularPhoneContains(String text) {
        return cellularPhone.get(0).getText().contains(text);
    }

    public boolean landlinesPhoneContains(String text) {
        return landlinesPhone.get(0).getText().contains(text);
    }

    public boolean emailContains(String text) {
        return email.get(0).getText().contains(text);
    }

    public boolean israelCitizenContains(String text) {
        return israeliCitizen.get(0).getText().contains(text);
    }

    public boolean maritalStatusContains(String text) {
        return maritalStatus.get(0).getText().contains(text);
    }

    public boolean spouseIsraeliCitizenContains(String text) {
        return spouseIsraeliCitizen.get(0).getText().contains(text);
    }

    public boolean spouseIdContains(String text) {
        return spouseId.get(0).getText().contains(text);
    }

    public boolean spousePassportContains(String text) {
        return spousePassport.get(0).getText().contains(text);
    }

    public boolean spouseCountryContains(String text) {
        return spouseCountry.get(0).getText().contains(text);
    }

    public boolean spouseStateContains(String text) {
        return spouseState.get(0).getText().contains(text);
    }


    // methods info-box Vehicles
    public boolean typeVehicleExists(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).typeVehicleExists();
    }

    public boolean licenseVehicleExists(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).licenseVehicleExists();
    }

    public boolean usageVehicleExists(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).usageVehicleExists();
    }

    public boolean typeVehicleContainsText(int vehicleNumber, String vehicleType) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).elementContainsText(vehicleType);
    }

    public boolean licenseVehicleContainsText(int vehicleNumber, String vehicleLicense) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).elementContainsText(vehicleLicense);
    }

    public boolean usageVehicleContainsText(int vehicleNumber, String vehicleUsage) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).elementContainsText(vehicleUsage);
    }

    public boolean vehiclePrivate(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehiclePrivate();
    }

    public boolean vehicleCommercial(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehicleCommercial();
    }

    public boolean vehicleHeavyEngineeringEquipment(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehicleHeavyEngineeringEquipment();
    }

    public boolean vehicleAircraft(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehicleAircraft();
    }

    public boolean vehicleVessel(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehicleVessel();
    }

    public boolean usageVehiclePrivate(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).usageVehiclePrivate();
    }

    public boolean usageVehicleBusiness(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
        }

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).usageVehicleBusiness();
    }

    public int numberVehicles() {
        return integerSendFormVehicleDetailsMap.size();
    }

    // send form method
    public void clickBtnSubmit() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnSubmit);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // == private methods ==
    private void recreateMapPanelsOnPage() {
        integerSendFormVehicleDetailsMap = new HashMap<>();

        for (int i = 0; i < vehicles.size(); ++i) {
            WebElement webElement = vehicles.get(i);
            integerSendFormVehicleDetailsMap.put(i, new SendFormVehicleDetails(driver, webElement));
        }

    }
}