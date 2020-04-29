package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.errorMessageNeedFillCountrySubElementDetails;
import static constants.BaseConstants.waitFewSecondsWarningDisabled;
import static constants.VariousConstants.*;

public class StocksDetails extends BasePage {

    private final WebElement details;

    public StocksDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }


    // == protected methods ==
    protected void enterCompanyName(String companyName) {
        fillFormField(getTxtCompanyName(), companyName);
    }

    protected void deleteCompanyName() {
        cleanFormField(getTxtCompanyName());
    }

    protected void chooseCompanySourceIsrael() {
        if (elementHasClass(getBtnCompanySourceIsrael(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnCompanySourceIsrael());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseCompanySourceOversea() {
        if (elementHasClass(getBtnCompanySourceOversea(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnCompanySourceOversea());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void selectCountryFromDropDownListByName(String country) {
        selectItemFromDropDownListByName(getDropDownCountry(), country);
    }

    protected String selectCountryFromDropDownListByIndex(int index) {
        return selectItemFromDropDownListByIndex(getDropDownCountry(), index);
    }

    protected void enterState(String state) {
        fillFormField(getTxtState(details), state);
    }

    protected void deleteState() {
        cleanFormField(getTxtState(details));
    }

    protected void enterCompanyNum(String companyNum) {
        fillFormField(getTxtCompanyNum(), companyNum);
    }

    protected void deleteCompanyNum() {
        cleanFormField(getTxtCompanyNum());
    }

    protected void enterCompanyPercentage(String companyPercentage) {
        fillFormField(getTxtCompanyPercentage(), companyPercentage);
    }

    protected void deleteCompanyPercentage() {
        cleanFormField(getTxtCompanyPercentage());
    }

    // error messages
    protected List<WebElement> getNeedFillCompanyNameErrorMessage() {
        return details.findElements(errorMessageNeedFillCompanyNameSubElementDetails);
    }

    protected List<WebElement> getNeedFillCompanySourceErrorMessage() {
        return details.findElements(errorMessageNeedFillCompanySourceSubElementDetails);
    }

    protected List<WebElement> getNeedFillCompanyNumErrorMessage() {
        return details.findElements(errorMessageNeedFillCompanyNumSubElementDetails);
    }

    protected List<WebElement> getNeedFillCompanyPercentageErrorMessage() {
        return details.findElements(errorMessageNeedFillCompanyPercentageSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillCountry() {
        return details.findElements(errorMessageNeedFillCountrySubElementDetails);
    }

    protected List<WebElement> getCompanyNameContainsCharactersErrorMessage() {
        return details.findElements(errorMessageCompanyNameContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getCompanyNumContainsCharactersErrorMessage() {
        return details.findElements(errorMessageCompanyNumContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getPercentageOneHundredMaxErrorMessage() {
        return details.findElements(errorMessagePercentageOneHundredMaxSubElementDetails);
    }

    protected List<WebElement> getPercentageOneMinErrorMessage() {
        return details.findElements(errorMessagePercentageOneMinSubElementDetails);
    }

    protected List<WebElement> getCompanyNumDigitsOnlyErrorMessage() {
        return details.findElements(errorMessageCompanyNumDigitsOnlySubElementDetails);
    }

    protected List<WebElement> getCompanyNumNineDigitsMinErrorMessage() {
        return details.findElements(errorMessageCompanyNumNineDigitsMinSubElementDetails);
    }

    protected List<WebElement> getCompanyNumNineDigitsMaxErrorMessage() {
        return details.findElements(errorMessageCompanyNumNineDigitsMaxSubElementDetails);
    }


    // == private methods ==
    private WebElement getTxtCompanyName() {
        return details.findElement(txtCompanyNameSubElementStocksDetails);
    }

    private WebElement getBtnCompanySourceIsrael() {
        return details.findElements(btnsCompanySourceSubElementStocksDetails).get(0);
    }

    private WebElement getBtnCompanySourceOversea() {
        return details.findElements(btnsCompanySourceSubElementStocksDetails).get(1);
    }

    private WebElement getDropDownCountry() {
        return details.findElement(dropDownCountrySubElementStocksDetails);
    }

//    private WebElement getTxtState() {
//        return details.findElement(txtStateSubElementStocksDetails);
//    }

    private WebElement getTxtCompanyNum() {
        return details.findElement(txtCompanyNumSubElementStocksDetails);
    }

    private WebElement getTxtCompanyPercentage() {
        return details.findElement(txtCompanyPercentageSubElementStocksDetails);
    }

}
