package constants;

import org.openqa.selenium.By;

public class RealEstateConstants {

    // == constructors ==
    private RealEstateConstants() {
    }

    // elements
    public static final By realEstateDetailsPanel = By.xpath("//div[@class='other-box']//div[contains(@class, 'shaamPage')]");

    // sub-elements
    public static final By btnsRealEstateTrueSubElementDetails = By.xpath(".//*[not(contains(@class, 'yes-no-box'))]/*[contains(@class, 'toggle')]/button[@value='true']");
    public static final By btnsRealEstateFalseSubElementDetails = By.xpath(".//*[not(contains(@class, 'yes-no-box'))]/*[contains(@class, 'toggle')]/button[@value='false']");
    public static final By btnsRealEstateAssetIsraelOrAbroadSubElementDetails = By.xpath(".//div[@name='assetInIsrael']//button");
    public static final By btnsRealEstateAssetDetailsSubElementDetails = By.xpath(".//div[@name='assetDetails']//button");
    public static final By dropDownRealEstateTypeSubElementDetails = By.xpath(".//div[@class='v-select__slot']");
    public static final By txtExplainPropertyTypeSubElementDetails = By.xpath(".//input[@name='explainPropertyType']");
    public static final By calendarRealEstateSubElementDetails = By.xpath(".//input[@name='date']");
    public static final By txtRealEstateSizeSubElementDetails = By.xpath(".//input[@name='square']");
    public static final By txtRealEstateOwnershipPercentageSubElementDetails = By.xpath(".//input[@name='ownershipPercentage']");
    public static final By txtRealEstateAddressSubElementDetails = By.xpath(".//input[@name='assetAddress']");
    public static final By txtRealEstateBlockSubElementDetails = By.xpath(".//input[@name='gush']");
    public static final By txtRealEstatePlotSubElementDetails = By.xpath(".//input[@name='helka']");
    public static final By btnRealEstatePersonalUseSubElementDetails = By.xpath(".//button[@value='personal_use']");
    public static final By btnRealEstateFamilyUseSubElementDetails = By.xpath(".//button[@value='family_use']");
    public static final By btnRealEstateRentUseSubElementDetails = By.xpath(".//button[@value='rent']");
    public static final By btnRealEstateNoUseSubElementDetails = By.xpath(".//button[@value='no_use']");
    public static final By btnRealEstateOtherUseSubElementDetails = By.xpath(".//button[@value='other']");
    public static final By btnRealEstateSplitSubElementDetails = By.xpath(".//*[@name='wasSplit']/button[@value='true']");
    public static final By btnRealEstateNotSplitSubElementDetails = By.xpath(".//*[@name='wasSplit']/button[@value='false']");
    public static final By volumeRealEstateDividedSubElementDetails = By.xpath(".//input[@name='splitAmount']");
    public static final By volumeRealEstateAddSubElementDetails = By.xpath(".//button[contains(@class, 'addPanel')]");
    public static final By volumeRealEstateRemoveSubElementDetails = By.xpath(".//button[contains(@class, 'remove')]");
    public static final By txtRenterIdSubElementDetails = By.xpath(".//input[@name='renterId']");
    public static final By txtMonthlyRentSubElementDetails = By.xpath(".//input[@name='monthlyRent']");
    public static final By txtRenterCountrySubElementDetails = By.xpath(".//input[@name='renterCountry']");
    public static final By txtRenterPasswordSubElementDetails = By.xpath(".//input[@name='renterPassport']");
    public static final By attachContractFileSubElementDetails = By.xpath(".//div[@class='v-btn__content']//input");

    // picker (sub-element of Details)
    public static final By btnPickerSubElementDetail = By.xpath(".//input[@name='date']");
    public static final By btnHeaderPickerSubElementDetails = By.xpath(".//div[@class='accent--text']/button");
    public static final By btnRightSubElementDetails = By.xpath(".//button//i[contains(text(),'chevron_right')]");
    public static final By btnLeftSubElementDetails = By.xpath(".//button//i[contains(text(),'chevron_left')]");
    public static final By lblDaySubElementDetails = By.xpath(".//tbody/tr/td/button/div");
    public static final By btnsActionsPickerSubElementDetails = By.xpath(".//div[contains(@class, 'v-picker__actions')]/button");

}
