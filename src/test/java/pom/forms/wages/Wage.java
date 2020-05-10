package pom.forms.wages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.BaseConstants.checkCircleIconSubElementMenu;
import static constants.BaseConstants.errorIconSubElementMenu;
import static constants.WagesConstants.wagesDetailsPanel;
import static constants.WagesConstants.wagesSpouseDetailsPanel;

public class Wage extends BasePage {
    
    // == private fields =
    private Map<Integer, WageDetails> integerWageDetailsMap;
    private Map<Integer, WageSpouseDetails> integerWageSpouseDetailsMap;
    
    private String wage = "wage";

    // == web-elements ==
    @FindBy(xpath = "//*[@id='sachirInYearId']//button[@value='true']")
    private WebElement btnHaveWage;
    @FindBy(xpath = "//*[@id='sachirInYearId']//button[@value='false']")
    private WebElement btnDontHaveWage;
    @FindBy(xpath = "//*[@id='spouseSachirInYearId']//button[@value='true']")
    private WebElement btnHaveWageSpouse;
    @FindBy(xpath = "//*[@id='spouseSachirInYearId']//button[@value='false']")
    private WebElement btnDontHaveWageSpouse;
    @FindBy(xpath = "//*[@id='spouseSachirInYearId']")
    private List<WebElement> btnsWageSpouse;
    @FindBy(xpath = "//*[@id='sachirInYearId']/..//div[@class='add-item w-inline-block']//img")
    private List<WebElement> btnAddWage;
    @FindBy(xpath = "//*[@id='spouseSachirInYearId']/..//div[@class='add-item w-inline-block']//img")
    private List<WebElement> btnAddWageSpouse;
    @FindBy(xpath = "//*[@id='sachirInYearId']/..//span[contains(., 'delete')]")
    private List<WebElement> btnsDeleteWage;
    @FindBy(xpath = "//*[@id='spouseSachirInYearId']/..//span[contains(., 'delete')]")
    private List<WebElement> btnsDeleteWageSpouse;


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

        chooseHave(btnHaveWage);

