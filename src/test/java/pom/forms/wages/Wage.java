package pom.forms.wages;

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
    
    private String wage = "wage";

    // == constructors==
    public Wage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);

        recreateMapPanelsOnPage();
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
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).chooseIsraelIncome();
    }

    public void chooseAbroadIncome(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).chooseAbroadIncome();
    }

    // for Abroad Income only
    public void chooseCountryIsrael(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).chooseCountryIsrael();
    }

    public void chooseCountryZambia(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).chooseCountryZambia();
    }

    public void chooseCountryUsa(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).chooseCountryUsa();
    }

    public void enterState(int wageNumber, String state) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterState(state);
    }

    public void enterCity(int wageNumber, String city) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterCity(city);
    }

    public void enterStreet(int wageNumber, String street) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterStreet(street);
    }

    // for Israel Income only
    public void enterTikNikuim(int wageNumber, String tikNikuim) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterTikNikuim(tikNikuim);
    }

    public void selectCityFromDropDownListByName(int wageNumber, String city) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).selectCityFromDropDownListByName(city);
    }

    public void selectStreetFromDropDownListByName(int wageNumber, String street) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).selectStreetFromDropDownListByName(street);
    }

    public void enterHouseNum(int wageNumber, String houseNum) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterHouseNum(houseNum);
    }

    public void enterEmployerName(int wageNumber, String employerName) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterEmployerName(employerName);
    }

    public void enterAnnualIncome(int wageNumber, String annualIncome) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

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
