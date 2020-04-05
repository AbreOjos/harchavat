package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
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

    protected void enterState(String state) {
        fillFormField(getTxtState(details), state);
    }

    protected void enterCompanyNum(String companyNum) {
        fillFormField(getTxtCompanyNum(), companyNum);
    }

    protected void enterCompanyPercentage(String companyPercentage) {
        fillFormField(getTxtCompanyPercentage(), companyPercentage);
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
