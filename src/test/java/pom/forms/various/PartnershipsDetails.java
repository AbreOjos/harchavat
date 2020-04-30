package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.*;
import static constants.VariousConstants.*;

public class PartnershipsDetails extends BasePage {

    private final WebElement details;

    public PartnershipsDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    protected void enterName(String name) {
        fillFormField(getTxtName(), name);
    }

    protected void deleteName() {
        cleanFormField(getTxtName());
    }

    protected void choosePartnershipLocationIsrael() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnPartnershipLocationIsrael());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void choosePartnershipLocationOversea() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnPartnershipLocationOversea());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void enterBusinessNum(String osekNum) {
        fillFormField(getTxtBusinessNum(), osekNum);
    }

    protected void deleteBusinessNum() {
        cleanFormField(getTxtBusinessNum());
    }

    protected void enterPercentage(String percentage) {
        fillFormField(getTxtPercentage(), percentage);
    }

    protected void deletePercentage() {
        cleanFormField(getTxtPercentage());
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

    // error messages
    protected List<WebElement> getNeedFillNameErrorMessage() {
        return details.findElements(errorMessageNeedFillNameSubElementDetails);
    }

    protected List<WebElement> getNeedFillPartnershipLocationErrorMessage() {
        return details.findElements(errorMessageNeedFillPartnershipLocationSubElementDetails);
    }

    protected List<WebElement> getNeedFillBusinessNumErrorMessage() {
        return details.findElements(errorMessageNeedFillBusinessNumSubElementDetails);
    }

    protected List<WebElement> getNeedFillPercentageErrorMessage() {
        return details.findElements(errorMessageNeedFillPercentageSubElementDetails);
    }

    protected List<WebElement> getNeedFillCountryErrorMessage() {
        return details.findElements(errorMessageNeedFillCountrySubElementDetails);
    }

    protected List<WebElement> getBusinessNumDigitsOnlyErrorMessage() {
        return details.findElements(errorMessageBusinessNumDigitsOnlySubElementDetails);
    }

    protected List<WebElement> getBusinessNumNineDigitsMinErrorMessage() {
        return details.findElements(errorMessageBusinessNumNineDigitsMinSubElementDetails);
    }

    protected List<WebElement> getBusinessNumNineDigitsMaxErrorMessage() {
        return details.findElements(errorMessageBusinessNumNineDigitsMaxSubElementDetails);
    }

    protected List<WebElement> getPercentageOneHundredMaxErrorMessage() {
        return details.findElements(errorMessagePercentageOneHundredMaxSubElementDetails);
    }

    protected List<WebElement> getPercentageOneMinErrorMessage() {
        return details.findElements(errorMessagePercentageOneMinSubElementDetails);
    }

    protected List<WebElement> getPercentageThreeCharsMaxErrorMessage() {
        return details.findElements(errorMessagePercentageThreeCharsMaxSubElementDetails);
    }

    protected List<WebElement> getNameContainsCharactersErrorMessage() {
        return details.findElements(errorMessageNameContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getStateContainsCharactersErrorMessage() {
        return details.findElements(errorMessageStateContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getBusinessNumContainsCharactersErrorMessage() {
        return details.findElements(errorMessageBusinessNumContainsCharactersSubElementDetails);
    }


    // == private methods ==
    private WebElement getTxtName() {
        return details.findElement(txtNameSubElementPartnershipsDetails);
    }

    private WebElement getBtnPartnershipLocationIsrael() {
        return details.findElements(btnsPartnershipLocationSubElementPartnershipsDetails).get(0);
    }

    private WebElement getBtnPartnershipLocationOversea() {
        return details.findElements(btnsPartnershipLocationSubElementPartnershipsDetails).get(1);
    }

    private WebElement getTxtBusinessNum() {
        return details.findElement(txtBusinessNumSubElementPartnershipsDetails);
    }

    private WebElement getTxtPercentage() {
        return details.findElement(txtPercentageSubElementPartnershipsDetails);
    }

    private WebElement getDropDownCountry() {
        return details.findElement(dropDownCountrySubElementPartnershipsDetails);
    }

//    private WebElement getTxtState() {
//        return details.findElement(txtStateSubElementPartnershipsDetails);
//    }


}
