package pom.forms.realestates;

import com.mysql.cj.exceptions.WrongArgumentException;
import constants.EnglishHebrewConstants;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.BaseConstants.checkCircleIconSubElementMenu;
import static constants.BaseConstants.errorIconSubElementMenu;
import static constants.EnglishHebrewConstants.JANUARY;
import static constants.RealEstateConstants.*;

public class RealEstate extends BasePage {

    // == private fields =
    private Map<Integer, RealEstateDetails> integerRealEstateDetailsMap;
    
    private String realEstate = "real estate";

    // == constructors==
    public RealEstate(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);

        recreateMapPanelsOnPage();
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
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeApartment();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeHousingUnit(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeHousingUnit();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeStorage(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeStorage();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeParking(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeParking();

        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypePrivateLand(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypePrivateLand();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeAgriculturalLand(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeAgriculturalLand();

        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeFarm(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeFarm();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeUnionAction(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeUnionAction();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeOption(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeOption();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateTypeAnother(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTypeAnother();

//        recreateMapPanelsOnPage();
    }

    public String getChosenRealEstateType(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getChosenRealEstateType();
    }

    public void enterExplainPropertyType(int realEstateNumber, String propertyType) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterExplainPropertyType(propertyType);
    }


    // date picker
    public void openDatePicker(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).openDatePicker();

//        recreateMapPanelsOnPage();
    }

//    public void pickCancel(int realEstateNumber) {
//        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);
//
//        recreateMapPanelsOnPage();
//        integerRealEstateDetailsMap.get(realEstateNumber).pickCancel();
//
////        recreateMapPanelsOnPage();
//    }
//
//    public void pickOk(int realEstateNumber) {
//        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);
//
//        recreateMapPanelsOnPage();
//        integerRealEstateDetailsMap.get(realEstateNumber).pickOk();
//
////        recreateMapPanelsOnPage();
//    }

    protected String clickRightOnce() throws Exception {
        List<WebElement> btnsRight = getBtnRight();

        for (WebElement btnRight : btnsRight) {
            try {
                btnRight.click();
                Thread.sleep(500);
                return fetchCurrentMonthYear();
            } catch (ElementNotInteractableException e) {}
        }

        throw new Exception("Right button of a calendar not interactable");
    }

    protected String clickLeftOnce() throws Exception {
        List<WebElement> btnsLeft = getBtnLeft();

        for (WebElement btnLeft : btnsLeft) {
            try {
                btnLeft.click();
                Thread.sleep(500);
                return fetchCurrentMonthYear();
            } catch (ElementNotInteractableException e) {}
        }

        throw new Exception("Left button of a calendar not interactable");
//        getBtnLeft().click();
//        return fetchCurrentMonthYear();
    }

    protected String pickMonthYear(String month, String year) throws Exception {
        String currentMonthYear = fetchCurrentMonthYear();
        String currentYear = StringUtils.getDigits(currentMonthYear);

        if (Integer.parseInt(year) > Integer.parseInt(currentYear)) {
            clickLeft(JANUARY, year);
        } else {
            clickRight(JANUARY, year);
        }

        while (!currentMonthYear.contains(month) || !currentMonthYear.contains(year)) {
            currentMonthYear = clickLeft(month, year);
        }

        return currentMonthYear;
    }

    protected void pickCancel() {
        List<WebElement> btnsCancel = getBtnCancelPick();

        for (int i = 0; i < btnsCancel.size(); ++i) {
            try {
                btnsCancel.get(i).click();
                break;
            } catch (ElementNotInteractableException e) {
                if (i == (btnsCancel.size() - 1)) {
                    throw e;
                }
            }
        }
    }

    protected void pickOk() {
        List<WebElement> btnsOk = getBtnOkPick();

        for (int i = 0; i < btnsOk.size(); ++i) {
            try {
                btnsOk.get(i).click();
                break;
            } catch (ElementNotInteractableException e) {
                if (i == (btnsOk.size() - 1)) {
                    throw e;
                }
            }
        }
    }

    protected String pickDay(String day) {
        for (WebElement singleDay : getLblsDay()) {
            if (singleDay.getText().trim().equals(day)) {
                singleDay.click();
                return singleDay.getText().trim();
            }
        }

        throw new WrongArgumentException(String.format("Day %s not found in the picker", day));
    }

    public String pickDayMonthYear(int realEstateNumber, String day, String month, String year) throws Exception {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        openDatePicker(realEstateNumber);

        pickMonthYear(month, year);

        pickDay(day);

        pickOk();

        return formatDate(day, month, year);
    }



    // choose real estate ownership and size
    public void enterRealEstatePropertyArea(int realEstateNumber, String size) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstatePropertyArea(size);
    }

    public void deleteRealEstatePropertyArea(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteRealEstatePropertyArea();
    }

    public void enterRealEstateOwnershipPercentage(int realEstateNumber, String ownershipPercentage) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstateOwnershipPercentage(ownershipPercentage);
    }

    public void deleteRealEstateOwnershipPercentage(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteRealEstateOwnershipPercentage();
    }

    // choose real estate place
    public void chooseRealEstateInIsrael(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateInIsrael();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateOversea(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateOversea();

//        recreateMapPanelsOnPage();
    }

    public void chooseRealEstateAssetGushHalka(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateAssetGushHalka();
    }

    public void chooseRealEstateAssetAddress(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateAssetAddress();



    }

    // GUSH only
    public void enterRealEstateBlock(int realEstateNumber, String block) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstateBlock(block);
    }

    public void deleteRealEstateBlock(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteRealEstateBlock();
    }

    public void enterRealEstatePlot(int realEstateNumber, String plot) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstatePlot(plot);
    }

    public void deleteRealEstatePlot(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteRealEstatePlot();
    }

    public void enterRealEstateSubPlot(int realEstateNumber, String subPlot) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterRealEstateSubPlot(subPlot);
    }

    public void deleteRealEstateSubPlot(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteRealEstateSubPlot();
    }

    // Address only
    public void selectCityFromDropDownListByName(int realEstateNumber, String city) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).selectCityFromDropDownListByName(city);
    }

