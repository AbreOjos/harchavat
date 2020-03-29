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

        recreateMapPanelsOnPage();
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

        recreateMapPanelsOnPage();
    }

    public void chooseDontHaveVehicle() {
        chooseDontHave();

        recreateMapPanelsOnPage();
    }

    public void deleteVehicle(int indexVehicle) {

        deletePanel(indexVehicle);

        recreateMapPanelsOnPage();
    }

    public void deleteAllVehicles() {
        deleteAllPanels();

        recreateMapPanelsOnPage();
    }

    public void addVehicle() {

        addPanel();

        recreateMapPanelsOnPage();
    }

    // choose vehicle type
    public void choosePrivateVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).choosePrivateVehicle();

//        recreateMapPanelsOnPage();
//        PageFactory.initElements(driver, this);
    }

    public void chooseCommercialVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseCommercialVehicle();

//        recreateMapPanelsOnPage();
//        PageFactory.initElements(driver, this);
    }

    public void chooseHeavyVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseHeavyVehicle();

//        recreateMapPanelsOnPage();
//        PageFactory.initElements(driver, this);
    }

    public void chooseAircraftVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseAircraftVehicle();

//        recreateMapPanelsOnPage();
//        PageFactory.initElements(driver, this);
    }

    public void chooseVesselVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseVesselVehicle();

//        recreateMapPanelsOnPage();
    }

    public void chooseAnotherVehicle(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseAnotherVehicle();

//        recreateMapPanelsOnPage();
//        PageFactory.initElements(driver, this);
    }

    // addPanel and delete car license
    public void enterCarLicense(int vehicleNumber, String carLicense) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add car license for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).enterCarLicense(carLicense);
    }

    public void deleteCarLicense(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to delete car license for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).deleteCarLicense();
    }


    public void enterAnotherCarTypeDetails(int vehicleNumber, String anotherCarTypeDetails) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).enterAnotherCarTypeDetails(anotherCarTypeDetails);
    }

    public void deleteAnotherCarTypeDetails(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to delete details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).deleteAnotherCarTypeDetails();
    }

    public void enterAnotherUsageDetails(int vehicleNumber, String anotherUsageDetails) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).enterAnotherUsageDetails(anotherUsageDetails);
    }

    public void deleteAnotherUsageDetails(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to delete details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).deleteAnotherUsageDetails();
    }

    // choose vehicle usage
    public void choosePrivateUsage(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).choosePrivateUsage();

//        recreateMapPanelsOnPage();
//        PageFactory.initElements(driver, this);
    }

    public void chooseCommercialUsage(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseCommercialUsage();

//        recreateMapPanelsOnPage();
//        PageFactory.initElements(driver, this);
    }

    public void chooseAnotherUsage(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseAnotherUsage();

//        recreateMapPanelsOnPage();
//        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getNeedFillLicenseErrorMessage(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).getNeedFillLicenseErrorMessage();
    }

    public List<WebElement> getLicenseIncorrectErrorMessage(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).getLicenseIncorrectErrorMessage();
    }

    public List<WebElement> getNeedFillVehicleDetailsErrorMessage(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).getNeedFillVehicleDetailsErrorMessage();
    }

    public List<WebElement> getNeedFillUsageDetailsErrorMessage(int vehicleNumber) {
        if (vehicleNumber<0 || vehicleNumber>=integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get error message from a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).getNeedFillUsageDetailsErrorMessage();
    }



    // == private methods ==
    private void recreateMapPanelsOnPage() {
        integerVehicleDetailsMap = new HashMap<>();

        PageFactory.initElements(driver, this);

        List<WebElement> vehicleDetailsRows = driver.findElements(vehicleDetailsPanel);

        for (int i = 0; i < vehicleDetailsRows.size(); ++i) {
            WebElement webElement = vehicleDetailsRows.get(i);
            integerVehicleDetailsMap.put(i, new VehicleDetails(driver, webElement));
        }

    }

}
