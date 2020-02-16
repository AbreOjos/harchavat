package pom.fillform.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pom.fillform.FillForm;

import static constants.FillFormConstants.falseSubElementYesNoBox;
import static constants.FillFormConstants.trueSubElementYesNoBox;

public class Vehicle extends FillForm {

    // == constructors==
    public Vehicle(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

    // == public methods ==
    public Vehicle clickHaveVehicle() {
        WebElement yes = yesNoBoxes.get(0).findElement(trueSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Vehicle(driver);
    }

    public Vehicle clickDontHaveVehicle() {
        WebElement yes = yesNoBoxes.get(0).findElement(falseSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Vehicle(driver);
    }

}
