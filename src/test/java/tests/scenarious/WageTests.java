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
        log.info("Check the error message 'need to fill income type'");

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        basePage.clickMenuRealEstate();
        wage = basePage.clickMenuWage();

        if (!wage.israelIncomeChosen(0) && !wage.abroadIncomeChosen(0)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(0), 1,
                    "Error message 'Need to Fill Type of Income' did not appear on a first panel");
        }

        wage.addWage();
        wage.addWage();
        basePage.clickMenuRealEstate();
        wage = basePage.clickMenuWage();

        if (!wage.israelIncomeChosen(1) && !wage.abroadIncomeChosen(1)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(1), 1,
                    "Error message 'Need to Fill Type of Income' did not appear on a second panel");
        }

        if (!wage.israelIncomeChosen(2) && !wage.abroadIncomeChosen(2)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(2), 1,
                    "Error message 'Need to Fill Type of Income' did not appear on a third panel");
        }

        wage.chooseIsraelIncome(0);
        basePage.clickMenuRealEstate();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(0), 0,
                "Error message 'Need to Fill Type of Income' did not disappear on a first panel after Israel Income chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(1), 1,
                "Error message 'Need to Fill Type of Income' disappear on a second panel after income chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(2), 1,
                "Error message 'Need to Fill Type of Income' disappear on a third panel after income chosen on a first panel");

        wage.chooseAbroadIncome(2);
        basePage.clickMenuRealEstate();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(2), 0,
                "Error message 'Need to Fill Type of Income' did not disappear on a third panel after Abroad Income chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(1), 1,
                "Error message 'Need to Fill Type of Income' disappear on a second panel after income chosen on a third panel");

        wage.deleteWage(2);
        basePage.clickMenuRealEstate();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(1), 1,
                "Error message 'Need to Fill Type of Income' disappear on a second panel after a third panel was deleted");

        wage.deleteWage(1);
        basePage.clickMenuRealEstate();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(0), 0,
                "Error message 'Need to Fill Type of Income' re-appear on a first panel after second panel was deleted");

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
        log.info("Add a few wages, play with 'need to fill street' error message");

//        Integer firstIndex = 0;
//        Integer thirdIndex = 0;
//        String error = "Street";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        addTwoWages(wage);
        wage.chooseIsraelIncome(0);
        wage.chooseIsraelIncome(1);
        wage.chooseAbroadIncome(2);

        basePage.clickMenuSendForm();
        wage = basePage.clickMenuWage();

