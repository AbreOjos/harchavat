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
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        if (!various.nonWorkIncomeIsraeliChosen(0) && !various.nonWorkIncomeOverseaChosen(0)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(0), 1,
                    "Error message 'Need to Fill Type of Income' did not appear on a first panel");
        }

        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        if (!various.nonWorkIncomeIsraeliChosen(1) && !various.nonWorkIncomeOverseaChosen(1)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(1), 1,
                    "Error message 'Need to Fill Type of Income' did not appear on a second panel");
        }

        if (!various.nonWorkIncomeIsraeliChosen(2) && !various.nonWorkIncomeOverseaChosen(2)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(2), 1,
                    "Error message 'Need to Fill Type of Income' did not appear on a third panel");
        }

        various.chooseNonWorkIncomesIncomeIsraeli(0);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Type of Income' did not disappear on a first panel after income type was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(1), 1,
                "Error message 'Need to Fill Type of Income' disappeared on a second panel after income type was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(2), 1,
                "Error message 'Need to Fill Type of Income' disappeared on a third panel after income type was chosen on a first panel");

        various.chooseNonWorkIncomesIncomeOversea(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Type of Income' re-appeared on a first panel after income type was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(1), 1,
                "Error message 'Need to Fill Type of Income' disappeared on a second panel after income type was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(2), 0,
                "Error message 'Need to Fill Type of Income' did not disappear on a third panel after income type was chosen");

        various.deleteNonWorkIncomes(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Type of Income' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(1), 1,
                "Error message 'Need to Fill Type of Income' disappeared on a second panel after a third panel was deleted");

        various.deleteNonWorkIncomes(1);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeTypeErrorMessage(0), 0,
                "Error message 'Need to Fill Type of Income' re-appeared on a first panel after a last panel was deleted");
    }

    protected void needFillIncomeSourceErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'need to fill income source'");

        String firstIncomeSource = "First Income Source";
        String thirdIncomeSource = "Third Income Source";


        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(0), 1,
                "Error message 'Need to Fill Income Source' did not appear on a first panel");

        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(1), 1,
                "Error message 'Need to Fill Income Source' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(2), 1,
                "Error message 'Need to Fill Income Source' did not appear on a third panel");

        various.enterNonWorkIncomesIncomeSource(0, firstIncomeSource);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(0), 0,
                "Error message 'Need to Fill Income Source' did not disappear on a first panel after Income Source was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(1), 1,
                "Error message 'Need to Fill Income Source' disappeared on a second panel after Income Source was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(2), 1,
                "Error message 'Need to Fill Income Source' disappeared on a third panel after Income Source was entered on a first panel");

        various.enterNonWorkIncomesIncomeSource(2, thirdIncomeSource);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(0), 0,
                "Error message 'Need to Fill Income Source' re-appeared on a first panel after Income Source was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(1), 1,
                "Error message 'Need to Fill Income Source' disappeared on a second panel after Income Source was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(2), 0,
                "Error message 'Need to Fill Income Source' dud not disappear on a third panel after Income Source was entered");

        various.deleteNonWorkIncomes(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(0), 0,
                "Error message 'Need to Fill Income Source' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(1), 1,
                "Error message 'Need to Fill Income Source' disappeared on a second panel after a third panel was deleted");

        various.deleteNonWorkIncomes(1);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillIncomeSourceErrorMessage(0), 0,
                "Error message 'Need to Fill Income Source' re-appeared on a first panel after a last panel was deleted");
    }

    protected void needFillAnnualIncomeErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'need to fill annual income'");

        String firstAnnualIncome = "123";
        String thirdAnnualIncome = "456";


        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(0), 1,
                "Error message 'Need to Fill Annual Income' did not appear on a first panel");

        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);
        various.chooseNonWorkIncomesIncomeIsraeli(1);
        various.chooseNonWorkIncomesIncomeIsraeli(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(1), 1,
                "Error message 'Need to Fill Annual Income' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(2), 1,
                "Error message 'Need to Fill Annual Income' did not appear on a third panel");

        various.enterNonWorkIncomesAnnualIncome(0, firstAnnualIncome);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(0), 0,
                "Error message 'Need to Fill Annual Income' did not disappear on a first panel after Annual Income was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(1), 1,
                "Error message 'Need to Fill Annual Income' disappeared on a second panel after Annual Income was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(2), 1,
                "Error message 'Need to Fill Annual Income' disappeared on a third panel after Annual Income was entered on a first panel");

        various.enterNonWorkIncomesAnnualIncome(2, thirdAnnualIncome);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(0), 0,
                "Error message 'Need to Fill Annual Income' re-appeared on a first panel after Annual Income was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(1), 1,
                "Error message 'Need to Fill Annual Income' disappeared on a second panel after Annual Income was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(2), 0,
                "Error message 'Need to Fill Annual Income' dud not disappear on a third panel after Annual Income was entered");

        various.deleteNonWorkIncomes(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(0), 0,
                "Error message 'Need to Fill Annual Income' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(1), 1,
                "Error message 'Need to Fill Annual Income' disappeared on a second panel after a third panel was deleted");

        various.deleteNonWorkIncomes(1);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillAnnualIncomeErrorMessage(0), 0,
                "Error message 'Need to Fill Annual Income' re-appeared on a first panel after a last panel was deleted");
    }

    protected void needFillPayerNameErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'need to fill payer name'");

        String firstPayerName = "first payer name";
        String thirdPayerName = "third payer name";


        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(0), 1,
                "Error message 'Need to Fill payer name' did not appear on a first panel");

        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(1);
        various.chooseNonWorkIncomesIncomeIsraeli(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(1), 1,
                "Error message 'Need to Fill payer name' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(2), 1,
                "Error message 'Need to Fill payer name' did not appear on a third panel");

        various.enterNonWorkIncomesPayerName(0, firstPayerName);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(0), 0,
                "Error message 'Need to Fill payer name' did not disappear on a first panel after payer name was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(1), 1,
                "Error message 'Need to Fill payer name' disappeared on a second panel after payer name was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(2), 1,
                "Error message 'Need to Fill payer name' disappeared on a third panel after payer name was entered on a first panel");

        various.enterNonWorkIncomesPayerName(2, thirdPayerName);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(0), 0,
                "Error message 'Need to Fill payer name' re-appeared on a first panel after payer name was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(1), 1,
                "Error message 'Need to Fill payer name' disappeared on a second panel after payer name was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(2), 0,
                "Error message 'Need to Fill payer name' dud not disappear on a third panel after payer name was entered");

        various.deleteNonWorkIncomes(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(0), 0,
                "Error message 'Need to Fill payer name' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(1), 1,
                "Error message 'Need to Fill payer name' disappeared on a second panel after a third panel was deleted");

        various.deleteNonWorkIncomes(1);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillPayerNameErrorMessage(0), 0,
                "Error message 'Need to Fill payer name' re-appeared on a first panel after a last panel was deleted");
    }

    protected void needFillTikNikiumErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'need to fill tik nikuim'");

        String firstTikNikium = "123";
        String thirdTikNikium = "456";


        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(0), 1,
                "Error message 'Need to Fill tik nikuim' did not appear on a first panel");

        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(1);
        various.chooseNonWorkIncomesIncomeIsraeli(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(1), 1,
                "Error message 'Need to Fill tik nikuim' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(2), 1,
                "Error message 'Need to Fill tik nikuim' did not appear on a third panel");

        various.enterNonWorkIncomesTikNikuim(0, firstTikNikium);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(0), 0,
                "Error message 'Need to Fill tik nikuim' did not disappear on a first panel after tik nikuim was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(1), 1,
                "Error message 'Need to Fill tik nikuim' disappeared on a second panel after tik nikuim was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(2), 1,
                "Error message 'Need to Fill tik nikuim' disappeared on a third panel after tik nikuim was entered on a first panel");

        various.enterNonWorkIncomesTikNikuim(2, thirdTikNikium);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(0), 0,
                "Error message 'Need to Fill tik nikuim' re-appeared on a first panel after tik nikuim was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(1), 1,
                "Error message 'Need to Fill tik nikuim' disappeared on a second panel after tik nikuim was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(2), 0,
                "Error message 'Need to Fill tik nikuim' dud not disappear on a third panel after tik nikuim was entered");

        various.deleteNonWorkIncomes(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(0), 0,
                "Error message 'Need to Fill tik nikuim' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(1), 1,
                "Error message 'Need to Fill tik nikuim' disappeared on a second panel after a third panel was deleted");

        various.deleteNonWorkIncomes(1);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillITikNikuimErrorMessage(0), 0,
                "Error message 'Need to Fill tik nikuim' re-appeared on a first panel after a last panel was deleted");
    }

    protected void needFillCityErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'need to fill city'");

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(0), 1,
                "Error message 'Need to Fill City' did not appear on a first panel");

        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(1);
        various.chooseNonWorkIncomesIncomeIsraeli(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(1), 1,
                "Error message 'Need to Fill City' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(2), 1,
                "Error message 'Need to Fill City' did not appear on a third panel");

        various.selectCityNonWorkIncomesFromDropDownListByIndex(0, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(0), 0,
                "Error message 'Need to Fill City' did not disappear on a first panel after City was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(1), 1,
                "Error message 'Need to Fill City' disappeared on a second panel after City was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(2), 1,
                "Error message 'Need to Fill City' disappeared on a third panel after City was chosen on a first panel");

        various.selectCityNonWorkIncomesFromDropDownListByIndex(2, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(0), 0,
                "Error message 'Need to Fill City' re-appeared on a first panel after city was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(1), 1,
                "Error message 'Need to Fill City' disappeared on a second panel after city was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(2), 0,
                "Error message 'Need to Fill City' dud not disappear on a third panel after city was chosen");

        various.deleteNonWorkIncomes(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(0), 0,
                "Error message 'Need to Fill City' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(1), 1,
                "Error message 'Need to Fill City' disappeared on a second panel after a third panel was deleted");

        various.deleteNonWorkIncomes(1);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageNonWorkIncome(0), 0,
                "Error message 'Need to Fill City' re-appeared on a first panel after a last panel was deleted");
    }

    protected void needFillStreetErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'need to fill street'");

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(0), 1,
                "Error message 'Need to Fill street' did not appear on a first panel");

        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(1);
        various.chooseNonWorkIncomesIncomeIsraeli(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(1), 1,
                "Error message 'Need to Fill street' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(2), 1,
                "Error message 'Need to Fill street' did not appear on a third panel");

        various.selectCityNonWorkIncomesFromDropDownListByIndex(0, 0);
        various.selectStreetNonWorkIncomesFromDropDownListByIndex(0, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(0), 0,
                "Error message 'Need to Fill street' did not disappear on a first panel after street was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(1), 1,
                "Error message 'Need to Fill street' disappeared on a second panel after street was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(2), 1,
                "Error message 'Need to Fill street' disappeared on a third panel after street was chosen on a first panel");

        various.selectCityNonWorkIncomesFromDropDownListByIndex(2, 0);
        various.selectStreetNonWorkIncomesFromDropDownListByIndex(2, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(0), 0,
                "Error message 'Need to Fill street' re-appeared on a first panel after street was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(1), 1,
                "Error message 'Need to Fill street' disappeared on a second panel after street was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(2), 0,
                "Error message 'Need to Fill street' dud not disappear on a third panel after street was chosen");

        various.deleteNonWorkIncomes(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(0), 0,
                "Error message 'Need to Fill street' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(1), 1,
                "Error message 'Need to Fill street' disappeared on a second panel after a third panel was deleted");

        various.deleteNonWorkIncomes(1);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillStreetErrorMessage(0), 0,
                "Error message 'Need to Fill street' re-appeared on a first panel after a last panel was deleted");
    }

    protected void needFillHouseNumErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'need to fill house num'");

        String firstHouseNum = "123";
        String thirdHouseNum = "456";


        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(0);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(0), 1,
                "Error message 'Need to Fill house num' did not appear on a first panel");

        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeIsraeli(1);
        various.chooseNonWorkIncomesIncomeIsraeli(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(1), 1,
                "Error message 'Need to Fill house num' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(2), 1,
                "Error message 'Need to Fill house num' did not appear on a third panel");

        various.enterNonWorkIncomesHouseNum(0, firstHouseNum);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(0), 0,
                "Error message 'Need to Fill house num' did not disappear on a first panel after house num was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(1), 1,
                "Error message 'Need to Fill house num' disappeared on a second panel after house num was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(2), 1,
                "Error message 'Need to Fill house num' disappeared on a third panel after house num was entered on a first panel");

        various.enterNonWorkIncomesHouseNum(2, thirdHouseNum);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(0), 0,
                "Error message 'Need to Fill house num' re-appeared on a first panel after house num was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(1), 1,
                "Error message 'Need to Fill house num' disappeared on a second panel after house numm was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(2), 0,
                "Error message 'Need to Fill house num' dud not disappear on a third panel after house num was entered");

        various.deleteNonWorkIncomes(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(0), 0,
                "Error message 'Need to Fill house num' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(1), 1,
                "Error message 'Need to Fill house num' disappeared on a second panel after a third panel was deleted");

        various.deleteNonWorkIncomes(1);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillHouseNumErrorMessage(0), 0,
                "Error message 'Need to Fill house num' re-appeared on a first panel after a last panel was deleted");
    }

    protected void needFillCountryErrorMessageNonWorkIncomes() {
        log.info("Check the error message 'need to fill country'");

        Various various = basePage.clickMenuVarious();
        various.chooseHaveNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeOversea(0);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(0), 1,
                "Error message 'Need to Fill Country' did not appear on a first panel");

        various.addNonWorkIncomes();
        various.addNonWorkIncomes();
        various.chooseNonWorkIncomesIncomeOversea(1);
        various.chooseNonWorkIncomesIncomeOversea(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(1), 1,
                "Error message 'Need to Fill Country' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(2), 1,
                "Error message 'Need to Fill Country' did not appear on a third panel");

        various.selectCountryNonWorkIncomesFromDropDownListByIndex(0, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(0), 0,
                "Error message 'Need to Fill Country' did not disappear on a first panel after Country was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(1), 1,
                "Error message 'Need to Fill Country' disappeared on a second panel after Country was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(2), 1,
                "Error message 'Need to Fill Country' disappeared on a third panel after Country was chosen on a first panel");

        various.selectCountryNonWorkIncomesFromDropDownListByIndex(2, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(0), 0,
                "Error message 'Need to Fill Country' re-appeared on a first panel after Country was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(1), 1,
                "Error message 'Need to Fill Country' disappeared on a second panel after Country was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(2), 0,
                "Error message 'Need to Fill Country' dud not disappear on a third panel after Country was chosen");

        various.deleteNonWorkIncomes(2);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(0), 0,
                "Error message 'Need to Fill Country' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(1), 1,
                "Error message 'Need to Fill Country' disappeared on a second panel after a third panel was deleted");

        various.deleteNonWorkIncomes(1);
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageNonWorkIncomes(0), 0,
                "Error message 'Need to Fill Country' re-appeared on a first panel after a last panel was deleted");
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
        log.info("Check the error message 'need to fill country'");

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(0), 1,
                "Error message 'Need to Fill Country' did not appear on a first panel");

        various.addAbroadBankAccounts();
        various.addAbroadBankAccounts();
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(1), 1,
                "Error message 'Need to Fill Country' did not appear on a second panel");


        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(2), 1,
                "Error message 'Need to Fill Country' did not appear on a third panel");


        various.selectCountryAbroadBankAccountsFromDropDownListByIndex(0, 0);
