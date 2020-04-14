package pom.forms.wages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.*;
import static constants.WagesConstants.*;

public class WageDetails extends BasePage {

    private final WebElement details;

    public WageDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    protected WebElement getTxtEmployerName() {
        return details.findElement(txtEmployerNameSubElementDetails);
    }

    protected WebElement getTxtTikNikuim() {
        return details.findElement(txtTikNikuimSubElementDetals);
    }

    protected WebElement getTxtAnnualIncome() {
        return details.findElement(txtAnnualIncomeSubElementDetails);
    }

    protected WebElement getBtnIsraelIncome() {
        return details.findElement(btnIsraelIncomeSubElementDetails);
    }

    protected WebElement getBtnAbroadIncome() {
        return details.findElement(btnAbroadIncomeSubElementDetails);
    }

    protected WebElement getDropDownCountry() {
        return details.findElement(dropDownCountrySubElementDetails);
    }

    protected WebElement getTxtState() {
        return details.findElement(txtStateSubElementDetails);
    }

//    protected WebElement getTxtCity() {
//        return details.findElement(txtCitySubElementDetail);
//    }

//    protected WebElement getTxtStreet() {
//        return details.findElement(txtStreetSubElementDetails);
//    }

//    protected WebElement getTxtHouseNum() {
//        return details.findElement(txtHouseNumSubElementDetails);
//    }

    // wage details
    protected void chooseIsraelIncome() {
        if (israelIncomeChosen())
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnIsraelIncome());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseAbroadIncome() {
        if (abroadIncomeChosen())
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnAbroadIncome());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected boolean israelIncomeChosen() {
        return elementHasClass(getBtnIsraelIncome(), "active");
    }

    protected boolean abroadIncomeChosen() {
        return elementHasClass(getBtnAbroadIncome(), "active");
    }

    protected void chooseCountryIsrael() {
        clickDropDownList(getDropDownCountry(), 0);
    }

    protected void chooseCountryZambia() {
        clickDropDownList(getDropDownCountry(), 1);
    }

    protected void chooseCountryUsa() {
        clickDropDownList(getDropDownCountry(), 2);
    }

    protected String selectCountryFromDropDownListByIndex(int index) {
        return selectItemFromDropDownListByIndex(getDropDownCountry(), index);
    }

    protected void enterState(String state) {
        fillFormField(getTxtState(), state);
    }

    protected void deleteState() {
        cleanFormField(getTxtState());
    }

    protected void enterCity(String city) {
        fillFormField(getTxtCity(details), city);
    }

    protected void deleteCity() {
        cleanFormField(getTxtCity(details));
    }

    protected void selectCityFromDropDownListByName(String city) {
        selectItemFromDropDownListByName(getDropDownCity(details), city);
    }

    protected String selectCityFromDropDownListByIndex(int index) {
        return selectItemFromDropDownListByIndex(getDropDownCity(details), index);
    }

    protected void selectStreetFromDropDownListByName(String street) {
        selectItemFromDropDownListByName(getDropDownStreet(details), street);
    }

    protected String selectStreetFromDropDownListByIndex(int index) {
        return selectItemFromDropDownListByIndex(getDropDownStreet(details), index);
    }

    protected void enterStreet(String street) {
        fillFormField(getTxtStreet(details), street);
    }

    protected void deleteStreet() {
        cleanFormField(getTxtStreet(details));
    }

    protected void enterHouseNum(String houseNum) {
        fillFormField(getTxtHouseNum(details), houseNum);
    }

    protected void deleteHouseNum() {
        cleanFormField(getTxtHouseNum(details));
    }

    protected void enterEmployerName(String employerName) {
        fillFormField(getTxtEmployerName(), employerName);

    }

    protected void deleteEmployerName() {
        cleanFormField(getTxtEmployerName());
    }

    protected void enterTikNikuim(String tikNikuim) {
        fillFormField(getTxtTikNikuim(), tikNikuim);

    }

    protected void deleteTikNikuim() {
        cleanFormField(getTxtTikNikuim());
    }

    protected void enterAnnualIncome(String annualIncome) {
        fillFormField(getTxtAnnualIncome(), annualIncome);
    }

    protected void deleteAnnualIncome() {
        cleanFormField(getTxtAnnualIncome());
    }

    // error messages
    protected List<WebElement> getErrorMessageNeedFillTypeIncome() {
        return details.findElements(errorMessageNeedFillTypeIncomeSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillAnnualIncome() {
        return details.findElements(errorMessageNeedFillAnnualIncomeSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillEmployerName() {
        return details.findElements(errorMessageNeedFillEmployerNameSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillCity() {
        return details.findElements(errorMessageNeedFillCitySubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillStreet() {
        return details.findElements(errorMessageNeedFillStreetSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillHouseNumber() {
        return details.findElements(errorMessageNeedFillHouseNumberSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillTikNikuim() {
        return details.findElements(errorMessageNeedFillTikNikuimSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillCountry() {
        return details.findElements(errorMessageNeedFillCountrySubElementDetails);
    }

    protected List<WebElement> getErrorMessageTikNikuimNeedBeNineDigits() {
        return details.findElements(errorMessageTikNikuimNeedBeNineDigitsSubElementDetails);
    }

    protected List<WebElement> getErrorMessageTikNikuimCannotBeLongerNineDigits() {
        return details.findElements(errorMessageTikNikuimCannotBeLongerNineDigitsSubElementDetails);
    }

    protected List<WebElement> getErrorMessageTikNikuimTikNikuimCanContainDigitsOnly() {
        return details.findElements(errorMessageTikNikuimCanContainDigitsOnlySubElementDetails);
    }
}
