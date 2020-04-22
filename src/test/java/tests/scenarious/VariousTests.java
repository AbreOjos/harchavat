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

        various.deleteNonWorkIncomesYearlyIncome(0);
        various.enterNonWorkIncomesYearlyIncome(0, incomeAnnual);

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
}
