package constants;

import org.openqa.selenium.By;

public class BaseConstants {
    private BaseConstants() {
    }

//    public static final By waitFewSecondsWarningDisabled =
//            By.xpath("//*[@class='v-dialog v-dialog--persistent' and contains(@style, 'display: none')]");
    public static final By waitFewSecondsWarningDisabled =
            By.xpath("//*[@class='v-dialog v-dialog--persistent' and contains(@style, 'display: none')]//div[@role='progressbar']");


    // sub-elements
    public static final By errorIconSubElementMenu = By.xpath(".//i[contains(., 'error')]");
    public static final By checkCircleIconSubElementMenu = By.xpath(".//i[contains(., 'check_circle')]");

    public static final By dropDownCitySubElementDetails = By.xpath(".//input[@name='city']");
    public static final By dropDownStreetSubElementDetails = By.xpath(".//input[@name='street']");
    public static final By txtStreetSubElementDetails = By.xpath(".//input[@name='street']");
    public static final By txtCitySubElementDetail = By.xpath(".//input[@name='city']");
    public static final By txtHouseNumSubElementDetails = By.xpath(".//input[@name='houseNum']");
    public static final By txtStateSubElementDetails = By.xpath(".//input[@name='state']");

}
