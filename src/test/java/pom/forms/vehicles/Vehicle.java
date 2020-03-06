package pom.forms.vehicles;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
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

    // == web elements ==
    @FindBy(xpath = "//button[@value='true']")
    private WebElement btnHaveVehicle;
    @FindBy(xpath = "//button[@value='false']")
    private WebElement btnDontHaveVehicle;
    @FindBy(xpath = "//span[contains(., 'delete')]")
    private List<WebElement> btnsDeleteVehicle;
    @FindBy(xpath = "//div[@class='add-item w-inline-block']//img")
    private WebElement btnAddVehicle;
    @FindBy(xpath = "//*[@class='shaamPage']")
    private List<WebElement> listVehicleDetailsPanels;

    // == getters ==
    public WebElement getBtnHaveVehicle() {
        return btnHaveVehicle;
    }

    public WebElement getBtnDontHaveVehicle() {
        return btnDontHaveVehicle;
    }

    public Map<Integer, VehicleDetails> getIntegerVehicleDetailsMap() {
        return integerVehicleDetailsMap;
    }

    public List<WebElement> getBtnsDeleteVehicle() {
        return btnsDeleteVehicle;
    }

    public WebElement getBtnAddVehicle() {
        return btnAddVehicle;
    }

    public List<WebElement> getListVehicleDetailsPanels() {
        return listVehicleDetailsPanels;
    }


    // == public methods ==
    public void chooseHaveVehicle() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnHaveVehicle);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        PageFactory.initElements(driver, this);

        recreateMapPannelsOnPage();
    }

    public void chooseDontHaveVehicle() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnDontHaveVehicle);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        PageFactory.initElements(driver, this);

        recreateMapPannelsOnPage();
    }

    public void deleteVehicle(int indexVehicle) {
        if (btnsDeleteVehicle.isEmpty()) {
            throw new WrongArgumentException(String.format("Impossible to delete a vehicle #%d," +
                    "the list of vehicles is empty", indexVehicle));
        } else if (indexVehicle == 0) {
            throw new WrongArgumentException(String.format("Impossible to delete a vehicle #%d", indexVehicle));
        } else if (indexVehicle<0 || indexVehicle>btnsDeleteVehicle.size()) {
            throw new WrongArgumentException(String.format("Impossible to delete a vehicle #%d. " +
                    "The number need to be between 1 and %d inclusive", indexVehicle, btnsDeleteVehicle.size()));
        }

//        try {
//            scrollIntoViewMoveFocusAndClick(driver, btnsDeleteVehicle.get(indexVehicle-1));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        btnsDeleteVehicle.get(indexVehicle-1).click();


//        PageFactory.initElements(driver, this);

        recreateMapPannelsOnPage();
    }

    public void addVehicle() {
//        try {
//            scrollIntoViewMoveFocusAndClick(driver, btnAddVehicle);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        btnAddVehicle.click();

//        PageFactory.initElements(driver, this);

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
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 0 and %d not inclusive", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber).enterCarLicense(carLicense);

//        recreateMapPannelsOnPage();
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
