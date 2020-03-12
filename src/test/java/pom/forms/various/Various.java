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

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.waitFewSecondsWarningDisabled;
import static constants.VariousConstants.*;

public class Various extends BasePage {

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

        recreateMapPannelsOnPage();
    }



    // == public methods ==
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

    // add and delete panels
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
        if (nonWorkIncomeNumber<0 || nonWorkIncomeNumber>=integerNonWorkIncomesDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Non Work Incomes #%d. " +
                    "The number need to be between 0 and %d not inclusive", nonWorkIncomeNumber, integerNonWorkIncomesDetailsMap.size()));
        }

        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).chooseIncomeIsraeli();

        recreateMapPannelsOnPage();
    }

    public void chooseNonWorkIncomesIncomeOversea(int nonWorkIncomeNumber) {
        if (nonWorkIncomeNumber<0 || nonWorkIncomeNumber>=integerNonWorkIncomesDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Non Work Incomes #%d. " +
                    "The number need to be between 0 and %d not inclusive", nonWorkIncomeNumber, integerNonWorkIncomesDetailsMap.size()));
        }

        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).chooseIncomeOversea();

        recreateMapPannelsOnPage();
    }

    public void enterNonWorkIncomesIncomeSource(int nonWorkIncomeNumber, String incomeSource) {
        if (nonWorkIncomeNumber<0 || nonWorkIncomeNumber>=integerNonWorkIncomesDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Non Work Incomes #%d. " +
                    "The number need to be between 0 and %d not inclusive", nonWorkIncomeNumber, integerNonWorkIncomesDetailsMap.size()));
        }

        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterIncomeSource(incomeSource);
    }

    public void enterNonWorkIncomesYearlyIncome(int nonWorkIncomeNumber, String yearlyIncome) {
        if (nonWorkIncomeNumber<0 || nonWorkIncomeNumber>=integerNonWorkIncomesDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Non Work Incomes #%d. " +
                    "The number need to be between 0 and %d not inclusive", nonWorkIncomeNumber, integerNonWorkIncomesDetailsMap.size()));
        }

        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterYearlyIncome(yearlyIncome);
    }

    public void enterNonWorkIncomesPayerName(int nonWorkIncomeNumber, String payerName) {
        if (nonWorkIncomeNumber<0 || nonWorkIncomeNumber>=integerNonWorkIncomesDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Non Work Incomes #%d. " +
                    "The number need to be between 0 and %d not inclusive", nonWorkIncomeNumber, integerNonWorkIncomesDetailsMap.size()));
        }

        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterPayerName(payerName);
    }

    public void enterNonWorkIncomesTikNikuim(int nonWorkIncomeNumber, String tikNikuim) {
        if (nonWorkIncomeNumber<0 || nonWorkIncomeNumber>=integerNonWorkIncomesDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Non Work Incomes #%d. " +
                    "The number need to be between 0 and %d not inclusive", nonWorkIncomeNumber, integerNonWorkIncomesDetailsMap.size()));
        }

        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterTikNikuim(tikNikuim);
    }

    public void selectCityNonWorkIncomesFromDropDownListByName(int nonWorkIncomeNumber, String city) {
        if (nonWorkIncomeNumber<0 || nonWorkIncomeNumber>=integerNonWorkIncomesDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Non Work Incomes #%d. " +
                    "The number need to be between 0 and %d not inclusive", nonWorkIncomeNumber, integerNonWorkIncomesDetailsMap.size()));
        }

        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).selectCityFromDropDownListByName(city);

        recreateMapPannelsOnPage();
    }

    public void selectStreetNonWorkIncomesFromDropDownListByName(int nonWorkIncomeNumber, String street) {
        if (nonWorkIncomeNumber<0 || nonWorkIncomeNumber>=integerNonWorkIncomesDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Non Work Incomes #%d. " +
                    "The number need to be between 0 and %d not inclusive", nonWorkIncomeNumber, integerNonWorkIncomesDetailsMap.size()));
        }

        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).selectStreetFromDropDownListByName(street);

        recreateMapPannelsOnPage();
    }

    public void selectCountryNonWorkIncomesFromDropDownListByName(int nonWorkIncomeNumber, String country) {
        if (nonWorkIncomeNumber<0 || nonWorkIncomeNumber>=integerNonWorkIncomesDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Non Work Incomes #%d. " +
                    "The number need to be between 0 and %d not inclusive", nonWorkIncomeNumber, integerNonWorkIncomesDetailsMap.size()));
        }

        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).selectCountryFromDropDownListByName(country);

        recreateMapPannelsOnPage();
    }

    public void enterNonWorkIncomesHouseNum(int nonWorkIncomeNumber, String houseNum) {
        if (nonWorkIncomeNumber<0 || nonWorkIncomeNumber>=integerNonWorkIncomesDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Non Work Incomes #%d. " +
                    "The number need to be between 0 and %d not inclusive", nonWorkIncomeNumber, integerNonWorkIncomesDetailsMap.size()));
        }

        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterHouseNum(houseNum);
    }

    public void enterNonWorkIncomesState(int nonWorkIncomeNumber, String state) {
        if (nonWorkIncomeNumber<0 || nonWorkIncomeNumber>=integerNonWorkIncomesDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Non Work Incomes #%d. " +
                    "The number need to be between 0 and %d not inclusive", nonWorkIncomeNumber, integerNonWorkIncomesDetailsMap.size()));
        }

        integerNonWorkIncomesDetailsMap.get(nonWorkIncomeNumber).enterState(state);
    }


    // Abroad Bank Accounts methods
    public void selectCountryAbroadBankAccountsFromDropDownListByName(int abroadBankAccountsNumber, String country) {
        if (abroadBankAccountsNumber<0 || abroadBankAccountsNumber>=integerAbroadBankAccountsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for an Abroad Bank Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", abroadBankAccountsNumber, integerAbroadBankAccountsDetailsMap.size()));
        }

        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).selectCountryFromDropDownListByName(country);

        recreateMapPannelsOnPage();
    }

    public void enterAbroadBankAccountsState(int abroadBankAccountsNumber, String state) {
        if (abroadBankAccountsNumber<0 || abroadBankAccountsNumber>=integerAbroadBankAccountsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for an Abroad Bank Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", abroadBankAccountsNumber, integerAbroadBankAccountsDetailsMap.size()));
        }

        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterState(state);
    }

    public void enterAbroadBankAccountsCity(int abroadBankAccountsNumber, String city) {
        if (abroadBankAccountsNumber<0 || abroadBankAccountsNumber>=integerAbroadBankAccountsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for an Abroad Bank Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", abroadBankAccountsNumber, integerAbroadBankAccountsDetailsMap.size()));
        }

        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterCity(city);
    }

    public void enterAbroadBankAccountsBankName(int abroadBankAccountsNumber, String bankName) {
        if (abroadBankAccountsNumber<0 || abroadBankAccountsNumber>=integerAbroadBankAccountsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for an Abroad Bank Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", abroadBankAccountsNumber, integerAbroadBankAccountsDetailsMap.size()));
        }

        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterBankName(bankName);
    }

    public void enterAbroadBankAccountsBankNum(int abroadBankAccountsNumber, String bankNum) {
        if (abroadBankAccountsNumber<0 || abroadBankAccountsNumber>=integerAbroadBankAccountsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for an Abroad Bank Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", abroadBankAccountsNumber, integerAbroadBankAccountsDetailsMap.size()));
        }

        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterBankNum(bankNum);
    }

    public void enterAbroadBankAccountsBranchName(int abroadBankAccountsNumber, String branchName) {
        if (abroadBankAccountsNumber<0 || abroadBankAccountsNumber>=integerAbroadBankAccountsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for an Abroad Bank Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", abroadBankAccountsNumber, integerAbroadBankAccountsDetailsMap.size()));
        }

        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterBranchName(branchName);
    }

    public void enterAbroadBankAccountsBranchNum(int abroadBankAccountsNumber, String branchNum) {
        if (abroadBankAccountsNumber<0 || abroadBankAccountsNumber>=integerAbroadBankAccountsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for an Abroad Bank Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", abroadBankAccountsNumber, integerAbroadBankAccountsDetailsMap.size()));
        }

        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterBranchNum(branchNum);
    }

    public void enterAbroadBankAccountsAccountNum(int abroadBankAccountsNumber, String accountNum) {
        if (abroadBankAccountsNumber<0 || abroadBankAccountsNumber>=integerAbroadBankAccountsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for an Abroad Bank Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", abroadBankAccountsNumber, integerAbroadBankAccountsDetailsMap.size()));
        }

        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterAccountNum(accountNum);
    }

    public void enterAbroadBankAccountsPartners(int abroadBankAccountsNumber, String partnersNum) {
        if (abroadBankAccountsNumber<0 || abroadBankAccountsNumber>=integerAbroadBankAccountsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for an Abroad Bank Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", abroadBankAccountsNumber, integerAbroadBankAccountsDetailsMap.size()));
        }

        integerAbroadBankAccountsDetailsMap.get(abroadBankAccountsNumber).enterPartnersNum(partnersNum);
    }


    // Digital Coins methods
    public void chooseDigitalCoinsBitcoin(int digitalCoinsNumber) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseBitcoin();

        recreateMapPannelsOnPage();
    }

    public void chooseDigitalCoinsNano(int digitalCoinsNumber) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseNano();

        recreateMapPannelsOnPage();
    }

    public void chooseDigitalCoinsSteem(int digitalCoinsNumber) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseSteem();

        recreateMapPannelsOnPage();
    }

    public void chooseDigitalCoinsCardano(int digitalCoinsNumber) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseCardano();

        recreateMapPannelsOnPage();
    }

    public void chooseDigitalCoinsAnotherCoin(int digitalCoinsNumber) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseAnotherCoin();

        recreateMapPannelsOnPage();
    }

    public void enterDigitalCoinsAnotherCoin(int digitalCoinsNumber, String anotherCoinName) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterAnotherCoin(anotherCoinName);
    }

    public void enterDigitalCoinsCoinAmount(int digitalCoinsNumber, String coinAmount) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterCoinAmount(coinAmount);
    }

    public void enterDigitalCoinsPublicKey(int digitalCoinsNumber, String publicKey) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterPublicKey(publicKey);
    }

    public void chooseDigitalCoinsCoinsMaterialized(int digitalCoinsNumber) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseCoinsMaterialized();

        recreateMapPannelsOnPage();
    }

    public void chooseDigitalCoinsCoinsDontMaterialized(int digitalCoinsNumber) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseCoinsDontMaterialized();

        recreateMapPannelsOnPage();
    }

    public void enterDigitalCoinsAmountMaterialized(int digitalCoinsNumber, String amountMaterialized) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterAmountMaterialized(amountMaterialized);
    }

    public void enterDigitalCoinsMaterializationValue(int digitalCoinsNumber, String materializationValue) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterMaterializationValue(materializationValue);
    }

    public void chooseDigitalCoinsPurchasedWithCoins(int digitalCoinsNumber) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).choosePurchasedWithCoins();

        recreateMapPannelsOnPage();
    }

    public void chooseDigitalCoinsDontPurchasedWithCoins(int digitalCoinsNumber) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).chooseDontPurchasedWithCoins();

        recreateMapPannelsOnPage();
    }

    public void enterDigitalCoinsAmountSold(int digitalCoinsNumber, String amountSold) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterAmountSold(amountSold);
    }

    public void enterDigitalCoinsSoldValue(int digitalCoinsNumber, String soldValue) {
        if (digitalCoinsNumber<0 || digitalCoinsNumber>=integerDigitalCoinsDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a Digital Coins Accounts #%d. " +
                    "The number need to be between 0 and %d not inclusive", digitalCoinsNumber, integerDigitalCoinsDetailsMap.size()));
        }

        integerDigitalCoinsDetailsMap.get(digitalCoinsNumber).enterSoldValue(soldValue);
    }




    // == private methods ==
    private void chooseHave(WebElement button) {
        try {
            scrollIntoViewMoveFocusAndClick(driver, button);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        button.click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        recreateMapPannelsOnPage();
    }

    private void chooseDontHave(WebElement button) {
        try {
            scrollIntoViewMoveFocusAndClick(driver, button);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        button.click();


        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        recreateMapPannelsOnPage();
    }

    private void add(WebElement btnAdd) {
        btnAdd.click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        recreateMapPannelsOnPage();
    }

    private void delete(int index, List<WebElement> btnsDelete) {
        if (btnsDelete.isEmpty()) {
            throw new WrongArgumentException(String.format("Impossible to delete a panel #%d," +
                    "the list of panels is empty", index));
        } else if (index == 0) {
            throw new WrongArgumentException(String.format("Impossible to delete a panel #%d", index));
        } else if (index<0 || index> btnsDelete.size()) {
            throw new WrongArgumentException(String.format("Impossible to delete a vehicle #%d. " +
                    "The number need to be between 1 and %d inclusive", index, btnsDelete.size()));
        }

        btnsDelete.get(index-1).click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        recreateMapPannelsOnPage();
    }

    private void recreateMapPannelsOnPage() {
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
