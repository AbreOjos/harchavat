package pom.sendform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.List;

import static constants.SendFormConstants.tenantSubElementRealEstateList;

public class SendFormRealEstateDetails extends BasePage {

    // == private members ==
    private final WebElement details;

    // == constructors ==
    public SendFormRealEstateDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == private methods ==
    private List<WebElement> getTenantsList() {
        return details.findElements(tenantSubElementRealEstateList);
    }
}
