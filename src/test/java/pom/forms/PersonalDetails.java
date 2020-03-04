package pom.forms;

import com.mysql.cj.exceptions.WrongArgumentException;
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
    @FindBy(name = "maritalStatus")
    private WebElement dropDownMaritalStatus;
    @FindBy(name = "email")
    private WebElement txtEmail;

    @FindBy(name = "phone")
    private WebElement txtPhone;
    @FindBy(name = "cellular")
    private WebElement txtCellular;
    @FindBy(name = "numOfChildren")
    private WebElement dropDonwNumOfChildren;
    @FindBy(name = "residency")
    private WebElement dropDownResidency;
    @FindBy(name = "registeredSelection")
    private WebElement dropDownRegisteredSelection;

    @FindBy(name = "spouseIdentity")
    private WebElement txtSpouseIdentity;
    @FindBy(name = "spousePassport")
    private WebElement txtSpousePassport;
    @FindBy(name = "spouseCountry")
    private WebElement txtSpouseCountry;
    @FindBy(name = "spousePrevLastName")
    private WebElement txtSpousePrevLastName;
    @FindBy(name = "spouseFirstName")
    private WebElement txtSpouseFirstName;
    @FindBy(name = "spouseLastName")
    private WebElement txtSpouseLastName;
    @FindBy(name = "spouseBirthYear")
    private WebElement txtSpouseBirthYear;
    @FindBy(name = "spouseAliyaYear")
    private WebElement txtSpouseAliyaYear;


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

    public WebElement getTxtPhone() {
        return txtPhone;
    }

    public WebElement getTxtCellular() {
        return txtCellular;
    }

    public WebElement getDropDonwNumOfChildren() {
        return dropDonwNumOfChildren;
    }

    public WebElement getDropDownResidency() {
        return dropDownResidency;
    }

    public WebElement getDropDownRegisteredSelection() {
        return dropDownRegisteredSelection;
    }

    public WebElement getTxtSpouseIdentity() {
        return txtSpouseIdentity;
    }

    public WebElement getTxtSpousePassport() {
        return txtSpousePassport;
    }

    public WebElement getTxtSpouseCountry() {
        return txtSpouseCountry;
    }

    public WebElement getTxtSpousePrevLastName() {
        return txtSpousePrevLastName;
    }

    public WebElement getTxtSpouseFirstName() {
        return txtSpouseFirstName;
    }

    public WebElement getTxtSpouseLastName() {
        return txtSpouseLastName;
    }

    public WebElement getTxtSpouseBirthYear() {
        return txtSpouseBirthYear;
    }

    public WebElement getTxtSpouseAliyaYear() {
        return txtSpouseAliyaYear;
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

    public PersonalDetails checkHaveSpouse() throws InterruptedException {
        if (!isHaveSpouseChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(2));

        return new PersonalDetails(driver);
    }

    public PersonalDetails uncheckHaveSpouse() throws InterruptedException {
        if (isHaveSpouseChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(2));

        return new PersonalDetails(driver);
    }

    public PersonalDetails checkSpouseIsraeli() throws InterruptedException {
        if (!isSpouseIsraeliChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(3));

        return new PersonalDetails(driver);
    }

    public PersonalDetails uncheckSpouseIsraeli() throws InterruptedException {
        if (isSpouseIsraeliChecked())
            scrollIntoViewMoveFocusAndClickWithJavaScript(driver, checkBoxes.get(3));

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
        clickDropDownList(dropDownMaritalStatus, 0);
    }

    public void chooseMaritalStatusSpousalAlliance() {
        clickDropDownList(dropDownMaritalStatus, 1);
    }

    public void chooseMaritalStatusWidow() {
        clickDropDownList(dropDownMaritalStatus, 2);
    }

    public void chooseMaritalStatusFree() {
        clickDropDownList(dropDownMaritalStatus, 3);
    }

    public void chooseMaritalStatusDivorced() {
        clickDropDownList(dropDownMaritalStatus, 4);
    }

    public void chooseMaritalStatusMarried() {
        clickDropDownList(dropDownMaritalStatus, 5);
    }

    public void chooseMaritalStatusBachelor() {
        clickDropDownList(dropDownMaritalStatus, 6);
    }

    public String getChoosenMaritalStatus() {
        return dropDownMaritalStatus.findElement(selectedSubElementDropDownLists).getText();
    }

    // additional personal details
    public PersonalDetails enterPhone(String phone) {
        return fillFormField(txtPhone, phone);
    }

    public PersonalDetails enterCellular(String cellular) {
        return fillFormField(txtCellular, cellular);
    }

    // num of children
    public void chooseNumOfChildren(int numOfChildren) {
        if (numOfChildren < 0 || numOfChildren > 20)
            throw new WrongArgumentException(
                    String.format("Choose number of children between 0 and 20 (your choice is %d)", numOfChildren));

        clickDropDownList(dropDonwNumOfChildren, numOfChildren);
    }

    public String getChoosenNumberOfChildren() {
        return dropDonwNumOfChildren.findElement(selectedSubElementDropDownLists).getText();
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

    // registered selection
    public void chooseRegisteredSelectionSpouse() {
        clickDropDownList(dropDownRegisteredSelection, 0);
    }

    public void chooseRegisteredSelectionFillForm() {
        clickDropDownList(dropDownRegisteredSelection, 1);
    }

    public String getChoosenRegisterySelection() {
        return dropDownRegisteredSelection.findElement(selectedSubElementDropDownLists).getText();
    }

    // spouse personal details
    public PersonalDetails enterSpouseIdentity(String spouseIdentity) {
        return fillFormField(txtSpouseIdentity, spouseIdentity);
    }

    public PersonalDetails enterSpousePassport(String spousePassport) {
        return fillFormField(txtSpousePassport, spousePassport);
    }

    public PersonalDetails enterSpouseCountry(String spouseCountry) {
        return fillFormField(txtSpouseCountry, spouseCountry);
    }

    public PersonalDetails enterSpousePrevLastName(String spousePrevLastName) {
        return fillFormField(txtSpousePrevLastName, spousePrevLastName);
    }

    public PersonalDetails enterSpouseFirstName(String spouseFirstName) {
        return fillFormField(txtSpouseFirstName, spouseFirstName);
    }

    public PersonalDetails enterSpouseLastName(String spouseLastName) {
        return fillFormField(txtSpouseLastName, spouseLastName);
    }

    public PersonalDetails enterSpouseBirthYear(String spouseBirthYear) {
        return fillFormField(txtSpouseBirthYear, spouseBirthYear);
    }

    public PersonalDetails enterSpouseAliyaYear(String spouseAliyaYear) {
        return fillFormField(txtSpouseAliyaYear, spouseAliyaYear);
    }


    // == private methods ==
    private PersonalDetails fillFormField(WebElement field, String text) {
        fluentWaitElementClickable(driver, field, 10);
        field.sendKeys(text);
        return new PersonalDetails(driver);
    }

}

