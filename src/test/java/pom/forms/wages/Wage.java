package pom.forms.wages;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.WagesConstants.wagesDetailsPanel;

public class Wage extends BasePage {

    // == private fields =
    private Map<Integer, WageDetails> integerWageDetailsMap;

    // == constructors==
    public Wage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

    // == public methods ==
    public void chooseHaveWage() {

        chooseHave();

        recreateMapPannelsOnPage();
    }

    public void chooseDontHaveWage() {
        chooseDontHave();

        recreateMapPannelsOnPage();
    }

    public void deleteWage(int indexWage) {

        delete(indexWage);

        recreateMapPannelsOnPage();
    }

    public void addWage() {

        add();

        recreateMapPannelsOnPage();
    }

    public void enterEmployerName(int wageNumber, String employerName) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add employer name for a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        integerWageDetailsMap.get(wageNumber).enterEmployerName(employerName);
    }

    public void enterEmployerAddress(int wageNumber, String employerAddress) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add employer address for a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        integerWageDetailsMap.get(wageNumber).enterEmployerAddress(employerAddress);
    }

    public void enterTikNikuim(int wageNumber, String tikNikuim) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add tik nikuim for a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        integerWageDetailsMap.get(wageNumber).enterTikNikuim(tikNikuim);
    }

    public void enterAnnualIncome(int wageNumber, String annualIncome) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add annual income for a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        integerWageDetailsMap.get(wageNumber).enterAnnualIncome(annualIncome);
    }


    // == private methods ==
    private void recreateMapPannelsOnPage() {
        integerWageDetailsMap = new HashMap<>();

        PageFactory.initElements(driver, this);

        List<WebElement> wageDetailsRows = driver.findElements(wagesDetailsPanel);

        for (int i = 0; i < wageDetailsRows.size(); ++i) {
            WebElement webElement = wageDetailsRows.get(i);
            integerWageDetailsMap.put(i, new WageDetails(driver, webElement));
        }

    }

}