        recreateMapPanelsOnPage();
    }

    public void chooseDontHaveWage() {
        chooseDontHave(btnDontHaveWage);

        recreateMapPanelsOnPage();
    }

    public void chooseHaveWageSpouse() {

        chooseHave(btnHaveWageSpouse);

        recreateMapPanelsOnPage();
    }

    public void chooseDontHaveWageSpouse() {
        chooseDontHave(btnDontHaveWageSpouse);

        recreateMapPanelsOnPage();
    }

    public WebElement getBtnAddWage() {
        return btnAddWage.get(btnAddWage.size()-1);
    }

    public WebElement getBtnAddWageSpouse() {
        return btnAddWageSpouse.get(btnAddWageSpouse.size()-1);
    }

    public List<WebElement> getBtnsDeleteWage() {
        return btnsDeleteWage;
    }

    public List<WebElement> getBtnsDeleteWageSpouse() {
        return btnsDeleteWageSpouse;
    }

    public void deleteWage(int indexWage) {

        deletePanel(indexWage);

        recreateMapPanelsOnPage();
    }

    public void addWage() {

        addPanel(getBtnAddWage());

        recreateMapPanelsOnPage();
    }

    public void addWageSpouse() {

        addPanel(getBtnAddWageSpouse());

        recreateMapPanelsOnPage();
    }

    public void deletePanelWage(int index) {

        deletePanel(index, getBtnsDeleteWage());
    }

    public void deletePanelWageSpouse(int index) {

        deletePanel(index, getBtnsDeleteWageSpouse());
    }

    public boolean btnsWageSpouseExist() {
        return btnsWageSpouse.size() > 0;
    }

    public List<WageDetails> getListWages() {
        return new ArrayList<>(integerWageDetailsMap.values());
    }

    public int getWagesAmount() {
        return integerWageDetailsMap.size();
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

    public boolean israelIncomeChosen(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).israelIncomeChosen();
    }

    public boolean abroadIncomeChosen(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).abroadIncomeChosen();
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

    public String selectCountryFromDropDownListByIndex(int wageNumber, int index) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).selectCountryFromDropDownListByIndex(index);
    }

    public void enterState(int wageNumber, String state) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterState(state);
    }

    public void deleteState(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).deleteState();
    }

    public void enterCity(int wageNumber, String city) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterCity(city);
    }

    public void deleteCity(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).deleteCity();
    }

    public void enterStreet(int wageNumber, String street) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterStreet(street);
    }

    public void deleteStreet(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).deleteStreet();
    }

    // for Israel Income only
    public void enterTikNikuim(int wageNumber, String tikNikuim) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterTikNikuim(tikNikuim);
    }

    public void deleteTikNikuim(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).deleteTikNikuim();
    }

    public void selectCityFromDropDownListByName(int wageNumber, String city) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).selectCityFromDropDownListByName(city);
    }

    public String selectCityFromDropDownListByIndex(int wageNumber, int index) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).selectCityFromDropDownListByIndex(index);
    }

    public void selectStreetFromDropDownListByName(int wageNumber, String street) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).selectStreetFromDropDownListByName(street);
    }

    public String selectStreetFromDropDownListByIndex(int wageNumber, int index) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).selectStreetFromDropDownListByIndex(index);
    }

    public void enterHouseNum(int wageNumber, String houseNum) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterHouseNum(houseNum);
    }

    public void deleteHouseNum(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).deleteHouseNum();
    }

    public void enterEmployerName(int wageNumber, String employerName) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterEmployerName(employerName);
    }

    public void deleteEmployerName(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).deleteEmployerName();
    }

    public void enterAnnualIncome(int wageNumber, String annualIncome) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).enterAnnualIncome(annualIncome);
    }

    public void deleteAnnualIncome(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        integerWageDetailsMap.get(wageNumber).deleteAnnualIncome();
    }

    // error messages
    public List<WebElement> getErrorMessageNeedFillTypeIncome(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageNeedFillTypeIncome();
    }

    public List<WebElement> getErrorMessageNeedFillAnnualIncome(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageNeedFillAnnualIncome();
    }

    public List<WebElement> getErrorMessageNeedFillEmployerName(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageNeedFillEmployerName();
    }

    public List<WebElement> getErrorMessageNeedFillCity(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageNeedFillCity();
    }

    public List<WebElement> getErrorMessageNeedFillStreet(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageNeedFillStreet();
    }

    public List<WebElement> getErrorMessageNeedFillHouseNumber(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageNeedFillHouseNumber();
    }

    public List<WebElement> getErrorMessageNeedFillTikNikuim(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageNeedFillTikNikuim();
    }

    public List<WebElement> getErrorMessageNeedFillCountry(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageNeedFillCountry();
    }

    public List<WebElement> getErrorMessageTikNikuimNeedBeNineDigits(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageTikNikuimNeedBeNineDigits();
    }

    public List<WebElement> getErrorMessageTikNikuimCannotBeLongerNineDigits(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageTikNikuimCannotBeLongerNineDigits();
    }

    public List<WebElement> getErrorMessageTikNikuimTikNikuimCanContainDigitsOnly(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageTikNikuimTikNikuimCanContainDigitsOnly();
    }

    public List<WebElement> getErrorMessageEmployerNameContainsCharacters(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageEmployerNameContainsCharacters();
    }

    public List<WebElement> getErrorMessageHouseNumberContainsCharacters(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageHouseNumberContainsCharacters();
    }

    public List<WebElement> getErrorMessageStateContainsCharacters(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageStateContainsCharacters();
    }

    public List<WebElement> getErrorMessageCityContainsCharacters(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageCityContainsCharacters();
    }

    public List<WebElement> getErrorMessageStreetContainsCharacters(int wageNumber) {
        checkNumber(wageNumber, wage, integerWageDetailsMap);

        recreateMapPanelsOnPage();
        return integerWageDetailsMap.get(wageNumber).getErrorMessageStreetContainsCharacters();
    }


    // == private methods ==
    private void recreateMapPanelsOnPage() {
        integerWageDetailsMap = new HashMap<>();

        PageFactory.initElements(driver, this);

        List<WebElement> wageDetailsRows = driver.findElements(wagesDetailsPanel);
        List<WebElement> wageSpouseDetailsRows = driver.findElements(wagesSpouseDetailsPanel);

        for (int i = 0; i < wageDetailsRows.size(); ++i) {
            WebElement webElement = wageDetailsRows.get(i);
            integerWageDetailsMap.put(i, new WageDetails(driver, webElement));
        }

        for (int i = 0; i < wageSpouseDetailsRows.size(); ++i) {
            WebElement webElement = wageSpouseDetailsRows.get(i);
            integerWageSpouseDetailsMap.put(i, new WageSpouseDetails(driver, webElement));
        }
    }

}
