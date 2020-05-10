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
    protected boolean typeIncomeSpouseExists() {
        return details.findElements(typeIncomeSubElementWagesSpouseList).size() > 0;
    }

    protected boolean annualIncomeExists() {
        return details.findElements(annualIncomeSubElementWagesList).size() > 0;
    }

    protected boolean annualIncomeSpouseExists() {
        return details.findElements(annualIncomeSubElementWagesSpouseList).size() > 0;
    }

    protected boolean employerNameExists() {
        return details.findElements(employerNameSubElementWagesList).size() > 0;
    }

    protected boolean employerNameSpouseExists() {
        return details.findElements(employerNameSubElementWagesSpouseList).size() > 0;
    }

    protected boolean cityExists() {
        return details.findElements(citySubElementWagesList).size() > 0;
    }

    protected boolean citySpouseExists() {
        return details.findElements(citySubElementWagesSpouseList).size() > 0;
    }

    protected boolean streetExists() {
        return details.findElements(streetIncomeSubElementWagesList).size() > 0;
    }

    protected boolean streetSpouseExists() {
        return details.findElements(streetIncomeSubElementWagesSpouseList).size() > 0;
    }

    protected boolean houseNumberExists() {
        return details.findElements(houseNumberIncomeSubElementWagesList).size() > 0;
    }

    protected boolean houseNumberSpouseExists() {
        return details.findElements(houseNumberIncomeSubElementWagesSpouseList).size() > 0;
    }

    protected boolean tikNikuimExists() {
        return details.findElements(tikNikuimSubElementWagesList).size() > 0;
    }

    protected boolean tikNikuimSpouseExists() {
        return details.findElements(tikNikuimSubElementWagesSpouseList).size() > 0;
    }

    protected boolean countryExists() {
        return details.findElements(countrySubElementWagesList).size() > 0;
    }

    protected boolean countrySpouseExists() {
        return details.findElements(countrySubElementWagesSpouseList).size() > 0;
    }

    protected boolean stateExists() {
        return details.findElements(stateSubElementWagesList).size() > 0;
    }

    protected boolean stateSpouseExists() {
        return details.findElements(stateSubElementWagesSpouseList).size() > 0;
    }

}
