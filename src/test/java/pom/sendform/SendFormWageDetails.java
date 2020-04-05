package pom.sendform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

public class SendFormWageDetails extends BasePage {

    // == private members ==
    private final WebElement details;

    // == constructors ==
    public SendFormWageDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    protected boolean elementContainsText(String text) {
        return subElementContainsText(details, text);
    }
}