//        needFillErrorMessage(
//                wage::getErrorMessageNeedFillStreet,
//                basePage::clickMenuWage,
//                this::selectCityAndStreet,
//                wage::deleteWage,
//                firstIndex, thirdIndex, error);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillStreet(0), 1,
                "Error message 'need to fill street' did not appear on a first panel after Israel income was chosen");

        wage.addWage();
        wage.chooseIsraelIncome(1);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillStreet(1), 1,
                "Error message 'need to fill street' did not appear on a second panel after Israel income was chosen");

        wage.selectCityFromDropDownListByIndex(1, 0);
        wage.selectStreetFromDropDownListByIndex(1, 0);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillStreet(1), 0,
                "Error message 'need to fill street' did not disappear on a second panel after a street was selected");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillStreet(0), 1,
                "Error message 'need to fill street' disappear on a first panel after a street was selected on a second panel");

        wage.addWage();
        wage.chooseAbroadIncome(2);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillStreet(2), 0,
                "Error message 'need to fill street' appear on a third panel after Abroad Income was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillStreet(1), 0,
                "Error message 'need to fill street' re-appear on a second panel after new panel added");

        wage.deleteWage(2);
        wage.deleteWage(1);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillStreet(0), 1,
                "Error message 'need to fill street' disappear on a first panel after all other panels deleted");

    }

    protected void needFillHouseNumberErrorMessage() {
        log.info("Add a few wages, play with 'need to fill house number' error message");

        String houseNumber = "123";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        wage.chooseIsraelIncome(0);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillHouseNumber(0), 1,
                "Error message 'need to fill house number' did not appear on a first panel after Israel income was chosen");

        wage.addWage();
        wage.chooseIsraelIncome(1);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillHouseNumber(1), 1,
                "Error message 'need to fill house number' did not appear on a second panel after Israel income was chosen");

        wage.enterHouseNum(1, houseNumber);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillHouseNumber(1), 0,
                "Error message 'need to fill house number' did not disappear on a second panel after a house number was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillHouseNumber(0), 1,
                "Error message 'need to fill house number' disappear on a first panel after a house number was entered on a second panel");

        wage.addWage();
        wage.chooseAbroadIncome(2);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillHouseNumber(2), 0,
                "Error message 'need to fill house number' appear on a third panel after Abroad Income was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillHouseNumber(1), 0,
                "Error message 'need to fill house number' re-appear on a second panel after new panel added");

        wage.deleteWage(2);
        wage.deleteWage(1);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillHouseNumber(0), 1,
                "Error message 'need to fill house number' disappear on a first panel after all other panels deleted");

    }

    protected void needFillTikNikuimErrorMessage() {
        log.info("Add a few wages, play with 'need to fill tik nikuim' error message");

        String correctTikNikuim = "123456789";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        wage.chooseIsraelIncome(0);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTikNikuim(0), 1,
                "Error message 'need to fill tik nikuim' did not appear on a first panel after Israel income was chosen");

        wage.addWage();
        wage.chooseIsraelIncome(1);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTikNikuim(1), 1,
                "Error message 'need to fill tik nikuim' did not appear on a second panel after Israel income was chosen");

        wage.enterTikNikuim(1, correctTikNikuim);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTikNikuim(1), 0,
                "Error message 'need to fill tik nikuim' did not disappear on a second panel after a tik nikuim was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTikNikuim(0), 1,
                "Error message 'need to fill tik nikuim' disappear on a first panel after a tik nikuim was entered on a second panel");

        wage.addWage();
        wage.chooseAbroadIncome(2);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTikNikuim(2), 0,
                "Error message 'need to fill tik nikuim' appear on a third panel after Abroad Income was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTikNikuim(1), 0,
                "Error message 'need to fill tik nikuim' re-appear on a second panel after new panel added");

        wage.deleteWage(2);
        wage.deleteWage(1);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTikNikuim(0), 1,
                "Error message 'need to fill tik nikuim' disappear on a first panel after all other panels deleted");

    }

    protected void needFillCountryErrorMessage() {
        log.info("Add a few wages, play with 'need to fill country' error message");

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        wage.chooseAbroadIncome(0);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillCountry(0), 1,
                "Error message 'need to fill country' did not appear on a first panel after Abroad income was chosen");

        wage.addWage();
        wage.chooseAbroadIncome(1);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillCountry(1), 1,
                "Error message 'need to fill country' did not appear on a second panel after Abroad income was chosen");

        wage.selectCountryFromDropDownListByIndex(1, 0);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillCountry(1), 0,
                "Error message 'need to fill country' did not disappear on a second panel after a country was selected");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillCountry(0), 1,
                "Error message 'need to fill country' disappear on a first panel after a country was selected on a second panel");

        wage.addWage();
        wage.chooseIsraelIncome(2);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillCountry(2), 0,
                "Error message 'need to fill country' appear on a third panel after Israel Income was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillCountry(1), 0,
                "Error message 'need to fill country' re-appear on a second panel after new panel added");

        wage.deleteWage(2);
        wage.deleteWage(1);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillCountry(0), 1,
                "Error message 'need to fill country' disappear on a first panel after all other panels deleted");

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

    private void selectCityAndStreet(Integer panelIndex, Integer elementIndex) {
        Wage wage = new Wage(driver);
        wage.selectCityFromDropDownListByIndex(panelIndex, elementIndex);
        wage.selectStreetFromDropDownListByIndex(panelIndex, elementIndex);
    }

}

