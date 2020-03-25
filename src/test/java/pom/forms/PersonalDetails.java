package pom.forms;

import assertions.AssertionsHarchavat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.ArrayList;
import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.*;
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
    @FindBy(xpath = "//div[@name='residency']/button")
    private List<WebElement> btnsResident;

    @FindBy(xpath = "//div[@name='maritalStatus']/button")
    private List<WebElement> btnsMartialStatus;

    // for married only
    @FindBy(xpath = "//div[@name='spouseIsraeli']/button")
    private List<WebElement> btnsSpouseResident;

    // spouse expatriate details
    @FindBy(name = "spousePassport")
    private WebElement txtSpousePassport;
    @FindBy(xpath = "//div[@class='v-select__slot']")
    private WebElement dropDownSpouseCountry;
    @FindBy(name = "state")
    private WebElement txtSpouseState;

    // spouse Israeli only
    @FindBy(name = "spouseIdentity")
    private WebElement txtSpouseIdentity;

    // for separated only
    @FindBy(xpath = "//div[@class='v-btn__content']//input[@type='file']")
    private WebElement attachFileInput;
    @FindBy(xpath = "//span[@class='link-inner']")
    private WebElement downloadFileLink;

    // error messages
    @FindBy(xpath = "//p[contains(text(),'- ( ) +')]")
    private List<WebElement> phoneFormatErrorMessage;
    @FindBy(xpath = "//p[@class='error-msg' and contains(., 'יש להזין טלפון נייח או טלפון נייד')]")
    private List<WebElement> phoneMissingErrorMessage;
    @FindBy(xpath = "//p[@class='error-msg' and contains(., 'השדה טלפון נייד לא יכול להכיל יותר מ- 30 תווים')]")
    private List<WebElement> cellularPhoneTooLongErrorMessage;
    @FindBy(xpath = "//p[@class='error-msg' and contains(., 'השדה טלפון נייח לא יכול להכיל יותר מ- 30 תווים')]")
    private List<WebElement> landlinesPhoneTooLongErrorMessage;
    @FindBy(xpath = "//p[@class='error-msg'][contains(text(),'.')]")
    private List<WebElement> standardErrorMessage;
    @FindBy(xpath = "//p[@class='error-msg' and contains(., 'חובה למלא את השדה דואר אלקטרוני')]")
    private List<WebElement> emailNeedToFillErrorMessage;
    @FindBy(xpath = "//p[@class='error-msg' and contains(., 'השדה תעודת זהות בן/בת הזוג יכול להכיל ספרות שלמות בלבד')]")
    private List<WebElement> spouseIdOnlyDigitalErrorMessage;
    @FindBy(xpath = "//p[@class='error-msg' and contains(., 'חובה למלא את השדה תעודת זהות בן/בת הזוג')]")
    private List<WebElement> spouseIdNeedToFillErrorMessage;
    @FindBy(xpath = "//p[@class='error-msg' and contains(., 'השדה תעודת זהות בן/בת הזוג לא יכול להכיל יותר מ- 9 תווים')]")
    private List<WebElement> spouseIdTooLongErrorMessage;
    @FindBy(xpath = "//p[@class='error-msg' and contains(., 'חובה למלא את השדה מספר דרכון בן/בת הזוג')]")
    private List<WebElement> spousePassportNeedToFillErrorMessage;
    @FindBy(xpath = "//p[@class='error-msg' and contains(., 'מספר דרכון לא תקין')]")
    private List<WebElement> spousePassportIncorrectFormatErrorMessage;
    @FindBy(xpath = "//p[@class='error-msg' and contains(., 'השדה מספר דרכון בן/בת הזוג לא יכול להכיל יותר מ- 15 תווים')]")
    private List<WebElement> spousePassportTooLongErrorMessage;

    // == getters ==
    public List<WebElement> getPhoneFormatErrorMessage() {
        return phoneFormatErrorMessage;
    }

    public List<WebElement> getStandardErrorMessage() {
        return standardErrorMessage;
    }

    public List<WebElement> getEmailNeedToFillErrorMessage() {
        return emailNeedToFillErrorMessage;
    }

    public List<WebElement> getPhoneMissingErrorMessage() {
        return phoneMissingErrorMessage;
    }

    public List<WebElement> getCellularPhoneTooLongErrorMessage() {
        return cellularPhoneTooLongErrorMessage;
    }

    public List<WebElement> getLandlinesPhoneTooLongErrorMessage() {
        return landlinesPhoneTooLongErrorMessage;
    }

    public List<WebElement> getSpouseIdOnlyDigitalErrorMessage() {
        return spouseIdOnlyDigitalErrorMessage;
    }

    public List<WebElement> getSpouseIdNeedToFillErrorMessage() {
        return spouseIdNeedToFillErrorMessage;
    }

    public List<WebElement> getSpouseIdTooLongErrorMessage() {
        return spouseIdTooLongErrorMessage;
    }

    public List<WebElement> getSpousePassportNeedToFillErrorMessage() {
        return spousePassportNeedToFillErrorMessage;
    }

    public List<WebElement> getSpousePassportIncorrectFormatErrorMessage() {
        return spousePassportIncorrectFormatErrorMessage;
    }

    public List<WebElement> getSpousePassportTooLongErrorMessage() {
        return spousePassportTooLongErrorMessage;
    }




    // == public methods ==

    // menu icons
    public List<WebElement> getErrorIconMenu() {
        return getMenuPersonalDetails().findElements(errorIconSubElementMenu);
    }

    public List<WebElement> getCheckCircleIconMenu() {
        return getMenuPersonalDetails().findElements(checkCircleIconSubElementMenu);
    }

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

    public void deleteFirstName() {
        cleanFormField(txtFirstName);
    }

    public void enterLastName(String lastName) {
        fillFormField(txtLastName, lastName);

    }

    public void enterEmail(String email) {
        fillFormField(txtEmail, email);
    }

    public void deleteEmail() {
        cleanFormField(txtEmail);
    }

    public void enterCellular(String cellular) {
        fillFormField(txtCellular, cellular);
    }

    public void deleteCellular() {
        cleanFormField(txtCellular);
    }

    public void enterPhone(String phone) {
        fillFormField(txtPhone, phone);
    }

    public void deletePhone() {
        cleanFormField(txtPhone);
    }

    // resident
    public void chooseIsraeli() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsResident.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(driver, this);
    }

    public void chooseExpatriate() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsResident.get(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(driver, this);
    }

    // martial statuses
    public void chooseMaritalStatusBachelor() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(driver, this);
    }

    public void chooseMaritalStatusMarried() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(driver, this);
    }

    public void chooseMaritalStatusDivorced() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(driver, this);
    }

    public void chooseMaritalStatusWidow() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(driver, this);
    }

    public void chooseMaritalStatusSpousalAlliance() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(4));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(driver, this);
    }

    public void chooseMaritalStatusSeparated() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsMartialStatus.get(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

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
    public void chooseSpouseIsraeli() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsSpouseResident.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(driver, this);
    }


    public void chooseSpouseExpatriate() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnsSpouseResident.get(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(driver, this);
    }

    // for spouse expatriate only
    public void enterSpousePassport(String spousePassport) {
        fillFormField(txtSpousePassport, spousePassport);

    }

    public void deleteSpousePassport() {
        cleanFormField(txtSpousePassport);
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

    public void deleteSpouseState() {
        cleanFormField(txtSpouseState);
    }

    // for spouse Israeli only
    public void enterSpouseIdentity(String spouseIdentity) {
        fillFormField(txtSpouseIdentity, spouseIdentity);
    }

    public void deleteSpouseIdentity() {
        cleanFormField(txtSpouseIdentity);
    }

    // for separates only
    public void attachFileSeparated(String filename) {
        attachFileInput.sendKeys(filename);

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(this.driver, this);
    }

    public void clickDownloadLink() {
        downloadFileLink.click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    public void clickDownloadLinkAndReturn() {
        downloadFileLink.click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(0));

        PageFactory.initElements(driver, this);
    }

    public void clickDownloadLinkCheckSuffixAndReturn(String suffix) {
        downloadFileLink.click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));

        String url = driver.getCurrentUrl();
        AssertionsHarchavat.assertTextEndWithSubstring(url, suffix,
                String.format("URL '%s' does not end with a suffix '%s'", url, suffix));


        driver.switchTo().window(handles.get(0));

        PageFactory.initElements(driver, this);
    }

}

