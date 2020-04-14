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

        if (!wage.israelIncomeChosen(0) && !wage.abroadIncomeChosen(0)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(0), 0,
                    "Error message 'Need to Fill Type of Income' did not disappear on a first panel after Israel Income chosen");
        }

        if (!wage.israelIncomeChosen(1) && !wage.abroadIncomeChosen(1)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(1), 1,
                    "Error message 'Need to Fill Type of Income' disappear on a second panel after income chosen on a first panel");
        }

        if (!wage.israelIncomeChosen(2) && !wage.abroadIncomeChosen(2)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(2), 1,
                    "Error message 'Need to Fill Type of Income' disappear on a third panel after income chosen on a first panel");
        }

        wage.chooseAbroadIncome(2);
        basePage.clickMenuRealEstate();
        wage = basePage.clickMenuWage();

        if (!wage.israelIncomeChosen(2) && !wage.abroadIncomeChosen(2)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(2), 0,
                    "Error message 'Need to Fill Type of Income' did not disappear on a third panel after Abroad Income chosen");
        }

        if (!wage.israelIncomeChosen(1) && !wage.abroadIncomeChosen(1)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(1), 1,
                    "Error message 'Need to Fill Type of Income' disappear on a second panel after income chosen on a third panel");
        }

        wage.deleteWage(2);
        basePage.clickMenuRealEstate();
        wage = basePage.clickMenuWage();

        if (!wage.israelIncomeChosen(1) && !wage.abroadIncomeChosen(1)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(1), 1,
                    "Error message 'Need to Fill Type of Income' disappear on a second panel after a third panel was deleted");
        }

        wage.deleteWage(1);
        basePage.clickMenuRealEstate();
        wage = basePage.clickMenuWage();

        if (!wage.israelIncomeChosen(0) && !wage.abroadIncomeChosen(0)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillTypeIncome(0), 0,
                    "Error message 'Need to Fill Type of Income' re-disappear on a first panel after second panel was deleted");
        }

    }

    protected void needFillAnnualIncomeErrorMessage() {
        log.info("Add a few wages, play with 'need to add annual income' error message");

        String income = "123";

        Wage wage = basePage.clickMenuWage();
        wage.chooseHaveWage();
        wage.chooseIsraelIncome(0);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillAnnualIncome(0), 1,
                "Error message 'need to fill annual income' did not appear on a first panel after Israel income was chosen");

        wage.addWage();
        wage.chooseAbroadIncome(1);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillAnnualIncome(1), 1,
                "Error message 'need to fill annual income' did not appear on a second panel after Abroad income was chosen");

        wage.enterAnnualIncome(1, income);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillAnnualIncome(1), 0,
                "Error message 'need to fill annual income' did not disappear on a second panel after Abroad income entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillAnnualIncome(0), 1,
                "Error message 'need to fill annual income' disappear on a first panel after income entered on a second panel");

        wage.addWage();

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillAnnualIncome(1), 0,
                "Error message 'need to fill annual income' re-appear on a second panel after new panel added");

        wage.deleteWage(2);
        wage.deleteWage(1);

        basePage.clickMenuVehicle();
        wage = basePage.clickMenuWage();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(wage.getErrorMessageNeedFillAnnualIncome(0), 1,
                "Error message 'need to fill annual income' disappear on a first panel after all other panels deleted");


    }



}

