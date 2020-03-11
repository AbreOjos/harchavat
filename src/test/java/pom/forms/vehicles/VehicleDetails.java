package pom.forms.vehicles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.waitFewSecondsWarningDisabled;
import static constants.VehicleConstants.*;

public class VehicleDetails extends BasePage {

    private final WebElement details;

    public VehicleDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    protected WebElement getBtnPrivateVehicle() {
        return details.findElements(btnsVehicleTypesSubElementDetails).get(0);
    }

    protected WebElement getBtnCommercialVehicle() {
        return details.findElements(btnsVehicleTypesSubElementDetails).get(1);
    }

    protected WebElement getBtnHeavyVehicle() {
        return details.findElements(btnsVehicleTypesSubElementDetails).get(2);
    }

    protected WebElement getBtnAircraftVehicle() {
        return details.findElements(btnsVehicleTypesSubElementDetails).get(3);
    }

    protected WebElement getBtnVesselVehicle() {
        return details.findElements(btnsVehicleTypesSubElementDetails).get(4);
    }

    protected WebElement getBtnAnotherVehicle() {
        return details.findElements(btnsVehicleTypesSubElementDetails).get(5);
    }

    protected WebElement getTxtCarLicense() {
        return details.findElement(txtCarLicenseSubElementDetails);
    }

    protected WebElement getTxtAnotherCarTypeDetails() {
        return details.findElement(txtAnotherCarTypeDetailsSubElementDetails);
    }

    protected WebElement getTxtAnotherUsageDetails() {
        return details.findElement(txtAnotherUsageDetailsSubElementDetails);
    }

    protected WebElement getBtnUsagePrivate() {
        return details.findElements(btnsVehicleUsageSubElementDetails).get(0);
    }

    protected WebElement getBtnUsageCommercial() {
        return details.findElements(btnsVehicleUsageSubElementDetails).get(1);
    }

    protected WebElement getBtnUsageAnother() {
        return details.findElements(btnsVehicleUsageSubElementDetails).get(2);
    }


    // choose vehicle type
    protected void choosePrivateVehicle() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnPrivateVehicle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseCommercialVehicle() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnCommercialVehicle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseHeavyVehicle() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnHeavyVehicle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseAircraftVehicle() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnAircraftVehicle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseVesselVehicle() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnVesselVehicle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseAnotherVehicle() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnAnotherVehicle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }


    // license details
    protected void enterCarLicense(String carLicense) {
        fillFormField(getTxtCarLicense(), carLicense);

    }

    protected void enterAnotherCarTypeDetails(String anotherCarTypeDetails) {
        fillFormField(getTxtAnotherCarTypeDetails(), anotherCarTypeDetails);
    }

    protected void enterAnotherUsageDetails(String anotherUsageDetails) {
        fillFormField(getTxtAnotherUsageDetails(), anotherUsageDetails);

    }


    // vehicle usage details
    protected void choosePrivateUsage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnUsagePrivate());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseCommercialUsage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnUsageCommercial());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseAnotherUsage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnUsageAnother());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }
}