//        basePage.clickMenuRealEstate();
//        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(0), 0,
                "Error message 'Need to Fill Country' did not disappear on a first panel after Country was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(1), 1,
                "Error message 'Need to Fill Country' disappeared on a second panel after Country was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(2), 1,
                "Error message 'Need to Fill Country' disappeared on a third panel after Country was chosen on a first panel");

        various.selectCountryAbroadBankAccountsFromDropDownListByIndex(2, 0);
//        basePage.clickMenuRealEstate();
//        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(0), 0,
                "Error message 'Need to Fill Country' re-appeared on a first panel after Country was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(1), 1,
                "Error message 'Need to Fill Country' disappeared on a second panel after Country was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(2), 0,
                "Error message 'Need to Fill Country' did not disappear on a third panel after Country was chosen");

        various.deleteAbroadBankAccounts(2);
//        basePage.clickMenuRealEstate();
//        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(0), 0,
                "Error message 'Need to Fill Country' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(1), 1,
                "Error message 'Need to Fill Country' disappeared on a second panel after a third panel was deleted");

        various.deleteAbroadBankAccounts(1);
//        basePage.clickMenuRealEstate();
//        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCountryErrorMessageAbroadBankAccounts(0), 0,
                "Error message 'Need to Fill Country' re-appeared on a first panel after a last panel was deleted");
    }

    protected void needFillCityErrorMessageAbroadBankAccount() {
        log.info("Check the error message 'need to fill city'");

        String firstCity = "First City";
        String thirdCity = "Third City";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(0), 1,
                "Error message 'Need to Fill City' did not appear on a first panel");

        various.addAbroadBankAccounts();
        various.addAbroadBankAccounts();
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(1), 1,
                "Error message 'Need to Fill City' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(2), 1,
                "Error message 'Need to Fill City' did not appear on a third panel");


        various.enterAbroadBankAccountsCity(0, firstCity);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(0), 0,
                "Error message 'Need to Fill City' did not disappear on a first panel after City was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(1), 1,
                "Error message 'Need to Fill City' disappeared on a second panel after City was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(2), 1,
                "Error message 'Need to Fill City' disappeared on a third panel after City was entered on a first panel");


        various.enterAbroadBankAccountsCity(2, thirdCity);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(0), 0,
                "Error message 'Need to Fill City' re-appeared on a first panel after City was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(1), 1,
                "Error message 'Need to Fill City' disappeared on a second panel after City was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(2), 0,
                "Error message 'Need to Fill City' did not disappear on a third panel after City was entered");

        various.deleteAbroadBankAccounts(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(0), 0,
                "Error message 'Need to Fill City' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(1), 1,
                "Error message 'Need to Fill City' disappeared on a second panel after a third panel was deleted");

        various.deleteAbroadBankAccounts(1);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillCityErrorMessageAbroadBankAccounts(0), 0,
                "Error message 'Need to Fill City' re-appeared on a first panel after a last panel was deleted");
    }

    protected void needFillBankNameErrorMessageAbroadBankAccount() {
        log.info("Check the error message 'need to fill bank name'");

        String firstBankName = "First Bank Name";
        String thirdBankName = "Third Bank Name";

        Various various = basePage.clickMenuVarious();
        various.chooseHaveAbroadBankAccounts();
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(0), 1,
                "Error message 'Need to Fill Bank Name' did not appear on a first panel");

        various.addAbroadBankAccounts();
        various.addAbroadBankAccounts();
        basePage.clickMenuRealEstate();
        various = basePage.clickMenuVarious();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(1), 1,
                "Error message 'Need to Fill Bank Name' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(2), 1,
                "Error message 'Need to Fill Bank Name' did not appear on a third panel");


        various.enterAbroadBankAccountsBankName(0, firstBankName);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(0), 0,
                "Error message 'Need to Fill Bank Name' did not disappear on a first panel after Bank Name was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(1), 1,
                "Error message 'Need to Fill Bank Name' disappeared on a second panel after Bank Name was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(2), 1,
                "Error message 'Need to Fill Bank Name' disappeared on a third panel after Bank Name was entered on a first panel");


        various.enterAbroadBankAccountsBankName(2, thirdBankName);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(0), 0,
                "Error message 'Need to Fill Bank Name' re-appeared on a first panel after Bank Name was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(1), 1,
                "Error message 'Need to Fill Bank Name' disappeared on a second panel after Bank Name was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(2), 0,
                "Error message 'Need to Fill Bank Name' did not disappear on a third panel after Bank Name was entered");

        various.deleteAbroadBankAccounts(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(0), 0,
                "Error message 'Need to Fill Bank Name' re-appeared on a first panel after a third panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(1), 1,
                "Error message 'Need to Fill Bank Name' disappeared on a second panel after a third panel was deleted");

        various.deleteAbroadBankAccounts(1);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(various.getNeedFillBankNameErrorMessage(0), 0,
                "Error message 'Need to Fill Bank Name' re-appeared on a first panel after a last panel was deleted");
    }
}
