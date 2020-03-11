package pom.forms.realestates;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.waitFewSecondsWarningDisabled;
import static constants.EnglishHebrewConstants.JANUARY;
import static constants.RealEstateConstants.*;

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

    protected WebElement getCalendarRealEstate() {
        return details.findElement(calendarRealEstateSubElementDetails);
    }

    protected WebElement getTxtRealEstateSize() {
        return details.findElement(txtRealEstateSizeSubElementDetails);
    }

    protected WebElement getTxtRealEstateOwnershipPercentage() {
        return details.findElement(txtRealEstateOwnershipPercentageSubElementDetails);
    }

    protected WebElement getTxtRealEstateAddress() {
        return details.findElement(txtRealEstateAddressSubElementDetails);
    }

    protected WebElement getTxtRealEstateBlock() {
        return details.findElement(txtRealEstateBlockSubElementDetails);
    }

    protected WebElement getTxtRealEstatePlot() {
        return details.findElement(txtRealEstatePlotSubElementDetails);
    }

    protected WebElement getBtnRealEstateInIsrael() {
        return details.findElements(btnsRealEstateTrueSubElementDetails).get(0);
    }

    protected WebElement getBtnRealEstateOversea() {
        return details.findElements(btnsRealEstateFalseSubElementDetails).get(0);
    }



    protected WebElement getBtnRealEstateDivided() {
        return details.findElements(btnsRealEstateTrueSubElementDetails).get(1);
    }

    protected WebElement getBtnRealEstateNotDivided() {
        return details.findElements(btnsRealEstateFalseSubElementDetails).get(1);
    }

    protected WebElement getBtnRealEstateTenantIsraeli() {
        return details.findElements(btnsRealEstateTrueSubElementDetails).get(2);
    }

    protected WebElement getBtnRealEstateTenantNotIsraeli() {
        return details.findElements(btnsRealEstateFalseSubElementDetails).get(2);
    }

    protected WebElement getBtnRealEstatePersonalUsage() {
        return details.findElements(btnsRealEstateUsageSubElementDetails).get(0);
    }

    protected WebElement getBtnRealEstateFamilyUsage() {
        return details.findElements(btnsRealEstateUsageSubElementDetails).get(1);
    }

    protected WebElement getBtnRealEstateRenting() {
        return details.findElements(btnsRealEstateUsageSubElementDetails).get(2);
    }

    protected WebElement getBtnRealEstateNotUsing() {
        return details.findElements(btnsRealEstateUsageSubElementDetails).get(3);
    }

    protected WebElement getBtnRealEstateAnotherUsage() {
        return details.findElements(btnsRealEstateUsageSubElementDetails).get(4);
    }

    protected WebElement getBtnRealEstateResidentialPurpose() {
        return details.findElements(btnsRealEstateRentingPurpose).get(0);
    }

    protected WebElement getBtnRealEstateBusinessPurpose() {
        return details.findElements(btnsRealEstateRentingPurpose).get(1);
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

    protected WebElement getTxtRenterCountry() {
        return details.findElement(txtRenterCountrySubElementDetails);
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

    // enter real estate address
    protected void enterRealEstateAddress(String address) {
        fillFormField(getTxtRealEstateAddress(), address);
    }

    protected void enterRealEstateBlock(String block) {
        fillFormField(getTxtRealEstateBlock(), block);
    }

    protected void enterRealEstatePlot(String plot) {
        fillFormField(getTxtRealEstatePlot(), plot);
    }

    // choose real estate place
    protected void chooseRealEstateInIsrael() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateInIsrael());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateOversea() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateOversea());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }



    protected void chooseRealEstateDivided() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateDivided());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateNotDivided() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateNotDivided());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateTenantIsraeli() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateTenantIsraeli());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateTenantNotIsraeli() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateTenantNotIsraeli());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    // choose real estate usage
    protected void chooseRealEstatePersonalUsage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstatePersonalUsage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateFamilyUsage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateFamilyUsage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateRenting() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateRenting());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateNotUsing() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateNotUsing());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateAnotherUsage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateAnotherUsage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    // real estate renting purpose
    protected void chooseRealEstateResidentialPurpose() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateResidentialPurpose());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseRealEstateBusinessPurpose() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateBusinessPurpose());
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

    protected void enterRenterCountry(String renterCountry) {
        fillFormField(getTxtRenterCountry(), renterCountry);
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
