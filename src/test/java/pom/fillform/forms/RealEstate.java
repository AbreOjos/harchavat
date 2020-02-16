package pom.fillform.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pom.fillform.FillForm;

import static constants.FillFormConstants.falseSubElementYesNoBox;
import static constants.FillFormConstants.trueSubElementYesNoBox;

public class RealEstate extends FillForm {

    // == constructors==
    public RealEstate(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

    // == public methods ==
    public RealEstate clickHaveRealEstate() {
        WebElement yes = yesNoBoxes.get(0).findElement(trueSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new RealEstate(driver);
    }

    public RealEstate clickDontHaveRealEstate() {
        WebElement yes = yesNoBoxes.get(0).findElement(falseSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new RealEstate(driver);
    }


}
