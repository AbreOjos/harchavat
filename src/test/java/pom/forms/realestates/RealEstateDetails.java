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



}
