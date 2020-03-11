package constants;

import org.openqa.selenium.By;

public class BaseConstants {
    private BaseConstants() {
    }


    public static final By waitFewSecondsWarningDisabled =
            By.xpath("//*[@class='v-dialog v-dialog--persistent' and contains(@style, 'display: none')]");

}
