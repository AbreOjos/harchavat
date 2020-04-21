package pom.forms.vehicles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.BaseConstants.checkCircleIconSubElementMenu;
import static constants.BaseConstants.errorIconSubElementMenu;
import static constants.VehicleConstants.vehicleDetailsPanel;

public class Vehicle extends BasePage {

    // == private fields ==
    private Map<Integer, VehicleDetails> integerVehicleDetailsMap;
    
    private String vehicle = "vehicle";

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

    public List<VehicleDetails> getListVehicles() {
        return new ArrayList<>(integerVehicleDetailsMap.values());
    }

    // choose vehicle type
    public void choosePrivateVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).choosePrivateVehicle();
    }

    public void chooseCommercialVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseCommercialVehicle();
    }

    public void chooseHeavyVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseHeavyVehicle();
    }

    public void chooseAircraftVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseAircraftVehicle();
    }

    public void chooseVesselVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseVesselVehicle();
    }

    public void chooseAnotherVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseAnotherVehicle();
    }

    // check chosen vehicle type
    public boolean chosenPrivateVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).chosenPrivateVehicle();
    }

    public boolean chosenCommercialVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).chosenCommercialVehicle();
    }

    public boolean chosenHeavyVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).chosenHeavyVehicle();
    }

    public boolean chosenAircraftVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).chosenAircraftVehicle();
    }

    public boolean chosenVesselVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).chosenVesselVehicle();
    }

    public boolean chosenAnotherVehicle(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).chosenAnotherVehicle();
    }

    // addPanel and delete car license
    public void enterCarLicense(int vehicleNumber, String carLicense) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).enterCarLicense(carLicense);
    }

    public void deleteCarLicense(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).deleteCarLicense();
    }

    public String getCarLicense(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).getCarLicense();
    }


    public void enterAnotherCarTypeDetails(int vehicleNumber, String anotherCarTypeDetails) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).enterAnotherCarTypeDetails(anotherCarTypeDetails);
    }

    public void deleteAnotherCarTypeDetails(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).deleteAnotherCarTypeDetails();
    }

    public String getAnotherCarTypeDetails(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).getAnotherCarTypeDetails();
    }

    public void enterAnotherUsageDetails(int vehicleNumber, String anotherUsageDetails) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).enterAnotherUsageDetails(anotherUsageDetails);
    }

    public void deleteAnotherUsageDetails(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).deleteAnotherUsageDetails();
    }

    public String getAnotherUsageDetails(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).getAnotherUsageDetails();
    }

    // choose vehicle usage
    public void choosePrivateUsage(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).choosePrivateUsage();
    }

    public void chooseCommercialUsage(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseCommercialUsage();
    }

    public void chooseAnotherUsage(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        integerVehicleDetailsMap.get(vehicleNumber).chooseAnotherUsage();
    }

    // check chosen usage
    public boolean chosenUsagePrivate(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).chosenUsagePrivate();
    }

    public boolean chosenUsageCommercial(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).chosenUsageCommercial();
    }

    public boolean chosenUsageAnother(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).chosenUsageAnother();
    }

    // error messages
    public List<WebElement> getNeedFillLicenseErrorMessage(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).getNeedFillLicenseErrorMessage();
    }

    public List<WebElement> getLicenseIncorrectErrorMessage(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).getLicenseIncorrectErrorMessage();
    }

    public List<WebElement> getNeedFillVehicleDetailsErrorMessage(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

        recreateMapPanelsOnPage();
        return integerVehicleDetailsMap.get(vehicleNumber).getNeedFillVehicleDetailsErrorMessage();
    }

    public List<WebElement> getNeedFillUsageDetailsErrorMessage(int vehicleNumber) {
        checkNumber(vehicleNumber, vehicle, integerVehicleDetailsMap);

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
