package constants;

import org.openqa.selenium.By;

public class FillFormConstants {
    private FillFormConstants() {
    }

    // sub-elements
    public static final By trueSubElementYesNoBox = By.xpath(".//input[@value='true']");
    public static final By falseSubElementYesNoBox = By.xpath(".//input[@value='valse']");
    public static final By selectedSubElementDropDownLists = By.xpath("./preceding-sibling::div");


}
