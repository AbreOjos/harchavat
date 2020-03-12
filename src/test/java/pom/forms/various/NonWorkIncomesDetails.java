package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.waitFewSecondsWarningDisabled;
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
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnIncomeIsraeli());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseIncomeOversea() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnIncomeOversea());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void enterIncomeSource(String incomeSource) {
        fillFormField(getTxtIncomeSource(), incomeSource);
    }

    protected void enterYearlyIncome(String yearlyIncome) {
        fillFormField(getTxtYearlyIncome(), yearlyIncome);
    }

    protected void enterPayerName(String payerName) {
        fillFormField(getTxtPayerName(), payerName);
    }

    protected void enterTikNikuim(String tikNikuim) {
        fillFormField(getTxtTikNikuim(), tikNikuim);
    }

    protected void selectCityFromDropDownListByName(String city) {
        selectItemFromDropDownListByName(getDropDownCity(), city);
    }

    protected void selectStreetFromDropDownListByName(String street) {
        selectItemFromDropDownListByName(getDropDownStreet(), street);
    }

    protected void selectCountryFromDropDownListByName(String country) {
        selectItemFromDropDownListByName(getDropDownCountry(), country);
    }

    protected void enterHouseNum(String houseNum) {
        fillFormField(getTxtHouseNum(), houseNum);
    }

    protected void enterState(String state) {
        fillFormField(getTxtState(), state);
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

    private WebElement getTxtYearlyIncome() {
        return details.findElement(txtYearlyIncomeSubElementNonWorkIncomesDetails);
    }

    private WebElement getTxtPayerName() {
        return details.findElement(txtPayerNameSubElementNonWorkIncomesDetails);
    }

    private WebElement getTxtTikNikuim() {
        return details.findElement(txtTikNikuimSubElementNonWorkIncomesDetails);
    }

    private WebElement getDropDownCity() {
        return details.findElement(dropDownCitySubElementNonWorkIncomesDetails);
    }

    private WebElement getDropDownStreet() {
        return details.findElement(dropDownStreetSubElementNonWorkIncomesDetails);
    }

    private WebElement getDropDownCountry() {
        return details.findElement(dropDownCountrySubElementNonWorkIncomesDetails);
    }

    private WebElement getTxtHouseNum() {
        return details.findElement(txtHouseNumSubElementNonWorkIncomesDetails);
    }

    private WebElement getTxtState() {
        return details.findElement(txtStateSubElementNonWorkIncomesDetails);
    }

}
