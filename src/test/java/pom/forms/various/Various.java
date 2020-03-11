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

    @FindBy(xpath = "//div[@id='nonWorkIncomes']//div[@class='add-item w-inline-block']//img")
    private WebElement btnAddNonWorkIncomes;
    @FindBy(xpath = "//div[@id='abroadBankAccounts']//div[@class='add-item w-inline-block']//img")
    private WebElement btnAddAbroadBankAccounts;
    @FindBy(xpath = "//div[@id='digitalCoins']//div[@class='add-item w-inline-block']//img")
    private WebElement btnAddDigitalCoins;
    @FindBy(xpath = "//div[@id='stocks']//div[@class='add-item w-inline-block']//img")
    private WebElement btnAddStocks;
    @FindBy(xpath = "//div[@id='partnerships']//div[@class='add-item w-inline-block']//img")
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

    // == override methods ==
    @Override
    protected void chooseHave() {
        try {
            throw new Exception("Do not call chooseHave method from an instance of a Various class");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    protected void chooseDontHave() {
        try {
            throw new Exception("Do not call chooseDontHave method from an instance of a Various class");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    protected void delete(int index) {
        try {
            throw new Exception("Do not call delete method from an instance of a Various class");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    protected void add() {
        try {
            throw new Exception("Do not call add method from an instance of a Various class");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    // == public methods ==
    // Have / Don't Have methods
    protected void chooseHaveNonWorkIncomes() {
        chooseHave(btnHaveNonWorkIncomes);
    }

    protected void chooseDontHaveNonWorkIncomes() {
        chooseDontHave(btnHaveNonWorkIncomes);
    }

    protected void chooseHaveAbroadBankAccounts() {
        chooseHave(btnHaveAbroadBankAccounts);
    }

    protected void chooseDontHaveAbroadBankAccounts() {
        chooseDontHave(btnDontHaveAbroadBankAccounts);

    }

    protected void chooseHaveDigitalCoins() {
        chooseHave(btnDontHaveDigitalCoins);
    }

    protected void chooseDontHaveDigitalCoins() {
        chooseDontHave(btnDontHaveDigitalCoins);
    }

    protected void chooseHaveStocks() {
        chooseHave(btnDontHaveStocks);
    }

    protected void chooseDontHaveStocks() {
        chooseDontHave(btnDontHaveStocks);
    }

    protected void chooseHavePartnerships() {
        chooseHave(btnDontHavePartnerships);
    }

    protected void chooseDontHavePartnerships() {
        chooseDontHave(btnDontHavePartnerships);
    }

    protected void chooseHaveJewelry() {
        chooseHave(btnDontHaveJewelry);
    }

    protected void chooseDontHaveJewelry() {
        chooseDontHave(btnDontHaveJewelry);
    }

    protected void chooseHaveArt() {
        chooseHave(btnDontHaveArt);
    }

    protected void chooseDontHaveArt() {
        chooseDontHave(btnDontHaveArt);
    }

    // add and delete panels
    protected void addNonWorkIncomes() {
        add(btnAddNonWorkIncomes);
    }

    protected void addAbroadBankAccounts() {
        add(btnAddAbroadBankAccounts);
    }

    protected void addDigitalCoins() {
        add(btnAddDigitalCoins);
    }

    protected void addStocks() {
        add(btnAddStocks);
    }

    protected void addPartnerships() {
        add(btnAddPartnerships);
    }

    protected void deleteNonWorkIncomes(int index) {
        delete(index, btnsDeleteNonWorkIncomes);
    }

    protected void deleteAbroadBankAccounts(int index) {
        delete(index, btnsDeleteAbroadBankAccounts);
    }

    protected void deleteDigitalCoins(int index) {
        delete(index, btnsDeleteDigitalCoins);
    }

    protected void deleteStocks(int index) {
        delete(index, btnsDeleteStocks);
    }

    protected void deletePartnerships(int index) {
        delete(index, btnsDeletePartnerships);
    }

    // == private methods ==
    private void chooseHave(WebElement button) {
        try {
            scrollIntoViewMoveFocusAndClick(driver, button);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        recreateMapPannelsOnPage();
    }

    private void chooseDontHave(WebElement button) {
        try {
            scrollIntoViewMoveFocusAndClick(driver, button);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        recreateMapPannelsOnPage();
    }

    private void add(WebElement btnAdd) {
        btnAdd.click();
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
