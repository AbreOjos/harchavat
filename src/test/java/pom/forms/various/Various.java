package pom.forms.various;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.*;
import static constants.VariousConstants.*;

public class Various extends BasePage {

    // == final members ==
    private String nonWorkIncomes = "Non Work Incomes";
    private String abroadBankAccounts = "Abroad Bank Accounts";
    private String digitalCoins = "Digital Coins";
    private String stocks = "Stocks";
    private String partnerships = "Partnerships";

    // == private fields =
    private Map<Integer, NonWorkIncomesDetails> integerNonWorkIncomesDetailsMap;
    private Map<Integer, AbroadBankAccountsDetails> integerAbroadBankAccountsDetailsMap;
    private Map<Integer, DigitalCoinsDetails> integerDigitalCoinsDetailsMap;
    private Map<Integer, StocksDetails> integerStocksDetailsMap;
    private Map<Integer, PartnershipsDetails> integerPartnershipsDetailsMap;
    private Map<Integer, OwnJewelryDetails> integerOwnJewelryDetailsMap;
    private Map<Integer, OwnArtDetails> integerOwnArtDetailsMap;


    // web-elements
    @FindBy(xpath = "//div[@id='nonWorkIncomes']//*[contains(@class, 'yes-no-box')]//button[@value='true']")
    private WebElement btnHaveNonWorkIncomes;
    @FindBy(xpath = "//div[@id='nonWorkIncomes']//*[contains(@class, 'yes-no-box')]//button[@value='false']")
    private WebElement btnDontHaveNonWorkIncomes;
    @FindBy(xpath = "//div[@id='abroadBankAccounts']//*[contains(@class, 'yes-no-box')]//button[@value='true']")
    private WebElement btnHaveAbroadBankAccounts;
    @FindBy(xpath = "//div[@id='abroadBankAccounts']//*[contains(@class, 'yes-no-box')]//button[@value='false']")
    private WebElement btnDontHaveAbroadBankAccounts;
    @FindBy(xpath = "//div[@id='digitalCoins']//*[contains(@class, 'yes-no-box')]//button[@value='true']")
    private WebElement btnHaveDigitalCoins;
    @FindBy(xpath = "//div[@id='digitalCoins']//*[contains(@class, 'yes-no-box')]//button[@value='false']")
    private WebElement btnDontHaveDigitalCoins;
    @FindBy(xpath = "//div[@id='stocks']//*[contains(@class, 'yes-no-box')]//button[@value='true']")
    private WebElement btnHaveStocks;
    @FindBy(xpath = "//div[@id='stocks']//*[contains(@class, 'yes-no-box')]//button[@value='false']")
    private WebElement btnDontHaveStocks;
    @FindBy(xpath = "//div[@id='partnerships']//*[contains(@class, 'yes-no-box')]//button[@value='true']")
    private WebElement btnHavePartnerships;
    @FindBy(xpath = "//div[@id='partnerships']//*[contains(@class, 'yes-no-box')]//button[@value='false']")
    private WebElement btnDontHavePartnerships;
    @FindBy(xpath = "//div[@id='ownJewelry']//*[contains(@class, 'yes-no-box')]//button[@value='true']")
    private WebElement btnHaveJewelry;
    @FindBy(xpath = "//div[@id='ownJewelry']//*[contains(@class, 'yes-no-box')]//button[@value='false']")
    private WebElement btnDontHaveJewelry;
    @FindBy(xpath = "//div[@id='ownArt']//*[contains(@class, 'yes-no-box')]//button[@value='true']")
    private WebElement btnHaveArt;
    @FindBy(xpath = "//div[@id='ownArt']//*[contains(@class, 'yes-no-box')]//button[@value='false']")
    private WebElement btnDontHaveArt;

    @FindBy(xpath = "//div[@id='nonWorkIncomes']//img")
    private WebElement btnAddNonWorkIncomes;
    @FindBy(xpath = "//div[@id='abroadBankAccounts']//img")
    private WebElement btnAddAbroadBankAccounts;
    @FindBy(xpath = "//div[@id='digitalCoins']//img")
    private WebElement btnAddDigitalCoins;
    @FindBy(xpath = "//div[@id='stocks']//img")
    private WebElement btnAddStocks;
    @FindBy(xpath = "//div[@id='partnerships']//img")
    private WebElement btnAddPartnerships;

