package pom.forms.vehicles;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.BaseConstants.checkCircleIconSubElementMenu;
import static constants.BaseConstants.errorIconSubElementMenu;
import static constants.VehicleConstants.vehicleDetailsPanel;

public class Vehicle extends BasePage {

    // == private fields ==
    private Map<Integer, VehicleDetails> integerVehicleDetailsMap;

    // == constructors==
    public Vehicle(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);

        recreateMapPannelsOnPage();
    }

    // == public methods ==

    // menu icons
    public List<WebElement> getErrorIconMenu() {
        return getMenuVehicle().findElements(errorIconSubElementMenu);
    }

    public List<WebElement> getCheckCircleIconMenu() {
        return getMenuVehicle().findElements(checkCircleIconSubElementMenu);
    }

    public void chooseHaveVehicle() {

        chooseHave();

        recreateMapPannelsOnPage();
    }

    public void chooseDontHaveVehicle() {
        chooseDontHave();

        recreateMapPannelsOnPage();
    }

    public void deleteVehicle(int indexVehicle) {

        delete(indexVehicle);

        recreateMapPannelsOnPage();
    }

    public void addVehicle() {

        add();

        recreateMapPannelsOnPage();
    }

    // choose vehicle type
    public void choosePrivateVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).choosePrivateVehicle();

        recreateMapPannelsOnPage();
    }

    public void chooseCommercialVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).chooseCommercialVehicle();

        recreateMapPannelsOnPage();
    }

    public void chooseHeavyVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).chooseHeavyVehicle();

        recreateMapPannelsOnPage();
    }

    public void chooseAircraftVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).chooseAircraftVehicle();

        recreateMapPannelsOnPage();
    }

    public void chooseVesselVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).chooseVesselVehicle();

        recreateMapPannelsOnPage();
    }

    public void chooseAnotherVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).chooseAnotherVehicle();

        recreateMapPannelsOnPage();
    }

    // add car license
    public void enterCarLicense(int vehicleNumber, String carLicense) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add car license for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).enterCarLicense(carLicense);

//        recreateMapPannelsOnPage();
    }

    public void enterAnotherCarTypeDetails(int vehicleNumber, String anotherCarTypeDetails) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).enterAnotherCarTypeDetails(anotherCarTypeDetails);
    }

    public void enterAnotherUsageDetails(int vehicleNumber, String anotherUsageDetails) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).enterAnotherUsageDetails(anotherUsageDetails);

//        recreateMapPannelsOnPage();
    }

    // choose vehicle usage
    public void choosePrivateUsage(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).choosePrivateUsage();

        recreateMapPannelsOnPage();
    }

    public void chooseCommercialUsage(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).chooseCommercialUsage();

        recreateMapPannelsOnPage();
    }

    public void chooseAnotherUsage(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).chooseAnotherUsage();

        recreateMapPannelsOnPage();
    }



    // == private methods ==
    private void recreateMapPannelsOnPage() {
        integerVehicleDetailsMap = new HashMap<>();

        PageFactory.initElements(driver, this);

        List<WebElement> vehicleDetailsRows = driver.findElements(vehicleDetailsPanel);

        for (int i = 0; i < vehicleDetailsRows.size(); ++i) {
            WebElement webElement = vehicleDetailsRows.get(i);
            integerVehicleDetailsMap.put(i, new VehicleDetails(driver, webElement));
        }

    }

}
