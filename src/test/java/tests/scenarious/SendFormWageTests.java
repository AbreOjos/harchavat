package tests.scenarious;

import org.apache.log4j.Logger;
import org.testng.Assert;
import pom.forms.sendform.SendForm;
import pom.forms.wages.Wage;
import tests.TestBase;

import static constants.EnglishHebrewConstants.NOT_YET_REPORTED;

public class SendFormWageTests extends TestBase {
    private static final Logger log = Logger.getLogger(SendFormWageTests.class);

    protected void checkEmptyIsraelIncomeFields() {
        log.info("Check form when there are empty fields in Israel Income");

        Wage wage = basePage.clickMenuWage();
        wage.chooseDontHaveWage();
        wage.clickBtnSave();
        wage.chooseHaveWage();
        wage.chooseIsraelIncome(0);

        SendForm sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.annualIncomeExists(0), "Field Annual Income with default value does not exist");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(0, "0"),
                "Field Annual Income does not contain the default value 0");
        Assert.assertFalse(sendForm.employerNameExists(0), "Empty field Employer Name exists");
        Assert.assertFalse(sendForm.citySubExists(0), "Empty field City exists");
        Assert.assertFalse(sendForm.streetIncomeExists(0), "Empty field Street exists");
        Assert.assertFalse(sendForm.houseNumberExists(0), "Empty field House Number exists");
        Assert.assertFalse(sendForm.tikNikuimExists(0), "Empty field Tik Nikuim exists");
    }

    protected void checkEmptyAbroadIncomeFields() {
        log.info("Check form when there are empty fields in Abroad Income");

        Wage wage = basePage.clickMenuWage();
        wage.chooseDontHaveWage();
        wage.clickBtnSave();
        wage.chooseHaveWage();
        wage.chooseAbroadIncome(0);

        SendForm sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.annualIncomeExists(0), "Field Annual Income with default value does not exist");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(0, "0"),
                "Field Annual Income does not contain the default value 0");
        Assert.assertFalse(sendForm.employerNameExists(0), "Empty field Employer Name exists");
        Assert.assertFalse(sendForm.countryExists(0), "Empty field Country exists");
        Assert.assertFalse(sendForm.citySubExists(0), "Empty field City exists");
        Assert.assertFalse(sendForm.streetIncomeExists(0), "Empty field Street exists");
        Assert.assertFalse(sendForm.houseNumberExists(0), "Empty field House Number exists");

        wage = basePage.clickMenuWage();
        wage.selectCountryFromDropDownListByIndex(0, 0);
        sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.stateExists(0),
                "Empty field State with default value does not exist after Country was chosen");
        Assert.assertTrue(sendForm.wageStateContainsText(0, NOT_YET_REPORTED),
                "Field State does not contain the default value NOT_YET_REPORTED after a country was chosen");

    }
}