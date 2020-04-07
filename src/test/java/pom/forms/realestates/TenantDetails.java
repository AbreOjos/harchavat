package pom.forms.realestates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.waitFewSecondsWarningDisabled;
import static constants.RealEstateConstants.*;

public class TenantDetails extends BasePage {
    private final WebElement details;

    // == constructors ==
    public TenantDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }


    // == protected methods ==

    // choose tenant origin
    protected void chooseTenantFromIsrael() {
        if (elementHasClass(getBtnRentIsraeli(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRentIsraeli());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseTenantFromAbroad() {
        if (elementHasClass(getBtnRentAbroad(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRentAbroad());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void enterTenantId(String tenantId) {
        fillFormField(getTxtRenterId(), tenantId);
    }

    protected void selectCountryTenantFromDropDownListByName(String countryTenant) {
        selectItemFromDropDownListByName(getDropDownCountryRenter(), countryTenant);
    }

    protected void enterTenantState(String tenantState) {
        fillFormField(getTxtRenterState(), tenantState);
    }

    protected void enterTenantPassport(String tenantPassport) {
        fillFormField(getTxtRenterPassport(), tenantPassport);
    }

    // == private methods ==
    private WebElement getBtnRentIsraeli() {
        return details.findElement(btnRentIsraeliSubElementTenant);
    }

    private WebElement getBtnRentAbroad() {
        return details.findElement(btnRentAbroadSubElementTenant);
    }

    private WebElement getTxtRenterId() {
        return details.findElement(txtRenterIdSubElementTenant);
    }

    private WebElement getDropDownCountryRenter() {
        return details.findElement(dropDownCountryRenterSubElementTenant);
    }

    private WebElement getTxtRenterState() {
        return details.findElement(txtRenterStateSubElementTenant);
    }

    private WebElement getTxtRenterPassport() {
        return details.findElement(txtRenterPassportSubElementTenant);
    }
}
