package pom.forms.wages;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.BaseConstants.checkCircleIconSubElementMenu;
import static constants.BaseConstants.errorIconSubElementMenu;
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

    // menu icons
    public List<WebElement> getErrorIconMenu() {
        return getMenuWage().findElements(errorIconSubElementMenu);
    }

    public List<WebElement> getCheckCircleIconMenu() {
        return getMenuWage().findElements(checkCircleIconSubElementMenu);
    }

    public void chooseHaveWage() {

        chooseHave();

        recreateMapPanelsOnPage();
    }

    public void chooseDontHaveWage() {
        chooseDontHave();

        recreateMapPanelsOnPage();
    }

    public void deleteWage(int indexWage) {

        deletePanel(indexWage);

        recreateMapPanelsOnPage();
    }

    public void addWage() {

        addPanel();

        recreateMapPanelsOnPage();
    }


    public void chooseIsraelIncome(int wageNumber) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to choose Israel Income on a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).chooseIsraelIncome();
    }

    public void chooseAbroadIncome(int wageNumber) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to choose Abroad Income for a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).chooseAbroadIncome();
    }

    // for Abroad Income only
    public void chooseCountryIsrael(int wageNumber) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to choose state on a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).chooseCountryIsrael();
    }

    public void chooseCountryZambia(int wageNumber) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to choose state on a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).chooseCountryZambia();
    }

    public void chooseCountryUsa(int wageNumber) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to choose state on a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).chooseCountryUsa();
    }

    public void enterState(int wageNumber, String state) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to enter state to a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterState(state);
    }

    // for Israel Income only
    public void enterTikNikuim(int wageNumber, String tikNikuim) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to enter tik nikuim to a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterTikNikuim(tikNikuim);
    }

    // both Abroad and Israel Income
    public void enterCity(int wageNumber, String city) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to enter city to a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterCity(city);
    }

    public void enterStreet(int wageNumber, String street) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to enter street to a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterStreet(street);
    }

    public void enterHouseNum(int wageNumber, String houseNum) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to enter house number to a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterHouseNum(houseNum);
    }

    public void enterEmployerName(int wageNumber, String employerName) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to enter employer name to a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterEmployerName(employerName);
    }

    public void enterAnnualIncome(int wageNumber, String annualIncome) {
        if (wageNumber<0 || wageNumber>=integerWageDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to enter annual income to a wage #%d. " +
                    "The number need to be between 0 and %d not inclusive", wageNumber, integerWageDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterAnnualIncome(annualIncome);
    }


    // == private methods ==
    private void recreateMapPanelsOnPage() {
        integerWageDetailsMap = new HashMap<>();

        PageFactory.initElements(driver, this);

        List<WebElement> wageDetailsRows = driver.findElements(wagesDetailsPanel);

        for (int i = 0; i < wageDetailsRows.size(); ++i) {
            WebElement webElement = wageDetailsRows.get(i);
            integerWageDetailsMap.put(i, new WageDetails(driver, webElement));
        }

    }

}
