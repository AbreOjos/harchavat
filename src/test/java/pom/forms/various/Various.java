package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;
import pom.forms.realestates.RealEstateDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.RealEstateConstants.realEstateDetailsPanel;

public class Various extends BasePage {

    // == private fields =
    private Map<Integer, RealEstateDetails> integerRealEstateDetailsMap;

    // == constructors==
    public Various(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }


    // == public methods ==
//    public Various clickHaveIncomeNotFromWork() {
//        WebElement yes = yesNoBoxes.get(0).findElement(trueSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickDontHaveIncomeNotFromWork() {
//        WebElement yes = yesNoBoxes.get(0).findElement(falseSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickHaveOverseasBankAccount() {
//        WebElement yes = yesNoBoxes.get(1).findElement(trueSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickDontHaveOverseasBankAccount() {
//        WebElement yes = yesNoBoxes.get(1).findElement(falseSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickHaveDigitalCurrencies() {
//        WebElement yes = yesNoBoxes.get(2).findElement(trueSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickDontHaveDigitalCurrencies() {
//        WebElement yes = yesNoBoxes.get(2).findElement(falseSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickHaveShares() {
//        WebElement yes = yesNoBoxes.get(3).findElement(trueSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickDontHaveShares() {
//        WebElement yes = yesNoBoxes.get(3).findElement(falseSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickHavePartnership() {
//        WebElement yes = yesNoBoxes.get(4).findElement(trueSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickDontHavePartnership() {
//        WebElement yes = yesNoBoxes.get(4).findElement(falseSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickHaveTrust() {
//        WebElement yes = yesNoBoxes.get(5).findElement(trueSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickDontHaveTrust() {
//        WebElement yes = yesNoBoxes.get(5).findElement(falseSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickHaveJewelry() {
//        WebElement yes = yesNoBoxes.get(6).findElement(trueSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickDontHaveJewelry() {
//        WebElement yes = yesNoBoxes.get(6).findElement(falseSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickHaveArtwork() {
//        WebElement yes = yesNoBoxes.get(7).findElement(trueSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }
//
//    public Various clickDontHaveArtwork() {
//        WebElement yes = yesNoBoxes.get(7).findElement(falseSubElementYesNoBox);
//        yes.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return new Various(driver);
//    }


    // == private methods ==
    private void recreateMapPannelsOnPage() {
        integerRealEstateDetailsMap = new HashMap<>();

        PageFactory.initElements(driver, this);

        List<WebElement> realEstateDetailsRows = driver.findElements(realEstateDetailsPanel);

        for (int i = 0; i < realEstateDetailsRows.size(); ++i) {
            WebElement webElement = realEstateDetailsRows.get(i);
            integerRealEstateDetailsMap.put(i, new RealEstateDetails(driver, webElement));
        }

    }

}