    public String selectCityFromDropDownListByIndex(int realEstateNumber, int index) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).selectCityFromDropDownListByIndex(index);
    }

    public void enterCity(int realEstateNumber, String city) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterCity(city);
    }

    public void deleteCity(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteCity();
    }

    public void enterExplainUsage(int realEstateNumber, String explainUsage) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterExplainUsage(explainUsage);
    }

    public void deleteExplainUsage(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteExplainUsage();
    }

    public void selectStreetFromDropDownListByName(int realEstateNumber, String street) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).selectStreetFromDropDownListByName(street);
    }

    public String selectStreetFromDropDownListByIndex(int realEstateNumber, int index) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).selectStreetFromDropDownListByIndex(index);
    }

    public void enterStreet(int realEstateNumber, String street) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterStreet(street);
    }

    public void deleteStreet(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteStreet();
    }

    public void enterHouseNum(int realEstateNumber, String houseNum) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterHouseNum(houseNum);
    }

    public void deleteHouseNum(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteHouseNum();
    }

    public void selectCountryFromDropDownListByName(int realEstateNumber, String country) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).selectCountryFromDropDownListByName(country);
    }

    public String selectCountryFromDropDownListByIndex(int realEstateNumber, int index) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).selectCountryFromDropDownListByIndex(index);
    }

    public void enterState(int realEstateNumber, String state) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterState(state);
    }

    public void deleteState(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteState();
    }

    // choose real estate usage
    public void chooseRealEstatePersonalUsage(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstatePersonalUsage();
    }

    public void chooseRealEstateFamilyUsage(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateFamilyUsage();
    }

    public void chooseRealEstateRentingUsage(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateRentingUsage();
    }

    public void chooseRealEstateNotUsing(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateNotUsing();
    }

    public void chooseRealEstateAnotherUsage(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateAnotherUsage();
    }

    public void chooseRealEstateSplit(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateSplit();
    }

    public void chooseRealEstateNotSplit(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateNotSplit();
    }


    public int getAmountPartitionsOfDividedRealEstate(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getAmountPartitionsOfDividedRealEstate();
    }

    public void enterAmountPartitionsOfDividedRealEstate(int realEstateNumber, String amountPartitions) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterAmountPartitionsOfDividedRealEstate(amountPartitions);
    }

    public void deleteAmountPartitionsOfDividedRealEstate(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteAmountPartitionsOfDividedRealEstate();
    }

    public int addSinglePartitionsOfDividedRealEstate(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).addSinglePartitionsOfDividedRealEstate();
    }

    public int removeSinglePartitionsOfDividedRealEstate(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).removeSinglePartitionsOfDividedRealEstate();
    }

    public int setAmountPartitionsOfDividedRealEstate(int realEstateNumber, int amountPartitions) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).setAmountPartitionsOfDividedRealEstate(amountPartitions);
    }

    // who is a tenant
//    public void chooseRealEstateTenantIsraeli(int realEstateNumber) {
//        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);
//
//        recreateMapPanelsOnPage();
//        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTenantIsraeli();
//
////        recreateMapPanelsOnPage();
//    }

