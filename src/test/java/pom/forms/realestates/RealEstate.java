package pom.forms.realestates;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.RealEstateConstants.realEstateDetailsPanel;

public class RealEstate extends BasePage {

    // == private fields =
    private Map<Integer, RealEstateDetails> integerRealEstateDetailsMap;

    // == constructors==
    public RealEstate(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

    // == public methods ==
    public void chooseHaveRealEstate() {

        chooseHave();

        recreateMapPannelsOnPage();
    }

    public void chooseDontHaveRealEstate() {
        chooseDontHave();

        recreateMapPannelsOnPage();
    }

    public void deleteRealEstate(int indexWage) {

        delete(indexWage);

        recreateMapPannelsOnPage();
    }

    public void addRealEstate() {

        add();

        recreateMapPannelsOnPage();
    }

    // choose real estate type
    public void chooseRealEstateTypeApartment(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeApartment();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateTypeHousingUnit(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeHousingUnit();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateTypeStorage(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeStorage();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateTypeParking(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeParking();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateTypePrivateLand(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypePrivateLand();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateTypeAgriculturalLand(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeAgriculturalLand();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateTypeFarm(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeFarm();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateTypeUnionAction(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeUnionAction();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateTypeOption(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeOption();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateTypeAnother(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeAnother();

        recreateMapPannelsOnPage();
    }




    // choose real estate place
    public void chooseRealEstateInIsrael(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateInIsrael();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateOversea(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateOversea();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateDivided(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateDivided();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateNotDivided(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateNotDivided();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateTenantIsraeli(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTenantIsraeli();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateTenantNotIsraeli(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTenantNotIsraeli();

        recreateMapPannelsOnPage();
    }


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
