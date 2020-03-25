package pom.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static constants.BaseConstants.checkCircleIconSubElementMenu;
import static constants.BaseConstants.errorIconSubElementMenu;

public class SendForm extends BasePage {

    // == constructors==
    public SendForm(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
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

    @FindBy(xpath = "//span[contains(text(),'תעודת זהות')]")
    private List<WebElement> id;
    @FindBy(xpath = "//span[contains(text(),'שם פרטי')]")
    private List<WebElement> firstName;
    @FindBy(xpath = "//span[contains(text(),'שם משפחה')]")
    private List<WebElement> familyName;
    @FindBy(xpath = "//span[contains(text(),'טלפון נייד')]")
    private List<WebElement> cellularPhone;
    @FindBy(xpath = "//span[contains(text(),'טלפון נייח')]")
    private List<WebElement> landlinesPhone;
    @FindBy(xpath = "//span[contains(text(),'דואר אלקטרוני')]")
    private List<WebElement> email;
    @FindBy(xpath = "//span[contains(text(),'תושב ישראל')]")
    private List<WebElement> israeliCitizen;
    @FindBy(xpath = "//span[contains(text(),'סטטוס')]")
    private List<WebElement> martialStatus;
    @FindBy(xpath = "//span[contains(text(),'בן/בת הזוג תושב/ת ישראל')]")
    private List<WebElement> spouseIsraeliCitizen;
    @FindBy(xpath = "//span[contains(text(),'תעודת זהות בן/בת הזוג')]")
    private List<WebElement> spouseId;
    @FindBy(xpath = "//span[contains(text(),'מספר דרכון בן/בת הזוג')]")
    private List<WebElement> spousePassport;
    @FindBy(xpath = "//span[contains(text(),'מדינת בן/בת זוג')]")
    private List<WebElement> spouseCountry;
    @FindBy(xpath = "//span[contains(text(),'מחוז בן/בת זוג')]")
    private List<WebElement> spouseState;

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

    public List<WebElement> getMartialStatus() {
        return martialStatus;
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

    public boolean martialStatusContains(String text) {
        return martialStatus.get(0).getText().contains(text);
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

    // send form method
    public void clickBtnSubmit() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnSubmit);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
