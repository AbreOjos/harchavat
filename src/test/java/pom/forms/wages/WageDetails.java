package pom.forms.wages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.waitFewSecondsWarningDisabled;
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

    // wage details
    protected void chooseIsraelIncome() {
        if (elementHasClass(getBtnIsraelIncome(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnIsraelIncome());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseAbroadIncome() {
        if (elementHasClass(getBtnAbroadIncome(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnAbroadIncome());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    public void chooseCountryIsrael() {
        clickDropDownList(getDropDownCountry(), 0);
    }

    public void chooseCountryZambia() {
        clickDropDownList(getDropDownCountry(), 1);
    }

    public void chooseCountryUsa() {
        clickDropDownList(getDropDownCountry(), 2);
    }

    protected void enterState(String state) {
        fillFormField(getTxtState(), state);
    }

    protected void enterEmployerName(String employerName) {
        fillFormField(getTxtEmployerName(), employerName);

    }

    protected void enterTikNikuim(String tikNikuim) {
        fillFormField(getTxtTikNikuim(), tikNikuim);

    }

    protected void enterAnnualIncome(String annualIncome) {
        fillFormField(getTxtAnnualIncome(), annualIncome);

    }
}
