package pom.forms.realestates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
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
    }

    protected void chooseRealEstateOversea() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateOversea());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    protected void chooseRealEstateDivided() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateDivided());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void chooseRealEstateNotDivided() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateNotDivided());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void chooseRealEstateTenantIsraeli() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateTenantIsraeli());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void chooseRealEstateTenantNotIsraeli() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateTenantNotIsraeli());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // choose real estate usage
    protected void chooseRealEstatePersonalUsage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstatePersonalUsage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void chooseRealEstateFamilyUsage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateFamilyUsage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void chooseRealEstateRenting() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateRenting());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void chooseRealEstateNotUsing() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateNotUsing());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void chooseRealEstateAnotherUsage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnRealEstateAnotherUsage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
