package tests.scenarious;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import pom.forms.wages.Wage;
import tests.TestBase;

public class WageTests extends TestBase {
    private static final Logger log = Logger.getLogger(WageTests.class);

    protected void checkMenuIcons() {
        log.info("Check that Wage menu has icons: error, checked, without icon");

        String annualIncome = "123";
        String employerName = "abc";
        String houseNum = "10";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        basePage.clickMenuRealEstate();
        wage = basePage.clickMenuWage();

        // check error icon
        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorIconMenu(), 1,
                "An error icon menu did not appears when there are empty mandatory fields");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getCheckCircleIconMenu(), 0,
                "A check-circle icon menu did not disappears when there are empty mandatory fields");


        // enter address and employer name
        wage.chooseIsraelIncome(0);
        wage.deleteAnnualIncome(0);
        wage.enterAnnualIncome(0, annualIncome);
        wage.deleteEmployerName(0);
        wage.enterEmployerName(0, employerName);
        wage.selectCityFromDropDownListByIndex(0, 0);
        wage.selectStreetFromDropDownListByIndex(0, 0);
        wage.deleteHouseNum(0);
        wage.enterHouseNum(0, houseNum);

        basePage.clickMenuRealEstate();
        wage = basePage.clickMenuWage();

        // check check-circle icon
        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getCheckCircleIconMenu(), 1,
                "A check-circle icon menu did not appears when mandatory fields contain correct values");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorIconMenu(), 0,
                "An error icon menu did not disappears when mandatory fields contain correct values");

        wage.chooseDontHaveWage();
        basePage.clickMenuWage();
        wage = basePage.clickMenuWage();

        // check icons disappeared
        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getCheckCircleIconMenu(), 0,
                "A check-circle icon menu appears when there are no wages");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorIconMenu(), 0,
                "An error icon menu appears when there are no wages");
    }


    protected void needFillTypeIncomeErrorMessage() {

        String error = "Need Fill Income Type";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        addTwoWages(wage);

        needChooseErrorMessage(
                wage::getErrorMessageNeedFillTypeIncome,
                basePage::clickMenuWage,
                wage::chooseIsraelIncome,
                wage::deleteWage,
                error);
    }

    protected void needFillAnnualIncomeErrorMessage() {

        String firstIncome = "123";
        String thirdIncome = "456";
        String error = "Annual Income";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        addTwoWages(wage);

        wage.chooseIsraelIncome(0);
        wage.chooseAbroadIncome(1);
        wage.chooseAbroadIncome(2);

        needFillErrorMessage(
                wage::getErrorMessageNeedFillAnnualIncome,
                basePage::clickMenuWage,
                wage::enterAnnualIncome,
                wage::deleteWage,
                firstIncome, thirdIncome, error);
    }

    protected void needFillEmployerNameErrorMessage() {

        String firstEmployerName = "First Employer Name";
        String thirdEmployerName = "Third Employer Name";
        String error = "Employer";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        addTwoWages(wage);

        wage.chooseIsraelIncome(0);
        wage.chooseAbroadIncome(1);
        wage.chooseAbroadIncome(2);

        needFillErrorMessage(
                wage::getErrorMessageNeedFillEmployerName,
                basePage::clickMenuWage,
                wage::enterEmployerName,
                wage::deleteWage,
                firstEmployerName, thirdEmployerName, error);
    }


    protected void needFillCityErrorMessage() {

        Integer firstIndex = 0;
        Integer thirdIndex = 0;
        String error = "City";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        addTwoWages(wage);

        wage.chooseIsraelIncome(0);
        wage.chooseIsraelIncome(1);
        wage.chooseIsraelIncome(2);

        needFillErrorMessage(
                wage::getErrorMessageNeedFillCity,
                basePage::clickMenuWage,
                wage::selectCityFromDropDownListByIndex,
                wage::deleteWage,
                firstIndex, thirdIndex, error);
    }

    protected void needFillStreetErrorMessage() {

        Integer firstIndex = 0;
        Integer thirdIndex = 0;
        String error = "Street";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        addTwoWagesIsraeli(wage);

        needFillErrorMessage(
                wage::getErrorMessageNeedFillStreet,
                basePage::clickMenuWage,
                this::selectCityAndStreet,
                wage::deleteWage,
                firstIndex, thirdIndex, error);
    }

    protected void needFillHouseNumberErrorMessage() {

        String firstHouseNumber = "123";
        String thirdHouseNumber = "10A";
        String error = "Need Fill House Number";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        addTwoWagesIsraeli(wage);

        needFillErrorMessage(
                wage::getErrorMessageNeedFillHouseNumber,
                basePage::clickMenuWage,
                wage::enterHouseNum,
                wage::deleteWage,
                firstHouseNumber, thirdHouseNumber, error);
    }

    protected void needFillTikNikuimErrorMessage() {

        String firstTikNikuim = "123456789";
        String thirdTikNikuim = "987654321";
        String error = "Need Fill Tik Nikuim";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        addTwoWagesIsraeli(wage);

        needFillErrorMessage(
                wage::getErrorMessageNeedFillTikNikuim,
                basePage::clickMenuWage,
                wage::enterTikNikuim,
                wage::deleteWage,
                firstTikNikuim, thirdTikNikuim, error);
    }

    protected void needFillCountryErrorMessage() {

        Integer firstIndex = 0;
        Integer thirdIndex = 0;
        String error = "Need Fill Country";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        addTwoWagesAbroad(wage);

        needFillErrorMessage(
                wage::getErrorMessageNeedFillCountry,
                basePage::clickMenuWage,
                wage::selectCountryFromDropDownListByIndex,
                wage::deleteWage,
                firstIndex, thirdIndex, error);
    }

    protected void tikNikuimCorrectFormat() {
        log.info("Check that only correct format allowed in the field 'tik nikuim'");

        String nonDigitTikNikuim = "abc";
        String shortTikNikuim = "12345678";
        String longTikNikuim = "1234567890";
        String correctTikNikuim = "123456789";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        wage.chooseIsraelIncome(0);

        wage.enterTikNikuim(0, nonDigitTikNikuim);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageTikNikuimTikNikuimCanContainDigitsOnly(0), 1,
                "Error message 'tik nikuim need must contain digits only' did not appear after non-digital value was entered");

        wage.deleteTikNikuim(0);
        wage.enterTikNikuim(0, shortTikNikuim);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageTikNikuimNeedBeNineDigits(0), 1,
                "Error message 'tik nikuim need be 9-digits long' did not appear after too short value was entered");

        wage.deleteTikNikuim(0);
        wage.enterTikNikuim(0, longTikNikuim);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageTikNikuimCannotBeLongerNineDigits(0), 1,
                "Error message 'tik nikuim cannot be longer than 9 digits' did not appear after too long value was entered");

        wage.deleteTikNikuim(0);
        wage.enterTikNikuim(0, correctTikNikuim);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageTikNikuimNeedBeNineDigits(0), 0,
                "Error message 'tik nikuim need be 9-digits long' appeared after a correct value was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageTikNikuimCannotBeLongerNineDigits(0), 0,
                "Error message 'tik nikuim cannot be longer than 9 digits' appeared after a correct value was entered");

    }

    protected void forbiddenCharactersEmployerName(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Employer Name field, find the error message", forbiddenChar));

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        wage.chooseIsraelIncome(0);

        wage.enterEmployerName(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageEmployerNameContainsCharacters(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Employer Name", forbiddenChar));
    }

    protected void forbiddenCharactersHouseNumber(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a House Number field, find the error message", forbiddenChar));

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        wage.chooseIsraelIncome(0);

        wage.enterHouseNum(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageHouseNumberContainsCharacters(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into House Number", forbiddenChar));
    }

    protected void forbiddenCharactersState(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a State field, find the error message", forbiddenChar));

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        wage.chooseAbroadIncome(0);

        wage.enterState(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageStateContainsCharacters(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into State", forbiddenChar));
    }

    protected void forbiddenCharactersCity(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a City field, find the error message", forbiddenChar));

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        wage.chooseAbroadIncome(0);

        wage.enterCity(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageCityContainsCharacters(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into City", forbiddenChar));
    }

    protected void forbiddenCharactersStreet(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Street field, find the error message", forbiddenChar));

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        wage.chooseAbroadIncome(0);

        wage.enterStreet(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageStreetContainsCharacters(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Street", forbiddenChar));
    }

    // == private methods ==
    private void addTwoWages(Wage wage) {
        wage.addWage();
        wage.addWage();
    }

    private void addTwoWagesIsraeli(Wage wage) {
        wage.addWage();
        wage.addWage();
        wage.chooseIsraelIncome(0);
        wage.chooseIsraelIncome(1);
        wage.chooseIsraelIncome(2);
    }

    private void addTwoWagesAbroad(Wage wage) {
        wage.addWage();
        wage.addWage();
        wage.chooseAbroadIncome(0);
        wage.chooseAbroadIncome(1);
        wage.chooseAbroadIncome(2);
    }

    private void selectCityAndStreet(Integer panelIndex, Integer elementIndex) {
        Wage wage = new Wage(driver);
        wage.selectCityFromDropDownListByIndex(panelIndex, elementIndex);
        wage.selectStreetFromDropDownListByIndex(panelIndex, elementIndex);
    }

}

