package pom.forms.sendform.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

public class VariousBase extends BasePage {

    // == private members ==
    private final WebElement details;

    // == constructors ==
    public VariousBase(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    protected boolean variousContainsText(String text) {
        return subElementContainsText(details, text);
    }
}