    @FindBy(xpath = "//div[@id='nonWorkIncomes']//span[contains(., 'delete')]")
    private List<WebElement> btnsDeleteNonWorkIncomes;
    @FindBy(xpath = "//div[@id='abroadBankAccounts']//span[contains(., 'delete')]")
    private List<WebElement> btnsDeleteAbroadBankAccounts;
    @FindBy(xpath = "//div[@id='digitalCoins']//span[contains(., 'delete')]")
    private List<WebElement> btnsDeleteDigitalCoins;
    @FindBy(xpath = "//div[@id='stocks']//span[contains(., 'delete')]")
    private List<WebElement> btnsDeleteStocks;
    @FindBy(xpath = "//div[@id='partnerships']//span[contains(., 'delete')]")
    private List<WebElement> btnsDeletePartnerships;

    // == constructors==
    public Various(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);

        recreateMapPanelsOnPage();
    }



    // == public methods ==

    // menu icons
    public List<WebElement> getErrorIconMenu() {
        return getMenuVarious().findElements(errorIconSubElementMenu);
    }

    public List<WebElement> getCheckCircleIconMenu() {
        return getMenuVarious().findElements(checkCircleIconSubElementMenu);
    }

    // Have / Don't Have methods
    public void chooseHaveNonWorkIncomes() {
        chooseHave(btnHaveNonWorkIncomes);
    }

    public void chooseDontHaveNonWorkIncomes() {
        chooseDontHave(btnDontHaveNonWorkIncomes);
    }

    public void chooseHaveAbroadBankAccounts() {
        chooseHave(btnHaveAbroadBankAccounts);
    }

    public void chooseDontHaveAbroadBankAccounts() {
        chooseDontHave(btnDontHaveAbroadBankAccounts);

    }

    public void chooseHaveDigitalCoins() {
        chooseHave(btnHaveDigitalCoins);
    }

    public void chooseDontHaveDigitalCoins() {
        chooseDontHave(btnDontHaveDigitalCoins);
    }

    public void chooseHaveStocks() {
        chooseHave(btnHaveStocks);
    }

    public void chooseDontHaveStocks() {
        chooseDontHave(btnDontHaveStocks);
    }

    public void chooseHavePartnerships() {
        chooseHave(btnHavePartnerships);
    }

    public void chooseDontHavePartnerships() {
        chooseDontHave(btnDontHavePartnerships);
    }

    public void chooseHaveJewelry() {
        chooseHave(btnHaveJewelry);
    }

    public void chooseDontHaveJewelry() {
        chooseDontHave(btnDontHaveJewelry);
    }

    public void chooseHaveArt() {
        chooseHave(btnHaveArt);
    }

    public void chooseDontHaveArt() {
        chooseDontHave(btnDontHaveArt);
    }

    // addPanel and deletePanel panels
    public void addNonWorkIncomes() {
        add(btnAddNonWorkIncomes);
    }

    public void addAbroadBankAccounts() {
        add(btnAddAbroadBankAccounts);
    }

    public void addDigitalCoins() {
        add(btnAddDigitalCoins);
    }

    public void addStocks() {
        add(btnAddStocks);
    }

    public void addPartnerships() {
        add(btnAddPartnerships);
    }

    public void deleteNonWorkIncomes(int index) {
        delete(index, btnsDeleteNonWorkIncomes);
    }

    public void deleteAbroadBankAccounts(int index) {
        delete(index, btnsDeleteAbroadBankAccounts);
    }

    public void deleteDigitalCoins(int index) {
        delete(index, btnsDeleteDigitalCoins);
    }

    public void deleteStocks(int index) {
        delete(index, btnsDeleteStocks);
    }

    public void deletePartnerships(int index) {
        delete(index, btnsDeletePartnerships);
    }

    // NonWorkIncomesDetails
    public void chooseNonWorkIncomesIncomeIsraeli(int nonWorkIncomeNumber) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).chooseIncomeIsraeli();
    }

    public void chooseNonWorkIncomesIncomeOversea(int nonWorkIncomeNumber) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).chooseIncomeOversea();
    }

    public void enterNonWorkIncomesIncomeSource(int nonWorkIncomeNumber, String incomeSource) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterIncomeSource(incomeSource);
    }

    public void deleteNonWorkIncomesIncomeSource(int nonWorkIncomeNumber) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).deleteIncomeSource();
    }

    public void enterNonWorkIncomesYearlyIncome(int nonWorkIncomeNumber, String yearlyIncome) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterYearlyIncome(yearlyIncome);
    }

    public void deleteNonWorkIncomesYearlyIncome(int nonWorkIncomeNumber) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).deleteYearlyIncome();
    }

    public void enterNonWorkIncomesPayerName(int nonWorkIncomeNumber, String payerName) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterPayerName(payerName);
    }

    public void deleteNonWorkIncomesPayerName(int nonWorkIncomeNumber) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).deletePayerName();
    }

    public void enterNonWorkIncomesTikNikuim(int nonWorkIncomeNumber, String tikNikuim) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterTikNikuim(tikNikuim);
    }

    public void deleteNonWorkIncomesTikNikuim(int nonWorkIncomeNumber) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).deleteTikNikuim();
    }

    public void selectCityNonWorkIncomesFromDropDownListByName(int nonWorkIncomeNumber, String city) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).selectCityFromDropDownListByName(city);
    }

    public String selectCityNonWorkIncomesFromDropDownListByIndex(int nonWorkIncomeNumber, int index) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        return integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).selectCityFromDropDownListByIndex(index);
    }

    public void selectStreetNonWorkIncomesFromDropDownListByName(int nonWorkIncomeNumber, String street) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).selectStreetFromDropDownListByName(street);
    }

    public String selectStreetNonWorkIncomesFromDropDownListByIndex(int nonWorkIncomeNumber, int index) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        return integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).selectStreetFromDropDownListByIndex(index);
    }

    public void selectCountryNonWorkIncomesFromDropDownListByName(int nonWorkIncomeNumber, String country) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).selectCountryFromDropDownListByName(country);
    }

    public String selectCountryNonWorkIncomesFromDropDownListByIndex(int nonWorkIncomeNumber, int index) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        return integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).selectCountryFromDropDownListByIndex(index);
    }

    public void enterNonWorkIncomesHouseNum(int nonWorkIncomeNumber, String houseNum) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterHouseNum(houseNum);
    }

    public void deleteNonWorkIncomesHouseNum(int nonWorkIncomeNumber) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).deleteHouseNum();
    }

    public void enterNonWorkIncomesState(int nonWorkIncomeNumber, String state) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterState(state);
    }

    public void deleteNonWorkIncomesState(int nonWorkIncomeNumber) {
        checkNumber(nonWorkIncomeNumber, nonWorkIncomes, integerNonWorkIncomesDetailsMap);

        recreateMapPanelsOnPage();
        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).deleteState();
    }


    // Abroad Bank Accounts methods
    public void selectCountryAbroadBankAccountsFromDropDownListByName(int abroadBankAccountsNumber, String country) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).selectCountryFromDropDownListByName(country);
    }

    public String selectCountryAbroadBankAccountsFromDropDownListByIndex(int abroadBankAccountsNumber, int index) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        return integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).selectCountryFromDropDownListByIndex(index);
    }

    public void enterAbroadBankAccountsState(int abroadBankAccountsNumber, String state) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterState(state);
    }

    public void deleteAbroadBankAccountsState(int abroadBankAccountsNumber) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).deleteState();
    }

    public void enterAbroadBankAccountsCity(int abroadBankAccountsNumber, String city) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterCity(city);
    }

    public void deleteAbroadBankAccountsCity(int abroadBankAccountsNumber) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).deleteCity();
    }

    public void enterAbroadBankAccountsBankName(int abroadBankAccountsNumber, String bankName) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterBankName(bankName);
    }

    public void deleteAbroadBankAccountsBankName(int abroadBankAccountsNumber) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).deleteBankName();
    }

    public void enterAbroadBankAccountsBankNum(int abroadBankAccountsNumber, String bankNum) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterBankNum(bankNum);
    }

    public void deleteAbroadBankAccountsBankNum(int abroadBankAccountsNumber) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).deleteBankNum();
    }

    public void enterAbroadBankAccountsBranchName(int abroadBankAccountsNumber, String branchName) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterBranchName(branchName);
    }

    public void deleteAbroadBankAccountsBranchName(int abroadBankAccountsNumber) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).deleteBranchName();
    }

    public void enterAbroadBankAccountsBranchNum(int abroadBankAccountsNumber, String branchNum) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterBranchNum(branchNum);
    }

    public void deleteAbroadBankAccountsBranchNum(int abroadBankAccountsNumber) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).deleteBranchNum();
    }

    public void enterAbroadBankAccountsAccountNum(int abroadBankAccountsNumber, String accountNum) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterAccountNum(accountNum);
    }

    public void deleteAbroadBankAccountsAccountNum(int abroadBankAccountsNumber) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).deleteAccountNum();
    }

    public void enterAbroadBankAccountsPartnersNum(int abroadBankAccountsNumber, String partnersNum) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterPartnersNum(partnersNum);
    }

    public void deleteAbroadBankAccountsPartnersNum(int abroadBankAccountsNumber) {
        checkNumber(abroadBankAccountsNumber, abroadBankAccounts, integerAbroadBankAccountsDetailsMap);

        recreateMapPanelsOnPage();
        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).deletePartnersNum();
    }


    // Digital Coins methods
    public void chooseDigitalCoinsBitcoin(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseBitcoin();
    }

    public void chooseDigitalCoinsNano(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseNano();
    }

    public void chooseDigitalCoinsSteem(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseSteem();
    }

    public void chooseDigitalCoinsCardano(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseCardano();
    }

    public void chooseDigitalCoinsAnotherCoin(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseAnotherCoin();
    }

    public void enterDigitalCoinsAnotherCoin(int digitalCoinsNumber, String anotherCoinName) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterAnotherCoin(anotherCoinName);
    }

    public void deleteDigitalCoinsAnotherCoin(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).deleteAnotherCoin();
    }

    public void enterDigitalCoinsCoinAmount(int digitalCoinsNumber, String coinAmount) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterCoinAmount(coinAmount);
    }

    public void deleteDigitalCoinsCoinAmount(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).deleteCoinAmount();
    }

    public void enterDigitalCoinsPublicKey(int digitalCoinsNumber, String publicKey) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterPublicKey(publicKey);
    }

    public void deleteDigitalCoinsPublicKey(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).deletePublicKey();
    }

    public void chooseDigitalCoinsCoinsMaterialized(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseCoinsMaterialized();
    }

    public void chooseDigitalCoinsCoinsDontMaterialized(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseCoinsDontMaterialized();
    }

    public void enterDigitalCoinsAmountMaterialized(int digitalCoinsNumber, String amountMaterialized) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterAmountMaterialized(amountMaterialized);
    }

    public void deleteDigitalCoinsAmountMaterialized(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).deleteAmountMaterialized();
    }

    public void enterDigitalCoinsMaterializationValue(int digitalCoinsNumber, String materializationValue) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterMaterializationValue(materializationValue);
    }

    public void deleteDigitalCoinsMaterializationValue(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).deleteMaterializationValue();
    }

    public void chooseDigitalCoinsPurchasedWithCoins(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).choosePurchasedWithCoins();
    }

    public void chooseDigitalCoinsDontPurchasedWithCoins(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseDontPurchasedWithCoins();
    }

    public void enterDigitalCoinsAmountSold(int digitalCoinsNumber, String amountSold) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterAmountSold(amountSold);
    }

    public void deleteDigitalCoinsAmountSold(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).deleteAmountSold();
    }

    public void enterDigitalCoinsSoldValue(int digitalCoinsNumber, String soldValue) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterSoldValue(soldValue);
    }

    public void deleteDigitalCoinsSoldValue(int digitalCoinsNumber) {
        checkNumber(digitalCoinsNumber, digitalCoins, integerDigitalCoinsDetailsMap);

        recreateMapPanelsOnPage();
        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).deleteSoldValue();
    }


    // Stocks methods
    public void enterStocksCompanyName(int stocksNumber, String companyName) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        integerStocksDetailsMap.get(stocksNumber).enterCompanyName(companyName);
    }

    public void deleteStocksCompanyName(int stocksNumber) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        integerStocksDetailsMap.get(stocksNumber).deleteCompanyName();
    }

    public void chooseStocksCompanySourceOversea(int stocksNumber) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        integerStocksDetailsMap.get(stocksNumber).chooseCompanySourceOversea();
    }

    public void chooseStocksCompanySourceIsrael(int stocksNumber) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        integerStocksDetailsMap.get(stocksNumber).chooseCompanySourceIsrael();
    }

    public void selectCountryStocksFromDropDownListByName(int stocksNumber, String country) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        integerStocksDetailsMap.get(stocksNumber).selectCountryFromDropDownListByName(country);
    }

    public String selectCountryStocksFromDropDownListByIndex(int stocksNumber, int index) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        return integerStocksDetailsMap.get(stocksNumber).selectCountryFromDropDownListByIndex(index);
    }

    public void enterStocksState(int stocksNumber, String state) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        integerStocksDetailsMap.get(stocksNumber).enterState(state);
    }

    public void deleteStocksState(int stocksNumber) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        integerStocksDetailsMap.get(stocksNumber).deleteState();
    }

    public void enterStocksCompanyNum(int stocksNumber, String companyNum) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        integerStocksDetailsMap.get(stocksNumber).enterCompanyNum(companyNum);
    }

    public void deleteStocksCompanyNum(int stocksNumber) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        integerStocksDetailsMap.get(stocksNumber).deleteCompanyNum();
    }

    public void enterStocksCompanyPercentage(int stocksNumber, String companyPercentage) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        integerStocksDetailsMap.get(stocksNumber).enterCompanyPercentage(companyPercentage);
    }

    public void deleteStocksCompanyPercentage(int stocksNumber) {
        checkNumber(stocksNumber, stocks, integerStocksDetailsMap);

        recreateMapPanelsOnPage();
        integerStocksDetailsMap.get(stocksNumber).deleteCompanyPercentage();
    }

    // partnerships methods
    public void enterPartnershipName(int partnershipsNumber, String name) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        integerPartnershipsDetailsMap.get(partnershipsNumber).enterName(name);
    }

    public void deletePartnershipName(int partnershipsNumber) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        integerPartnershipsDetailsMap.get(partnershipsNumber).deleteName();
    }

    public void choosePartnershipLocationIsrael(int partnershipsNumber) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        integerPartnershipsDetailsMap.get(partnershipsNumber).choosePartnershipLocationIsrael();
    }

    public void choosePartnershipLocationOversea(int partnershipsNumber) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        integerPartnershipsDetailsMap.get(partnershipsNumber).choosePartnershipLocationOversea();
    }

    public void enterPartnershipOsekNum(int partnershipsNumber, String osekNum) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        integerPartnershipsDetailsMap.get(partnershipsNumber).enterOsekNum(osekNum);
    }

    public void deletePartnershipOsekNum(int partnershipsNumber) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        integerPartnershipsDetailsMap.get(partnershipsNumber).deleteOsekNum();
    }

    public void enterPartnershipPercentage(int partnershipsNumber, String percentage) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        integerPartnershipsDetailsMap.get(partnershipsNumber).enterPercentage(percentage);
    }

    public void deletePartnershipPercentage(int partnershipsNumber) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        integerPartnershipsDetailsMap.get(partnershipsNumber).deletePercentage();
    }

    public void selectCountryPartnershipsFromDropDownListByName(int partnershipsNumber, String country) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        integerPartnershipsDetailsMap.get(partnershipsNumber).selectCountryFromDropDownListByName(country);
    }

    public String selectCountryPartnershipsFromDropDownListByIndex(int partnershipsNumber, int index) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        return integerPartnershipsDetailsMap.get(partnershipsNumber).selectCountryFromDropDownListByIndex(index);
    }

    public void enterPartnershipsState(int partnershipsNumber, String state) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        integerPartnershipsDetailsMap.get(partnershipsNumber).enterState(state);
    }

    public void deletePartnershipState(int partnershipsNumber) {
        checkNumber(partnershipsNumber, partnerships, integerPartnershipsDetailsMap);

        recreateMapPanelsOnPage();
        integerPartnershipsDetailsMap.get(partnershipsNumber).deleteState();
    }




    // == private methods ==
