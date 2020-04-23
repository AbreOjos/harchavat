package tests.scenarious;

import assertions.AssertionsHarchavat;
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

    protected void checkUnnecessaryAbroadIncomeFields() {
        log.info("Check that after changing income from Israel to Abroad necessary fields stored and unnecessary removed");

        String annualIncome = "123";
        String employerName = "Employer Name";
        String homeNum = "10 a";
        String tikNikuim = "123456789";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();

        // choose Israel Income, fill all fields
        wage.chooseIsraelIncome(0);
        wage.enterAnnualIncome(0, annualIncome);
        wage.enterEmployerName(0, employerName);
        wage.selectCityFromDropDownListByIndex(0, 0);
        wage.selectStreetFromDropDownListByIndex(0, 0);
        wage.enterHouseNum(0, homeNum);
        wage.enterTikNikuim(0, tikNikuim);

        // switch to Abroad income
        wage.chooseAbroadIncome(0);

        // go to Send Form page, check fields
        SendForm sendForm = basePage.clickMenuSendForm();

        String fieldLost = "field lost after moving from Israel to Abroad income";
        String fieldNotRemoved = "was not removed after moving from Israel to Abroad income";
        String incorrectValue = "incorrect after moving from Israel to Abroad income";

        Assert.assertTrue(sendForm.typeIncomeExists(0), "Type Income " + fieldLost);
        Assert.assertTrue(sendForm.wageIncomeTypeAbroad(0), "Wage Income " + incorrectValue);
        Assert.assertTrue(sendForm.annualIncomeExists(0), "Annual Income " + fieldLost);
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(0, annualIncome), "Annual Income " + incorrectValue);
        Assert.assertTrue(sendForm.employerNameExists(0), "Employer Name " + fieldLost);
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(0, employerName), "Employer Name " + incorrectValue);
        Assert.assertFalse(sendForm.cityExists(0), "City " + fieldNotRemoved);
        Assert.assertFalse(sendForm.streetExists(0), "Street " + fieldNotRemoved);
        Assert.assertFalse(sendForm.houseNumberExists(0), "House Number " + fieldNotRemoved);
        Assert.assertFalse(sendForm.tikNikuimExists(0), "Tik Nikuim " + fieldNotRemoved);
    }

    protected void multiWages() {
        log.info("Add and delete a few wages, check that data does not loss");

        String firstAnnualIncome = "123";
        String firstEmployerName = "Employer Name";
        String firstHouseNum = "10 a";
        String firstTikNikuim = "123456789";

        String secondAnnualIncome = "456";
        String secondEmployerName = "Second Employer Name";
        String secondHouseNum = "20 a";
        String secondTikNikuim = "987654321";

        String thirdAnnualIncome = "789";
        String thirdEmployerName = "Third Employer Name";
        String thirdState = "State";
        String thirdCity = "City";
        String thirdStreet = "Street";
        String thirdHouseNum = "30 a";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();

        wage.addWage();
        wage.addWage();

        // fill first wage
        wage.chooseIsraelIncome(0);
        wage.enterAnnualIncome(0, firstAnnualIncome);
        wage.enterEmployerName(0, firstEmployerName);
        String firstSelectedCity = wage.selectCityFromDropDownListByIndex(0, 0);
        String firstSelectedStreet = wage.selectStreetFromDropDownListByIndex(0, 0);
        wage.enterHouseNum(0, firstHouseNum);
        wage.enterTikNikuim(0, firstTikNikuim);

        // fill second wage
        wage.chooseIsraelIncome(1);
        wage.enterAnnualIncome(1, secondAnnualIncome);
        wage.enterEmployerName(1, secondEmployerName);
        String secondSelectedCity = wage.selectCityFromDropDownListByIndex(1, 1);
        String secondSelectedStreet = wage.selectStreetFromDropDownListByIndex(1, 1);
        wage.enterHouseNum(1, secondHouseNum);
        wage.enterTikNikuim(1, secondTikNikuim);

        // fill third wage
        wage.chooseAbroadIncome(2);
        wage.enterAnnualIncome(2, thirdAnnualIncome);
        wage.enterEmployerName(2, thirdEmployerName);
        String thirdCountry = wage.selectCountryFromDropDownListByIndex(2, 2);
        wage.enterState(2, thirdState);
        wage.enterCity(2, thirdCity);
        wage.enterStreet(2, thirdStreet);
        wage.enterHouseNum(2, thirdHouseNum);

        // go to Send Form, check data
        SendForm sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getWage(), 3,
                String.format("Expected %d wages on Send Form page, but found %d", 3, sendForm.getWage().size()));

        // first wage
        Assert.assertTrue(sendForm.wageIncomeTypeIsrael(0), "Type Income incorrect, expected Israel");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(0, firstAnnualIncome),
                String.format("Annual Income incorrect, expected %s", firstAnnualIncome));
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(0, firstEmployerName),
                String.format("Employer Name incorrect, expected %s", firstEmployerName));
        Assert.assertTrue(sendForm.wageCityContainsText(0, firstSelectedCity),
                String.format("City incorrect, expected %s", firstSelectedCity));
        Assert.assertTrue(sendForm.wageStreetContainsText(0, firstSelectedStreet),
                String.format("Street incorrect, expected %s", firstSelectedStreet));
        Assert.assertTrue(sendForm.wageNumHouseContainsText(0, firstHouseNum),
                String.format("House Number incorrect, expected %s", firstHouseNum));
        Assert.assertTrue(sendForm.wageTikNikuimContainsText(0, firstTikNikuim),
                String.format("Tik Nikuim incorrect, expected %s", firstTikNikuim));

        // second wage
        Assert.assertTrue(sendForm.wageIncomeTypeIsrael(1), "Type Income incorrect, expected Israel");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(1, secondAnnualIncome),
                String.format("Annual Income incorrect, expected %s", secondAnnualIncome));
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(1, secondEmployerName),
                String.format("Employer Name incorrect, expected %s", secondEmployerName));
        Assert.assertTrue(sendForm.wageCityContainsText(1, secondSelectedCity),
                String.format("City incorrect, expected %s", secondSelectedCity));
        Assert.assertTrue(sendForm.wageStreetContainsText(1, secondSelectedStreet),
                String.format("Street incorrect, expected %s", secondSelectedStreet));
        Assert.assertTrue(sendForm.wageNumHouseContainsText(1, secondHouseNum),
                String.format("House Number incorrect, expected %s", secondHouseNum));
        Assert.assertTrue(sendForm.wageTikNikuimContainsText(1, secondTikNikuim),
                String.format("Tik Nikuim incorrect, expected %s", secondTikNikuim));

        // third wage
        Assert.assertTrue(sendForm.wageIncomeTypeAbroad(2), "Type Income incorrect, expected Abroad");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(2, thirdAnnualIncome),
                String.format("Annual Income incorrect, expected %s", thirdAnnualIncome));
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(2, thirdEmployerName),
                String.format("Employer Name incorrect, expected %s", thirdEmployerName));
        Assert.assertTrue(sendForm.wageCountryContainsText(2, thirdCountry),
                String.format("Country incorrect, expected %s", thirdCountry));
        Assert.assertTrue(sendForm.wageStateContainsText(2, thirdState),
                String.format("State incorrect, expected %s", thirdState));
        Assert.assertTrue(sendForm.wageCityContainsText(2, thirdCity),
                String.format("City incorrect, expected %s", thirdCity));
        Assert.assertTrue(sendForm.wageStreetContainsText(2, thirdStreet),
                String.format("Street incorrect, expected %s", thirdStreet));
        Assert.assertTrue(sendForm.wageNumHouseContainsText(2, thirdHouseNum),
                String.format("House Number incorrect, expected %s", thirdHouseNum));

        // return to Wage, delete one of the wages
        wage = basePage.clickMenuWage();
        wage.deleteWage(1);

        // return to Send Form, re-check data
        sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getWage(), 2,
                String.format("Expected %d wages on Send Form page, but found %d", 2, sendForm.getWage().size()));

        // first wage
        Assert.assertTrue(sendForm.wageIncomeTypeIsrael(0), "Type Income incorrect, expected Israel");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(0, firstAnnualIncome),
                String.format("Annual Income incorrect, expected %s", firstAnnualIncome));
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(0, firstEmployerName),
                String.format("Employer Name incorrect, expected %s", firstEmployerName));
        Assert.assertTrue(sendForm.wageCityContainsText(0, firstSelectedCity),
                String.format("City incorrect, expected %s", firstSelectedCity));
        Assert.assertTrue(sendForm.wageStreetContainsText(0, firstSelectedStreet),
                String.format("Street incorrect, expected %s", firstSelectedStreet));
        Assert.assertTrue(sendForm.wageNumHouseContainsText(0, firstHouseNum),
                String.format("House Number incorrect, expected %s", firstHouseNum));
        Assert.assertTrue(sendForm.wageTikNikuimContainsText(0, firstTikNikuim),
                String.format("Tik Nikuim incorrect, expected %s", firstTikNikuim));

        // second wage (former third)
        Assert.assertTrue(sendForm.wageIncomeTypeAbroad(1), "Type Income incorrect, expected Abroad");
        Assert.assertTrue(sendForm.wageAnnualIncomeContainsText(1, thirdAnnualIncome),
                String.format("Annual Income incorrect, expected %s", thirdAnnualIncome));
        Assert.assertTrue(sendForm.wageEmployerNameContainsText(1, thirdEmployerName),
                String.format("Employer Name incorrect, expected %s", thirdEmployerName));
        Assert.assertTrue(sendForm.wageCountryContainsText(1, thirdCountry),
                String.format("Country incorrect, expected %s", thirdCountry));
        Assert.assertTrue(sendForm.wageStateContainsText(1, thirdState),
                String.format("State incorrect, expected %s", thirdState));
        Assert.assertTrue(sendForm.wageCityContainsText(1, thirdCity),
                String.format("City incorrect, expected %s", thirdCity));
        Assert.assertTrue(sendForm.wageStreetContainsText(1, thirdStreet),
                String.format("Street incorrect, expected %s", thirdStreet));
        Assert.assertTrue(sendForm.wageNumHouseContainsText(1, thirdHouseNum),
                String.format("House Number incorrect, expected %s", thirdHouseNum));

    }
}
