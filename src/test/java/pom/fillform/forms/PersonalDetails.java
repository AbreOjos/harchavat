package pom.fillform.forms;

import automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.fillform.FillForm;

import java.util.List;

import static utils.helpers.Waits.fluentWaitElementClickable;

public class PersonalDetails extends FillForm {

    // == constructors==
    public PersonalDetails(WebDriver driver) {
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
    @FindBy(name = "maritalStatus")
    private WebElement dropDownMaritalStatus;
    @FindBy(name = "email")
    private WebElement txtEmail;

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

    public WebElement getDropDownMaritalStatus() {
        return dropDownMaritalStatus;
    }

    public WebElement getTxtEmail() {
        return txtEmail;
    }


    // == public methods ==

    // checkboxes check / uncheck
    public boolean isAgreementChecked() {
        return checkBoxes.get(0).getAttribute("aria-checked").equals("true");
    }

    public boolean isCanSendEmailChecked() {
        return checkBoxes.get(1).getAttribute("aria-checked").equals("true");
    }

    public boolean isHaveSpouseChecked() {
        return checkBoxes.get(2).getAttribute("aria-checked").equals("true");
    }

    public boolean isSpouseIsraeliChecked() {
        return checkBoxes.get(3).getAttribute("aria-checked").equals("true");
    }

    public PersonalDetails checkAgreement() {
        if (!isAgreementChecked())
            JavascriptExecutors.clickElementWithJavaScript(driver, checkBoxes.get(0));

        return new PersonalDetails(driver);
    }

    public PersonalDetails uncheckAgreement() {
        if (isAgreementChecked())
            JavascriptExecutors.clickElementWithJavaScript(driver, checkBoxes.get(0));

        return new PersonalDetails(driver);
    }

    public PersonalDetails checkCanSendEmail() {
        if (!isCanSendEmailChecked())
            JavascriptExecutors.clickElementWithJavaScript(driver, checkBoxes.get(1));

        return new PersonalDetails(driver);
    }

    public PersonalDetails uncheckCanSendEmail() {
        if (isCanSendEmailChecked())
            JavascriptExecutors.clickElementWithJavaScript(driver, checkBoxes.get(1));

        return new PersonalDetails(driver);
    }

    public PersonalDetails checkHaveSpouse() {
        if (!isHaveSpouseChecked())
            JavascriptExecutors.clickElementWithJavaScript(driver, checkBoxes.get(2));

        return new PersonalDetails(driver);
    }

    public PersonalDetails uncheckHaveSpouse() {
        if (isHaveSpouseChecked())
            JavascriptExecutors.clickElementWithJavaScript(driver, checkBoxes.get(2));

        return new PersonalDetails(driver);
    }

    public PersonalDetails checkSpouseIsraeli() {
        if (!isSpouseIsraeliChecked())
            JavascriptExecutors.clickElementWithJavaScript(driver, checkBoxes.get(3));

        return new PersonalDetails(driver);
    }

    public PersonalDetails uncheckSpouseIsraeli() {
        if (isSpouseIsraeliChecked())
            JavascriptExecutors.clickElementWithJavaScript(driver, checkBoxes.get(3));

        return new PersonalDetails(driver);
    }

    // personal details
    public void enterIdentity(String identity) {
        fluentWaitElementClickable(driver, txtIdentity, 10);
        txtIdentity.sendKeys(identity);
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        fluentWaitElementClickable(driver, txtFirstName, 10);
        txtFirstName.sendKeys(firstName);
        PageFactory.initElements(driver, this);
    }

    public void enterLastName(String lastName) {
        fluentWaitElementClickable(driver, txtLastName, 10);
        txtLastName.sendKeys(lastName);
        PageFactory.initElements(driver, this);
    }

    public void enterFatherName(String fatherName) {
        fluentWaitElementClickable(driver, txtFatherName, 10);
        txtFatherName.sendKeys(fatherName);
        PageFactory.initElements(driver, this);
    }

    public void enterBirthYear(String birthYear) {
        fluentWaitElementClickable(driver, txtBirthYear, 10);
        txtBirthYear.sendKeys(birthYear);
        PageFactory.initElements(driver, this);
    }

    public void enterAliyaYear(String aliyaYear) {
        fluentWaitElementClickable(driver, txtAliyaYear, 10);
        txtAliyaYear.sendKeys(aliyaYear);
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        fluentWaitElementClickable(driver, txtEmail, 10);
        txtEmail.sendKeys(email);
        PageFactory.initElements(driver, this);
    }


}

