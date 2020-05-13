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
    public static final By txtAnnualIncomeSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='yearlyIncome']");
    public static final By txtPayerNameSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='payerName']");
    public static final By txtTikNikuimSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='tikNikuim']");
    public static final By dropDownStreetSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='street']");
    public static final By dropDownCountrySubElementNonWorkIncomesDetails = By.xpath(".//input[@name='countryOfIncome']");
    public static final By txtHouseNumSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='houseNum']");
    public static final By txtStateSubElementNonWorkIncomesDetails = By.xpath(".//input[@name='state']");

    // non work incomes errors sub-elements
    public static final By errorMessageNeedFillIncomeSourceSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מקור הכנסה')]");
    public static final By errorMessageNeedFillAnnualIncomeSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה גובה הכנסה שנתית')]");
    public static final By errorMessageNeedFillPayerNameSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה שם המשלם')]");
    public static final By errorMessageAnnualIncomeTwentyCharsMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה גובה הכנסה שנתית לא יכול להכיל יותר מ- 20 תווים')]");
    public static final By errorMessageCityFifteenCharsMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה עיר לא יכול להכיל יותר מ- 15 תווים')]");
    public static final By errorMessageStreetFifteenCharsMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה רחוב לא יכול להכיל יותר מ- 15 תווים')]");
    public static final By errorMessageIncomeSourceContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מקור הכנסה יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessagePayerNameContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה שם המשלם יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");

    // abroad bank accounts details sub-element
    public static final By dropDownCountrySubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='country']");
    public static final By txtStateSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='state']");
    public static final By txtBankNameSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='bankName']");
    public static final By txtBankNumSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='bankNum']");
    public static final By txtBranchNameSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='branchName']");
    public static final By txtBranchNumSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='branchNum']");
    public static final By txtAccountNumSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='accountNum']");
    public static final By txtPartnersNumSubElementAbroadBankAccountsDetails = By.xpath(".//input[@name='partnersNum']");

    // abroad bank accounts errors sub-elements
    public static final By errorMessageNeedFillBankNameSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה שם בנק')]");
    public static final By errorMessageNeedFillBankNumSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מספר בנק')]");
    public static final By errorMessageNeedFillBranchNameSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה שם סניף')]");
    public static final By errorMessageNeedFillBranchNumSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מספר סניף')]");
    public static final By errorMessageNeedFillAccountNumSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מספר חשבון')]");
    public static final By errorMessageNeedFillNumPartnersInAccountSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מספר שותפים בחשבון')]");
    public static final By errorMessageBankNameContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה שם בנק יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageBankNumContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר בנק יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageBranchNameContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה שם סניף יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageBranchNumContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר סניף יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageAccountNumContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר חשבון יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageNumPartnersInAccountContainsDigitsOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר שותפים בחשבון יכול להכיל ספרות שלמות בלבד')]");
    public static final By errorMessageBankNumTenCharsMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר בנק לא יכול להכיל יותר מ- 10 תווים')]");

    // digital coins details
    public static final By btnsTypeOfIncomeSubElementDigitalCoinsDetails = By.xpath(".//div[contains(@class, 'bgl-toggle')]//button");
    public static final By txtAnotherCoinSubElementDigitalCoinsDetails = By.xpath(".//input[@name='keyInCoin']");
    public static final By txtCoinAmountSubElementDigitalCoinsDetails = By.xpath(".//input[@name='coinAmount']");
    public static final By txtPublicKeySubElementDigitalCoinsDetails = By.xpath(".//input[@name='publicKey']");
    public static final By btnCoinsMaterializedSubElementDigitalCoinsDetails = By.xpath(".//div[@id='isCoinMaterializedId']//button[@value='true']");
    public static final By btnCoinsDontMaterializedSubElementDigitalCoinsDetails = By.xpath(".//div[@id='isCoinMaterializedId']//button[@value='false']");
    public static final By txtAmountMaterializedSubElementDigitalCoinsDetails = By.xpath(".//input[@name='amountMaterialized']");
    public static final By txtMaterializationValueSubElementDigitalCoinsDetails = By.xpath(".//input[@name='materializationValue']");
    public static final By btnPurchasedWithCoinsSubElementDigitalCoinsDetails = By.xpath(".//div[@id='isCoinSellId']//button[@value='true']");
    public static final By btnDontPurchasedWithCoinsSubElementDigitalCoinsDetails = By.xpath(".//div[@id='isCoinSellId']//button[@value='false']");
    public static final By txtAmountUsedSubElementDigitalCoinsDetails = By.xpath(".//input[@name='amountSold']");
    public static final By txtUsedValueSubElementDigitalCoinsDetails = By.xpath(".//input[@name='soldValue']");

    // digital coins errors sub-elements
    public static final By errorMessageNeedFillCoinTypeSubElementDetails =
            By.xpath(".//p[@class='errors-msg'][contains(text(),'חובה למלא את השדה בחר סוג מטבע')]");
    public static final By errorMessageNeedFillAnotherCoinSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה הקלד מטבע')]");
    public static final By errorMessageNeedFillNumberOfCoinsSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה כמות מטבעות שברשותך')]");
    public static final By errorMessageNeedFillPublicKeyDigitalWalletSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מפתח ציבורי של הארנק הדיגיטלי')]");
    public static final By errorMessageNeedDidYouSellCoinsSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה האם מכרת מטבעות בשנת')]");
    public static final By errorMessageNeedFillHowManyCoinsSoldSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה כמות מטבעות שמכרת')]");
    public static final By errorMessageNeedFillTotalSalesSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה סהכ ערך המכירה')]");
    public static final By errorMessageNeedFillDidYouBuyWithCoinsSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה האם רכשת מוצרים באמצעות המטבעות בשנת')]");
    public static final By errorMessageNeedFillHowManyCoinsUsedSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה כמות מטבעות שמומשה')]");
    public static final By errorMessageNeedFillTotalUsedValueSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה סהכ ערך המכירה')]");
    public static final By errorMessageNumberOfCoinsDigitsOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה כמות מטבעות שברשותך חייב להיות מספרי ולהכיל 3 נקודות עשרוניות')]");
    public static final By errorMessageNumberOfCoinsThirtyCharsMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה כמות מטבעות שברשותך לא יכול להכיל יותר מ- 30 תווים')]");
    public static final By errorMessagePublicKeyDigitsAndLettersOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מפתח ציבורי של הארנק הדיגיטלי יכול להכיל רק אותיות ומספרים')]");
    public static final By errorMessageCoinsSellDigitsOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה כמות מטבעות שמכרת חייב להיות מספרי ולהכיל 3 נקודות עשרוניות')]");
    public static final By errorMessageTotalSalesTwentyCharsMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה סהכ ערך המכירה לא יכול להכיל יותר מ- 20 תווים')]");
    public static final By errorMessageHowManyCoinsUsedDigitsOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה כמות מטבעות שמומשה חייב להיות מספרי ולהכיל 3 נקודות עשרוניות')]");
    public static final By errorMessageHowManyCoinsUsedThirtyCharsMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה כמות מטבעות שמומשה לא יכול להכיל יותר מ- 30 תווים')]");
    public static final By errorMessageTotalUsedTwentyCharsMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה סהכ ערך המכירה לא יכול להכיל יותר מ- 20 תווים')]");


    // stocks details
    public static final By txtCompanyNameSubElementStocksDetails = By.xpath(".//input[@name='companyName']");
    public static final By btnsCompanySourceSubElementStocksDetails = By.xpath(".//div[@name='companySource']/button");
    public static final By dropDownCountrySubElementStocksDetails = By.xpath(".//input[@name='countryOfIncome']");
    public static final By txtStateSubElementStocksDetails = By.xpath(".//input[@name='state']");
    public static final By txtCompanyNumSubElementStocksDetails = By.xpath(".//input[@name='companyNum']");
    public static final By txtCompanyPercentageSubElementStocksDetails = By.xpath(".//input[@name='companyPercentage']");

    // stock errors sub-elements
    public static final By errorMessageNeedFillCompanyNameSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה שם חברה')]");
    public static final By errorMessageNeedFillCompanySourceSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה החברה רשומה בארץ או')]");
    public static final By errorMessageNeedFillCompanyNumSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מספר חברה')]");
    public static final By errorMessageNeedFillCompanyPercentageSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה אחוז אחזקה בחברה')]");
    public static final By errorMessageCompanyNameContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה שם חברה יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageCompanyNumContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר חברה יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageCompanyPercentageOneHundredMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה אחוז אחזקה בחברה יכול להיות 100 לכל היותר')]");
    public static final By errorMessageCompanyPercentageOneMinSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'הערך של אחוז אחזקה בחברה חייב להיות לפחות 1')]");
    public static final By errorMessageCompanyNumDigitsOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר חברה יכול להכיל ספרות שלמות בלבד')]");
    public static final By errorMessageCompanyNumNineDigitsMinSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר חברה חייב להכיל 9 תווים לפחות')]");
    public static final By errorMessageCompanyNumNineDigitsMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר חברה לא יכול להכיל יותר מ- 9 תווים')]");

    // partnerships details
    public static final By txtNameSubElementPartnershipsDetails = By.xpath(".//input[@name='name']");
    public static final By btnsPartnershipLocationSubElementPartnershipsDetails = By.xpath(".//div[@name='partnershipLocation']/button");
    public static final By txtBusinessNumSubElementPartnershipsDetails = By.xpath(".//input[@name='osekNum']");
    public static final By txtPercentageSubElementPartnershipsDetails = By.xpath(".//input[@name='percentage']");
    public static final By dropDownCountrySubElementPartnershipsDetails = By.xpath(".//input[@name='country']");
    public static final By txtStateSubElementPartnershipsDetails = By.xpath(".//input[@name='state']");

    // partnership errors sub-elements
    public static final By errorMessageNeedFillNameSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה שם')]");
    public static final By errorMessageNeedFillPartnershipLocationSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מיקום השותפות')]");
    public static final By errorMessageNeedFillBusinessNumSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מספר עוסק')]");
    public static final By errorMessageNeedFillPercentageSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה אחוז')]");
    public static final By errorMessageBusinessNumDigitsOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר עוסק יכול להכיל ספרות שלמות בלבד')]");
    public static final By errorMessageBusinessNumNineDigitsMinSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר עוסק חייב להכיל 9 תווים לפחות')]");
    public static final By errorMessageBusinessNumNineDigitsMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר עוסק לא יכול להכיל יותר מ- 9 תווים')]");
    public static final By errorMessagePercentageOneHundredMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה אחוז יכול להיות 100 לכל היותר')]");
    public static final By errorMessagePercentageOneMinSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'הערך של אחוז חייב להיות לפחות 1')]");
    public static final By errorMessagePercentageThreeCharsMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה אחוז לא יכול להכיל יותר מ- 3 תווים')]");
    public static final By errorMessageNameContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה שם יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageBusinessNumContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר עוסק יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");



}
