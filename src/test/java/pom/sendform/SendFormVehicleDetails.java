package pom.sendform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import static constants.EnglishHebrewConstants.*;
import static constants.SendFormConstants.*;

public class SendFormVehicleDetails extends BasePage {

    // == private members ==
    private final WebElement details;

    // == constructors ==
    public SendFormVehicleDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    protected boolean typeVehicleExists() {
        return details.findElements(typeVehicleSubElementVehiclesList).size() > 0;
    }

    protected boolean licenseVehicleExists() {
        return details.findElements(licenseVehicleSubElementVehiclesList).size() > 0;
    }

    protected boolean usageVehicleExists() {
        return details.findElements(usageVehicleSubElementVehiclesList).size() > 0;
    }

    protected boolean elementContainsText(String text) {
        return details.getText().contains(text);
    }

    protected boolean vehiclePrivate() {
        return details.getText().contains(PRIVATE);
    }

    protected boolean vehicleCommercial() {
        return details.getText().contains(COMMERCIAL);
    }

    protected boolean vehicleHeavyEngineeringEquipment() {
        return details.getText().contains(HEAVY_ENGINEERING_EQUIPMENT);
    }

    protected boolean vehicleAircraft() {
        return details.getText().contains(AIRCRAFT);
    }

    protected boolean vehicleVessel() {
        return details.getText().contains(VESSEL);
    }

    protected boolean usageVehiclePrivate() {
        return details.getText().contains(PRIVATE);
    }

    protected boolean usageVehicleBusiness() {
        return details.getText().contains(BUSINESS);
    }

}
