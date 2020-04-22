package constants;

import org.openqa.selenium.By;

public class BaseConstants {
    private BaseConstants() {
    }

//    public static final By waitFewSecondsWarningDisabled =
//            By.xpath("//*[@class='v-dialog v-dialog--persistent' and contains(@style, 'display: none')]");
    public static final By waitFewSecondsWarningDisabled =
            By.xpath("//*[@class='v-dialog v-dialog--persistent' and contains(@style, 'display: none')]//div[@role='progressbar']");


    // sub-elements
    public static final By errorIconSubElementMenu = By.xpath(".//i[contains(., 'error')]");
    public static final By checkCircleIconSubElementMenu = By.xpath(".//i[contains(., 'check_circle')]");

    public static final By dropDownCitySubElementDetails = By.xpath(".//input[@name='city']");
    public static final By dropDownStreetSubElementDetails = By.xpath(".//input[@name='street']");
    public static final By txtStreetSubElementDetails = By.xpath(".//input[@name='street']");
    public static final By txtCitySubElementDetail = By.xpath(".//input[@name='city']");
    public static final By txtHouseNumSubElementDetails = By.xpath(".//input[@name='houseNum']");
    public static final By txtStateSubElementDetails = By.xpath(".//input[@name='state']");

    // error messages
    public static final By errorMessageNeedFillTypeIncomeSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה סוג ההכנסה')]");
    public static final By errorMessageNeedFillTikNikuimSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה תיק ניכויים')]");
    public static final By errorMessageNeedFillCitySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה עיר')]");
    public static final By errorMessageNeedFillStreetSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה רחוב')]");
    public static final By errorMessageNeedFillHouseNumberSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מספר בית')]");
    public static final By errorMessageNeedFillCountrySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מדינה')]");
    public static final By errorMessageTikNikuimCanContainDigitsOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה תיק ניכויים יכול להכיל ספרות שלמות בלבד')]");
    public static final By errorMessageHouseNumberContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר בית יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageStateContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מחוז יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageCityContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה עיר יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageStreetContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה רחוב יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
}