//    public void chooseRealEstateTenantNotIsraeli(int realEstateNumber) {
//        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);
//
//        recreateMapPanelsOnPage();
//        integerRealEstateDetailsMap.get(realEstateNumber).chooseRealEstateTenantNotIsraeli();
//
////        recreateMapPanelsOnPage();
//    }

    public void addTenant(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).addTenant();
    }

    public void deleteTenant(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteTenant(tenantNumber);
    }

//    public void enterRenterId(int realEstateNumber, String renterId) {
//        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);
//
//        recreateMapPanelsOnPage();
//        integerRealEstateDetailsMap.get(realEstateNumber).enterRenterId(renterId);
//
////        recreateMapPanelsOnPage();
//    }

    public void enterMonthlyRent(int realEstateNumber, String monthlyRent) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterMonthlyRent(monthlyRent);
    }

    public void deleteMonthlyRent(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteMonthlyRent();
    }


//    public void selectCountryRenterFromDropDownListByName(int realEstateNumber, String countryRenter) {
//        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);
//
//        recreateMapPanelsOnPage();
//        integerRealEstateDetailsMap.get(realEstateNumber).selectCountryRenterFromDropDownListByName(countryRenter);
//    }


//    public void enterRenterPassport(int realEstateNumber, String renterPassport) {
//        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);
//
//        recreateMapPanelsOnPage();
//        integerRealEstateDetailsMap.get(realEstateNumber).enterRenterPassport(renterPassport);
//
////        recreateMapPanelsOnPage();
//    }

    public void chooseTenantFromIsrael(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseTenantFromIsrael(tenantNumber);
    }

    public void chooseTenantFromAbroad(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).chooseTenantFromAbroad(tenantNumber);
    }

    public void enterTenantId(int realEstateNumber, int tenantNumber, String tenantId) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterTenantId(tenantNumber, tenantId);
    }

    public void deleteTenantId(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteTenantId(tenantNumber);
    }

    public void selectCountryRenterFromDropDownListByName(int realEstateNumber, int tenantNumber, String countryTenant) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).selectCountryRenterFromDropDownListByName(tenantNumber, countryTenant);
    }

    public String selectCountryTenantFromDropDownListByIndex(int realEstateNumber, int tenantNumber, int index) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).selectCountryTenantFromDropDownListByIndex(tenantNumber, index);
    }

    public void enterTenantState(int realEstateNumber, int tenantNumber, String tenantState) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterTenantState(tenantNumber, tenantState);
    }

    public void deleteTenantState(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteTenantState(tenantNumber);
    }

    public void enterTenantPassport(int realEstateNumber, int tenantNumber, String tenantPassport) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).enterTenantPassport(tenantNumber, tenantPassport);
    }

    public void deleteTenantPassport(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).deleteTenantPassport(tenantNumber);
    }

    // attach contract
    public void attachContractFile(int realEstateNumber, String filename) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        integerRealEstateDetailsMap.get(realEstateNumber).attachContractFile(filename);
    }


    // error messages
    public List<WebElement> getErrorMessageNeedFillRealEstateType(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillRealEstateType();
    }

    public List<WebElement> getErrorMessageNeedFillDate(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillDate();
    }

    public List<WebElement> getErrorMessageNeedFillPropertyArea(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillPropertyArea();
    }

    public List<WebElement> getErrorMessagePropertyAreaContainsDigitalOnly(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessagePropertyAreaContainsDigitalOnly();
    }

    public List<WebElement> getErrorMessageNeedFillOwnershipPercentage(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillOwnershipPercentage();
    }

    public List<WebElement> getErrorMessageOwnershipPercentageContainsDigitalOnly(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageOwnershipPercentageContainsDigitalOnly();
    }

    public List<WebElement> getErrorMessageOwnershipPercentageHundredMax(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageOwnershipPercentageHundredMax();
    }

    public List<WebElement> getErrorMessageOwnershipPercentageOneMin(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageOwnershipPercentageOneMin();
    }

    public List<WebElement> getErrorMessageNeedFillBlock(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillBlock();
    }

    public List<WebElement> getErrorMessageBlockContainsDigitalOnly(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageBlockContainsDigitalOnly();
    }

    public List<WebElement> getErrorMessageNeedFillPlot(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillPlot();
    }

    public List<WebElement> getErrorMessagePlotContainsDigitalOnly(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessagePlotContainsDigitalOnly();
    }

    public List<WebElement> getErrorMessageSubPlotContainsDigitalOnly(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageSubPlotContainsDigitalOnly();
    }

    public List<WebElement> getErrorMessageSubPlotTooLong(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageSubPlotTooLong();
    }

    public List<WebElement> getErrorMessageNeedFillCity(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillCity();
    }

    public List<WebElement> getErrorMessageNeedFillStreet(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillStreet();
    }

    public List<WebElement> getErrorMessageNeedFillHouseNumber(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillHouseNumber();
    }

    public List<WebElement> getErrorMessageHouseNumberContainsCharacters(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageHouseNumberContainsCharacters();
    }

    public List<WebElement> getErrorMessageNeedFillCountry(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillCountry();
    }

    public List<WebElement> getErrorMessageStateContainsCharacters(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageStateContainsCharacters();
    }

    public List<WebElement> getErrorMessageCityContainsCharacters(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageCityContainsCharacters();
    }

    public List<WebElement> getErrorMessageStreetContainsCharacters(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageStreetContainsCharacters();
    }

    public List<WebElement> getErrorMessageNeedFillUsageRealEstate(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillUsageRealEstate();
    }

    public List<WebElement> getErrorMessageNeedFillUsageDetails(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillUsageDetails();
    }

    public List<WebElement> getErrorMessageUsageDetailsContainsCharacters(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageUsageDetailsContainsCharacters();
    }

    public List<WebElement> getErrorMessageNeedFillPropertySplit(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillPropertyDivided();
    }

    public List<WebElement> getErrorMessageMonthlyRentTwentyMax(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageMonthlyRentTwentyMax();
    }

    public List<WebElement> getErrorMessageNeedFillAmountPartitions(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillAmountPartitions();
    }

    public List<WebElement> getErrorMessageAmountPartitionsTwoMin(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageAmountPartitionsTwoMin();
    }

    public List<WebElement> getErrorMessageAmountPartitionsTenCharsMax(int realEstateNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageAmountPartitionsTenCharsMax();
    }

    public List<WebElement> getErrorMessageNeedFillTenantID(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillTenantID(tenantNumber);
    }

    public List<WebElement> getErrorMessageTenantIDDigitsOnly(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageTenantIDDigitsOnly(tenantNumber);
    }

    public List<WebElement> getErrorMessageTenantIDNineDigitsMax(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageTenantIDNineDigitsMax(tenantNumber);
    }

    public List<WebElement> getErrorMessageNeedFillTenantCountry(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillTenantCountry(tenantNumber);
    }

    public List<WebElement> getErrorMessageTenantStateContainsCharacters(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageTenantStateContainsCharacters(tenantNumber);
    }

    public List<WebElement> getErrorMessageNeedFillTenantPassport(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageNeedFillTenantPassport(tenantNumber);
    }

    public List<WebElement> getErrorMessageTenantPassportIncorrect(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageTenantPassportIncorrect(tenantNumber);
    }

    public List<WebElement> getErrorMessageTenantPassportFifteenDigitsMax(int realEstateNumber, int tenantNumber) {
        checkNumber(realEstateNumber, realEstate, integerRealEstateDetailsMap);

        recreateMapPanelsOnPage();
        return integerRealEstateDetailsMap.get(realEstateNumber).getErrorMessageTenantPassportFifteenDigitsMax(tenantNumber);
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

    private List<WebElement> getLblsDay() {
        return driver.findElements(lblDay);
    }

    private List<WebElement> getBtnCancelPick() {
        return driver.findElements(btnCalendarCancel);
    }

    private List<WebElement> getBtnOkPick() {
        return driver.findElements(btnCalendarOk);
    }

    private List<WebElement> getBtnHeaderPicker() {
        return driver.findElements(btnHeaderPicker);
    }

    private String fetchCurrentMonthYear() throws Exception {
        List<WebElement> headers = getBtnHeaderPicker();

        for (WebElement header : headers) {
            String currentMonthYear = header.getText().trim();
            if (StringUtils.isNotEmpty(currentMonthYear)) {
                return currentMonthYear;
            }
        }

        throw new Exception("Calendar header is empty");
    }

    private String clickRight(String month, String year) throws Exception {
        String currentMonthYear = fetchCurrentMonthYear();
        while (!currentMonthYear.contains(month) || !currentMonthYear.contains(year)) {
            currentMonthYear = clickRightOnce();
        }

        return fetchCurrentMonthYear();
    }

    private String clickLeft(String month, String year) throws Exception {
        String currentMonthYear = fetchCurrentMonthYear();
        while (!currentMonthYear.contains(month) || !currentMonthYear.contains(year)) {
            currentMonthYear = clickLeftOnce();
        }

        return fetchCurrentMonthYear();
    }

    protected List<WebElement> getBtnRight() {
        return driver.findElements(btnRight);
    }

    protected List<WebElement> getBtnLeft() {
        return driver.findElements(btnLeft);
    }

    private String formatDate(String day, String month, String year) {
        String fullDay = day.length()==1? "0" + day : day;

        return fullDay + "/" + EnglishHebrewConstants.getMonth(month) + "/" + year;
    }

}
