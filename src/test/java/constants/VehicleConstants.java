package constants;

import org.openqa.selenium.By;

public class VehicleConstants {

    private VehicleConstants() {
    }

    // sub-elements
    public static final By vehicleDetailsPanel = By.className("shaamPage");
    public static final By btnsVehicleTypesSubElementDetails = By.xpath(".//*[@class='shaamPage']//*[not(@name='usage')]/button");
    public static final By btnsVehicleUsageSubElementDetails = By.xpath(".//*[@name='usage']/button");
    public static final By txtCarLicenseSubElementDetails = By.xpath(".//*[@name='carLicense']");
}
