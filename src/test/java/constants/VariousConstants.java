package constants;

import org.openqa.selenium.By;

public class VariousConstants {

    // == constructors ==
    private VariousConstants() {
    }

    // == constants ==

    // elements
    public static final By nonWorkIncomesDetailsPanel = By.xpath("//div[@id='nonWorkIncomes']//div[contains(@class, 'shaamPage')]");
    public static final By abroadBankAccountsDetailsPanel = By.xpath("//div[@id='abroadBankAccounts']//div[contains(@class, 'shaamPage')]");
    public static final By digitalCoinsDetailsPanel = By.xpath("//div[@id='digitalCoins']//div[contains(@class, 'shaamPage')]");
    public static final By stocksDetailsPanel = By.xpath("//div[@id='stocks']//div[contains(@class, 'shaamPage')]");
    public static final By partnershipDetailsPanel = By.xpath("//div[@id='partnerships']//div[contains(@class, 'shaamPage')]");
    public static final By ownJewelryDetailsPanel = By.xpath("//div[@id='ownJewelry']//div[contains(@class, 'shaamPage')]");
    public static final By ownArtDetailsPanel = By.xpath("//div[@id='ownArt']//div[contains(@class, 'shaamPage')]");
    public static final By dropDownListItems = By.xpath("//div[contains(@class, 'menuable__content__active')]//div[@class='v-list__tile__title']");


    // sub-elements

    // non work incomes details sub-element
    public static final By btnsTypeOfIncomeSubElementNonWorkIncomesDetails = By.xpath(".//div[@name='typeOfIncome']//button");
    public static final By txtIncomeSourceSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='incomeSource']");
    public static final By txtYearlyIncomeSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='yearlyIncome']");
    public static final By txtPayerNameSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='payerName']");
    public static final By txtTikNikuimSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='tikNikuim']");
    public static final By dropDownCitySubElementNonWorkIncomesDetails = By.xpath(".//input[@name='city']");
    public static final By dropDownStreetSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='street']");
    public static final By dropDownCountrySubElementNonWorkIncomesDetails = By.xpath(".//input[@name='countryOfIncome']");
    public static final By txtHouseNumSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='houseNum']");
    public static final By txtStateSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='spouseState']");

    // abroad bank accounts details sub-element
    public static final By dropDownCountrySubElementAbroadBankAccountsDetails = By.xpath(".//div[@class='v-select__selections']//input");
    public static final By txtStateSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='state']");
    public static final By txtCitySubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='city']");
    public static final By txtBankNameSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='bankName']");
    public static final By txtBankNumSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='bankNum']");
    public static final By txtBranchNameSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='branchName']");
    public static final By txtBranchNumSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='branchNum']");
    public static final By txtAccountNumSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='accountNum']");
    public static final By txtPartnersNumSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='partnersNum']");


}
