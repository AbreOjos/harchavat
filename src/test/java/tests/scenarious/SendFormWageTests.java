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
        Assert.assertFalse(sendForm.cityExists(0), "Empty field City exists");
        Assert.assertFalse(sendForm.streetExists(0), "Empty field Street exists");
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
        Assert.assertFalse(sendForm.cityExists(0), "Empty field City exists");
        Assert.assertFalse(sendForm.streetExists(0), "Empty field Street exists");
        Assert.assertFalse(sendForm.houseNumberExists(0), "Empty field House Number exists");

        wage = basePage.clickMenuWage();
        wage.selectCountryFromDropDownListByIndex(0, 0);
        sendForm = basePage.clickMenuSendForm();

        Assert.assertTrue(sendForm.stateExists(0),
                "Empty field State with default value does not exist after Country was chosen");
        Assert.assertTrue(sendForm.wageStateContainsText(0, NOT_YET_REPORTED),
                "Field State does not contain the default value NOT_YET_REPORTED after a country was chosen");
    }

    protected void checkUnnecessaryIsraelIncomeFields() {
        log.info("Check that after changing income from Abroad to Israel necessary fields stored and unnecessary removed");

        String annualIncome = "123";
        String employerName = "Employer Name";
        String state = "State";
        String city = "City";
        String street = "Street";
        String homeNum = "10 a";

        Wage wage = basePage.clickMenuWage();
        wage.chooseDontHaveWage();
        wage.clickBtnSave();
        wage.chooseHaveWage();

        // choose Abroad Income, fill all fields
        wage.chooseAbroadIncome(0);
        wage.enterAnnualIncome(0, annualIncome);
        wage.enterEmployerName(0, employerName);
        wage.selectCountryFromDropDownListByIndex(0, 0);
        wage.enterState(0, state);
        wage.enterCity(0, city);
        wage.enterStreet(0, street);
        wage.enterHouseNum(0, homeNum);

        // switch to Israel Income
        wage.chooseIsraelIncome(0);

        // go to Send Form page, check fields
        SendForm sendForm = basePage.clickMenuSendForm();

        String fieldLost = "field lost after moving from Abroad to Israel income";
        String fieldNotRemoved = "was not removed after moving from Abroad to Israel income";
        String incorrectValue = "incorrect after moving from Abroad to Israel income";

        Assert.assertTrue(sendForm.typeIncomeExists(0), "Type Income " + fieldLost);
        Assert.assertTrue(sendForm.wageIncomeTypeIsrael(0), "Type Income " + incorrectValue);
        Assert.assertTrue(sendForm.annualIncomeExists(0), "Annual Income " + fieldLost);
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(0, annualIncome), "Annual Income " + incorrectValue);
        Assert.assertTrue(sendForm.employerNameExists(0), "Employer Name " + fieldLost);
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(0, employerName), "Employer Name " + incorrectValue);
        Assert.assertFalse(sendForm.countryExists(0), "Country " + fieldNotRemoved);
        Assert.assertFalse(sendForm.stateExists(0), "State " + fieldNotRemoved);
        Assert.assertFalse(sendForm.cityExists(0), "City " + fieldNotRemoved);
        Assert.assertFalse(sendForm.streetExists(0), "Street " + fieldNotRemoved);
        Assert.assertFalse(sendForm.houseNumberExists(0), "House Number " + fieldNotRemoved);

    }
}
