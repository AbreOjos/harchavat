package constants;

import org.openqa.selenium.By;

public class WagesConstants {

    // == constructors ==
    private WagesConstants() {
    }

    // constants

    // elements
    public static final By wagesDetailsPanel = By.xpath("//div[@class='other-box']/div[2]/div/div/div/div");

    // sub-elements
    public static final By txtEmployerNameSubElementDetails = By.xpath(".//*[@name='employerName']");
    public static final By txtTikNikuimSubElementDetals = By.xpath(".//input[@name='tikNumber']");
    public static final By txtAnnualIncomeSubElementDetails = By.xpath(".//input[@name='anualIncome']");
    public static final By btnIsraelIncomeSubElementDetails = By.xpath(".//button[@value='israelIncome']");
    public static final By btnAbroadIncomeSubElementDetails = By.xpath(".//button[@value='abroardIncome']");
    public static final By dropDownCountrySubElementDetails = By.xpath(".//input[@name='countryOfIncomeWork']");
//    public static final By txtStateSubElementDetails = By.xpath(".//input[@name='state']");
//    public static final By txtCitySubElementDetail = By.xpath(".//input[@name='city']");
    public static final By txtStreetSubElementDetails = By.xpath(".//input[@name='street']");
//    public static final By txtHouseNumSubElementDetails = By.xpath(".//input[@name='houseNum']");

    // error messages sub-elements
    public static final By errorMessageNeedFillTypeIncomeSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה סוג ההכנסה')]");
    public static final By errorMessageNeedFillAnnualIncomeSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה הכנסה שנתית')]");
    public static final By errorMessageNeedFillEmployerNameSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה שם מעסיק')]");
    public static final By errorMessageNeedFillCitySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה עיר')]");
    public static final By errorMessageNeedFillStreetSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה רחוב')]");
    public static final By errorMessageNeedFillHouseNumberSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מספר בית')]");
    public static final By errorMessageNeedFillTikNikuimSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה תיק ניכויים')]");
    public static final By errorMessageNeedFillCountrySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מדינה')]");
    public static final By errorMessageTikNikuimNeedBeNineDigitsSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה תיק ניכויים חייב להכיל 9 תווים לפחות')]");
    public static final By errorMessageTikNikuimCannotBeLongerNineDigitsSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה תיק ניכויים לא יכול להכיל יותר מ- 9 תווים')]");
    public static final By errorMessageTikNikuimCanContainDigitsOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה תיק ניכויים יכול להכיל ספרות שלמות בלבד')]");
    public static final By errorMessageEmployerNameContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה שם מעסיק יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageHouseNumberContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר בית יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageStateContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מחוז יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageCityContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה עיר יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageStreetContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה רחוב יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");


}
