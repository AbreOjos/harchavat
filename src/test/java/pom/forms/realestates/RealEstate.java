package pom.forms.realestates;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.BaseConstants.checkCircleIconSubElementMenu;
import static constants.BaseConstants.errorIconSubElementMenu;
import static constants.RealEstateConstants.btnsDeletePanel;
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
    protected List<WebElement> getBtnsDeletePanel() {
        return driver.findElements(btnsDeletePanel);
    }

    // menu icons
    public List<WebElement> getErrorIconMenu() {
        return getMenuRealEstate().findElements(errorIconSubElementMenu);
    }

    public List<WebElement> getCheckCircleIconMenu() {
        return getMenuRealEstate().findElements(checkCircleIconSubElementMenu);
    }

    public void chooseHaveRealEstate() {

        chooseHave();

        recreateMapPanelsOnPage();
    }

    public void chooseDontHaveRealEstate() {
        chooseDontHave();

        recreateMapPanelsOnPage();
    }

    public void deleteRealEstate(int realEstateNumber) {

        deletePanel(realEstateNumber, getBtnsDeletePanel());

        recreateMapPanelsOnPage();
    }

    public void addRealEstate() {

        addPanel();

        recreateMapPanelsOnPage();
    }

    // choose real estate type
    public void chooseRealEstateTypeApartment(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeApartment();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeHousingUnit(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeHousingUnit();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeStorage(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeStorage();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeParking(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeParking();

        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypePrivateLand(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypePrivateLand();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeAgriculturalLand(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeAgriculturalLand();

        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeFarm(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeFarm();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeUnionAction(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeUnionAction();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeOption(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeOption();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeAnother(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeAnother();

//        recreateMapPanelsOnPage();
    }

    public void enterExplainPropertyType(int realEstateNumber, String propertyType) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterExplainPropertyType(propertyType);
    }


    // date picker
    public void openDatePicker(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).openDatePicker();

//        recreateMapPanelsOnPage();
    }

    public void pickCancel(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).pickCancel();

//        recreateMapPanelsOnPage();
    }

    public void pickOk(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).pickOk();

//        recreateMapPanelsOnPage();
    }

    public String pickMonthYear(int realEstateNumber, String month, String year) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).pickMonthYear(month, year);
    }

    public String pickDay(int realEstateNumber, String day) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).pickDay(day);
    }

    public void pickDayMonthYear(int realEstateNumber, String day, String month, String year) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        openDatePicker(realEstateNumber);

        pickMonthYear(realEstateNumber, month, year);

        pickDay(realEstateNumber, day);

        pickOk(realEstateNumber);
    }



    // choose real estate ownership and size
    public void enterRealEstateSize(int realEstateNumber, String size) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstateSize(size);

//        recreateMapPanelsOnPage();
    }

    public void enterRealEstateOwnershipPercentage(int realEstateNumber, String ownershipPercentage) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstateOwnershipPercentage(ownershipPercentage);

//        recreateMapPanelsOnPage();
    }

    // choose real estate place
    public void chooseRealEstateInIsrael(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateInIsrael();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateOversea(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateOversea();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateAssetGushHalka(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateAssetGushHalka();
    }

    public void chooseRealEstateAssetAddress(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateAssetAddress();



    }

    // GUSH only
    public void enterRealEstateBlock(int realEstateNumber, String block) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstateBlock(block);

//        recreateMapPanelsOnPage();
    }

    public void enterRealEstatePlot(int realEstateNumber, String plot) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstatePlot(plot);

//        recreateMapPanelsOnPage();
    }

    public void enterRealEstateSubPlot(int realEstateNumber, String subPlot) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstateSubPlot(subPlot);
    }

    // Address only
    public void selectCityFromDropDownListByName(int realEstateNumber, String city) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to choose city of a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).selectCityFromDropDownListByName(city);
    }

    public void selectStreetFromDropDownListByName(int realEstateNumber, String street) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to choose street of a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).selectStreetFromDropDownListByName(street);
    }

    public void enterHouseNum(int realEstateNumber, String houseNum) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterHouseNum(houseNum);
    }

    public void selectCountryFromDropDownListByName(int realEstateNumber, String country) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to choose country of a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).selectCountryFromDropDownListByName(country);
    }

    public void enterState(int realEstateNumber, String state) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterState(state);
    }

    // choose real estate usage
    public void chooseRealEstatePersonalUsage(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstatePersonalUsage();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateFamilyUsage(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateFamilyUsage();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateRenting(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateRenting();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateNotUsing(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateNotUsing();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateAnotherUsage(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateAnotherUsage();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateSplit(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateSplit();
    }

    public void chooseRealEstateNotSplit(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateNotSplit();
    }


    // was real estate divided?
//    public void chooseRealEstateDivided(int realEstateNumber) {
//        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
//            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
//                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
//        }
//
//        recreateMapPanelsOnPage();
//        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateDivided();
//
////        recreateMapPanelsOnPage();
//    }

//    public void chooseRealEstateNotDivided(int realEstateNumber) {
//        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
//            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
//                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
//        }
//
//        recreateMapPanelsOnPage();
//        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateNotDivided();
//
////        recreateMapPanelsOnPage();
//    }

    public int amountPartitionsOfDividedRealEstate(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get details of a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).amountPartitionsOfDividedRealEstate();
    }

    public int addSinglePartitionsOfDividedRealEstate(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).addSinglePartitionsOfDividedRealEstate();
    }

    public int removeSinglePartitionsOfDividedRealEstate(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).removeSinglePartitionsOfDividedRealEstate();
    }

    public int setAmountPartitionsOfDividedRealEstate(int realEstateNumber, int amountPartitions) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).setAmountPartitionsOfDividedRealEstate(amountPartitions);
    }

    // who is a tenant
    public void chooseRealEstateTenantIsraeli(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTenantIsraeli();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTenantNotIsraeli(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTenantNotIsraeli();

//        recreateMapPanelsOnPage();
    }

    public void addTenant(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).addTenant();
    }

    public void deleteTenant(int realEstateNumber, int tenantNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to delete details from a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteTenant(tenantNumber);
    }

    public void enterRenterId(int realEstateNumber, String renterId) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRenterId(renterId);

//        recreateMapPanelsOnPage();
    }

    public void enterMonthlyRent(int realEstateNumber, String monthlyRent) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterMonthlyRent(monthlyRent);

//        recreateMapPanelsOnPage();
    }


    public void selectCountryRenterFromDropDownListByName(int realEstateNumber, String countryRenter) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to choose country of a renter of a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).selectCountryRenterFromDropDownListByName(countryRenter);
    }


    public void enterRenterPassword(int realEstateNumber, String renterPassword) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRenterPassword(renterPassword);

//        recreateMapPanelsOnPage();
    }

    // attach contract
    public void attachContractFile(int realEstateNumber, String filename) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).attachContractFile(filename);

//        recreateMapPanelsOnPage();
    }


    // == private methods ==
    private void recreateMapPanelsOnPage() {
        integerRealEstateDetailsMap = new HashMap<>();

        PageFactory.initElements(driver, this);

        List<WebElement> realEstateDetailsRows = driver.findElements(realEstateDetailsPanel);

        for (int i = 0; i < realEstateDetailsRows.size(); ++i) {
            WebElement webElement = realEstateDetailsRows.get(i);
            integerRealEstateDetailsMap.put(i, new RealEstateDetails(driver, webElement));
        }

    }

}
