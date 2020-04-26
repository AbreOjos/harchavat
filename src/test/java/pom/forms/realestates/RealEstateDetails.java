package pom.forms.realestates;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.*;
import static constants.RealEstateConstants.*;

public class RealEstateDetails extends BasePage {

    // == private fields ==
    private final WebElement details;
    private Map<Integer, TenantDetails> integerTenantDetailsMap;
    
    private String tenant = "tenant";

    // == static final fields ==
    private static final String IMPOSSIBLE_ADD_DETAILS =
            "Impossible to add details for a tenant #%d. The number need to be between 0 and %d not inclusive";

    public RealEstateDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;

        recreateMapPanelsOnPage();
    }

    // == protected methods ==
    protected WebElement getDropDownRealEstateType() {
        return details.findElement(dropDownRealEstateTypeSubElementDetails);
    }

    protected WebElement geLblDropDownRealEstateType() {
        return details.findElement(lblDropDownRealEstateTypeSubElementDetails);
    }

    protected WebElement getTxtExplainPropertyType() {
        return details.findElement(txtExplainPropertyTypeSubElementDetails);
    }

    protected WebElement getCalendarRealEstate() {
        return details.findElement(calendarRealEstateSubElementDetails);
    }

    protected WebElement getTxtRealEstatePropertyArea() {
        return details.findElement(txtRealEstatePropertyAreaSubElementDetails);
    }

    protected WebElement getTxtRealEstateOwnershipPercentage() {
        return details.findElement(txtRealEstateOwnershipPercentageSubElementDetails);
    }

    protected WebElement getTxtRealEstateBlock() {
        return details.findElement(txtRealEstateBlockSubElementDetails);
    }

    protected WebElement getTxtRealEstatePlot() {
        return details.findElement(txtRealEstatePlotSubElementDetails);
    }

    protected WebElement getTxtRealEstateSubPlot() {
        return details.findElement(txtRealEstateSubPlotSubElementDetails);
    }

    protected WebElement getTxtRealEstateCity() {
        return details.findElement(txtRealEstateCitySubElementDetails);
    }

    protected WebElement getTxtExplainUsage() {
        return details.findElement(txtExplainUsageSubElementDetails);
    }

    protected WebElement getBtnRealEstateInIsrael() {
        return details.findElements(btnsRealEstateAssetIsraelOrAbroadSubElementDetails).get(0);
    }

    protected WebElement getBtnRealEstateOversea() {
        return details.findElements(btnsRealEstateAssetIsraelOrAbroadSubElementDetails).get(1);
    }

    protected WebElement getBtnRealEstateAssetGushHalka() {
        return details.findElements(btnsRealEstateAssetDetailsSubElementDetails).get(0);
    }

    protected WebElement getBtnRealEstateAssetAddress() {
        return details.findElements(btnsRealEstateAssetDetailsSubElementDetails).get(1);
    }

    protected WebElement getTxtState() {
        return details.findElement(txtStateSubElementDetails);
    }

    protected WebElement getDropDownCountry() {
        return details.findElement(dropDownCountrySubElementDetails);
    }

    protected WebElement getBtnAddTenant() {
        return details.findElement(btnAddTenantSubElementDetails);
    }

    protected List<WebElement> getBtnsDeleteTenant() {
        return details.findElements(btnsDeleteTenantSubElementDetails);
    }

    protected WebElement getBtnRealEstatePersonalUsage() {
        return details.findElement(btnRealEstatePersonalUseSubElementDetails);
    }

    protected WebElement getBtnRealEstateFamilyUsage() {
        return details.findElement(btnRealEstateFamilyUseSubElementDetails);

    }

    protected WebElement getBtnRealEstateRenting() {
        return details.findElement(btnRealEstateRentUseSubElementDetails);
    }

    protected WebElement getBtnRealEstateNotUsing() {
        return details.findElement(btnRealEstateNoUseSubElementDetails);
    }

    protected WebElement getBtnRealEstateAnotherUsage() {
        return details.findElement(btnRealEstateOtherUseSubElementDetails);
    }

    protected WebElement getBtnRealEstateSplit() {
        return details.findElement(btnRealEstateSplitSubElementDetails);
    }

    protected WebElement getBtnRealEstateNotSplit() {
        return details.findElement(btnRealEstateNotSplitSubElementDetails);
    }

    protected WebElement getVolumeRealEstateDivided() {
        return details.findElement(volumeRealEstateDividedSubElementDetails);
    }

    protected WebElement getVolumeRealEstateAdd() {
        return details.findElement(volumeRealEstateAddSubElementDetails);
    }

    protected WebElement getVolumeRealEstateRemove() {
        return details.findElement(volumeRealEstateRemoveSubElementDetails);
    }


    protected WebElement getTxtMonthlyRent() {
        return details.findElement(txtMonthlyRentSubElementDetails);
    }

    protected WebElement getAttachContractFile() {
        return details.findElement(attachContractFileSubElementDetails);
    }

    // picker
    protected WebElement getBtnPicker() {
        return details.findElement(btnPickerSubElementDetail);
    }

    // choose real estate type
    protected void chooseRealEstateTypeApartment() {
        clickDropDownList(getDropDownRealEstateType(), 0);
    }

    protected void chooseRealEstateTypeHousingUnit() {
        clickDropDownList(getDropDownRealEstateType(), 1);
    }

    protected void chooseRealEstateTypeStorage() {
        clickDropDownList(getDropDownRealEstateType(), 2);
    }

    protected void chooseRealEstateTypeParking() {
        clickDropDownList(getDropDownRealEstateType(), 3);
    }

    protected void chooseRealEstateTypePrivateLand() {
        clickDropDownList(getDropDownRealEstateType(), 4);
    }

    protected void chooseRealEstateTypeAgriculturalLand() {
        clickDropDownList(getDropDownRealEstateType(), 5);
    }

    protected void chooseRealEstateTypeOption() {
        clickDropDownList(getDropDownRealEstateType(), 6);
    }

    protected void chooseRealEstateTypeFarm() { clickDropDownList(getDropDownRealEstateType(), 7); }

    protected void chooseRealEstateTypeUnionAction() {
        clickDropDownList(getDropDownRealEstateType(), 8);
    }

    protected void chooseRealEstateTypeAnother() {
        clickDropDownList(getDropDownRealEstateType(), 9);
    }

    protected String getChosenRealEstateType() {
        return geLblDropDownRealEstateType().getText().trim();
    }

    protected void enterExplainPropertyType(String propertyType) {
        fillFormField(getTxtExplainPropertyType(), propertyType);
    }

    // date picker
    protected void openDatePicker() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnPicker());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    protected String fetchCurrentMonthYear() {
////        PageFactory.initElements(driver, this);
//        return getBtnHeaderPicker().getText().trim();
//    }

//    protected String clickRightOnce() {
//        getBtnRight().click();
//        return fetchCurrentMonthYear();
//    }
//
//    protected String clickLeftOnce() {
//        getBtnLeft().click();
//        return fetchCurrentMonthYear();
//    }

//    protected String pickMonthYear(String month, String year) {
//        String currentMonthYear = fetchCurrentMonthYear();
//        String currentYear = StringUtils.getDigits(currentMonthYear);
//
//        if (Integer.parseInt(year) > Integer.parseInt(currentYear)) {
//            clickLeft(JANUARY, year);
//        } else {
//            clickRight(JANUARY, year);
//        }
//
//        while (!currentMonthYear.contains(month) || !currentMonthYear.contains(year)) {
//            currentMonthYear = clickLeft(month, year);
//        }
//
//        return currentMonthYear;
//    }

//    protected String pickDay(String day) {
//        for (WebElement singleDay : getLblsDay()) {
//            if (singleDay.getText().trim().equals(day)) {
//                singleDay.click();
//                return singleDay.getText().trim();
//            }
//        }
//
//        throw new WrongArgumentException(String.format("Day %s not found in the picker", day));
//    }

//    protected void pickCancel() {
//        getBtnCancelPick().click();
//    }
//
//    protected void pickOk() {
//        getBtnOkPick().click();
//    }



    // choose real estate ownership and size
    protected void enterRealEstatePropertyArea(String size) {
        fillFormField(getTxtRealEstatePropertyArea(), size);
    }

    protected void deleteRealEstatePropertyArea() {
        cleanFormField(getTxtRealEstatePropertyArea());
    }

    protected void enterRealEstateOwnershipPercentage(String ownershipPercentage) {
        fillFormField(getTxtRealEstateOwnershipPercentage(), ownershipPercentage);
    }

    protected void deleteRealEstateOwnershipPercentage() {
        cleanFormField(getTxtRealEstateOwnershipPercentage());
    }

    // GUSH only
    protected void enterRealEstateBlock(String block) {
        fillFormField(getTxtRealEstateBlock(), block);
    }

    protected void deleteRealEstateBlock() {
        cleanFormField(getTxtRealEstateBlock());
    }

    protected void enterRealEstatePlot(String plot) {
        fillFormField(getTxtRealEstatePlot(), plot);
    }

    protected void deleteRealEstatePlot() {
        cleanFormField(getTxtRealEstatePlot());
    }

    protected void enterRealEstateSubPlot(String subPlot) {
        fillFormField(getTxtRealEstateSubPlot(), subPlot);
    }

    protected void deleteRealEstateSubPlot() {
        cleanFormField(getTxtRealEstateSubPlot());
    }

    // Address only
    protected void selectCityFromDropDownListByName(String city) {
        selectItemFromDropDownListByName(getDropDownCity(details), city);
    }

    protected String selectCityFromDropDownListByIndex(int index) {
        return selectItemFromDropDownListByIndex(getDropDownCity(details), index);
    }

    protected void enterCity(String city) {
        fillFormField(getTxtRealEstateCity(), city);
    }

    protected void deleteCity() {
        cleanFormField(getTxtRealEstateCity());
    }

    protected void enterExplainUsage(String explainUsage) {
        fillFormField(getTxtExplainUsage(), explainUsage);
    }

    protected void deleteExplainUsage() {
        cleanFormField(getTxtExplainUsage());
    }

    protected void selectStreetFromDropDownListByName(String street) {
        selectItemFromDropDownListByName(getDropDownStreet(details), street);
    }

    protected String selectStreetFromDropDownListByIndex(int index) {
        return selectItemFromDropDownListByIndex(getDropDownStreet(details), index);
    }

    protected void enterStreet(String street) {
        fillFormField(getTxtStreet(details), street);
    }

    protected void deleteStreet() {
        cleanFormField(getTxtStreet(details));
    }

    protected void enterHouseNum(String houseNum) {
        fillFormField(getTxtHouseNum(details), houseNum);
    }

    protected void deleteHouseNum() {
        cleanFormField(getTxtHouseNum(details));
    }

    protected void selectCountryFromDropDownListByName(String country) {
        selectItemFromDropDownListByName(getDropDownCountry(), country);
    }

    protected String selectCountryFromDropDownListByIndex(int index) {
        return selectItemFromDropDownListByIndex(getDropDownCountry(), index);
    }

    protected void enterState(String state) {
        fillFormField(getTxtState(), state);
    }

    protected void deleteState() {
        cleanFormField(getTxtState());
    }

    // choose real estate place
    protected void chooseRealEstateInIsrael() {
        if (elementHasClass(getBtnRealEstateInIsrael(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateInIsrael());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateOversea() {
        if (elementHasClass(getBtnRealEstateOversea(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateOversea());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateAssetGushHalka() {
        if (elementHasClass(getBtnRealEstateAssetGushHalka(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateAssetGushHalka());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateAssetAddress() {
        if (elementHasClass(getBtnRealEstateAssetAddress(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateAssetAddress());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }



//    protected void chooseRealEstateDivided() {
//        if (elementHasClass(getBtnRealEstateDivided(), "active"))
//            return;
//
//        try {
//            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateDivided());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
//    }

//    protected void chooseRealEstateNotDivided() {
//        if (elementHasClass(getBtnRealEstateNotDivided(), "active"))
//            return;
//
//        try {
//            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateNotDivided());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
//    }

//    protected void chooseRealEstateTenantIsraeli() {
//        if (elementHasClass(getBtnRealEstateTenantIsraeli(), "active"))
//            return;
//
//        try {
//            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateTenantIsraeli());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
//    }

//    protected void chooseRealEstateTenantNotIsraeli() {
//        if (elementHasClass(getBtnRealEstateTenantNotIsraeli(), "active"))
//            return;
//
//        try {
//            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateTenantNotIsraeli());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
//    }

    protected void addTenant() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnAddTenant());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    public void deleteTenant(int tenantNumber) {

        deletePanel(tenantNumber, getBtnsDeleteTenant());

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    // choose real estate usage
    protected void chooseRealEstatePersonalUsage() {
        if (elementHasClass(getBtnRealEstatePersonalUsage(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstatePersonalUsage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateFamilyUsage() {
        if (elementHasClass(getBtnRealEstateFamilyUsage(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateFamilyUsage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateRentingUsage() {
        if (elementHasClass(getBtnRealEstateRenting(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateRenting());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateNotUsing() {
        if (elementHasClass(getBtnRealEstateNotUsing(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateNotUsing());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateAnotherUsage() {
        if (elementHasClass(getBtnRealEstateAnotherUsage(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateAnotherUsage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateSplit() {
        if (elementHasClass(getBtnRealEstateSplit(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateSplit());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateNotSplit() {
        if (elementHasClass(getBtnRealEstateNotSplit(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateNotSplit());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    // real estate divided
    protected int getAmountPartitionsOfDividedRealEstate() {
        return Integer.parseInt(getVolumeRealEstateDivided().getAttribute("value"));
    }

    protected void enterAmountPartitionsOfDividedRealEstate(String amountPartitions) {
        fillFormField(getVolumeRealEstateDivided(), amountPartitions);
    }

    protected void deleteAmountPartitionsOfDividedRealEstate() {
        cleanFormField(getVolumeRealEstateDivided());
    }

    protected int addSinglePartitionsOfDividedRealEstate() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getVolumeRealEstateAdd());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return getAmountPartitionsOfDividedRealEstate();
    }

    protected int removeSinglePartitionsOfDividedRealEstate() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getVolumeRealEstateRemove());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return getAmountPartitionsOfDividedRealEstate();
    }

    protected int setAmountPartitionsOfDividedRealEstate(int amountPartitions) {
        if (amountPartitions < 0) {
            throw new WrongArgumentException(String.format
                    ("Illegal argument %d, Amount of partitions must be positive.", amountPartitions));
        }

        int actualAmountPartitions = getAmountPartitionsOfDividedRealEstate();
        while (amountPartitions != actualAmountPartitions) {
            actualAmountPartitions = addOrRemoveSinglePartitionsOfDividedRealEstate(amountPartitions);
        }

        return getAmountPartitionsOfDividedRealEstate();
    }

    // tenant details
    protected void enterMonthlyRent(String monthlyRent) {
        fillFormField(getTxtMonthlyRent(), monthlyRent);
    }

    protected void deleteMonthlyRent() {
        cleanFormField(getTxtMonthlyRent());
    }

    public void chooseTenantFromIsrael(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        integerTenantDetailsMap.get(tenantNumber).chooseTenantFromIsrael();
    }

    public void chooseTenantFromAbroad(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        integerTenantDetailsMap.get(tenantNumber).chooseTenantFromAbroad();
    }

    public void enterTenantId(int tenantNumber, String tenantId) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        integerTenantDetailsMap.get(tenantNumber).enterTenantId(tenantId);
    }

    public void deleteTenantId(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        integerTenantDetailsMap.get(tenantNumber).deleteTenantId();
    }

    public void selectCountryRenterFromDropDownListByName(int tenantNumber, String countryTenant) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        integerTenantDetailsMap.get(tenantNumber).selectCountryTenantFromDropDownListByName(countryTenant);
    }

    public String selectCountryTenantFromDropDownListByIndex(int tenantNumber, int index) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        return integerTenantDetailsMap.get(tenantNumber).selectCountryTenantFromDropDownListByIndex(index);
    }

    public void enterTenantState(int tenantNumber, String tenantState) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        integerTenantDetailsMap.get(tenantNumber).enterTenantState(tenantState);
    }

    public void deleteTenantState(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        integerTenantDetailsMap.get(tenantNumber).deleteTenantState();
    }

    public void enterTenantPassport(int tenantNumber, String tenantPassport) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        integerTenantDetailsMap.get(tenantNumber).enterTenantPassport(tenantPassport);
    }

    public void deleteTenantPassport(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        integerTenantDetailsMap.get(tenantNumber).deleteTenantPassport();
    }

    // attach contract
    protected void attachContractFile(String filename) {
        getAttachContractFile().sendKeys(filename);
    }


    // error messages
    protected List<WebElement> getErrorMessageNeedFillRealEstateType() {
        return details.findElements(errorMessageNeedFillRealEstateTypeSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillDate() {
        return details.findElements(errorMessageNeedFillDateSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillPropertyArea() {
        return details.findElements(errorMessageNeedFillPropertyAreaSubElementDetails);
    }

    protected List<WebElement> getErrorMessagePropertyAreaContainsDigitalOnly() {
        return details.findElements(errorMessagePropertyAreaContainsDigitalOnlySubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillOwnershipPercentage() {
        return details.findElements(errorMessageNeedFillOwnershipPercentageSubElementDetails);
    }

    protected List<WebElement> getErrorMessageOwnershipPercentageContainsDigitalOnly() {
        return details.findElements(errorMessageOwnershipPercentageContainsDigitalOnlySubElementDetails);
    }

    protected List<WebElement> getErrorMessageOwnershipPercentageHundredMax() {
        return details.findElements(errorMessageOwnershipPercentageHundredMaxSubElementDetails);
    }

    protected List<WebElement> getErrorMessageOwnershipPercentageOneMin() {
        return details.findElements(errorMessageOwnershipPercentageOneMinSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillBlock() {
        return details.findElements(errorMessageNeedFillBlockSubElementDetails);
    }

    protected List<WebElement> getErrorMessageBlockContainsDigitalOnly() {
        return details.findElements(errorMessageBlockContainsDigitalOnlySubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillPlot() {
        return details.findElements(errorMessageNeedFillPlotSubElementDetails);
    }

    protected List<WebElement> getErrorMessagePlotContainsDigitalOnly() {
        return details.findElements(errorMessagePlotContainsDigitalOnlySubElementDetails);
    }

    protected List<WebElement> getErrorMessageSubPlotContainsDigitalOnly() {
        return details.findElements(errorMessageSubPlotContainsDigitalOnlySubElementDetails);
    }

    protected List<WebElement> getErrorMessageSubPlotTooLong() {
        return details.findElements(errorMessageSubPlotTooLongSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillCity() {
        return details.findElements(errorMessageNeedFillCitySubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillStreet() {
        return details.findElements(errorMessageNeedFillStreetSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillHouseNumber() {
        return details.findElements(errorMessageNeedFillHouseNumberSubElementDetails);
    }

    protected List<WebElement> getErrorMessageHouseNumberContainsCharacters() {
        return details.findElements(errorMessageHouseNumberContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillCountry() {
        return details.findElements(errorMessageNeedFillCountrySubElementDetails);
    }

    protected List<WebElement> getErrorMessageStateContainsCharacters() {
        return details.findElements(errorMessageStateContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getErrorMessageCityContainsCharacters() {
        return details.findElements(errorMessageCityContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getErrorMessageStreetContainsCharacters() {
        return details.findElements(errorMessageStreetContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillUsageRealEstate() {
        return details.findElements(errorMessageNeedFillUsageRealEstateSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillUsageDetails() {
        return details.findElements(errorMessageNeedFillUsageDetailsSubElementDetails);
    }

    protected List<WebElement> getErrorMessageUsageDetailsContainsCharacters() {
        return details.findElements(errorMessageUsageDetailsContainsCharactersSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillPropertyDivided() {
        return details.findElements(errorMessageNeedFillPropertyDividedSubElementDetails);
    }

    protected List<WebElement> getErrorMessageMonthlyRentTwentyMax() {
        return details.findElements(errorMessageMonthlyRentTwentyMaxSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillAmountPartitions() {
        return details.findElements(errorMessageNeedFillAmountPartitionsSubElementDetails);
    }

    protected List<WebElement> getErrorMessageAmountPartitionsTwoMin() {
        return details.findElements(errorMessageAmountPartitionsTwoMinSubElementDetails);
    }

    protected List<WebElement> getErrorMessageAmountPartitionsTenCharsMax() {
        return details.findElements(errorMessageAmountPartitionsTenCharsMaxSubElementDetails);
    }

    protected List<WebElement> getErrorMessageNeedFillTenantID(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        return integerTenantDetailsMap.get(tenantNumber).getErrorMessageNeedFillTenantID();
    }

    protected List<WebElement> getErrorMessageTenantIDDigitsOnly(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        return integerTenantDetailsMap.get(tenantNumber).getErrorMessageTenantIDDigitsOnly();
    }

    protected List<WebElement> getErrorMessageTenantIDNineDigitsMax(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        return integerTenantDetailsMap.get(tenantNumber).getErrorMessageTenantIDNineDigitsMax();
    }

    protected List<WebElement> getErrorMessageNeedFillTenantCountry(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        return integerTenantDetailsMap.get(tenantNumber).getErrorMessageNeedFillTenantCountry();
    }

    protected List<WebElement> getErrorMessageTenantStateContainsCharacters(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        return integerTenantDetailsMap.get(tenantNumber).getErrorMessageTenantStateContainsCharacters();
    }

    protected List<WebElement> getErrorMessageNeedFillTenantPassport(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        return integerTenantDetailsMap.get(tenantNumber).getErrorMessageNeedFillTenantPassport();
    }

    protected List<WebElement> getErrorMessageTenantPassportIncorrect(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        return integerTenantDetailsMap.get(tenantNumber).getErrorMessageTenantPassportIncorrect();
    }

    protected List<WebElement> getErrorMessageTenantPassportFifteenDigitsMax(int tenantNumber) {
        checkNumber(tenantNumber, tenant, integerTenantDetailsMap);

        recreateMapPanelsOnPage();
        return integerTenantDetailsMap.get(tenantNumber).getErrorMessageTenantPassportFifteenDigitsMax();
    }

    protected int getTenantsAmount() {
        recreateMapPanelsOnPage();
        return integerTenantDetailsMap.size();
    }



    // == private methods ==
    private void recreateMapPanelsOnPage() {
        integerTenantDetailsMap = new HashMap<>();

//        PageFactory.initElements(driver, this);

        List<WebElement> tenantDetailsRows = details.findElements(tenantPanelSubElementRealEstatePanel);

        for (int i = 0; i < tenantDetailsRows.size(); ++i) {
            WebElement webElement = tenantDetailsRows.get(i);
            integerTenantDetailsMap.put(i, new TenantDetails(driver, webElement));
        }

    }


    private int addOrRemoveSinglePartitionsOfDividedRealEstate(int amountPartitions) {
        if (getAmountPartitionsOfDividedRealEstate() > amountPartitions) {
            return removeSinglePartitionsOfDividedRealEstate();
        } else if(getAmountPartitionsOfDividedRealEstate() < amountPartitions) {
            return addSinglePartitionsOfDividedRealEstate();
        } else {
            return getAmountPartitionsOfDividedRealEstate();
        }
    }

//    private String clickRight(String month, String year) {
//        String currentMonthYear = fetchCurrentMonthYear();
//        while (!currentMonthYear.contains(month) || !currentMonthYear.contains(year)) {
//            currentMonthYear = clickRightOnce();
//        }
//
//        return fetchCurrentMonthYear();
//    }
//
//    private String clickLeft(String month, String year) {
//        String currentMonthYear = fetchCurrentMonthYear();
//        while (!currentMonthYear.contains(month) || !currentMonthYear.contains(year)) {
//            currentMonthYear = clickLeftOnce();
//        }
//
//        return fetchCurrentMonthYear();
//    }

}
