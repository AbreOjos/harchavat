package constants;

import org.openqa.selenium.By;

public class VehicleConstants {

    private VehicleConstants() {
    }

    // elements
    public static final By vehicleDetailsPanel = By.xpath("//*[@class='shaamPage']");

    // sub-elements
    public static final By btnsVehicleTypesSubElementDetails = By.xpath(".//*[not(@name='usage')]/button");
    public static final By btnsVehicleUsageSubElementDetails = By.xpath(".//*[@name='usage']/button");
    public static final By txtCarLicenseSubElementDetails = By.xpath(".//*[@name='carLicense']");
    public static final By txtAnotherCarTypeDetailsSubElementDetails = By.xpath(".//input[@name='explain']");
    public static final By txtAnotherUsageDetailsSubElementDetails = By.xpath(".//input[@name='usageDetails']");
}