//    private void chooseHave(WebElement button) {
//        try {
//            scrollIntoViewMoveFocusAndClick(driver, button);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
////        button.click();
//
//        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
//
//        recreateMapPanelsOnPage();
//    }

//    private void chooseDontHave(WebElement button) {
//        try {
//            scrollIntoViewMoveFocusAndClick(driver, button);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
////        button.click();
//
//
//        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
//
//        recreateMapPanelsOnPage();
//    }

    private void add(WebElement btnAdd) {
        btnAdd.click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        recreateMapPanelsOnPage();
    }

    private void delete(int index, List<WebElement> btnsDelete) {
        if (btnsDelete.isEmpty()) {
            throw new WrongArgumentException(String.format("Impossible to deletePanel a panel #%d," +
                    "the list of panels is empty", index));
        } else if (index == 0) {
            throw new WrongArgumentException(String.format("Impossible to deletePanel a panel #%d", index));
        } else if (index<0 || index> btnsDelete.size()) {
            throw new WrongArgumentException(String.format("Impossible to deletePanel a vehicle #%d. " +
                    "The number need to be between 1 and %d inclusive", index, btnsDelete.size()));
        }

        btnsDelete.get(index-1).click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        recreateMapPanelsOnPage();
    }

    private void recreateMapPanelsOnPage() {
        integerAbroadBankAccountsDetailsMap = new HashMap<>();
        integerDigitalCoinsDetailsMap = new HashMap<>();
        integerNonWorkIncomesDetailsMap = new HashMap<>();
        integerOwnArtDetailsMap = new HashMap<>();
        integerOwnJewelryDetailsMap = new HashMap<>();
        integerPartnershipsDetailsMap = new HashMap<>();
        integerStocksDetailsMap = new HashMap<>();

        PageFactory.initElements(driver, this);

        List<WebElement> abroadBankAccountsDetailsRows = driver.findElements(abroadBankAccountsDetailsPanel);
        List<WebElement> digitalCoinsDetailsRows = driver.findElements(digitalCoinsDetailsPanel);
        List<WebElement> nonWorkIncomesDetailsRows = driver.findElements(nonWorkIncomesDetailsPanel);
        List<WebElement> ownArtDetailsRows = driver.findElements(ownArtDetailsPanel);
        List<WebElement> ownJewelryDetailsRows = driver.findElements(ownJewelryDetailsPanel);
        List<WebElement> partnershipsDetailsRows = driver.findElements(partnershipDetailsPanel);
        List<WebElement> stocksDetailsRows = driver.findElements(stocksDetailsPanel);

        for (int i = 0; i < abroadBankAccountsDetailsRows.size(); ++i) {
            WebElement webElement = abroadBankAccountsDetailsRows.get(i);
            integerAbroadBankAccountsDetailsMap.put(i, new AbroadBankAccountsDetails(driver, webElement));
        }

        for (int i = 0; i < digitalCoinsDetailsRows.size(); ++i) {
            WebElement webElement = digitalCoinsDetailsRows.get(i);
            integerDigitalCoinsDetailsMap.put(i, new DigitalCoinsDetails(driver, webElement));
        }

        for (int i = 0; i < nonWorkIncomesDetailsRows.size(); ++i) {
            WebElement webElement = nonWorkIncomesDetailsRows.get(i);
            integerNonWorkIncomesDetailsMap.put(i, new NonWorkIncomesDetails(driver, webElement));
        }

        for (int i = 0; i < ownArtDetailsRows.size(); ++i) {
            WebElement webElement = ownArtDetailsRows.get(i);
            integerOwnArtDetailsMap.put(i, new OwnArtDetails(driver, webElement));
        }

        for (int i = 0; i < integerOwnJewelryDetailsMap.size(); ++i) {
            WebElement webElement = ownJewelryDetailsRows.get(i);
            integerOwnJewelryDetailsMap.put(i, new OwnJewelryDetails(driver, webElement));
        }

        for (int i = 0; i < partnershipsDetailsRows.size(); ++i) {
            WebElement webElement = partnershipsDetailsRows.get(i);
            integerPartnershipsDetailsMap.put(i, new PartnershipsDetails(driver, webElement));
        }

        for (int i = 0; i < stocksDetailsRows.size(); ++i) {
            WebElement webElement = stocksDetailsRows.get(i);
            integerStocksDetailsMap.put(i, new StocksDetails(driver, webElement));
        }
    }

}
