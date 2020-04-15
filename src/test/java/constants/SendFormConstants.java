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
    public static final By typeIncomeSubElementWagesList = By.xpath(".//strong[contains(text(), 'סוג ההכנסה')]");
    public static final By annualIncomeSubElementWagesList = By.xpath(".//strong[contains(text(), 'הכנסה שנתית')]");
    public static final By employerNameSubElementWagesList = By.xpath(".//strong[contains(text(), 'שם מעסיק')]");
    public static final By citySubElementWagesList = By.xpath(".//strong[contains(text(), 'עיר')]");
    public static final By streetIncomeSubElementWagesList = By.xpath(".//strong[contains(text(), 'רחוב')]");
    public static final By houseNumberIncomeSubElementWagesList = By.xpath(".//strong[contains(text(), 'מספר בית')]");
    public static final By tikNikuimSubElementWagesList = By.xpath(".//strong[contains(text(), 'תיק ניכויים')]");
    public static final By countrySubElementWagesList = By.xpath(".//strong[contains(text(), 'מדינה')]");
    public static final By stateSubElementWagesList = By.xpath(".//strong[contains(text(), 'מחוז')]");


    // real-estate constants - sub-elements of Real Estate list
    public static final By tenantSubElementRealEstateList = By.xpath(".//li");

}
