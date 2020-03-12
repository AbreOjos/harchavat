package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import static constants.VariousConstants.*;

public class AbroadBankAccountsDetails extends BasePage {

    private final WebElement details;

    public AbroadBankAccountsDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    protected void selectCountryFromDropDownListByName(String country) {
        selectItemFromDropDownListByName(getDropDownCountry(), country);
    }

    protected void enterState(String state) {
        fillFormField(getTxtState(), state);
    }

    protected void enterCity(String city) {
        fillFormField(getTxtCity(), city);
    }

    protected void enterBankName(String city) {
        fillFormField(getTxtBankName(), city);
    }

    protected void enterBankNum(String bankNum) {
        fillFormField(getTxtBankNum(), bankNum);
    }

    protected void enterBranchName(String branchName) {
        fillFormField(getTxtBranchName(), branchName);
    }

    protected void enterBranchNum(String branchNum) {
        fillFormField(getTxtBranchNum(), branchNum);
    }

    protected void enterAccountNum(String accountNum) {
        fillFormField(getTxtAccountNum(), accountNum);
    }

    protected void enterPartnersNum(String partnersNum) {
        fillFormField(getTxtPartnersNum(), partnersNum);
    }


    // == private methods ==
    private WebElement getDropDownCountry() {
        return details.findElement(dropDownCountrySubElementAbroadBankAccountsDetails);
    }

    private WebElement getTxtState() {
        return details.findElement(txtStateSubElementAbroadBankAccountsDetails);
    }

    private WebElement getTxtCity() {
        return details.findElement(txtCitySubElementAbroadBankAccountsDetails);
    }

    private WebElement getTxtBankName() {
        return details.findElement(txtBankNameSubElementAbroadBankAccountsDetails);
    }

    private WebElement getTxtBankNum() {
        return details.findElement(txtBankNumSubElementAbroadBankAccountsDetails);
    }

    private WebElement getTxtBranchName() {
        return details.findElement(txtBranchNameSubElementAbroadBankAccountsDetails);
    }

    private WebElement getTxtBranchNum() {
        return details.findElement(txtBranchNumSubElementAbroadBankAccountsDetails);
    }

    private WebElement getTxtAccountNum() {
        return details.findElement(txtAccountNumSubElementAbroadBankAccountsDetails);
    }

    private WebElement getTxtPartnersNum() {
        return details.findElement(txtPartnersNumSubElementAbroadBankAccountsDetails);
    }
}
