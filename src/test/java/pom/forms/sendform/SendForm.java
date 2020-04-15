package pom.forms.sendform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;
import pom.forms.sendform.various.VariousAbroadBankAccount;
import pom.forms.sendform.various.VariousDigitalCoins;
import pom.forms.sendform.various.VariousNonWorkIncomes;
import pom.forms.sendform.various.VariousStocks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static constants.BaseConstants.checkCircleIconSubElementMenu;
import static constants.BaseConstants.errorIconSubElementMenu;
import static constants.EnglishHebrewConstants.*;

public class SendForm extends BasePage {

    // == private members ==
    private final String VEHICLE = "vehicle";
    private final String WAGE = "wage";
    private final String REAL_ESTATE = "real estate";

    private Map<Integer, SendFormVehicleDetails> integerSendFormVehicleDetailsMap;
    private Map<Integer, SendFormWageDetails> integerSendFormWageDetailsMap;
    private Map<Integer, SendFormRealEstateDetails> integerSendFormRealEstateDetailsMap;

    private Map<Integer, VariousNonWorkIncomes> integerVariousNonWorkIncomesMap;
    private Map<Integer, VariousAbroadBankAccount> integerVariousAbroadBankAccountsMap;
    private Map<Integer, VariousDigitalCoins> integerVariousDigitalCoinsMap;
    private Map<Integer, VariousStocks> integerVariousStocksMap;
    private Map<Integer, SendFormRealEstateDetails> integerVariousPartnershipMap;

    // == constructors==
    public SendForm(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);

