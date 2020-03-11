package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

public class NonWorkIncomesDetails extends BasePage {

    private final WebElement details;

    public NonWorkIncomesDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }
}
