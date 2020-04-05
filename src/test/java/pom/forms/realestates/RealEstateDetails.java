package pom.forms.realestates;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.*;
import static constants.EnglishHebrewConstants.JANUARY;
import static constants.RealEstateConstants.*;
import static constants.VariousConstants.dropDownStreetSubElementNonWorkIncomesDetails;

public class RealEstateDetails extends BasePage {

    private final WebElement details;

    public RealEstateDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    protected WebElement getDropDownRealEstateType() {
        return details.findElement(dropDownRealEstateTypeSubElementDetails);
    }

    protected WebElement getTxtExplainPropertyType() {
        return details.findElement(txtExplainPropertyTypeSubElementDetails);
    }

    protected WebElement getCalendarRealEstate() {
        return details.findElement(calendarRealEstateSubElementDetails);
    }

    protected WebElement getTxtRealEstateSize() {
        return details.findElement(txtRealEstateSizeSubElementDetails);
    }

    protected WebElement getTxtRealEstateOwnershipPercentage() {
        return details.findElement(txtRealEstateOwnershipPercentageSubElementDetails);
    }

//    protected WebElement getTxtRealEstateAddress() {
//        return details.findElement(txtRealEstateAddressSubElementDetails);
//    }

    protected WebElement getTxtRealEstateBlock() {
        return details.findElement(txtRealEstateBlockSubElementDetails);
    }

    protected WebElement getTxtRealEstatePlot() {
        return details.findElement(txtRealEstatePlotSubElementDetails);
    }

    protected WebElement getTxtRealEstateSubPlot() {
        return details.findElement(txtRealEstateSubPlotSubElementDetails);
    }

    protected WebElement getBtnRealEstateInIsrael() {
//        return details.findElements(btnsRealEstateTrueSubElementDetails).get(0);
        return details.findElements(btnsRealEstateAssetIsraelOrAbroadSubElementDetails).get(0);
    }

    protected WebElement getBtnRealEstateOversea() {
//        return details.findElements(btnsRealEstateFalseSubElementDetails).get(0);
        return details.findElements(btnsRealEstateAssetIsraelOrAbroadSubElementDetails).get(1);
    }

    protected WebElement getBtnRealEstateAssetGushHalka() {
        return details.findElements(btnsRealEstateAssetDetailsSubElementDetails).get(0);
    }

    protected WebElement getBtnRealEstateAssetAddress() {
        return details.findElements(btnsRealEstateAssetDetailsSubElementDetails).get(1);
    }

    private WebElement getDropDownCity() {
        return details.findElement(dropDownCitySubElementNonWorkIncomesDetails);
    }

    protected WebElement getTxtState() {
        return details.findElement(txtStateSubElementDetails);
    }

    private WebElement getDropDownStreet() {
        return details.findElement(dropDownStreetSubElementNonWorkIncomesDetails);
    }

    protected WebElement getTxtHouseNum() {
        return details.findElement(txtHouseNumSubElementDetails);
    }

    protected WebElement getDropDownCountry() {
        return details.findElement(dropDownCountrySubElementDetails);
    }


//    protected WebElement getBtnRealEstateDivided() {
//        return details.findElements(btnsRealEstateTrueSubElementDetails).get(1);
//    }
//
//    protected WebElement getBtnRealEstateNotDivided() {
//        return details.findElements(btnsRealEstateFalseSubElementDetails).get(1);
//    }
//
    protected WebElement getBtnRealEstateTenantIsraeli() {
        return details.findElements(btnsRealEstateTrueSubElementDetails).get(2);
    }