        recreateMapPanelsOnPage();
    }

    // == web-elements ==
    @FindBy(xpath = "//textarea[@name='comments']")
    private WebElement commentsTextArea;

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
    private List<WebElement> vehicle;

    // Wage elements
    @FindBy(xpath = "(//*[@class='info-box'])[3]//ul/li")
    private List<WebElement> wage;

    // Real Estate elements
    @FindBy(xpath = "(//*[@class='info-box'])[4]//ul/li")
    private List<WebElement> realEstate;

    // Various elements
    @FindBy(xpath = "((//*[@class='info-box'])[5]/div)[1]//ul/li")
    private List<WebElement> variousNonWorkIncomes;
    @FindBy(xpath = "((//*[@class='info-box'])[5]/div)[2]//ul/li")
    private List<WebElement> variousAbroadBankAccount;
    @FindBy(xpath = "((//*[@class='info-box'])[5]/div)[3]//ul/li")
    private List<WebElement> variousDigitalCoins;
    @FindBy(xpath = "((//*[@class='info-box'])[5]/div)[4]//ul/li")
    private List<WebElement> variousStocks;
    @FindBy(xpath = "((//*[@class='info-box'])[5]/div)[5]//ul/li")
    private List<WebElement> variousPartnership;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    // == getters ==

    public WebElement getCommentsTextArea() {
        return commentsTextArea;
    }

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

    public List<WebElement> getVehicle() {
        return vehicle;
    }

    public List<WebElement> getWage() {
        return wage;
    }

    public List<WebElement> getRealEstate() {
        return realEstate;
    }

    public List<WebElement> getVariousNonWorkIncomes() {
        return variousNonWorkIncomes;
    }

    public List<WebElement> getVariousAbroadBankAccount() {
        return variousAbroadBankAccount;
    }

    public List<WebElement> getVariousDigitalCoins() {
        return variousDigitalCoins;
    }

    public List<WebElement> getVariousStocks() {
        return variousStocks;
    }

    public List<WebElement> getVariousPartnership() {
        return variousPartnership;
    }


    // == pubic methods ==

    public void enterComment(String comment) {
        fillFormField(commentsTextArea, comment);
    }

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
//        if (vehicleNumber<0 || vehicleNumber>=integerSendFormVehicleDetailsMap.size()) {
//            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
//                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerSendFormVehicleDetailsMap.size()));
//        }

        checkNumber(vehicleNumber, "type vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).typeVehicleExists();
    }

    public boolean licenseVehicleExists(int vehicleNumber) {

        checkNumber(vehicleNumber, "license vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).licenseVehicleExists();
    }

    public boolean usageVehicleExists(int vehicleNumber) {

        checkNumber(vehicleNumber, "usage vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).usageVehicleExists();
    }

    public boolean typeVehicleContainsText(int vehicleNumber, String vehicleType) {

        checkNumber(vehicleNumber, "type vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehicleContainsText(vehicleType);
    }

    public boolean licenseVehicleContainsText(int vehicleNumber, String vehicleLicense) {

        checkNumber(vehicleNumber, "license vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehicleContainsText(vehicleLicense);
    }

    public boolean usageVehicleContainsText(int vehicleNumber, String vehicleUsage) {

        checkNumber(vehicleNumber, "usage vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehicleContainsText(vehicleUsage);
    }

    public boolean vehiclePrivate(int vehicleNumber) {

        checkNumber(vehicleNumber, "type vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehiclePrivate();
    }

    public boolean vehicleCommercial(int vehicleNumber) {

        checkNumber(vehicleNumber, "type vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehicleCommercial();
    }

    public boolean vehicleHeavyEngineeringEquipment(int vehicleNumber) {

        checkNumber(vehicleNumber, "type vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehicleHeavyEngineeringEquipment();
    }

    public boolean vehicleAircraft(int vehicleNumber) {

        checkNumber(vehicleNumber, "type vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehicleAircraft();
    }

    public boolean vehicleVessel(int vehicleNumber) {

        checkNumber(vehicleNumber, "type vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).vehicleVessel();
    }

    public boolean usageVehiclePrivate(int vehicleNumber) {

        checkNumber(vehicleNumber, "usage vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).usageVehiclePrivate();
    }

    public boolean usageVehicleBusiness(int vehicleNumber) {

        checkNumber(vehicleNumber, "usage vehicle", VEHICLE, integerSendFormVehicleDetailsMap);

        return integerSendFormVehicleDetailsMap.get(vehicleNumber).usageVehicleBusiness();
    }

    public int numberVehicles() {
        return integerSendFormVehicleDetailsMap.size();
    }


    // methods info-box Wages
    public boolean typeIncomeExists(int wageNumber) {
//        if (wageNumber<0 || wageNumber>=integerSendFormWageDetailsMap.size()) {
//            throw new WrongArgumentException(String.format("Impossible to get income type from a wage #%d. " +
//                    "The number need to be between 0 and %d not inclusive", wageNumber, integerSendFormWageDetailsMap.size()));
//        }

        checkNumber(wageNumber, "income type", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).typeIncomeExists();
    }

    public boolean annualIncomeExists(int wageNumber) {

        checkNumber(wageNumber, "annual income", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).annualIncomeExists();
    }

    public boolean employerNameExists(int wageNumber) {

        checkNumber(wageNumber, "employer name", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).employerNameExists();
    }

    public boolean citySubExists(int wageNumber) {

        checkNumber(wageNumber, "city", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).citySubExists();
    }

    public boolean streetIncomeExists(int wageNumber) {

        checkNumber(wageNumber, "street", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).streetIncomeExists();
    }

    public boolean houseNumberExists(int wageNumber) {

        checkNumber(wageNumber, "house number", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).houseNumberExists();
    }

    public boolean tikNikuimExists(int wageNumber) {

        checkNumber(wageNumber, "tik nikuim", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).tikNikuimExists();
    }

    public boolean countryExists(int wageNumber) {

        checkNumber(wageNumber, "country", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).countryExists();
    }

    public boolean stateExists(int wageNumber) {

        checkNumber(wageNumber, "state", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).stateExists();
    }

    public boolean wageIncomeTypeIsrael(int wageNumber) {

        checkNumber(wageNumber, "income type", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).wageContainsText(INCOME_ISRAEL);
    }

    public boolean wageIncomeTypeAbroad(int wageNumber) {

        checkNumber(wageNumber, "income type", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).wageContainsText(INCOME_ABROAD);
    }

    public boolean wageAnnualIncomeContainsText(int wageNumber, String annualIncome) {

        checkNumber(wageNumber, "annual income", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).wageContainsText(annualIncome);
    }

    public boolean wageEmployerNameContainsText(int wageNumber, String employerName) {

        checkNumber(wageNumber, "employer name", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).wageContainsText(employerName);
    }

    public boolean wageCityContainsText(int wageNumber, String city) {

        checkNumber(wageNumber, "city", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).wageContainsText(city);
    }

    public boolean wageStreetContainsText(int wageNumber, String street) {

        checkNumber(wageNumber, "street", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).wageContainsText(street);
    }

    public boolean wageNumHouseContainsText(int wageNumber, String numHouse) {

        checkNumber(wageNumber, "house number", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).wageContainsText(numHouse);
    }

    public boolean wageTikNikuimContainsText(int wageNumber, String tikNikuim) {

        checkNumber(wageNumber, "tik nikuim", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).wageContainsText(tikNikuim);
    }

    public boolean wageCountryContainsText(int wageNumber, String country) {

        checkNumber(wageNumber, "country", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).wageContainsText(country);
    }

    public boolean wageStateContainsText(int wageNumber, String state) {

        checkNumber(wageNumber, "state", WAGE, integerSendFormWageDetailsMap);

        return integerSendFormWageDetailsMap.get(wageNumber).wageContainsText(state);
    }

    public int numberWages() {
        return integerSendFormWageDetailsMap.size();
    }


    // methods info-box Real Estate
    public boolean tenantIsraeli(int realEstateNumber, int tenantNumber) {
        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).tenantIsraeli(tenantNumber);
    }

    public boolean tenantAbroad(int realEstateNumber, int tenantNumber) {
        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).tenantAbroad(tenantNumber);
    }

    public boolean tenantIdContains(int realEstateNumber, int tenantNumber, String id) {
        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).tenantIdContains(tenantNumber, id);
    }

    public boolean tenantCountryContains(int realEstateNumber, int tenantNumber, String country) {
        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).tenantCountryContains(tenantNumber, country);
    }

    public boolean tenantStateContains(int realEstateNumber, int tenantNumber, String state) {
        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).tenantStateContains(tenantNumber, state);
    }

    public boolean tenantPassportContains(int realEstateNumber, int tenantNumber, String passport) {
        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).tenantPassportContains(tenantNumber, passport);
    }

    public boolean realEstateTypeContainsText(int realEstateNumber, String typeRealEstate) {
//        if (realEstateNumber<0 || realEstateNumber>=integerSendFormRealEstateDetailsMap.size()) {
//            throw new WrongArgumentException(String.format("Impossible to get details about a real estate #%d. " +
//                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerSendFormRealEstateDetailsMap.size()));
//        }
        checkNumber(realEstateNumber, "type real estate", REAL_ESTATE, integerSendFormRealEstateDetailsMap);

        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).realEstateContainsText(typeRealEstate);
    }

    public boolean realEstateDateOwnershipContainsText(int realEstateNumber, String dateOwnership) {

        checkNumber(realEstateNumber, "date ownership real estate", REAL_ESTATE, integerSendFormRealEstateDetailsMap);

        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).realEstateContainsText(dateOwnership);
    }

    public boolean realEstateAreaSizeContainsText(int realEstateNumber, String areaSize) {

        checkNumber(realEstateNumber, "area size real estate", REAL_ESTATE, integerSendFormRealEstateDetailsMap);

        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).realEstateContainsText(areaSize);
    }

    public boolean realEstateOwnershipPercentageContainsText(int realEstateNumber, String ownershipPercentage) {

        checkNumber(realEstateNumber, "ownership percentage real estate", REAL_ESTATE, integerSendFormRealEstateDetailsMap);

        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).realEstateContainsText(ownershipPercentage);
    }

    public boolean realEstateIsraeli(int realEstateNumber) {

        checkNumber(realEstateNumber, "type real estate", REAL_ESTATE, integerSendFormRealEstateDetailsMap);

        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).realEstateContainsText(YES);
    }

    public boolean realEstateAbroad(int realEstateNumber) {

        checkNumber(realEstateNumber, "type real estate", REAL_ESTATE, integerSendFormRealEstateDetailsMap);

        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).realEstateContainsText(NO);
    }

    public boolean realEstateUsageContainsText(int realEstateNumber, String usage) {

        checkNumber(realEstateNumber, "real estate details", REAL_ESTATE, integerSendFormRealEstateDetailsMap);

        return integerSendFormRealEstateDetailsMap.get(realEstateNumber).realEstateContainsText(usage);
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
        integerSendFormWageDetailsMap = new HashMap<>();
        integerSendFormRealEstateDetailsMap = new HashMap<>();
        integerVariousNonWorkIncomesMap = new HashMap<>();
        integerVariousAbroadBankAccountsMap = new HashMap<>();
        integerVariousDigitalCoinsMap = new HashMap<>();
        integerVariousStocksMap = new HashMap<>();
        integerVariousPartnershipMap = new HashMap<>();


        for (int i = 0; i < vehicle.size(); ++i) {
            WebElement webElement = vehicle.get(i);
            integerSendFormVehicleDetailsMap.put(i, new SendFormVehicleDetails(driver, webElement));
        }

        for (int i = 0; i < wage.size(); ++i) {
            WebElement webElement = wage.get(i);
            integerSendFormWageDetailsMap.put(i, new SendFormWageDetails(driver, webElement));
        }

        for (int i = 0; i < realEstate.size(); ++i) {
            WebElement webElement = realEstate.get(i);
            integerSendFormRealEstateDetailsMap.put(i, new SendFormRealEstateDetails(driver, webElement));
        }

        for (int i = 0; i < realEstate.size(); ++i) {
            WebElement webElement = realEstate.get(i);
            integerVariousNonWorkIncomesMap.put(i, new VariousNonWorkIncomes(driver, webElement));
        }

        for (int i = 0; i < realEstate.size(); ++i) {
            WebElement webElement = realEstate.get(i);
            integerVariousAbroadBankAccountsMap.put(i, new VariousAbroadBankAccount(driver, webElement));
        }

        for (int i = 0; i < realEstate.size(); ++i) {
            WebElement webElement = realEstate.get(i);
            integerVariousDigitalCoinsMap.put(i, new VariousDigitalCoins(driver, webElement));
        }

        for (int i = 0; i < realEstate.size(); ++i) {
            WebElement webElement = realEstate.get(i);
            integerVariousStocksMap.put(i, new VariousStocks(driver, webElement));
        }

        for (int i = 0; i < realEstate.size(); ++i) {
            WebElement webElement = realEstate.get(i);
            integerVariousPartnershipMap.put(i, new SendFormRealEstateDetails(driver, webElement));
        }

    }
}
