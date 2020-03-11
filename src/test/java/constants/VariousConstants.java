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

    // sub-elements
    public static final By btnsTypeOfIncomeSubElementnonWorkIncomesDetails =
            By.xpath(".//div[@name='typeOfIncome']//button");
}
