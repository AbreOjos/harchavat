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
    public static final By lblDropDownRealEstateTypeSubElementDetails = By.xpath(".//div[@class='v-select__slot']/label");
    public static final By txtExplainPropertyTypeSubElementDetails = By.xpath(".//input[@name='explainPropertyType']");
    public static final By calendarRealEstateSubElementDetails = By.xpath(".//input[@name='date']");
    public static final By txtRealEstatePropertyAreaSubElementDetails = By.xpath(".//input[@name='square']");
    public static final By txtRealEstateOwnershipPercentageSubElementDetails = By.xpath(".//input[@name='ownershipPercentage']");
    public static final By txtRealEstateBlockSubElementDetails = By.xpath(".//input[@name='gush']");
    public static final By txtRealEstatePlotSubElementDetails = By.xpath(".//input[@name='helka']");
    public static final By txtRealEstateSubPlotSubElementDetails = By.xpath(".//input[@name='subHelka']");
    public static final By dropDownCountrySubElementDetails = By.xpath(".//input[@name='country']");
    public static final By txtRealEstateCitySubElementDetails = By.xpath(".//input[@name='city']");
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

    // error messages sub-elements
    public static final By errorMessageNeedFillRealEstateTypeSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה סוג נדלן')]");
    public static final By errorMessageNeedFillDateSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה תאריך')]");
    public static final By errorMessageNeedFillPropertyAreaSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה שטח הנכס')]");
    public static final By errorMessagePropertyAreaContainsDigitalOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה שטח הנכס יכול להכיל ספרות שלמות בלבד')]");
    public static final By errorMessageNeedFillOwnershipPercentageSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה אחוז בעלות')]");
    public static final By errorMessageOwnershipPercentageContainsDigitalOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה אחוז בעלות יכול להכיל ספרות שלמות בלבד')]");
    public static final By errorMessageOwnershipPercentageHundredMaxSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה אחוז בעלות יכול להיות 100 לכל היותר')]");
    public static final By errorMessageOwnershipPercentageOneMinSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'הערך של אחוז בעלות חייב להיות לפחות 1')]");
    public static final By errorMessageNeedFillBlockSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה גוש')]");
    public static final By errorMessageBlockContainsDigitalOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה גוש יכול להכיל ספרות שלמות בלבד')]");
    public static final By errorMessageNeedFillPlotSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה חלקה')]");
    public static final By errorMessagePlotContainsDigitalOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה חלקה יכול להכיל ספרות שלמות בלבד')]");
    public static final By errorMessageSubPlotContainsDigitalOnlySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה תת-חלקה יכול להכיל ספרות שלמות בלבד')]");
    public static final By errorMessageSubPlotTooLongSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה תת-חלקה לא יכול להכיל יותר מ- 2 תווים')]");
    public static final By errorMessageNeedFillCitySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה עיר')]");
    public static final By errorMessageNeedFillStreetSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה רחוב')]");
    public static final By errorMessageNeedFillHouseNumberSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מספר בית')]");
    public static final By errorMessageHouseNumberContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מספר בית יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageNeedFillCountrySubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'חובה למלא את השדה מדינה')]");
    public static final By errorMessageStateContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה מחוז יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");
    public static final By errorMessageCityContainsCharactersSubElementDetails =
            By.xpath(".//p[@class='error-msg'][contains(text(),'השדה עיר יכול להכיל את התווים הבאים: אותיות, מספרים . , - ( ) ! : / ? + @ ₪')]");

}
