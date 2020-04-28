package tests.scenarious;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import pom.forms.various.Various;
import tests.TestBase;

public class VariousTests extends TestBase {
    private static final Logger log = Logger.getLogger(VariousTests.class);

    protected void checkMenuIcons() {
        log.info("Check that Various menu has icons: error, checked, without icon");

        String incomeSource = "Income Source";
        String incomeAnnual = "123";
        String payerName = "Payer Name";
        String tikNikuim = "415121";
        String houseNum = "10a";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        basePage.clickMenuWage();
        various = basePage.clickMenuVarious();

        // check error icon
        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getErrorIconMenu(), 1,
                "An error icon menu did not appears when there are empty mandatory fields");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCheckCircleIconMenu(), 0,
                "A check-circle icon menu did not disappears when there are empty mandatory fields");

        // fill data
        various.chooseNonWorkIncomesIncomeIsraeli(0);

        various.deleteNonWorkIncomesIncomeSource(0);
        various.enterNonWorkIncomesIncomeSource(0, incomeSource);

        various.deleteNonWorkIncomesAnnualIncome(0);
        various.enterNonWorkIncomesAnnualIncome(0, incomeAnnual);

        various.deleteNonWorkIncomesPayerName(0);
        various.enterNonWorkIncomesPayerName(0, payerName);

        various.deleteNonWorkIncomesTikNikuim(0);
        various.enterNonWorkIncomesTikNikuim(0, tikNikuim);

        various.selectCityNonWorkIncomesFromDropDownListByIndex(0, 0);
        various.selectStreetNonWorkIncomesFromDropDownListByIndex(0, 0);

        various.deleteNonWorkIncomesHouseNum(0);
        various.enterNonWorkIncomesHouseNum(0, houseNum);

        basePage.clickMenuWage();
        various = basePage.clickMenuVarious();

        // check OK icon
        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getErrorIconMenu(), 0,
                "An error icon menu did not disappeared when there are not empty mandatory fields");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCheckCircleIconMenu(), 1,
                "A check-circle icon menu did not appears when there are not empty mandatory fields");

        various.chooseDontHaveNonWorkIncomes();
        basePage.clickMenuWage();
        various = basePage.clickMenuVarious();

        // check icons
        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getErrorIconMenu(), 0,
                "An error icon menu did not disappeared when there are no Various details");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCheckCircleIconMenu(), 0,
                "A check-circle icon menu did not disappeared when there are no Various details");
    }


    // non work incomes tests
    protected void needFillTypeIncomeErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'need to fill income type'");

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        basePage.clickMenuSendForm();
        various = basePage.clickMenuVarious();

        if (!various.nonWorkIncomeIsraeliChosen(0) && !various.nonWorkIncomeOverseaChosen(0)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(0), 1,
                    "Error message 'Need to Fill Type of Income' did not appear on a first panel");
        }

        if (!various.nonWorkIncomeIsraeliChosen(1) && !various.nonWorkIncomeOverseaChosen(1)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(1), 1,
                    "Error message 'Need to Fill Type of Income' did not appear on a second panel");
        }

        if (!various.nonWorkIncomeIsraeliChosen(2) && !various.nonWorkIncomeOverseaChosen(2)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(2), 1,
                    "Error message 'Need to Fill Type of Income' did not appear on a third panel");
        }

        various.chooseNonWorkIncomesIncomeIsraeli(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Type of Income' did not disappear on a first panel after income type was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(1), 1,
                "Error message 'Need to Fill Type of Income' disappeared on a second panel after income type was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(2), 1,
                "Error message 'Need to Fill Type of Income' disappeared on a third panel after income type was chosen on a first panel");

        various.chooseNonWorkIncomesIncomeOversea(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Type of Income' re-appeared on a first panel after income type was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(1), 1,
                "Error message 'Need to Fill Type of Income' disappeared on a second panel after income type was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(2), 0,
                "Error message 'Need to Fill Type of Income' did not disappear on a third panel after income type was chosen");

        various.deleteNonWorkIncomes(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Type of Income' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(1), 1,
                "Error message 'Need to Fill Type of Income' disappeared on a second panel after a third panel was deleted");

        various.deleteNonWorkIncomes(1);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Type of Income' re-appeared on a first panel after a last panel was deleted");
    }

    protected void needFillIncomeSourceErrorMessageNonWorkIncomes() {

        String firstIncomeSource = "First Income Source";
        String thirdIncomeSource = "Third Income Source";
        String error = "Income Source";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        addTwoNonWorkIncomesIsraeli(various);

        needFillErrorMessage(various::getNeedFillIncomeSourceErrorMessage,
                basePage::clickMenuVarious,
                various::enterNonWorkIncomesIncomeSource,
                various::deleteNonWorkIncomes,
                firstIncomeSource, thirdIncomeSource, error);
    }

    protected void needFillAnnualIncomeErrorMessageNonWorkIncomes() {

        String firstAnnualIncome = "123";
        String thirdAnnualIncome = "456";
        String error = "Annual Income";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        addTwoNonWorkIncomesIsraeli(various);

        needFillErrorMessage(various::getNeedFillAnnualIncomeErrorMessage,
                basePage::clickMenuVarious,
                various::enterNonWorkIncomesAnnualIncome,
                various::deleteNonWorkIncomes,
                firstAnnualIncome, thirdAnnualIncome, error);
    }

    protected void needFillPayerNameErrorMessageNonWorkIncomes() {

        String firstPayerName = "first payer name";
        String thirdPayerName = "third payer name";
        String error = "Payer Name";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        addTwoNonWorkIncomesIsraeli(various);

        needFillErrorMessage(various::getNeedFillPayerNameErrorMessage,
                basePage::clickMenuVarious,
                various::enterNonWorkIncomesPayerName,
                various::deleteNonWorkIncomes,
                firstPayerName, thirdPayerName, error);
    }

    protected void needFillTikNikiumErrorMessageNonWorkIncomes() {

        String firstTikNikium = "123";
        String thirdTikNikium = "456";
        String error = "Tik Nikuim";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        addTwoNonWorkIncomesIsraeli(various);

        needFillErrorMessage(various::getNeedFillITikNikuimErrorMessage,
                basePage::clickMenuVarious,
                various::enterNonWorkIncomesTikNikuim,
                various::deleteNonWorkIncomes,
                firstTikNikium, thirdTikNikium, error);
    }

    protected void needFillCityErrorMessageNonWorkIncomes() {

        Integer firstIndex = 0;
        Integer thirdIndex = 0;
        String error = "City";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        addTwoNonWorkIncomesIsraeli(various);

        needFillErrorMessage(various::getNeedFillCityErrorMessageNonWorkIncome,
                basePage::clickMenuVarious,
                various::selectCityNonWorkIncomesFromDropDownListByIndex,
                various::deleteNonWorkIncomes,
                firstIndex, thirdIndex, error);
    }

    protected void needFillStreetErrorMessageNonWorkIncomes() {

        Integer firstIndex = 0;
        Integer thirdIndex = 0;
        String error = "Street";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        addTwoNonWorkIncomesIsraeli(various);

        needFillErrorMessage(various::getNeedFillStreetErrorMessage,
                basePage::clickMenuVarious,
                this::selectCityAndStreet,
                various::deleteNonWorkIncomes,
                firstIndex, thirdIndex, error);
    }

    protected void needFillHouseNumErrorMessageNonWorkIncomes() {

        String firstHouseNum = "123";
        String thirdHouseNum = "456";
        String error = "House Num";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        addTwoNonWorkIncomesIsraeli(various);

        needFillErrorMessage(various::getNeedFillHouseNumErrorMessage,
                basePage::clickMenuVarious,
                various::enterNonWorkIncomesHouseNum,
                various::deleteNonWorkIncomes,
                firstHouseNum, thirdHouseNum, error);
    }

    protected void needFillCountryErrorMessageNonWorkIncomes() {

        Integer firstIndex = 0;
        Integer thirdIndex = 0;
        String error = "Country";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        addTwoNonWorkIncomesOversea(various);

        needFillErrorMessage(various::getNeedFillCountryErrorMessageNonWorkIncomes,
                basePage::clickMenuVarious,
                various::selectCountryNonWorkIncomesFromDropDownListByIndex,
                various::deleteNonWorkIncomes,
                firstIndex, thirdIndex, error);
    }

    protected void annualIncomeTwentyCharsMaxErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'Annual Income Twenty Chars Max'");

        String tooLongAnnualIncome = "1234567890123456";
        String correctAnnualIncome = "123456789012345";


        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);

        various.enterNonWorkIncomesAnnualIncome(0, tooLongAnnualIncome);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getAnnualIncomeTwentyCharsMaxErrorMessage(0), 1,
                String.format("Error message 'Annual Income Twenty Chars Max' did not appear when the incorrect value %s was entered", tooLongAnnualIncome));

        various.deleteNonWorkIncomesAnnualIncome(0);
        various.enterNonWorkIncomesAnnualIncome(0, correctAnnualIncome);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getAnnualIncomeTwentyCharsMaxErrorMessage(0), 0,
                String.format("Error message 'Annual Income Twenty Chars Max' did not disappear when the correct value %s was entered", correctAnnualIncome));
    }

    protected void cityFifteenCharsMaxErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'City Fifteen Chars Max'");

        String tooLongCityName = "Very Looong Name";
        String correctCityName = "City";


        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeOversea(0);

        various.enterNonWorkIncomesCity(0, tooLongCityName);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCityFifteenCharsMaxErrorMessage(0), 1,
                String.format("Error message 'CityFifteenCharsMax' did not appear when the incorrect value %s was entered", tooLongCityName));

        various.deleteNonWorkIncomesCity(0);
        various.enterNonWorkIncomesCity(0, correctCityName);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCityFifteenCharsMaxErrorMessage(0), 0,
                String.format("Error message 'CityFifteenCharsMax' did not disappear when the correct value %s was entered", correctCityName));
    }

    protected void streetFifteenCharsMaxErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'Street Fifteen Chars Max'");

        String tooLongStreetName = "Too Loooong Name";
        String correctStreetName = "Street";


        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeOversea(0);

        various.enterNonWorkIncomesStreet(0, tooLongStreetName);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getStreetFifteenCharsMaxErrorMessage(0), 1,
                String.format("Error message 'StreetFifteenCharsMax' did not appear when the incorrect value %s was entered", tooLongStreetName));

        various.deleteNonWorkIncomesStreet(0);
        various.enterNonWorkIncomesStreet(0, correctStreetName);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getStreetFifteenCharsMaxErrorMessage(0), 0,
                String.format("Error message 'StreetFifteenCharsMax' did not disappear when the correct value %s was entered", correctStreetName));
    }

    protected void tikNikuimContainsDigitsOnlyErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'Tik Nikuim contains digits only'");

        String incorrectTikNikuim = "abc";
        String correctTikNikuim = "123";


        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);

        various.enterNonWorkIncomesTikNikuim(0, incorrectTikNikuim);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getTikNikuimCanContainDigitsOnlyErrorMessage(0), 1,
                String.format("Error message 'Tik Nikuim contains digits only' did not appear when the incorrect value %s was entered", incorrectTikNikuim));

        various.deleteNonWorkIncomesTikNikuim(0);
        various.enterNonWorkIncomesTikNikuim(0, correctTikNikuim);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getTikNikuimCanContainDigitsOnlyErrorMessage(0), 0,
                String.format("Error message 'Tik Nikuim contains digits only' did not disappear when the correct value %s was entered", correctTikNikuim));
    }

    protected void forbiddenCharactersIncomeSourceNonWorkIncomes(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Income Source field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);

        various.enterNonWorkIncomesIncomeSource(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getIncomeSourceContainsCharactersErrorMessage(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Income Source", forbiddenChar));
    }

    protected void forbiddenCharactersPayerNameNonWorkIncomes(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Payer Name field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);

        various.enterNonWorkIncomesPayerName(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getPayerNameContainsCharactersErrorMessage(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Payer Name", forbiddenChar));
    }

    protected void forbiddenCharactersHouseNumNonWorkIncomes(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a House Num field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);

        various.enterNonWorkIncomesHouseNum(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getHouseNumContainsCharactersErrorMessage(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into House Num", forbiddenChar));
    }

    protected void forbiddenCharactersStateNonWorkIncomes(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a State field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeOversea(0);

        various.enterNonWorkIncomesState(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getStateContainsCharactersErrorMessageNonWorkIncomes(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into State", forbiddenChar));
    }

    protected void forbiddenCharactersCityNonWorkIncomes(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a City field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeOversea(0);

        various.enterNonWorkIncomesCity(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCityContainsCharactersErrorMessagenonWorkIncomes(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into City", forbiddenChar));
    }

    protected void forbiddenCharactersStreetNonWorkIncomes(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Street field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeOversea(0);

        various.enterNonWorkIncomesStreet(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getStreetContainsCharactersErrorMessage(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Street", forbiddenChar));
    }


    // Abroad Bank Account tests
    protected void needFillCountryErrorMessageAbroadBankAccount() {

        Integer firstIndex = 0;
        Integer thirdIndex = 0;
        String error = "Country";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();
        addTwoAbroadBankAccounts(various);

        needFillErrorMessage(various::getNeedFillCountryErrorMessageAbroadBankAccounts,
                basePage::clickMenuVarious,
                various::selectCountryAbroadBankAccountsFromDropDownListByIndex,
                various::deleteAbroadBankAccounts,
                firstIndex, thirdIndex, error);
    }

    protected void needFillCityErrorMessageAbroadBankAccount() {

        String firstCity = "First City";
        String thirdCity = "Third City";
        String error = "City";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();
        addTwoAbroadBankAccounts(various);

        needFillErrorMessage(various::getNeedFillCityErrorMessageAbroadBankAccounts,
                basePage::clickMenuVarious,
                various::enterAbroadBankAccountsCity,
                various::deleteAbroadBankAccounts,
                firstCity, thirdCity, error);
    }

    protected void needFillBankNameErrorMessageAbroadBankAccount() {

        String firstBankName = "First Bank Name";
        String thirdBankName = "Third Bank Name";
        String error = "Bank Name";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();
        addTwoAbroadBankAccounts(various);

        needFillErrorMessage(various::getNeedFillBankNameErrorMessage,
                basePage::clickMenuVarious,
                various::enterAbroadBankAccountsBankName,
                various::deleteAbroadBankAccounts,
                firstBankName, thirdBankName, error);
    }

    protected void needFillBankNumErrorMessageAbroadBankAccount() {

        String firstBankNum = "123";
        String thirdBankNum = "456";
        String error = "Branch Num";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();
        addTwoAbroadBankAccounts(various);

        needFillErrorMessage(various::getNeedFillBankNumErrorMessage,
                basePage::clickMenuVarious,
                various::enterAbroadBankAccountsBankNum,
                various::deleteAbroadBankAccounts,
                firstBankNum, thirdBankNum, error);
    }

    protected void needFillBranchNameErrorMessageAbroadBankAccount() {

        String firstBranchName = "First Branch Name";
        String thirdBranchName = "Third Branch Name";
        String error = "Branch Name";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();
        addTwoAbroadBankAccounts(various);

        needFillErrorMessage(various::getNeedFillBranchNameErrorMessage,
                basePage::clickMenuVarious,
                various::enterAbroadBankAccountsBranchName,
                various::deleteAbroadBankAccounts,
                firstBranchName, thirdBranchName, error);
    }

    protected void needFillBranchNumErrorMessageAbroadBankAccount() {

        String firstBranchNum = "123";
        String thirdBranchNum = "456";
        String error = "Account Num";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();
        addTwoAbroadBankAccounts(various);

        needFillErrorMessage(various::getNeedFillBranchNumErrorMessage,
                basePage::clickMenuVarious,
                various::enterAbroadBankAccountsBranchNum,
                various::deleteAbroadBankAccounts,
                firstBranchNum, thirdBranchNum, error);
    }

    protected void needFillAccountNumErrorMessageAbroadBankAccount() {

        String firstAccountNum = "123";
        String thirdAccountNum = "456";
        String error = "Account Num";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();
        addTwoAbroadBankAccounts(various);

        needFillErrorMessage(various::getNeedFillAccountNumErrorMessage,
                basePage::clickMenuVarious,
                various::enterAbroadBankAccountsAccountNum,
                various::deleteAbroadBankAccounts,
                firstAccountNum, thirdAccountNum, error);
    }

    protected void needFillNumOfPartnersErrorMessageAbroadBankAccount() {

        String firstNumOfPartners = "1";
        String thirdNumOfPartners = "10";
        String error = "Num of Partners";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();
        addTwoAbroadBankAccounts(various);

        needFillErrorMessage(
                various::getNeedFillNumPartnersInAccountErrorMessage,
                basePage::clickMenuVarious,
                various::enterAbroadBankAccountsPartnersNum,
                various::deleteAbroadBankAccounts,
                firstNumOfPartners, thirdNumOfPartners, error);
    }

    protected void forbiddenCharactersStateAbroadBankAccounts(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a State field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();

        various.enterAbroadBankAccountsState(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getStateContainsCharactersErrorMessageAbroadBankAccounts(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into State", forbiddenChar));
    }

    protected void forbiddenCharactersCityAbroadBankAccounts(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a City field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();

        various.enterAbroadBankAccountsCity(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCityContainsCharactersErrorMessageAbroadBankAccounts(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into City", forbiddenChar));
    }

    protected void forbiddenCharactersBankNameAbroadBankAccounts(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Bank Name field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();

        various.enterAbroadBankAccountsBankName(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBankNameContainsCharactersErrorMessage(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Bank Name", forbiddenChar));
    }

    protected void forbiddenCharactersBankNumAbroadBankAccounts(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Bank Num field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();

        various.enterAbroadBankAccountsBankNum(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBankNumContainsCharactersErrorMessage(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Bank Num", forbiddenChar));
    }

    protected void forbiddenCharactersBranchNameAbroadBankAccounts(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Branch Name field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();

        various.enterAbroadBankAccountsBranchName(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBranchNameContainsCharactersErrorMessage(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Branch Name", forbiddenChar));
    }

    protected void forbiddenCharactersBranchNumAbroadBankAccounts(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Branch Num field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();

        various.enterAbroadBankAccountsBranchNum(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBranchNumContainsCharactersErrorMessage(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Branch Num", forbiddenChar));
    }

    protected void forbiddenCharactersAccountNumAbroadBankAccounts(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Account Num field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();

        various.enterAbroadBankAccountsAccountNum(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getAccountNumContainsCharactersErrorMessage(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Account Num", forbiddenChar));
    }

    protected void partnersNumContainsDigitsOnlyErrorMessageAbroadBankAccounts() {
        log.info("Check the error message 'Number of Partners in Account contains digits only'");

        String incorrectNumPartnersInAccount = "abc";
        String correctNumPartnersInAccount = "123";


        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();

        various.enterAbroadBankAccountsPartnersNum(0, incorrectNumPartnersInAccount);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNumPartnersInAccountContainsDigitsOnlyErrorMessage(0), 1,
                String.format("Error message 'Number of Partners in Account contains digits only' did not appear when the incorrect value %s was entered", incorrectNumPartnersInAccount));

        various.deleteAbroadBankAccountsPartnersNum(0);
        various.enterAbroadBankAccountsPartnersNum(0, correctNumPartnersInAccount);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNumPartnersInAccountContainsDigitsOnlyErrorMessage(0), 0,
                String.format("Error message 'Number of Partners in Account contains digits only' did not disappear when the correct value %s was entered", correctNumPartnersInAccount));
    }

    protected void bankNumTenCharsMaxErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'Bank Num Ten Chars Max'");

        String tooLongBankNum = "12345678901";
        String correctBankNum = "1234567890";


        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();

        various.enterAbroadBankAccountsBankNum(0, tooLongBankNum);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBankNumTenCharsMaxErrorMessage(0), 1,
                String.format("Error message 'Bank Num Ten Chars Max' did not appear when the incorrect value %s was entered", tooLongBankNum));

        various.deleteAbroadBankAccountsBankNum(0);
        various.enterAbroadBankAccountsBankNum(0, correctBankNum);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBankNumTenCharsMaxErrorMessage(0), 0,
                String.format("Error message 'Bank Num Ten Chars Max' did not disappear when the correct value %s was entered", correctBankNum));
    }


    // Digital Coins tests
    protected void needFillCoinTypeErrorMessageDigitalCoins() {
        log.info("Check the error message 'need to fill coin type'");

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        various.addDigitalCoins();
        various.addDigitalCoins();
        basePage.clickMenuSendForm();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(0), 1,
                "Error message 'Need to Fill Coin Type' did not appear on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(1), 1,
                "Error message 'Need to Fill Coin Type' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(2), 1,
                "Error message 'Need to Fill Coin Type' did not appear on a third panel");

        various.chooseDigitalCoinsBitcoin(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Coin Type' did not disappear on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(1), 1,
                "Error message 'Need to Fill Coin Type' disappear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(2), 1,
                "Error message 'Need to Fill Coin Type' disappear on a third panel");

        various.chooseDigitalCoinsNano(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Coin Type' re-appeared on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(1), 1,
                "Error message 'Need to Fill Coin Type' disappeared on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(2), 0,
                "Error message 'Need to Fill Coin Type' did not disappear on a third panel");

        various.deleteDigitalCoins(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Coin Type' re-appeared on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(1), 1,
                "Error message 'Need to Fill Coin Type' disappeared on a second panel");

        various.deleteDigitalCoins(1);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCoinTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Coin Type' re-appeared on a first panel");
    }

    protected void needFillAnotherCoinErrorMessageDigitalCoins() {

        String firstAnotherCoin = "First Another Coin";
        String thirdAnotherCoin = "Third Another Coin";
        String error = "Another Coin";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoins(various);
        various.chooseDigitalCoinsAnotherCoin(0);
        various.chooseDigitalCoinsAnotherCoin(1);
        various.chooseDigitalCoinsAnotherCoin(2);

        needFillErrorMessage(
                various::getNeedFillAnotherCoinErrorMessage,
                basePage::clickMenuVarious,
                various::enterDigitalCoinsAnotherCoin,
                various::deleteDigitalCoins,
                firstAnotherCoin, thirdAnotherCoin, error);
    }

    protected void needFillAmountOfCoinsErrorMessageDigitalCoins() {

        String firstNumberOfCoins = "123";
        String thirdNumberOfCoins = "456";
        String error = "Amount of Coins";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoins(various);

        needFillErrorMessage(
                various::getNeedFillAmountOfCoinsErrorMessage,
                basePage::clickMenuVarious,
                various::enterDigitalCoinsCoinAmount,
                various::deleteDigitalCoins,
                firstNumberOfCoins, thirdNumberOfCoins, error);
    }

    protected void needFillPublicKeyErrorMessageDigitalCoins() {

        String firstPublicKey = "FirstPublicKey";
        String thirdPublickKey = "ThirdPublicKey";
        String error = "Public Key of Digital Wallet";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoins(various);

        needFillErrorMessage(
                various::getNeedFillPublicKeyDigitalWalletErrorMessage,
                basePage::clickMenuVarious,
                various::enterDigitalCoinsPublicKey,
                various::deleteDigitalCoins,
                firstPublicKey, thirdPublickKey, error);
    }

    protected void needFillDidYouSellCoinsErrorMessageDigitalCoins() {
        log.info("Check the error message 'need to fill did you sell coins field'");

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        various.addDigitalCoins();
        various.addDigitalCoins();
        basePage.clickMenuSendForm();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(0), 1,
                "Error message 'Need to Fill Did You Sell Coin' did not appear on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(1), 1,
                "Error message 'Need to Fill Did You Sell Coin' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(2), 1,
                "Error message 'Need to Fill Did You Sell Coin' did not appear on a third panel");

        various.chooseDigitalCoinsCoinsMaterialized(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(0), 0,
                "Error message 'Need to Fill Did You Sell Coin' did not disappear on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(1), 1,
                "Error message 'Need to Fill Did You Sell Coin' disappear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(2), 1,
                "Error message 'Need to Fill Did You Sell Coin' disappear on a third panel");

        various.chooseDigitalCoinsCoinsDontMaterialized(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(0), 0,
                "Error message 'Need to Fill Did You Sell Coin' re-appeared on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(1), 1,
                "Error message 'Need to Fill Did You Sell Coin' disappeared on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(2), 0,
                "Error message 'Need to Fill Did You Sell Coin' did not disappear on a third panel");

        various.deleteDigitalCoins(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(0), 0,
                "Error message 'Need to Fill Did You Sell Coin' re-appeared on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(1), 1,
                "Error message 'Need to Fill Did You Sell Coin' disappeared on a second panel");

        various.deleteDigitalCoins(1);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillDidYouSellCoinsErrorMessage(0), 0,
                "Error message 'Need to Fill Did You Sell Coin' re-appeared on a first panel");
    }

    protected void needFillAmountCoinsSoldErrorMessageDigitalCoins() {

        String firstAmountCoinsSell = "123";
        String thirdAmountCoinsSell = "456";
        String error = "How Many Coins Sold";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoins(various);
        various.chooseDigitalCoinsCoinsMaterialized(0);
        various.chooseDigitalCoinsCoinsMaterialized(1);
        various.chooseDigitalCoinsCoinsMaterialized(2);

        needFillErrorMessage(
                various::getNeedFillHowManyCoinsSoldErrorMessage,
                basePage::clickMenuVarious,
                various::enterDigitalCoinsAmountMaterialized,
                various::deleteDigitalCoins,
                firstAmountCoinsSell, thirdAmountCoinsSell, error);
    }




    // == private methods ==
    private void addTwoDigitalCoins(Various various) {
        various.addDigitalCoins();
        various.addDigitalCoins();
    }

    private void addTwoAbroadBankAccounts(Various various) {
        various.addAbroadBankAccounts();
        various.addAbroadBankAccounts();
    }

    private void addTwoNonWorkIncomesOversea(Various various) {
        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeOversea(0);
        various.chooseNonWorkIncomesIncomeOversea(1);
        various.chooseNonWorkIncomesIncomeOversea(2);
    }

    private void addTwoNonWorkIncomesIsraeli(Various various) {
        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);
        various.chooseNonWorkIncomesIncomeIsraeli(1);
        various.chooseNonWorkIncomesIncomeIsraeli(2);
    }

    private void selectCityAndStreet(Integer panelIndex, Integer elementIndex) {
        Various various = new Various(driver);
        various.selectCityNonWorkIncomesFromDropDownListByIndex(panelIndex, elementIndex);
        various.selectStreetNonWorkIncomesFromDropDownListByIndex(panelIndex, elementIndex);
    }

}
