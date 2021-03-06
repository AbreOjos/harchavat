package constants;

import org.openqa.selenium.By;

public class WagesConstants {

    // == constructors ==
    private WagesConstants() {
    }

    // constants

    // elements
//    public static final By wagesDetailsPanel = By.xpath("//div[@class='other-box']/div[2]/div/div/div/div");
    public static final By wagesDetailsPanel = By.xpath("//div[@class='other-box']/div[2]/div/div/div/div/*[@id='workTypeOfIncomeId']/..");
    public static final By wagesSpouseDetailsPanel = By.xpath("//div[@class='other-box']/div[2]/div/div/div/*[@id='workTypeOfIncomeId']/..");


    // sub-elements
    public static final By txtEmployerNameSubElementDetails = By.xpath(".//*[@name='employerName']");
    public static final By txtTikNikuimSubElementDetals = By.xpath(".//input[@name='tikNumber']");
    public static final By txtAnnualIncomeSubElementDetails = By.xpath(".//input[@name='anualIncome']");
    public static final By btnIsraelIncomeSubElementDetails = By.xpath(".//button[@value='israelIncome']");
    public static final By btnAbroadIncomeSubElementDetails = By.xpath(".//button[@value='abroardIncome']");
    public static final By dropDownCountrySubElementDetails = By.xpath(".//input[@name='countryOfIncomeWork']");
    public static final By txtStreetSubElementDetails = By.xpath(".//input[@name='street']");

    // error messages sub-elements
    public static final By errorMessageNeedFillAnnualIncomeSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה הכנסה שנתית')]");
    public static final By errorMessageNeedFillEmployerNameSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה שם מעסיק')]");
    public static final By errorMessageTikNikuimNeedBeNineDigitsSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה תיק ניכויים חייב להכיל 9 תווים לפחות')]");
    public static final By errorMessageTikNikuimCannotBeLongerNineDigitsSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה תיק ניכויים לא יכול להכיל יותר מ- 9 תווים')]");
    public static final By errorMessageEmployerNameContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה שם מעסיק יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");

}
