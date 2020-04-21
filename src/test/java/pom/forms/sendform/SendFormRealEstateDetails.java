package pom.forms.sendform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.List;

import static constants.EnglishHebrewConstants.NO;
import static constants.EnglishHebrewConstants.YES;
import static constants.SendFormConstants.tenantSubElementRealEstateList;

public class SendFormRealEstateDetails extends BasePage {

    // == final members ==
    public static final String TENANT = "tenant";

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
//        if (tenantNumber<0 || tenantNumber>=getTenantsList().size()) {
//            throw new WrongArgumentException(String.format("Impossible to get details about a tenant #%d. " +
//                    "The number need to be between 0 and %d not inclusive", tenantNumber, getTenantsList().size()));
//        }

        checkNumber(tenantNumber, TENANT, getTenantsList());

        return realEstateContainsText(getTenantsList().get(tenantNumber), YES);
    }

    protected boolean tenantAbroad(int tenantNumber) {
        checkNumber(tenantNumber, TENANT, getTenantsList());

        return realEstateContainsText(getTenantsList().get(tenantNumber), NO);
    }

    protected boolean tenantIdContains(int tenantNumber, String id) {
        checkNumber(tenantNumber, TENANT, getTenantsList());

        return realEstateContainsText(getTenantsList().get(tenantNumber), id);
    }

    protected boolean tenantCountryContains(int tenantNumber, String country) {
        checkNumber(tenantNumber, TENANT, getTenantsList());

        return realEstateContainsText(getTenantsList().get(tenantNumber), country);
    }

    protected boolean tenantStateContains(int tenantNumber, String state) {
        checkNumber(tenantNumber, TENANT, getTenantsList());

        return realEstateContainsText(getTenantsList().get(tenantNumber), state);
    }

    protected boolean tenantPassportContains(int tenantNumber, String passport) {
        checkNumber(tenantNumber, TENANT, getTenantsList());

        return realEstateContainsText(getTenantsList().get(tenantNumber), passport);
    }

    // == private methods ==
    private List<WebElement> getTenantsList() {
        return details.findElements(tenantSubElementRealEstateList);
    }
}
