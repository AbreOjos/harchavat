package pom.forms.wages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import static constants.WagesConstants.*;

public class WageDetails extends BasePage {

    private final WebElement details;

    public WageDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    protected WebElement getTxtEmployerName() {
        return details.findElement(txtEmployerNameSubElementDetails);
    }

    protected WebElement getTxtEmployerAddress() {
        return details.findElement(txtEmployerAddressSubElementDetails);
    }

    protected WebElement getTxtTikNikuim() {
        return details.findElement(txtTikNikuimSubElementDetals);
    }

    protected WebElement getTxtAnnualIncome() {
        return details.findElement(txtAnnualIncomeSubElementDetails);
    }

    // wage details
    protected void enterEmployerName(String employerName) {
        fillFormField(getTxtEmployerName(), employerName);

    }

    protected void enterEmployerAddress(String employerAddress) {
        fillFormField(getTxtEmployerAddress(), employerAddress);

    }

    protected void enterTikNikuim(String tikNikuim) {
        fillFormField(getTxtTikNikuim(), tikNikuim);

    }

    protected void enterAnnualIncome(String annualIncome) {
        fillFormField(getTxtAnnualIncome(), annualIncome);

    }
}
