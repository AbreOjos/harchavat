package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

public class OwnJewelryDetails extends BasePage {

    private final WebElement details;

    public OwnJewelryDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }
}
