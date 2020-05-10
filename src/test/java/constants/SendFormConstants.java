package constants;

import org.openqa.selenium.By;

public class SendFormConstants {

    private SendFormConstants() {
    }

    // vehicle constants - sub-element of Vehicles list
    public static final By typeVehicleSubElementVehiclesList = By.xpath("./strong[contains(text(),'סוג רכב')]");
    public static final By licenseVehicleSubElementVehiclesList = By.xpath("./strong[contains(text(),'מספר רשיון רכב')]");
    public static final By usageVehicleSubElementVehiclesList = By.xpath("./strong[contains(text(),'שימוש ברכב')]");

    // wage constants - sub-element of Wages list
//    public static final By typeIncomeSubElementWagesList = By.xpath(".//strong[contains(text(), 'סוג ההכנסה')]");
    public static final By typeIncomeSubElementWagesList = By.xpath(".//h4[contains(text(), 'הכנסתי כשכיר')]/following-sibling::ul//strong[contains(text(), 'סוג ההכנסה')]");
    public static final By annualIncomeSubElementWagesList = By.xpath(".//h4[contains(text(), 'הכנסתי כשכיר')]/following-sibling::ul//strong[contains(text(), 'הכנסה שנתית')]");
    public static final By employerNameSubElementWagesList = By.xpath(".//h4[contains(text(), 'הכנסתי כשכיר')]/following-sibling::ul//strong[contains(text(), 'שם מעסיק')]");
    public static final By citySubElementWagesList = By.xpath(".//h4[contains(text(), 'הכנסתי כשכיר')]/following-sibling::ul//strong[contains(text(), 'עיר')]");
    public static final By streetIncomeSubElementWagesList = By.xpath(".//h4[contains(text(), 'הכנסתי כשכיר')]/following-sibling::ul//strong[contains(text(), 'רחוב')]");
    public static final By houseNumberIncomeSubElementWagesList = By.xpath(".//h4[contains(text(), 'הכנסתי כשכיר')]/following-sibling::ul//strong[contains(text(), 'מספר בית')]");
    public static final By tikNikuimSubElementWagesList = By.xpath(".//h4[contains(text(), 'הכנסתי כשכיר')]/following-sibling::ul//strong[contains(text(), 'תיק ניכויים')]");
    public static final By countrySubElementWagesList = By.xpath(".//h4[contains(text(), 'הכנסתי כשכיר')]/following-sibling::ul//strong[contains(text(), 'מדינה')]");
    public static final By stateSubElementWagesList = By.xpath(".//h4[contains(text(), 'הכנסתי כשכיר')]/following-sibling::ul//strong[contains(text(), 'מחוז')]");

    public static final By typeIncomeSubElementWagesSpouseList = By.xpath(".//h4[contains(text(), 'הכנסת בן/בת הזוג כשכיר/ה')]/following-sibling::ul//strong[contains(text(), 'סוג ההכנסה')]");
    public static final By annualIncomeSubElementWagesSpouseList = By.xpath(".//h4[contains(text(), 'הכנסת בן/בת הזוג כשכיר/ה')]/following-sibling::ul//strong[contains(text(), 'הכנסה שנתית')]");
    public static final By employerNameSubElementWagesSpouseList = By.xpath(".//h4[contains(text(), 'הכנסת בן/בת הזוג כשכיר/ה')]/following-sibling::ul//strong[contains(text(), 'שם מעסיק')]");
    public static final By citySubElementWagesSpouseList = By.xpath(".//h4[contains(text(), 'הכנסת בן/בת הזוג כשכיר/ה')]/following-sibling::ul//strong[contains(text(), 'עיר')]");
    public static final By streetIncomeSubElementWagesSpouseList = By.xpath(".//h4[contains(text(), 'הכנסת בן/בת הזוג כשכיר/ה')]/following-sibling::ul//strong[contains(text(), 'רחוב')]");
    public static final By houseNumberIncomeSubElementWagesSpouseList = By.xpath(".//h4[contains(text(), 'הכנסת בן/בת הזוג כשכיר/ה')]/following-sibling::ul//strong[contains(text(), 'מספר בית')]");
    public static final By tikNikuimSubElementWagesSpouseList = By.xpath(".//h4[contains(text(), 'הכנסת בן/בת הזוג כשכיר/ה')]/following-sibling::ul//strong[contains(text(), 'תיק ניכויים')]");
    public static final By countrySubElementWagesSpouseList = By.xpath(".//h4[contains(text(), 'הכנסת בן/בת הזוג כשכיר/ה')]/following-sibling::ul//strong[contains(text(), 'מדינה')]");
    public static final By stateSubElementWagesSpouseList = By.xpath(".//h4[contains(text(), 'הכנסת בן/בת הזוג כשכיר/ה')]/following-sibling::ul//strong[contains(text(), 'מחוז')]");

    // real-estate constants - sub-elements of Real Estate list
    public static final By tenantSubElementRealEstateList = By.xpath(".//li");

}
