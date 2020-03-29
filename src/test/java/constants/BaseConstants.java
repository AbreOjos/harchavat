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

}