    protected WebElement getBtnRealEstateTenantNotIsraeli() {
        return details.findElements(btnsRealEstateFalseSubElementDetails).get(2);
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

    protected WebElement getTxtRenterId() {
        return details.findElement(txtRenterIdSubElementDetails);
    }

    protected WebElement getTxtMonthlyRent() {
        return details.findElement(txtMonthlyRentSubElementDetails);
    }

//    protected WebElement getTxtRenterCountry() {
//        return details.findElement(txtRenterCountrySubElementDetails);
//    }

    protected WebElement getDropDownCountryRenter() {
        return details.findElement(dropDownCountryRenterSubElementDetails);
    }

    protected WebElement getTxtRenterPassword() {
        return details.findElement(txtRenterPasswordSubElementDetails);
    }

    protected WebElement getAttachContractFile() {
        return details.findElement(attachContractFileSubElementDetails);
    }

    // picker
    protected WebElement getBtnPicker() {
        return details.findElement(btnPickerSubElementDetail);
    }

    protected WebElement getBtnHeaderPicker() {
        return details.findElement(btnHeaderPickerSubElementDetails);
    }

    protected WebElement getBtnRight() {
        return details.findElement(btnRightSubElementDetails);
    }

    protected WebElement getBtnLeft() {
        return details.findElement(btnLeftSubElementDetails);
    }

    protected List<WebElement> getLblsDay() {
        return details.findElements(lblDaySubElementDetails);
    }

    protected WebElement getBtnCancelPick() {
        return details.findElements(btnsActionsPickerSubElementDetails).get(0);
    }

    protected WebElement getBtnOkPick() {
        return details.findElements(btnsActionsPickerSubElementDetails).get(1);
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

    protected void chooseRealEstateTypeFarm() {
        clickDropDownList(getDropDownRealEstateType(), 6);
    }

    protected void chooseRealEstateTypeUnionAction() {
        clickDropDownList(getDropDownRealEstateType(), 7);
    }

    protected void chooseRealEstateTypeOption() {
        clickDropDownList(getDropDownRealEstateType(), 8);
    }

    protected void chooseRealEstateTypeAnother() {
        clickDropDownList(getDropDownRealEstateType(), 9);
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

    protected String fetchCurrentMonthYear() {
        return getBtnHeaderPicker().getText().trim();
    }

    protected String clickRightOnce() {
        getBtnRight().click();
        return fetchCurrentMonthYear();
    }

    protected String clickLeftOnce() {
        getBtnLeft().click();
        return fetchCurrentMonthYear();
    }

    protected String pickMonthYear(String month, String year) {
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

    protected String pickDay(String day) {
        for (WebElement singleDay : getLblsDay()) {
            if (singleDay.getText().trim().equals(day)) {
                singleDay.click();
                return singleDay.getText().trim();
            }
        }

        throw new WrongArgumentException(String.format("Day %s not found in the picker", day));
    }

    protected void pickCancel() {
        getBtnCancelPick().click();
    }

    protected void pickOk() {
        getBtnOkPick().click();
    }



    // choose real estate ownership and size
    protected void enterRealEstateSize(String size) {
        fillFormField(getTxtRealEstateSize(), size);
    }

    protected void enterRealEstateOwnershipPercentage(String ownershipPercentage) {
        fillFormField(getTxtRealEstateOwnershipPercentage(), ownershipPercentage);
    }

    // GUSH only
    protected void enterRealEstateBlock(String block) {
        fillFormField(getTxtRealEstateBlock(), block);
    }

    protected void enterRealEstatePlot(String plot) {
        fillFormField(getTxtRealEstatePlot(), plot);
    }

    protected void enterRealEstateSubPlot(String subPlot) {
        fillFormField(getTxtRealEstateSubPlot(), subPlot);
    }

    // Address only
    protected void selectCityFromDropDownListByName(String city) {
        selectItemFromDropDownListByName(getDropDownCity(), city);
    }

    protected void selectStreetFromDropDownListByName(String street) {
        selectItemFromDropDownListByName(getDropDownStreet(), street);
    }

    protected void enterHouseNum(String houseNum) {
        fillFormField(getTxtHouseNum(), houseNum);
    }

    protected void selectCountryFromDropDownListByName(String country) {
        selectItemFromDropDownListByName(getDropDownCountry(), country);
    }

    protected void enterState(String state) {
        fillFormField(getTxtState(), state);
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

    protected void chooseRealEstateTenantIsraeli() {
        if (elementHasClass(getBtnRealEstateTenantIsraeli(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateTenantIsraeli());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateTenantNotIsraeli() {
        if (elementHasClass(getBtnRealEstateTenantNotIsraeli(), "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateTenantNotIsraeli());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

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

    protected void chooseRealEstateRenting() {
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
    protected int amountPartitionsOfDividedRealEstate() {
        return Integer.parseInt(getVolumeRealEstateDivided().getAttribute("value"));
    }

    protected int addSinglePartitionsOfDividedRealEstate() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getVolumeRealEstateAdd());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return amountPartitionsOfDividedRealEstate();
    }

    protected int removeSinglePartitionsOfDividedRealEstate() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getVolumeRealEstateRemove());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return amountPartitionsOfDividedRealEstate();
    }

    protected int setAmountPartitionsOfDividedRealEstate(int amountPartitions) {
        if (amountPartitions < 0) {
            throw new WrongArgumentException(String.format
                    ("Illegal argument %d, Amount of partitions must be positive.", amountPartitions));
        }

        int actualAmountPartitions = amountPartitionsOfDividedRealEstate();
        while (amountPartitions != actualAmountPartitions) {
            actualAmountPartitions = addOrRemoveSinglePartitionsOfDividedRealEstate(amountPartitions);
        }

        return amountPartitionsOfDividedRealEstate();
    }

    // tenant details
    protected void enterRenterId(String renterId) {
        fillFormField(getTxtRenterId(), renterId);
    }

    protected void enterMonthlyRent(String monthlyRent) {
        fillFormField(getTxtMonthlyRent(), monthlyRent);
    }

    protected void selectCountryRenterFromDropDownListByName(String countryRenter) {
        selectItemFromDropDownListByName(getDropDownCountryRenter(), countryRenter);
    }

    protected void enterRenterPassword(String renterPassword) {
        fillFormField(getTxtRenterPassword(), renterPassword);
    }

    // attach contract
    protected void attachContractFile(String filename) {
        getAttachContractFile().sendKeys(filename);
    }


    // == private methods ==
    private int addOrRemoveSinglePartitionsOfDividedRealEstate(int amountPartitions) {
        if (amountPartitionsOfDividedRealEstate() > amountPartitions) {
            return removeSinglePartitionsOfDividedRealEstate();
        } else if(amountPartitionsOfDividedRealEstate() < amountPartitions) {
            return addSinglePartitionsOfDividedRealEstate();
        } else {
            return amountPartitionsOfDividedRealEstate();
        }
    }

    private String clickRight(String month, String year) {
        String currentMonthYear = fetchCurrentMonthYear();
        while (!currentMonthYear.contains(month) || !currentMonthYear.contains(year)) {
            currentMonthYear = clickRightOnce();
        }

        return fetchCurrentMonthYear();
    }

    private String clickLeft(String month, String year) {
        String currentMonthYear = fetchCurrentMonthYear();
        while (!currentMonthYear.contains(month) || !currentMonthYear.contains(year)) {
            currentMonthYear = clickLeftOnce();
        }

        return fetchCurrentMonthYear();
    }

}
