package constants;

import org.openqa.selenium.By;

public class RealEstateConstants {

    // == constructors ==
    private RealEstateConstants() {
    }

    // elements
    public static final By realEstateDetailsPanel = By.xpath("//div[@class='other-box']/div[2]/div/div/div");
    public static final By btnsDeletePanel = By.xpath("//div[not(contains(@class, '_250'))]/div/div/p/span[contains(., 'delete')]");
    public static final By tenantPanelSubElementRealEstatePanel = By.xpath(".//p[@class='item-head']/following-sibling::*");

    // sub-elements
    public static final By btnsRealEstateAssetIsraelOrAbroadSubElementDetails = By.xpath(".//div[@name='assetInIsrael']//button");
    public static final By btnsRealEstateAssetDetailsSubElementDetails = By.xpath(".//div[@name='assetDetails']//button");
    public static final By dropDownRealEstateTypeSubElementDetails = By.xpath(".//div[@class='v-select__slot']");
    public static final By txtExplainPropertyTypeSubElementDetails = By.xpath(".//input[@name='explainPropertyType']");
    public static final By calendarRealEstateSubElementDetails = By.xpath(".//input[@name='date']");
    public static final By txtRealEstateSizeSubElementDetails = By.xpath(".//input[@name='square']");
    public static final By txtRealEstateOwnershipPercentageSubElementDetails = By.xpath(".//input[@name='ownershipPercentage']");
    public static final By txtRealEstateBlockSubElementDetails = By.xpath(".//input[@name='gush']");
    public static final By txtRealEstatePlotSubElementDetails = By.xpath(".//input[@name='helka']");
    public static final By txtRealEstateSubPlotSubElementDetails = By.xpath(".//input[@name='subHelka']");
    public static final By dropDownCountrySubElementDetails = By.xpath(".//input[@name='country']");
    public static final By btnRealEstatePersonalUseSubElementDetails = By.xpath(".//button[@value='personal_use']");
    public static final By btnRealEstateFamilyUseSubElementDetails = By.xpath(".//button[@value='family_use']");
    public static final By btnRealEstateRentUseSubElementDetails = By.xpath(".//button[@value='rent']");
    public static final By btnAddTenantSubElementDetails = By.xpath(".//div[@class='_250']//div//img");
    public static final By btnsDeleteTenantSubElementDetails = By.xpath(".//span[contains(., 'delete')]");
    public static final By btnRealEstateNoUseSubElementDetails = By.xpath(".//button[@value='no_use']");
    public static final By btnRealEstateOtherUseSubElementDetails = By.xpath(".//button[@value='other']");
    public static final By btnRealEstateSplitSubElementDetails = By.xpath(".//*[@name='wasSplit']/button[@value='true']");
    public static final By btnRealEstateNotSplitSubElementDetails = By.xpath(".//*[@name='wasSplit']/button[@value='false']");
    public static final By volumeRealEstateDividedSubElementDetails = By.xpath(".//input[@name='splitAmount']");
    public static final By volumeRealEstateAddSubElementDetails = By.xpath(".//button[contains(@class, 'add')]");
    public static final By volumeRealEstateRemoveSubElementDetails = By.xpath(".//button[contains(@class, 'remove')]");
    public static final By txtMonthlyRentSubElementDetails = By.xpath(".//input[@name='monthlyRent']");
    public static final By attachContractFileSubElementDetails = By.xpath(".//div[@class='v-btn__content']//input");

    // sub-elements of tenant sub-panel
    public static final By btnRentIsraeliSubElementTenant = By.xpath(".//*[@name='isRentIsraeli']/button[@value='true']");
    public static final By btnRentAbroadSubElementTenant = By.xpath(".//*[@name='isRentIsraeli']/button[@value='false']");
    public static final By txtRenterIdSubElementTenant = By.xpath(".//input[@name='renterId']");
    public static final By dropDownCountryRenterSubElementTenant = By.xpath(".//input[@name='countryOfRenter']");
    public static final By txtRenterStateSubElementTenant = By.xpath(".//input[@name='state']");
    public static final By txtRenterPassportSubElementTenant = By.xpath(".//input[@name='renterPassport']");


    // picker
    public static final By btnPickerSubElementDetail = By.xpath(".//input[@name='date']");

    public static final By btnHeaderPicker = By.xpath("//div[@class='accent--text']/button");
    public static final By btnRight = By.xpath("//button//i[contains(text(),'chevron_right')]");
    public static final By btnLeft = By.xpath("//button//i[contains(text(),'chevron_left')]");
    public static final By lblDay = By.xpath("//tbody/tr/td/button/div");
    public static final By btnCalendarCancel =
            By.xpath("//div[contains(@class, 'v-picker__actions')]/button/div[contains(text(), 'ביטול')]");
    public static final By btnCalendarOk =
            By.xpath("//div[contains(@class, 'v-picker__actions')]/button/div[contains(text(), 'אישור')]");

}
