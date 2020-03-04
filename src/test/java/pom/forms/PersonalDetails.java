package pom.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.List;

import static constants.FillFormConstants.selectedSubElementDropDownLists;
import static utils.helpers.Waits.fluentWaitElementClickable;
import static utils.utilitiesForInfra.JavaScriptHelpersHarchavat.scrollIntoViewMoveFocusAndClickWithJavaScript;

public class PersonalDetails extends BasePage {

    // == constructors==
    public PersonalDetails(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
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
    @FindBy(name = "fatherName")
    private WebElement txtFatherName;
    @FindBy(name = "birthYear")
    private WebElement txtBirthYear;
    @FindBy(name = "aliyaYear")
    private WebElement txtAliyaYear;
    @FindBy(name = "email")
    private WebElement txtEmail;

    @FindBy(name = "phone")
    private WebElement txtPhone;
    @FindBy(name = "cellular")
    private WebElement txtCellular;
    @FindBy(name = "residency")
    private WebElement dropDownResidency;

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

    public WebElement getTxtFatherName() {
        return txtFatherName;
    }

    public WebElement getTxtBirthYear() {
        return txtBirthYear;
    }

    public WebElement getTxtAliyaYear() {
        return txtAliyaYear;
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

    public WebElement getDropDownResidency() {
        return dropDownResidency;
    }

    // == public methods ==

    // checkboxes check / uncheck
    public boolean isAgreementChecked() {
        return checkBoxes.get(0).getAttribute("aria-checked").equals("true");
    }

    public boolean isCanSendEmailChecked() {
        return checkBoxes.get(1).getAttribute("aria-checked").equals("true");
    }

    public PersonalDetails checkAgreement() throws InterruptedException {
        if (!isAgreementChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(0));

        return new PersonalDetails(driver);
    }

    public PersonalDetails uncheckAgreement() throws InterruptedException {
        if (isAgreementChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(0));

        return new PersonalDetails(driver);
    }

    public PersonalDetails checkCanSendEmail() throws InterruptedException {
        if (!isCanSendEmailChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(1));

        return new PersonalDetails(driver);
    }

    public PersonalDetails uncheckCanSendEmail() throws InterruptedException {
        if (isCanSendEmailChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(1));

        return new PersonalDetails(driver);
    }

    // personal details
    public PersonalDetails enterIdentity(String identity) {
        return fillFormField(txtIdentity, identity);
    }

    public PersonalDetails enterFirstName(String firstName) {
        return fillFormField(txtFirstName, firstName);

    }

    public PersonalDetails enterLastName(String lastName) {
        return fillFormField(txtLastName, lastName);

    }

    public PersonalDetails enterFatherName(String fatherName) {
        return fillFormField(txtFatherName, fatherName);

    }

    public PersonalDetails enterBirthYear(String birthYear) {
        return fillFormField(txtBirthYear, birthYear);
    }

    public PersonalDetails enterAliyaYear(String aliyaYear) {
        return fillFormField(txtAliyaYear, aliyaYear);

    }

    public PersonalDetails enterEmail(String email) {
        return fillFormField(txtEmail, email);

    }

    // martial statuses
    public void chooseMaritalStatusPolygamy() {

    }

    public void chooseMaritalStatusSpousalAlliance() {

    }

    public void chooseMaritalStatusWidow() {
    }

    public void chooseMaritalStatusFree() {

    }

    public void chooseMaritalStatusDivorced() {
    }

    public void chooseMaritalStatusMarried() {
    }

    public void chooseMaritalStatusBachelor() {
    }

    public String getChosenMaritalStatus() {
        return null;
    }

    // additional personal details
    public PersonalDetails enterPhone(String phone) {
        return fillFormField(txtPhone, phone);
    }

    public PersonalDetails enterCellular(String cellular) {
        return fillFormField(txtCellular, cellular);
    }

    // residency
    public void chooseResidencyExpatriate() {
        clickDropDownList(dropDownResidency, 0);
    }

    public void chooseResidencyIsraeli() {
        clickDropDownList(dropDownResidency, 1);
    }

    public String getChoosenResidency() {
        return dropDownResidency.findElement(selectedSubElementDropDownLists).getText();
    }


    // == private methods ==
    private PersonalDetails fillFormField(WebElement field, String text) {
        fluentWaitElementClickable(driver, field, 10);
        field.sendKeys(text);
        return new PersonalDetails(driver);
    }

}

