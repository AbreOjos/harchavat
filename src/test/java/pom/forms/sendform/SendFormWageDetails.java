package pom.forms.sendform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import static constants.SendFormConstants.*;

public class SendFormWageDetails extends BasePage {

    // == private members ==
    private final WebElement details;

    // == constructors ==
    public SendFormWageDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    protected boolean wageContainsText(String text) {
        return subElementContainsText(details, text);
    }

    protected boolean typeIncomeExists() {
        return details.findElements(typeIncomeSubElementWagesList).size() > 0;
    }

    protected boolean annualIncomeExists() {
        return details.findElements(annualIncomeSubElementWagesList).size() > 0;
    }

    protected boolean employerNameExists() {
        return details.findElements(employerNameSubElementWagesList).size() > 0;
    }

    protected boolean citySubExists() {
        return details.findElements(citySubElementWagesList).size() > 0;
    }

    protected boolean streetIncomeExists() {
        return details.findElements(streetIncomeSubElementWagesList).size() > 0;
    }

    protected boolean houseNumberExists() {
        return details.findElements(houseNumberIncomeSubElementWagesList).size() > 0;
    }

    protected boolean tikNikuimExists() {
        return details.findElements(tikNikuimSubElementWagesList).size() > 0;
    }

    protected boolean countryExists() {
        return details.findElements(countrySubElementWagesList).size() > 0;
    }

    protected boolean stateExists() {
        return details.findElements(stateSubElementWagesList).size() > 0;
    }

}
