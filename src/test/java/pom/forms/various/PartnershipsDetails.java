package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.waitFewSecondsWarningDisabled;
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

    protected void enterOsekNum(String osekNum) {
        fillFormField(getTxtOsekNum(), osekNum);
    }

    protected void deleteOsekNum() {
        cleanFormField(getTxtOsekNum());
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

    private WebElement getTxtOsekNum() {
        return details.findElement(txtOsekNumSubElementPartnershipsDetails);
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
