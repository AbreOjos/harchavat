package pom.sendform;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.List;

import static constants.EnglishHebrewConstants.NO;
import static constants.EnglishHebrewConstants.YES;
import static constants.SendFormConstants.tenantSubElementRealEstateList;

public class SendFormRealEstateDetails extends BasePage {

    // == private members ==
    private final WebElement details;

    // == constructors ==
    public SendFormRealEstateDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    protected boolean realEstateContainsText(String text) {
        return realEstateContainsText(details, text);
    }

    protected boolean realEstateContainsText(WebElement webElement, String text) {
        return subElementContainsText(webElement, text);
    }

    protected boolean tenantIsraeli(int tenantNumber) {
        if (tenantNumber<0 || tenantNumber>=getTenantsList().size()) {
            throw new WrongArgumentException(String.format("Impossible to get details about a tenant #%d. " +
                    "The number need to be between 0 and %d not inclusive", tenantNumber, getTenantsList().size()));
        }

        return realEstateContainsText(getTenantsList().get(tenantNumber), YES);
    }

    protected boolean tenantAbroad(int tenantNumber) {
        if (tenantNumber<0 || tenantNumber>=getTenantsList().size()) {
            throw new WrongArgumentException(String.format("Impossible to get details about a tenant #%d. " +
                    "The number need to be between 0 and %d not inclusive", tenantNumber, getTenantsList().size()));
        }

        return realEstateContainsText(getTenantsList().get(tenantNumber), NO);
    }

    protected boolean tenantIdContains(int tenantNumber, String id) {
        if (tenantNumber<0 || tenantNumber>=getTenantsList().size()) {
            throw new WrongArgumentException(String.format("Impossible to get details about a tenant #%d. " +
                    "The number need to be between 0 and %d not inclusive", tenantNumber, getTenantsList().size()));
        }

        return realEstateContainsText(getTenantsList().get(tenantNumber), id);
    }

    protected boolean tenantCountryContains(int tenantNumber, String country) {
        if (tenantNumber<0 || tenantNumber>=getTenantsList().size()) {
            throw new WrongArgumentException(String.format("Impossible to get details about a tenant #%d. " +
                    "The number need to be between 0 and %d not inclusive", tenantNumber, getTenantsList().size()));
        }

        return realEstateContainsText(getTenantsList().get(tenantNumber), country);
    }

    protected boolean tenantStateContains(int tenantNumber, String state) {
        if (tenantNumber<0 || tenantNumber>=getTenantsList().size()) {
            throw new WrongArgumentException(String.format("Impossible to get details about a tenant #%d. " +
                    "The number need to be between 0 and %d not inclusive", tenantNumber, getTenantsList().size()));
        }

        return realEstateContainsText(getTenantsList().get(tenantNumber), state);
    }

    protected boolean tenantPassportContains(int tenantNumber, String passport) {
        if (tenantNumber<0 || tenantNumber>=getTenantsList().size()) {
            throw new WrongArgumentException(String.format("Impossible to get details about a tenant #%d. " +
                    "The number need to be between 0 and %d not inclusive", tenantNumber, getTenantsList().size()));
        }

        return realEstateContainsText(getTenantsList().get(tenantNumber), passport);
    }

    // == private methods ==
    private List<WebElement> getTenantsList() {
        return details.findElements(tenantSubElementRealEstateList);
    }
}
