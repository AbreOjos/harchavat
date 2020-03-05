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

public class Vehicle extends BasePage {

    // == private fields ==
    private Map<Integer, VehicleDetails> integerVehicleDetailsMap;

    // == constructors==
    public Vehicle(WebDriver driver) {
        super(driver);
        this.driver = driver;

        recreateMapPannelsOnPage();

        PageFactory.initElements(this.driver, this);
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
    @FindBy(className = "shaamPage")
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

        PageFactory.initElements(driver, this);

        recreateMapPannelsOnPage();
    }

    public void chooseDontHaveVehicle() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnDontHaveVehicle);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);

        recreateMapPannelsOnPage();
    }

    public void deleteVehicle(int vehicleNumber) {
        if (btnsDeleteVehicle.isEmpty()) {
            throw new WrongArgumentException(String.format("Impossible to delete a vehicle #%d," +
                    "the list of vehicles is empty", vehicleNumber));
        } else if (vehicleNumber == 1) {
            throw new WrongArgumentException(String.format("Impossible to delete a vehicle #%d", vehicleNumber));
        } else if (vehicleNumber<1 || vehicleNumber>btnsDeleteVehicle.size()) {
            throw new WrongArgumentException(String.format("Impossible to delete a vehicle #%d. " +
                    "The number need to be between 2 and %d", vehicleNumber, btnsDeleteVehicle.size()));
        }

//        try {
//            scrollIntoViewMoveFocusAndClick(driver, btnsDeleteVehicle.get(vehicleNumber-1));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        btnsDeleteVehicle.get(vehicleNumber-2).click();


        PageFactory.initElements(driver, this);

        recreateMapPannelsOnPage();
    }

    public void addVehicle() {
//        try {
//            scrollIntoViewMoveFocusAndClick(driver, btnAddVehicle);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        btnAddVehicle.click();

        PageFactory.initElements(driver, this);

        recreateMapPannelsOnPage();
    }

    // choose vehicle type
    public void choosePrivateVehicle(int vehicleNumber) {
        if (vehicleNumber<1 || vehicleNumber>integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 1 and %d", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber-1).choosePrivateVehicle();
    }

    public void chooseCommercialVehicle(int vehicleNumber) {
        if (vehicleNumber<1 || vehicleNumber>integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 1 and %d", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber-1).chooseCommercialVehicle();
    }

    public void chooseHeavyVehicle(int vehicleNumber) {
        if (vehicleNumber<1 || vehicleNumber>integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 1 and %d", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber-1).chooseHeavyVehicle();
    }

    public void chooseAircraftVehicle(int vehicleNumber) {
        if (vehicleNumber<1 || vehicleNumber>integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 1 and %d", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber-1).chooseAircraftVehicle();
    }

    public void chooseVesselVehicle(int vehicleNumber) {
        if (vehicleNumber<1 || vehicleNumber>integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 1 and %d", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber-1).chooseVesselVehicle();
    }

    public void chooseAnotherVehicle(int vehicleNumber) {
        if (vehicleNumber<1 || vehicleNumber>integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 1 and %d", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber-1).chooseAnotherVehicle();
    }

    // add car license
    public void enterCarLicense(int vehicleNumber, String carLicense) {
        if (vehicleNumber<1 || vehicleNumber>integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 1 and %d", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(--vehicleNumber).enterCarLicense(carLicense);
    }

    // choose vehicle usage
    public void choosePrivateUsage(int vehicleNumber) {
        if (vehicleNumber<1 || vehicleNumber>integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 1 and %d", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber-1).choosePrivateUsage();
    }

    public void chooseCommercialUsage(int vehicleNumber) {
        if (vehicleNumber<1 || vehicleNumber>integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 1 and %d", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber-1).chooseCommercialUsage();
    }

    public void chooseAnotherUsage(int vehicleNumber) {
        if (vehicleNumber<1 || vehicleNumber>integerVehicleDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a vehicle #%d. " +
                    "The number need to be between 1 and %d", vehicleNumber, integerVehicleDetailsMap.size()));
        }

        integerVehicleDetailsMap.get(vehicleNumber-1).chooseAnotherUsage();
    }



    // == private methods ==
    private void recreateMapPannelsOnPage() {
        integerVehicleDetailsMap = new HashMap<>();

        PageFactory.initElements(driver, this);

//        List<WebElement> vehicleDetailsRows = driver.findElements(vehicleDetailsPanel);

        for (int i = 1; i < listVehicleDetailsPanels.size(); ++i) {
            WebElement webElement = listVehicleDetailsPanels.get(i);
            integerVehicleDetailsMap.put(i, new VehicleDetails(driver, webElement));
        }

    }

}
