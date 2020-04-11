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

}

