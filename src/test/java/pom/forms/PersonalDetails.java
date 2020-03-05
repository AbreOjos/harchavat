package pom.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static utils.utilitiesForInfra.JavaScriptHelpersHarchavat.scrollIntoViewMoveFocusAndClickWithJavaScript;

public class PersonalDetails extends BasePage {

    // == constructors==
    public PersonalDetails(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    // == web elements ==
    @FindBy(xpath = "//input[@role='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(name = "identity")
    private WebElement txtIdentity;
    @FindBy(name = "firstName")
    private WebElement txtFirstName;
    @FindBy(name = "lastName")
    private WebElement txtLastName;
    @FindBy(name = "cellular")
    private WebElement txtCellular;
    @FindBy(name = "phone")
    private WebElement txtPhone;
    @FindBy(name = "email")
    private WebElement txtEmail;
    @FindBy(xpath = "//*[contains(@class, 'v-item-group') and @dir='rtl']/button")
    private List<WebElement> btnsResident;

    @FindBy(xpath = "//div[@name='Marital Status']/button")
    private List<WebElement> btnsMartialStatus;

    // for married only
    @FindBy(xpath = "//div[@class='layout mt-4']//button")
    private List<WebElement> btnsSpouseResident;

    // spouse expatriate details
    @FindBy(name = "spousePassport")
    private WebElement txtSpousePassport;
    @FindBy(xpath = "//div[@class='v-select__slot']")
    private WebElement dropDownSpouseCountry;
    @FindBy(name = "spouseState")
    private WebElement txtSpouseState;

    // spouse Israeli only
    @FindBy(name = "spouseIdentity")
    private WebElement txtSpouseIdentity;

    // for separated only
    @FindBy(xpath = "//div[@class='v-btn__content']//input[@type='file']")
    private WebElement attachFileInput;

    // == getters ==
    public List<WebElement> getCheckBoxes() {
        return checkBoxes;
    }

    public WebElement getTxtIdentity() {
        return txtIdentity;
    }

    public WebElement getTxtFirstName() {
        return txtFirstName;
    }

    public WebElement getTxtLastName() {
        return txtLastName;
    }

    public WebElement getTxtEmail() {
        return txtEmail;
    }

    public WebElement getTxtPhone() {
        return txtPhone;
    }

    public WebElement getTxtCellular() {
        return txtCellular;
    }

    public List<WebElement> getBtnsResident() {
        return btnsResident;
    }

    public List<WebElement> getBtnsMartialStatus() {
        return btnsMartialStatus;
    }

    public List<WebElement> getBtnsSpouseResident() {
        return btnsSpouseResident;
    }

    public WebElement getTxtSpousePassport() {
        return txtSpousePassport;
    }

    public WebElement getTxtSpouseState() {
        return txtSpouseState;
    }

    public WebElement getTxtSpouseIdentity() {
        return txtSpouseIdentity;
    }

    public WebElement getAttachFileInput() {
        return attachFileInput;
    }

    public WebElement getDropDownSpouseCountry() {
        return dropDownSpouseCountry;
    }


    // == public methods ==

    // checkboxes check / uncheck
    public boolean isAgreementChecked() {
        return checkBoxes.get(0).getAttribute("aria-checked").equals("true");
    }

    public boolean isCanSendEmailChecked() {
        return checkBoxes.get(1).getAttribute("aria-checked").equals("true");
    }

    public void checkAgreement() throws InterruptedException {
        if (!isAgreementChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(0));
    }

    public void uncheckAgreement() throws InterruptedException {
        if (isAgreementChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(0));
    }

    public void checkCanSendEmail() throws InterruptedException {
        if (!isCanSendEmailChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(1));
    }

    public void uncheckCanSendEmail() throws InterruptedException {
        if (isCanSendEmailChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(1));
    }

    // personal details
    public void enterIdentity(String identity) {
        fillFormField(txtIdentity, identity);
    }

    public void enterFirstName(String firstName) {
        fillFormField(txtFirstName, firstName);

    }

    public void enterLastName(String lastName) {
        fillFormField(txtLastName, lastName);

    }

    public void enterEmail(String email) {
        fillFormField(txtEmail, email);
    }

    public void enterCellular(String cellular) {
        fillFormField(txtCellular, cellular);
    }

    public void enterPhone(String phone) {
        fillFormField(txtPhone, phone);
    }

    // resident
    public void chooseExpatriate() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsResident.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    public void chooseIsraeli() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsResident.get(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    // martial statuses
    public void chooseMaritalStatusBachelor() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    public void chooseMaritalStatusMarried() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    public void chooseMaritalStatusDivorced() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    public void chooseMaritalStatusWidow() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    public void chooseMaritalStatusSpousalAlliance() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(4));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    public void chooseMaritalStatusSeparated() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    public void chooseMaritalStatusPolygamy() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(6));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    // spouse resident
    public void chooseSpouseExpatriate() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsSpouseResident.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    public void chooseSpouseIsraeli() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsSpouseResident.get(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    // for spouse expatriate only
    public void enterSpousePassport(String spousePassport) {
        fillFormField(txtSpousePassport, spousePassport);

    }

    public void chooseStateSpouseIsrael() {
        clickDropDownList(dropDownSpouseCountry, 0);
    }

    public void chooseStateSpouseZambia() {
        clickDropDownList(dropDownSpouseCountry, 1);
    }

    public void chooseStateSpouseUsa() {
        clickDropDownList(dropDownSpouseCountry, 2);
    }

    public void enterSpouseState(String spouseState) {
        fillFormField(txtSpouseState, spouseState);

    }

    // for spouse Israeli only
    public void enterSpouseIdentity(String spouseIdentity) {
        fillFormField(txtSpouseIdentity, spouseIdentity);
    }

    // attach file for separated
    public void attachFileSeparated(String filename) {
        attachFileInput.sendKeys(filename);

        PageFactory.initElements(this.driver, this);
    }

}

