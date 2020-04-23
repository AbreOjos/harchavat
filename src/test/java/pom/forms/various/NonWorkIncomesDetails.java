package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.*;
import static constants.VariousConstants.*;

public class NonWorkIncomesDetails extends BasePage {

    private final WebElement details;

    public NonWorkIncomesDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==

    // choose type of income
    protected void chooseIncomeIsraeli() {
        if (incomeIsraeliChosen())
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnIncomeIsraeli());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseIncomeOversea() {
        if (incomeOverseaChosen())
            return;
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnIncomeOversea());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected boolean incomeIsraeliChosen() {
        return elementHasClass(getBtnIncomeIsraeli(), "active");
    }

    protected boolean incomeOverseaChosen() {
        return elementHasClass(getBtnIncomeOversea(), "active");
    }

    protected void enterIncomeSource(String incomeSource) {
        fillFormField(getTxtIncomeSource(), incomeSource);
    }

    protected void deleteIncomeSource() {
        cleanFormField(getTxtIncomeSource());
    }

    protected void enterAnnualIncome(String annualIncome) {
        fillFormField(getTxtAnnualIncome(), annualIncome);
    }

    protected void deleteAnnualIncome() {
        cleanFormField(getTxtAnnualIncome());
    }

    protected void enterPayerName(String payerName) {
        fillFormField(getTxtPayerName(), payerName);
    }

    protected void deletePayerName() {
        cleanFormField(getTxtPayerName());
    }

    protected void enterTikNikuim(String tikNikuim) {
        fillFormField(getTxtTikNikuim(), tikNikuim);
    }

    protected void deleteTikNikuim() {
        cleanFormField(getTxtTikNikuim());
    }

    protected void selectCityFromDropDownListByName(String city) {
        selectItemFromDropDownListByName(getDropDownCity(details), city);
    }

    protected String selectCityFromDropDownListByIndex(int index) {
        return selectItemFromDropDownListByIndex(getDropDownCity(details), index);
    }

    protected void enterCity(String city) {
        fillFormField(getTxtCity(details), city);
    }

    protected void deleteCity() {
        cleanFormField(getTxtCity(details));
    }

    protected void selectStreetFromDropDownListByName(String street) {
        selectItemFromDropDownListByName(getDropDownStreet(), street);
    }

    protected String selectStreetFromDropDownListByIndex(int index) {
        return selectItemFromDropDownListByIndex(getDropDownStreet(), index);
    }

    protected void enterStreet(String street) {
        fillFormField(getTxtStreet(details), street);
    }

    protected void deleteStreet() {
        cleanFormField(getTxtStreet(details));
    }

    protected void selectCountryFromDropDownListByName(String country) {
        selectItemFromDropDownListByName(getDropDownCountry(), country);
    }

    protected String selectCountryFromDropDownListByIndex(int index) {
        return selectItemFromDropDownListByIndex(getDropDownCountry(), index);
    }

    protected void enterHouseNum(String houseNum) {
        fillFormField(getTxtHouseNum(details), houseNum);
    }

    protected void deleteHouseNum() {
        cleanFormField(getTxtHouseNum(details));
    }

    protected void enterState(String state) {
        fillFormField(getTxtState(details), state);
    }

    protected void deleteState() {
        cleanFormField(getTxtState(details));
    }

    // error messages
    protected List<WebElement> getNeedFillIncomeTypeErrorMessage() {
        return  details.findElements(errorMessageNeedFillTypeIncomeSubElementDetails);
    }

    protected List<WebElement> getNeedFillIncomeSourceErrorMessage() {
        return  details.findElements(errorMessageNeedFillIncomeSourceSubElementDetails);
    }

    protected List<WebElement> getNeedFillAnnualIncomeErrorMessage() {
        return  details.findElements(errorMessageNeedFillAnnualIncomeSubElementDetails);
    }

    protected List<WebElement> getNeedFillPayerNameErrorMessage() {
        return  details.findElements(errorMessageNeedFillPayerNameSubElementDetails);
    }

    protected List<WebElement> getNeedFillITikNikuimErrorMessage() {
        return  details.findElements(errorMessageNeedFillTikNikuimSubElementDetails);
    }

    protected List<WebElement> getNeedFillCityErrorMessage() {
        return  details.findElements(errorMessageNeedFillCitySubElementDetails);
    }

    protected List<WebElement> getNeedFillStreetErrorMessage() {
        return  details.findElements(errorMessageNeedFillStreetSubElementDetails);
    }

    protected List<WebElement> getNeedFillHouseNumErrorMessage() {
        return  details.findElements(errorMessageNeedFillHouseNumberSubElementDetails);
    }

    protected List<WebElement> getNeedFillCountryErrorMessage() {
        return  details.findElements(errorMessageNeedFillCountrySubElementDetails);
    }

    protected List<WebElement> getAnnualIncomeTwentyCharsMaxErrorMessage() {
        return  details.findElements(errorMessageAnnualIncomeTwentyCharsMaxSubElementDetails);
    }

    protected List<WebElement> getCityFifteenCharsMaxErrorMessage() {
        return  details.findElements(errorMessageCityFifteenCharsMaxSubElementDetails);
    }

    protected List<WebElement> getStreetFifteenCharsMaxErrorMessage() {
        return  details.findElements(errorMessageStreetFifteenCharsMaxSubElementDetails);
    }

    protected List<WebElement> getIncomeSourceContainsCharactersErrorMessage() {
        return  details.findElements(errorMessageIncomeSourceContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getPayerNameContainsCharactersErrorMessage() {
        return  details.findElements(errorMessagePayerNameContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getTikNikuimCanContainDigitsOnlyErrorMessage() {
        return  details.findElements(errorMessageTikNikuimCanContainDigitsOnlySubElementDetails);
    }

    protected List<WebElement> getHouseNumContainsCharactersErrorMessage() {
        return  details.findElements(errorMessageHouseNumberContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getStateContainsCharactersErrorMessage() {
        return details.findElements(errorMessageStateContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getCityContainsCharactersErrorMessage() {
        return details.findElements(errorMessageCityContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getStreetContainsCharactersErrorMessage() {
        return details.findElements(errorMessageStreetContainsCharactersSubElementDetails);
    }



    // == private methods ==
    private WebElement getBtnIncomeIsraeli() {
        return details.findElements(btnsTypeOfIncomeSubElementNonWorkIncomesDetails).get(0);
    }

    private WebElement getBtnIncomeOversea() {
        return details.findElements(btnsTypeOfIncomeSubElementNonWorkIncomesDetails).get(1);
    }

    private WebElement getTxtIncomeSource() {
        return details.findElement(txtIncomeSourceSubElementNonWorkIncomesDetails);
    }

    private WebElement getTxtAnnualIncome() {
        return details.findElement(txtAnnualIncomeSubElementNonWorkIncomesDetails);
    }

    private WebElement getTxtPayerName() {
        return details.findElement(txtPayerNameSubElementNonWorkIncomesDetails);
    }

    private WebElement getTxtTikNikuim() {
        return details.findElement(txtTikNikuimSubElementNonWorkIncomesDetails);
    }

    private WebElement getDropDownStreet() {
        return details.findElement(dropDownStreetSubElementNonWorkIncomesDetails);
    }

    private WebElement getDropDownCountry() {
        return details.findElement(dropDownCountrySubElementNonWorkIncomesDetails);
    }

}
