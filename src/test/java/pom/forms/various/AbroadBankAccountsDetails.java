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

    protected String selectCountryFromDropDownListByIndex(int index) {
        return selectItemFromDropDownListByIndex(getDropDownCountry(), index);
    }

    protected void enterState(String state) {
        fillFormField(getTxtState(details), state);
    }

    protected void deleteState() {
        cleanFormField(getTxtState(details));
    }

    protected void enterCity(String city) {
        fillFormField(getTxtCity(details), city);
    }

    protected void deleteCity() {
        cleanFormField(getTxtCity(details));
    }

    protected void enterBankName(String city) {
        fillFormField(getTxtBankName(), city);
    }

    protected void deleteBankName() {
        cleanFormField(getTxtBankName());
    }

    protected void enterBankNum(String bankNum) {
        fillFormField(getTxtBankNum(), bankNum);
    }

    protected void deleteBankNum() {
        cleanFormField(getTxtBankNum());
    }

    protected void enterBranchName(String branchName) {
        fillFormField(getTxtBranchName(), branchName);
    }

    protected void deleteBranchName() {
        cleanFormField(getTxtBranchName());
    }

    protected void enterBranchNum(String branchNum) {
        fillFormField(getTxtBranchNum(), branchNum);
    }

    protected void deleteBranchNum() {
        cleanFormField(getTxtBranchNum());
    }

    protected void enterAccountNum(String accountNum) {
        fillFormField(getTxtAccountNum(), accountNum);
    }

    protected void deleteAccountNum() {
        cleanFormField(getTxtAccountNum());
    }

    protected void enterPartnersNum(String partnersNum) {
        fillFormField(getTxtPartnersNum(), partnersNum);
    }

    protected void deletePartnersNum() {
        cleanFormField(getTxtPartnersNum());
    }


    // == private methods ==
    private WebElement getDropDownCountry() {
        return details.findElement(dropDownCountrySubElementAbroadBankAccountsDetails);
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
