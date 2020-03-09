package pom.forms.realestates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

public class RealEstateDetails extends BasePage {

    private final WebElement details;

    public RealEstateDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }
}
