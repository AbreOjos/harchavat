package pom.fillform.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pom.fillform.FillForm;

import static constants.FillFormConstants.falseSubElementYesNoBox;
import static constants.FillFormConstants.trueSubElementYesNoBox;

public class Various extends FillForm {

    // == constructors==
    public Various(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }


    // == public methods ==
    public Various clickHaveIncomeNotFromWork() {
        WebElement yes = yesNoBoxes.get(0).findElement(trueSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickDontHaveIncomeNotFromWork() {
        WebElement yes = yesNoBoxes.get(0).findElement(falseSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickHaveOverseasBankAccount() {
        WebElement yes = yesNoBoxes.get(1).findElement(trueSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickDontHaveOverseasBankAccount() {
        WebElement yes = yesNoBoxes.get(1).findElement(falseSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickHaveDigitalCurrencies() {
        WebElement yes = yesNoBoxes.get(2).findElement(trueSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickDontHaveDigitalCurrencies() {
        WebElement yes = yesNoBoxes.get(2).findElement(falseSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickHaveShares() {
        WebElement yes = yesNoBoxes.get(3).findElement(trueSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickDontHaveShares() {
        WebElement yes = yesNoBoxes.get(3).findElement(falseSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickHavePartnership() {
        WebElement yes = yesNoBoxes.get(4).findElement(trueSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickDontHavePartnership() {
        WebElement yes = yesNoBoxes.get(4).findElement(falseSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickHaveTrust() {
        WebElement yes = yesNoBoxes.get(5).findElement(trueSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickDontHaveTrust() {
        WebElement yes = yesNoBoxes.get(5).findElement(falseSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickHaveJewelry() {
        WebElement yes = yesNoBoxes.get(6).findElement(trueSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickDontHaveJewelry() {
        WebElement yes = yesNoBoxes.get(6).findElement(falseSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickHaveArtwork() {
        WebElement yes = yesNoBoxes.get(7).findElement(trueSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Various clickDontHaveArtwork() {
        WebElement yes = yesNoBoxes.get(7).findElement(falseSubElementYesNoBox);
        yes.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

}
