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

        String error = "Need Fill Income Type";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        addTwoNonWorkIncomes(various);

        needChooseErrorMessage(
                various::getNeedFillIncomeTypeErrorMessage,
                basePage::clickMenuVarious,
                various::chooseNonWorkIncomesIncomeIsraeli,
                various::deleteNonWorkIncomes,
                error);
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
                this::selectCityAndStreetNonWorkIncomes,
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

        String error = "Need Choose Coin Type";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoins(various);

        needChooseErrorMessage(
                various::getNeedFillCoinTypeErrorMessage,
                basePage::clickMenuVarious,
                various::chooseDigitalCoinsBitcoin,
                various::deleteDigitalCoins,
                error);
    }

    protected void needFillAnotherCoinErrorMessageDigitalCoins() {

        String firstAnotherCoin = "First Another Coin";
        String thirdAnotherCoin = "Third Another Coin";
        String error = "Another Coin";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoinsAnotherCoin(various);

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

        String error = "Did You Sell Coins";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoins(various);

        needChooseErrorMessage(
                various::getNeedFillDidYouSellCoinsErrorMessage,
                basePage::clickMenuVarious,
                various::chooseDigitalCoinsCoinsDontMaterialized,
                various::deleteDigitalCoins,
                error);
    }

    protected void needFillAmountCoinsSoldErrorMessageDigitalCoins() {

        String firstAmountCoinsSell = "123";
        String thirdAmountCoinsSell = "456";
        String error = "How Many Coins Sold";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoinsMaterialized(various);

        needFillErrorMessage(
                various::getNeedFillHowManyCoinsSoldErrorMessage,
                basePage::clickMenuVarious,
                various::enterDigitalCoinsAmountMaterialized,
                various::deleteDigitalCoins,
                firstAmountCoinsSell, thirdAmountCoinsSell, error);
    }

    protected void needFillTotalSalesErrorMessageDigitalCoins() {

        String firstTotalSales = "123";
        String thirdTotalSales = "456";
        String error = "Total Sales";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoinsMaterialized(various);

        needFillErrorMessage(
                various::getNeedFillTotalSalesErrorMessage,
                basePage::clickMenuVarious,
                various::enterDigitalCoinsMaterializationValue,
                various::deleteDigitalCoins,
                firstTotalSales, thirdTotalSales, error);
    }

    protected void needFillDidYouBuyWithCoinsErrorMessageDigitalCoins() {

        String error = "Did You Buy With Coins";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoins(various);

        needChooseErrorMessage(
                various::getNeedFillDidYouBuyWithCoinsErrorMessage,
                basePage::clickMenuVarious,
                various::chooseDigitalCoinsPurchasedWithCoins,
                various::deleteDigitalCoins,
                error);
    }

    protected void needFillHowManyCoinsUsedErrorMessageDigitalCoins() {

        String firstHowManyCoinsUsed = "123";
        String thirdHowManyCoinsUsed = "456";
        String error = "How Many Coins Used";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoinsPurchasedWith(various);

        needFillErrorMessage(
                various::getNeedFillHowManyCoinsUsedErrorMessage,
                basePage::clickMenuVarious,
                various::enterDigitalCoinsAmountUsed,
                various::deleteDigitalCoins,
                firstHowManyCoinsUsed, thirdHowManyCoinsUsed, error);
    }

    protected void needFillTotalUsedValueErrorMessageDigitalCoins() {

        String firstTotalUsedValue = "123";
        String thirdTotalUsedValue = "456";
        String error = "Total Used Value";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        addTwoDigitalCoinsPurchasedWith(various);

        needFillErrorMessage(
                various::getNeedFillTotalUsedValueErrorMessage,
                basePage::clickMenuVarious,
                various::enterDigitalCoinsUsedValue,
                various::deleteDigitalCoins,
                firstTotalUsedValue, thirdTotalUsedValue, error);
    }

    protected void numberOfCoinsFieldFormat() {
        log.info("Check that Number of Coins field accept numeric value only");

        String nonNumericValue = "abc";
        String tooManyDigitsAfterDecimalPoint = "123.4567";
        String tooLongValue = "1234567890123456789012345678901";
        String correctIntegerValue = "1234567890";
        String correctFloatPointValue = "123.456";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();

        various.enterDigitalCoinsCoinAmount(0, nonNumericValue);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNumberOfCoinsDigitsOnlyErrorMessage(0), 1,
                String.format("Error message 'Number of Coins must be numeric' did not appear when incorrect value %s was entered", nonNumericValue));

        various.deleteDigitalCoinsCoinAmount(0);
        various.enterDigitalCoinsCoinAmount(0, tooManyDigitsAfterDecimalPoint);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNumberOfCoinsDigitsOnlyErrorMessage(0), 1,
                String.format("Error message 'Number of Coins must be numeric' did not appear when incorrect value %s was entered", tooManyDigitsAfterDecimalPoint));

        various.deleteDigitalCoinsCoinAmount(0);
        various.enterDigitalCoinsCoinAmount(0, tooLongValue);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNumberOfCoinsThirtyCharsMaxErrorMessage(0), 1,
                String.format("Error message 'Number of Coins value must be 30 chars max' did not appear when incorrect value %s was entered", tooLongValue));

        various.deleteDigitalCoinsCoinAmount(0);
        various.enterDigitalCoinsCoinAmount(0, correctIntegerValue);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNumberOfCoinsDigitsOnlyErrorMessage(0), 0,
                String.format("Error message 'Number of Coins must be numeric' did not disappear when correct value %s was entered", correctIntegerValue));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNumberOfCoinsThirtyCharsMaxErrorMessage(0), 0,
                String.format("Error message 'Number of Coins value must be 30 chars max' did not disappear when correct value %s was entered", correctIntegerValue));

        various.deleteDigitalCoinsCoinAmount(0);
        various.enterDigitalCoinsCoinAmount(0, correctFloatPointValue);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNumberOfCoinsDigitsOnlyErrorMessage(0), 0,
                String.format("Error message 'Number of Coins must be numeric' did not disappear when correct value %s was entered", correctFloatPointValue));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNumberOfCoinsThirtyCharsMaxErrorMessage(0), 0,
                String.format("Error message 'Number of Coins value must be 30 chars max' did not disappear when correct value %s was entered", correctFloatPointValue));
    }

    protected void publicKeyFormat() {
        log.info("Check that Public Key field accept digits and letters only");

        String incorrectPublicKey = "1=d";
        String correctPublicKey = "123abc";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();

        various.enterDigitalCoinsPublicKey(0, incorrectPublicKey);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getPublicKeyDigitsAndLettersOnlyErrorMessage(0), 1,
                String.format("Error message 'Public Key accept digits and letters only' did not appear when incorrect value %s was entered", incorrectPublicKey));

        various.deleteDigitalCoinsPublicKey(0);
        various.enterDigitalCoinsPublicKey(0, correctPublicKey);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getPublicKeyDigitsAndLettersOnlyErrorMessage(0), 0,
                String.format("Error message 'Public Key accept digits and letters only' did not disappear when incorrect value %s was entered", correctPublicKey));
    }

    protected void coinsSellFormat() {
        log.info("Check that Coins Sell field accept digits only");

        String correctCoinsSell = "123";
        String incorrectCoinsSell = "abc";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        various.chooseDigitalCoinsCoinsMaterialized(0);

        various.enterDigitalCoinsAmountMaterialized(0, incorrectCoinsSell);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCoinsSellDigitsOnlyErrorMessage(0), 1,
                String.format("Error message 'Coins Sell field accept digits and letters only' did not appear when incorrect value %s was entered", incorrectCoinsSell));

        various.deleteDigitalCoinsAmountMaterialized(0);
        various.enterDigitalCoinsAmountMaterialized(0, correctCoinsSell);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCoinsSellDigitsOnlyErrorMessage(0), 0,
                String.format("Error message 'Coins Sell field accept digits and letters only' did not disappear when correct value %s was entered", correctCoinsSell));
    }

    protected void totalSellFormat() {
        log.info("Check that Total Sell field accept 20 chars max");

        String correctTotalSell = "123456789012345";
        String incorrectTotalSell = "1234567890123456";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        various.chooseDigitalCoinsCoinsMaterialized(0);

        various.enterDigitalCoinsMaterializationValue(0, incorrectTotalSell);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getTotalSalesTwentyCharsMaxErrorMessage(0), 1,
                String.format("Error message 'Total Sell field accept 20 chars max' did not appear when incorrect value %s was entered", incorrectTotalSell));

        various.deleteDigitalCoinsMaterializationValue(0);
        various.enterDigitalCoinsMaterializationValue(0, correctTotalSell);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getTotalSalesTwentyCharsMaxErrorMessage(0), 0,
                String.format("Error message 'Total Sell field accept 20 chars max' did not disappear when correct value %s was entered", correctTotalSell));
    }

    protected void howManyCoinsUsedFieldFormat() {
        log.info("Check that How Many Coins used field accept correct values");

        String nonNumericValue = "abc";
        String tooManyDigitsAfterDecimalPoint = "123.4567";
        String tooLongValue = "1234567890123456789012345678901";
        String correctIntegerValue = "1234567890";
        String correctFloatPointValue = "123.456";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        various.chooseDigitalCoinsPurchasedWithCoins(0);

        various.enterDigitalCoinsAmountUsed(0, nonNumericValue);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getHowManyCoinsUsedDigitsOnlyErrorMessage(0), 1,
                String.format("Error message 'How Many Coins used field accept correct values only' did not appear when incorrect value %s was entered", nonNumericValue));

        various.deleteDigitalCoinsAmountUsed(0);
        various.enterDigitalCoinsAmountUsed(0, tooManyDigitsAfterDecimalPoint);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getHowManyCoinsUsedDigitsOnlyErrorMessage(0), 1,
                String.format("Error message 'How Many Coins used field accept correct values' did not appear when incorrect value %s was entered", tooManyDigitsAfterDecimalPoint));

        various.deleteDigitalCoinsAmountUsed(0);
        various.enterDigitalCoinsAmountUsed(0, tooLongValue);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getHowManyCoinsUsedThirtyCharsMaxErrorMessage(0), 1,
                String.format("Error message 'How Many Coins value must be 30 chars max' did not appear when incorrect value %s was entered", tooLongValue));

        various.deleteDigitalCoinsAmountUsed(0);
        various.enterDigitalCoinsAmountUsed(0, correctIntegerValue);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getHowManyCoinsUsedDigitsOnlyErrorMessage(0), 0,
                String.format("Error message 'How Many Coins used field accept correct values' did not disappear when correct value %s was entered", correctIntegerValue));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getHowManyCoinsUsedThirtyCharsMaxErrorMessage(0), 0,
                String.format("Error message 'Number of Coins value must be 30 chars max' did not disappear when correct value %s was entered", correctIntegerValue));

        various.deleteDigitalCoinsAmountUsed(0);
        various.enterDigitalCoinsAmountUsed(0, correctFloatPointValue);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getHowManyCoinsUsedDigitsOnlyErrorMessage(0), 0,
                String.format("Error message 'How Many Coins used field accept correct values' did not disappear when correct value %s was entered", correctFloatPointValue));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getHowManyCoinsUsedThirtyCharsMaxErrorMessage(0), 0,
                String.format("Error message 'Number of Coins value must be 30 chars max' did not disappear when correct value %s was entered", correctFloatPointValue));
    }

    protected void totalUsedFormat() {
        log.info("Check that Total Used field accept 20 chars max");

        String correctTotalUsed = "123456789012345";
        String incorrectTotalUsed = "1234567890123456";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveDigitalCoins();
        various.chooseDigitalCoinsPurchasedWithCoins(0);

        various.enterDigitalCoinsUsedValue(0, incorrectTotalUsed);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getTotalUsedTwentyCharsMaxErrorMessage(0), 1,
                String.format("Error message 'Total Used field accept 20 chars max' did not appear when incorrect value %s was entered", incorrectTotalUsed));

        various.deleteDigitalCoinsUsedValue(0);
        various.enterDigitalCoinsUsedValue(0, correctTotalUsed);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getTotalUsedTwentyCharsMaxErrorMessage(0), 0,
                String.format("Error message 'Total Used field accept 20 chars max' did not disappear when correct value %s was entered", correctTotalUsed));
    }


    // Stocks tests
    protected void needFillCompanyNameErrorMessageStocks() {

        String firstCompanyName = "First Company Name";
        String thirdCompanyName = "Third Company Name";
        String error = "Company Name";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveStocks();
        addTwoStocks(various);

        needFillErrorMessage(
                various::getNeedFillCompanyNameErrorMessageStocks,
                basePage::clickMenuVarious,
                various::enterStocksCompanyName,
                various::deleteStocks,
                firstCompanyName, thirdCompanyName, error);
    }

    protected void needFillCompanySourceErrorMessageStocks() {

        String error = "Company Source";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveStocks();
        addTwoStocks(various);

        needChooseErrorMessage(
                various::getNeedFillCompanySourceErrorMessageStocks,
                basePage::clickMenuVarious,
                various::chooseStocksCompanySourceIsrael,
                various::deleteStocks,
                error);
    }

    protected void needFillCompanyNumErrorMessageStocks() {

        String firstCompanyNum = "123456789";
        String thirdCompanyNum = "987654321";
        String error = "Company Number";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveStocks();
        addTwoStocksIsraeli(various);

        needFillErrorMessage(
                various::getNeedFillCompanyNumErrorMessageStocks,
                basePage::clickMenuVarious,
                various::enterStocksCompanyNum,
                various::deleteStocks,
                firstCompanyNum, thirdCompanyNum, error);
    }

    protected void needFillCompanyPercentageErrorMessageStocks() {

        String firstCompanyPercentage = "12";
        String thirdCompanyPercentage = "98";
        String error = "Company Percentage";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveStocks();
        addTwoStocksIsraeli(various);

        needFillErrorMessage(
                various::getNeedFillCompanyPercentageErrorMessageStocks,
                basePage::clickMenuVarious,
                various::enterStocksCompanyPercentage,
                various::deleteStocks,
                firstCompanyPercentage, thirdCompanyPercentage, error);
    }

    protected void needFillCountryErrorMessageStocks() {

        Integer firstIndex = 0;
        Integer thirdIndex = 0;
        String error = "Country";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveStocks();
        addTwoStocksOversea(various);

        needFillErrorMessage(
                various::getNeedFillCountryErrorMessageStocks,
                basePage::clickMenuVarious,
                various::selectCountryStocksFromDropDownListByIndex,
                various::deleteStocks,
                firstIndex, thirdIndex, error);
    }

    protected void forbiddenCharactersCompanyNameStocks(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Company Name field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveStocks();

        various.enterStocksCompanyName(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyNameContainsCharactersErrorMessageStocks(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Company Name", forbiddenChar));
    }

    protected void forbiddenCharactersCompanyNumStocks(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Company Name field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHaveStocks();
        various.chooseStocksCompanySourceOversea(0);

        various.enterStocksCompanyNum(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyNumContainsCharactersErrorMessageStocks(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Company Num", forbiddenChar));
    }

    protected void percentageFieldFormat() {
        log.info("Check allowed format of the field Percentage");

        String tooBigPercentage = "101";
        String tooSmalPercentage = "0";
        String correctPercentage = "100";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveStocks();
        various.chooseStocksCompanySourceIsrael(0);

        various.enterStocksCompanyPercentage(0, tooBigPercentage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyPercentageOneHundredMaxErrorMessageStocks(0), 1,
                String.format("Error message '100 percents max' did not appear when the incorrect value %s were entered", tooBigPercentage));

        various.deleteStocksCompanyPercentage(0);
        various.enterStocksCompanyPercentage(0, tooSmalPercentage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyPercentageOneMinErrorMessageStocks(0), 1,
                String.format("Error message '1 percents min' did not appear when the incorrect value %s were entered", tooSmalPercentage));

        various.deleteStocksCompanyPercentage(0);
        various.enterStocksCompanyPercentage(0, correctPercentage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyPercentageOneHundredMaxErrorMessageStocks(0), 0,
                String.format("Error message '100 percents max' appeared when the incorrect value %s were entered", correctPercentage));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyPercentageOneMinErrorMessageStocks(0), 0,
                String.format("Error message '1 percents min' appeared when the incorrect value %s were entered", correctPercentage));
    }

    protected void companyNumberFormat() {
        log.info("Check allowed format of the field Company Number");

        String nonDigitValue = "asdfghjkl";
        String tooShortNumber = "12345678";
        String tooLongNumber = "1234567890";
        String correctNumber = "123456789";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveStocks();
        various.chooseStocksCompanySourceIsrael(0);

        various.enterStocksCompanyNum(0, nonDigitValue);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyNumDigitsOnlyErrorMessageStocks(0), 1,
                String.format("Error message 'Company Number digits only' did not appear when the incorrect value %s were entered", nonDigitValue));

        various.deleteStocksCompanyNum(0);
        various.enterStocksCompanyNum(0, tooShortNumber);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyNumNineDigitsMinErrorMessageStocks(0), 1,
                String.format("Error message 'Company Number 9 digits min' did not appear when the incorrect value %s were entered", tooShortNumber));

        various.deleteStocksCompanyNum(0);
        various.enterStocksCompanyNum(0, tooLongNumber);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyNumNineDigitsMaxErrorMessageStocks(0), 1,
                String.format("Error message 'Company Number 9 digits max' did not appear when the incorrect value %s were entered", tooLongNumber));

        various.deleteStocksCompanyNum(0);
        various.enterStocksCompanyNum(0, correctNumber);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyNumDigitsOnlyErrorMessageStocks(0), 0,
                String.format("Error message 'Company Number digits only' appeared when the correct value %s were entered", correctNumber));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyNumNineDigitsMinErrorMessageStocks(0), 0,
                String.format("Error message 'Company Number 9 digits min' appeared when the correct value %s were entered", correctNumber));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getCompanyNumNineDigitsMaxErrorMessageStocks(0), 0,
                String.format("Error message 'Company Number 9 digits max' appeared when the correct value %s were entered", correctNumber));

    }


    // Partnership tests
    protected void needFillNameErrorMessagePartnership() {

        String firstName = "First Name";
        String thirdName = "Third Name";
        String error = "Name";

        Various various = basePage.clickMenuVarious();
        various.chooseHavePartnerships();
        addTwoPartnership(various);

        needFillErrorMessage(
                various::getNeedFillNameErrorMessagePartnership,
                basePage::clickMenuVarious,
                various::enterPartnershipName,
                various::deletePartnerships,
                firstName, thirdName, error);
    }

    protected void needFillPartnershipLocationErrorMessagePartnership() {

        String error = "Partnership Location";

        Various various = basePage.clickMenuVarious();
        various.chooseHavePartnerships();
        addTwoPartnershipIsraeli(various);

        needChooseErrorMessage(
                various::getNeedFillPartnershipLocationErrorMessagePartnership,
                basePage::clickMenuVarious,
                various::choosePartnershipLocationIsrael,
                various::deletePartnerships,
                error);
    }

    protected void needFillBusinessNumErrorMessagePartnership() {

        String firstBusinessNum = "123456789";
        String thirdBusinessNum = "987654321";
        String error = "Business Number";

        Various various = basePage.clickMenuVarious();
        various.chooseHavePartnerships();
        addTwoPartnershipIsraeli(various);

        needFillErrorMessage(
                various::getNeedFillBusinessNumErrorMessagePartnership,
                basePage::clickMenuVarious,
                various::enterPartnershipBusinessNum,
                various::deletePartnerships,
                firstBusinessNum, thirdBusinessNum, error);
    }

    protected void needFillPercentageErrorMessagePartnership() {

        String firstPercentage = "100";
        String thirdPercentage = "50";
        String error = "Percentage";

        Various various = basePage.clickMenuVarious();
        various.chooseHavePartnerships();
        addTwoPartnershipIsraeli(various);

        needFillErrorMessage(
                various::getNeedFillPercentageErrorMessagePartnership,
                basePage::clickMenuVarious,
                various::enterPartnershipPercentage,
                various::deletePartnerships,
                firstPercentage, thirdPercentage, error);
    }

    protected void needFillCountryErrorMessagePartnership() {

        Integer firstIndex = 0;
        Integer thirdIndex = 0;
        String error = "Country";

        Various various = basePage.clickMenuVarious();
        various.chooseHavePartnerships();
        addTwoPartnershipOversea(various);

        needFillErrorMessage(
                various::getNeedFillCountryErrorMessagePartnership,
                basePage::clickMenuVarious,
                various::selectCountryPartnershipsFromDropDownListByIndex,
                various::deletePartnerships,
                firstIndex, thirdIndex, error);
    }

    protected void businessNumberFormatPartnership() {
        log.info("Check allowed format of the field Business Number");

        String nonDigitValue = "asdfghjkl";
        String tooShortNumber = "12345678";
        String tooLongNumber = "1234567890";
        String correctNumber = "123456789";

        Various various = basePage.clickMenuVarious();
        various.chooseHavePartnerships();
        addTwoPartnershipIsraeli(various);

        various.enterPartnershipBusinessNum(0, nonDigitValue);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBusinessNumDigitsOnlyErrorMessagePartnership(0), 1,
                String.format("Error message 'Business Number digits only' did not appear when the incorrect value %s were entered", nonDigitValue));


        various.deletePartnershipBusinessNum(0);
        various.enterPartnershipBusinessNum(0, tooShortNumber);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBusinessNumNineDigitsMinErrorMessagePartnership(0), 1,
                String.format("Error message 'Business Number Nine digits min' did not appear when the incorrect value %s were entered", nonDigitValue));

        various.deletePartnershipBusinessNum(0);
        various.enterPartnershipBusinessNum(0, tooLongNumber);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBusinessNumNineDigitsMaxErrorMessagePartnership(0), 1,
                String.format("Error message 'Business Number Nine digits max' did not appear when the incorrect value %s were entered", nonDigitValue));

        various.deletePartnershipBusinessNum(0);
        various.enterPartnershipBusinessNum(0, correctNumber);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBusinessNumDigitsOnlyErrorMessagePartnership(0), 0,
                String.format("Error message 'Business Number digits only' did not disappear when the correct value %s were entered", correctNumber));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBusinessNumNineDigitsMinErrorMessagePartnership(0), 0,
                String.format("Error message 'Business Number Nine digits min' did not disappear when the correct value %s were entered", correctNumber));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBusinessNumNineDigitsMaxErrorMessagePartnership(0), 0,
                String.format("Error message 'Business Number digits only' did not disappear when the correct value %s were entered", correctNumber));

    }

    protected void percentageFormatPartnership() {
        log.info("Check allowed format of the field Percentage");

        String nonDigitPercent = "abc";
        String tooSmallPercent = "0";
        String tooBigPercent = "101";
        String tooLongPercent = "1234";
        String correctPercent = "100";

        Various various = basePage.clickMenuVarious();
        various.chooseHavePartnerships();
        addTwoPartnershipIsraeli(various);

        various.enterPartnershipPercentage(0, nonDigitPercent);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getPercentageOneHundredMaxErrorMessagePartnership(0), 1,
                String.format("Error message 'Percentage One Hundred max' did not appear when the incorrect value %s were entered", nonDigitPercent));

        various.deletePartnershipPercentage(0);
        various.enterPartnershipPercentage(0, tooSmallPercent);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getPercentageOneMinErrorMessagePartnership(0), 1,
                String.format("Error message 'Percentage One min' did not appear when the incorrect value %s were entered", tooSmallPercent));

        various.deletePartnershipPercentage(0);
        various.enterPartnershipPercentage(0, tooBigPercent);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getPercentageOneHundredMaxErrorMessagePartnership(0), 1,
                String.format("Error message 'Percentage Hundred max' did not appear when the incorrect value %s were entered", tooBigPercent));

        various.deletePartnershipPercentage(0);
        various.enterPartnershipPercentage(0, tooLongPercent);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getPercentageThreeCharsMaxErrorMessagePartnership(0), 1,
                String.format("Error message 'Percentage Three Chars max' did not appear when the incorrect value %s were entered", tooLongPercent));

        various.deletePartnershipPercentage(0);
        various.enterPartnershipPercentage(0, correctPercent);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getPercentageOneHundredMaxErrorMessagePartnership(0), 0,
                String.format("Error message 'Percentage One Hundred max' did not disappear when the correct value %s were entered", correctPercent));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getPercentageOneMinErrorMessagePartnership(0), 0,
                String.format("Error message 'Percentage One min' did not disappear when the correct value %s were entered", correctPercent));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getPercentageThreeCharsMaxErrorMessagePartnership(0), 0,
                String.format("Error message 'Percentage Three Chars max' did not disappear when the correct value %s were entered", correctPercent));
    }

    protected void forbiddenCharactersNamePartnership(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Name field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHavePartnerships();
        various.choosePartnershipLocationIsrael(0);

        various.enterPartnershipName(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNameContainsCharactersErrorMessagePartnership(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Name", forbiddenChar));
    }

    protected void forbiddenCharactersStatePartnership(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a State field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHavePartnerships();
        various.choosePartnershipLocationOversea(0);

        various.enterPartnershipsState(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getStateContainsCharactersErrorMessagePartnership(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into State", forbiddenChar));
    }

    protected void forbiddenCharactersBusinessNumberPartnership(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Business Number field, find the error message", forbiddenChar));

        Various various = basePage.clickMenuVarious();
        various.chooseHavePartnerships();
        various.choosePartnershipLocationOversea(0);

        various.enterPartnershipBusinessNum(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getBusinessNumContainsCharactersErrorMessagePartnership(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into Business Number", forbiddenChar));
    }


    // == private methods ==
    private void addTwoPartnership(Various various) {
        various.addPartnerships();
        various.addPartnerships();
    }

    private void addTwoPartnershipIsraeli(Various various) {
        various.addPartnerships();
        various.addPartnerships();
        various.choosePartnershipLocationIsrael(0);
        various.choosePartnershipLocationIsrael(1);
        various.choosePartnershipLocationIsrael(2);
    }

    private void addTwoPartnershipOversea(Various various) {
        various.addPartnerships();
        various.addPartnerships();
        various.choosePartnershipLocationOversea(0);
        various.choosePartnershipLocationOversea(1);
        various.choosePartnershipLocationOversea(2);
    }

    private void addTwoStocks(Various various) {
        various.addStocks();
        various.addStocks();
    }

    private void addTwoStocksIsraeli(Various various) {
        various.addStocks();
        various.addStocks();
        various.chooseStocksCompanySourceIsrael(0);
        various.chooseStocksCompanySourceIsrael(1);
        various.chooseStocksCompanySourceIsrael(2);
    }

    private void addTwoStocksOversea(Various various) {
        various.addStocks();
        various.addStocks();
        various.chooseStocksCompanySourceOversea(0);
        various.chooseStocksCompanySourceOversea(1);
        various.chooseStocksCompanySourceOversea(2);
    }

    private void addTwoDigitalCoins(Various various) {
        various.addDigitalCoins();
        various.addDigitalCoins();
    }

    private void addTwoDigitalCoinsPurchasedWith(Various various) {
        various.addDigitalCoins();
        various.addDigitalCoins();
        various.chooseDigitalCoinsPurchasedWithCoins(0);
        various.chooseDigitalCoinsPurchasedWithCoins(1);
        various.chooseDigitalCoinsPurchasedWithCoins(2);
    }

    private void addTwoDigitalCoinsMaterialized(Various various) {
        various.addDigitalCoins();
        various.addDigitalCoins();
        various.chooseDigitalCoinsCoinsMaterialized(0);
        various.chooseDigitalCoinsCoinsMaterialized(1);
        various.chooseDigitalCoinsCoinsMaterialized(2);
    }

    private void addTwoDigitalCoinsAnotherCoin(Various various) {
        various.addDigitalCoins();
        various.addDigitalCoins();
        various.chooseDigitalCoinsAnotherCoin(0);
        various.chooseDigitalCoinsAnotherCoin(1);
        various.chooseDigitalCoinsAnotherCoin(2);
    }

    private void addTwoAbroadBankAccounts(Various various) {
        various.addAbroadBankAccounts();
        various.addAbroadBankAccounts();
    }

    private void addTwoNonWorkIncomes(Various various) {
        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
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

    private void selectCityAndStreetNonWorkIncomes(Integer panelIndex, Integer elementIndex) {
        Various various = new Various(driver);
        various.selectCityNonWorkIncomesFromDropDownListByIndex(panelIndex, elementIndex);
        various.selectStreetNonWorkIncomesFromDropDownListByIndex(panelIndex, elementIndex);
    }

}
