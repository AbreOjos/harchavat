package constants;

import org.openqa.selenium.By;

public class SendFormConstants {

    private SendFormConstants() {
    }

    // vehicle constants - sub-element of Vehicles list
    public static final By typeVehicleSubElementVehiclesList = By.xpath("./strong[contains(text(),'סוג רכב')]");
    public static final By licenseVehicleSubElementVehiclesList = By.xpath("./strong[contains(text(),'מספר רשיון רכב')]");
    public static final By usageVehicleSubElementVehiclesList = By.xpath("./strong[contains(text(),'שימוש ברכב')]");

    // real-estate constants - sub-elements of Real Estate list
    public static final By tenantSubElementRealEstateList = By.xpath(".//li");

}
