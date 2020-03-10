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


    // date picker
    public void openDatePicker(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).openDatePicker();

        recreateMapPannelsOnPage();
    }

    public void pickCancel(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).pickCancel();

        recreateMapPannelsOnPage();
    }

    public void pickOk(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).pickOk();

        recreateMapPannelsOnPage();
    }

    public String pickMonthYear(int realEstateNumber, String month, String year) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        return integerRealEstateDetailsMap.get(realEstateNumber).pickMonthYear(month, year);
    }

    public String pickDay(int realEstateNumber, String day) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

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

        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstateSize(size);

        recreateMapPannelsOnPage();
    }

    public void enterRealEstateOwnershipPercentage(int realEstateNumber, String ownershipPercentage) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstateOwnershipPercentage(ownershipPercentage);

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

    // enter real estate address
    public void enterRealEstateAddress(int realEstateNumber, String address) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstateAddress(address);

        recreateMapPannelsOnPage();
    }

    public void enterRealEstateBlock(int realEstateNumber, String block) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstateBlock(block);

        recreateMapPannelsOnPage();
    }

    public void enterRealEstatePlot(int realEstateNumber, String plot) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstatePlot(plot);

        recreateMapPannelsOnPage();
    }

    // choose real estate usage
    public void chooseRealEstatePersonalUsage(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstatePersonalUsage();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateFamilyUsage(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateFamilyUsage();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateRenting(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateRenting();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateNotUsing(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateNotUsing();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateAnotherUsage(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateAnotherUsage();

        recreateMapPannelsOnPage();
    }

    // choose real estate renting purpose
    public void chooseRealEstateResidentialPurpose(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateResidentialPurpose();

        recreateMapPannelsOnPage();
    }

    public void chooseRealEstateBusinessPurpose(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateBusinessPurpose();

        recreateMapPannelsOnPage();
    }

    // was real estate divided?
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

    public int amountPartitionsOfDividedRealEstate(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to get details of a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        return integerRealEstateDetailsMap.get(realEstateNumber).amountPartitionsOfDividedRealEstate();
    }

    public int addSinglePartitionsOfDividedRealEstate(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        int newAmount = integerRealEstateDetailsMap.get(realEstateNumber).addSinglePartitionsOfDividedRealEstate();

        recreateMapPannelsOnPage();

        return newAmount;
    }

    public int removeSinglePartitionsOfDividedRealEstate(int realEstateNumber) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        int newAmount = integerRealEstateDetailsMap.get(realEstateNumber).removeSinglePartitionsOfDividedRealEstate();

        recreateMapPannelsOnPage();

        return newAmount;
    }

    public int setAmountPartitionsOfDividedRealEstate(int realEstateNumber, int amountPartitions) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        int newAmount = integerRealEstateDetailsMap.get(realEstateNumber).setAmountPartitionsOfDividedRealEstate(amountPartitions);

        recreateMapPannelsOnPage();

        return newAmount;
    }

    // who is a tenant
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

    public void enterRenterId(int realEstateNumber, String renterId) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).enterRenterId(renterId);

        recreateMapPannelsOnPage();
    }

    public void enterMonthlyRent(int realEstateNumber, String monthlyRent) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).enterMonthlyRent(monthlyRent);

        recreateMapPannelsOnPage();
    }

    public void enterRenterCountry(int realEstateNumber, String renterCountry) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).enterRenterCountry(renterCountry);

        recreateMapPannelsOnPage();
    }

    public void enterRenterPassword(int realEstateNumber, String renterPassword) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).enterRenterPassword(renterPassword);

        recreateMapPannelsOnPage();
    }

    // attach contract
    public void attachContractFile(int realEstateNumber, String filename) {
        if (realEstateNumber<0 || realEstateNumber>=integerRealEstateDetailsMap.size()) {
            throw new WrongArgumentException(String.format("Impossible to add details for a real estate #%d. " +
                    "The number need to be between 0 and %d not inclusive", realEstateNumber, integerRealEstateDetailsMap.size()));
        }

        integerRealEstateDetailsMap.get(realEstateNumber).attachContractFile(filename);

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
