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
    public static final By dropDownRealEstateTypeSubElementDetails = By.xpath(".//div[@class='v-select__slot']");
    public static final By calendarRealEstateSubElementDetails = By.xpath(".//input[@name='date']");
    public static final By txtRealEstateSizeSubElementDetails = By.xpath(".//input[@name='square']");
    public static final By txtRealEstateOwnershipPercentageSubElementDetails = By.xpath(".//input[@name='ownershipPercentage']");
    public static final By txtRealEstateAddressSubElementDetails = By.xpath(".//input[@name='assetAddress']");
    public static final By txtRealEstateBlockSubElementDetails = By.xpath(".//input[@name='gush']");
    public static final By txtRealEstatePlotSubElementDetails = By.xpath(".//input[@name='gush']");
    public static final By btnsRealEstateUsageSubElementDetails = By.xpath(".//div[@class='bgl-toggle mb-3']//button");

}
