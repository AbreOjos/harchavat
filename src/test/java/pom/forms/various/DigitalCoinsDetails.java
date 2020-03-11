package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

public class DigitalCoinsDetails extends BasePage {

    private final WebElement details;

    public DigitalCoinsDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }
}
