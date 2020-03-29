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

//        PageFactory.initElements(driver, this);
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
        if (elementHasClass(getBtnPrivateVehicle(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnPrivateVehicle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseCommercialVehicle() {
        if (elementHasClass(getBtnCommercialVehicle(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnCommercialVehicle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseHeavyVehicle() {
        if (elementHasClass(getBtnHeavyVehicle(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnHeavyVehicle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseAircraftVehicle() {
        if (elementHasClass(getBtnAircraftVehicle(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnAircraftVehicle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseVesselVehicle() {
        if (elementHasClass(getBtnVesselVehicle(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnVesselVehicle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseAnotherVehicle() {
        if (elementHasClass(getBtnAnotherVehicle(), "active"))
            return;

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

    protected void deleteCarLicense() {
        cleanFormField(getTxtCarLicense());
    }

    protected void enterAnotherCarTypeDetails(String anotherCarTypeDetails) {
        fillFormField(getTxtAnotherCarTypeDetails(), anotherCarTypeDetails);
    }

    protected void deleteAnotherCarTypeDetails() {
        cleanFormField(getTxtAnotherCarTypeDetails());
    }

    protected void enterAnotherUsageDetails(String anotherUsageDetails) {
        fillFormField(getTxtAnotherUsageDetails(), anotherUsageDetails);

    }

    protected void deleteAnotherUsageDetails() {
        cleanFormField(getTxtAnotherUsageDetails());
    }


    // vehicle usage details
    protected void choosePrivateUsage() {
        if (elementHasClass(getBtnUsagePrivate(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnUsagePrivate());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseCommercialUsage() {
        if (elementHasClass(getBtnUsageCommercial(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnUsageCommercial());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseAnotherUsage() {
        if (elementHasClass(getBtnUsageAnother(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnUsageAnother());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }
}
