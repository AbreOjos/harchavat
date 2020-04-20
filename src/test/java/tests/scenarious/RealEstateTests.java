package tests.scenarious;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pom.forms.realestates.RealEstate;
import tests.TestBase;

import static constants.EnglishHebrewConstants.*;

public class RealEstateTests extends TestBase {
    private static final Logger log = Logger.getLogger(RealEstateTests.class);

    protected void checkMenuIcons() throws Exception {
        log.info("Check that Real Estate menu has icons: error, checked, without icon");

        String realEstateSize = "67";
        String ownershipPercentage = "24";
        String gush = "500";
        String helka = "100";
        String tatHelka = "10";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        // check error icon
        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorIconMenu(), 1,
                "An error icon menu did not appears when there are empty mandatory fields");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getCheckCircleIconMenu(), 0,
                "A check-circle icon menu did not disappears when there are empty mandatory fields");


        realEstate.chooseRealEstateTypeApartment(0);
        realEstate.pickDayMonthYear(0, "12", MARCH, "2020");
        realEstate.enterRealEstatePropertyArea(0, realEstateSize);
        realEstate.enterRealEstateOwnershipPercentage(0, ownershipPercentage);
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateAssetGushHalka(0);
        realEstate.enterRealEstateBlock(0, gush);
        realEstate.enterRealEstatePlot(0, helka);
        realEstate.chooseRealEstatePersonalUsage(0);
        realEstate.chooseRealEstateNotSplit(0);

        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        // check check-circle icon
        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getCheckCircleIconMenu(), 1,
                "A check-circle icon menu did not appears when mandatory fields contain correct values");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorIconMenu(), 0,
                "An error icon menu did not disappears when mandatory fields contain correct values");

        realEstate.chooseDontHaveRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        // check icons disappeared
        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getCheckCircleIconMenu(), 0,
                "A check-circle icon menu appears when there are no vehicles");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorIconMenu(), 0,
                "An error icon menu appears when there are no vehicles");

    }

    protected void needFillRealEstateTypeErrorMessage() {
        log.info("Check the error message 'need to fill real estate type'");

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        if (realEstate.getChosenRealEstateType(0).equals(REAL_ESTATE_TYPE)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(0), 1,
                    "Error message 'Need to Fill Real Estate Type' did not appear on a first panel");
        }

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        if (realEstate.getChosenRealEstateType(1).equals(REAL_ESTATE_TYPE)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(1), 1,
                    "Error message 'Need to Fill Real Estate Type' did not appear on a second panel");
        }

        if (realEstate.getChosenRealEstateType(2).equals(REAL_ESTATE_TYPE)) {
            AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(2), 1,
                    "Error message 'Need to Fill Real Estate Type' did not appear on a third panel");
        }

        realEstate.chooseRealEstateTypeApartment(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(0), 0,
                "Error message 'Need to Fill Real Estate Type' did not disappear on a first panel after type was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(1), 1,
                "Error message 'Need to Fill Real Estate Type' disappear on a second panel after type was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(2), 1,
                "Error message 'Need to Fill Real Estate Type' disappear on a third panel after type was chosen on a first panel");


        realEstate.chooseRealEstateTypeParking(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(0), 0,
                "Error message 'Need to Fill Real Estate Type' re-appear on a first panel after type was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(1), 1,
                "Error message 'Need to Fill Real Estate Type' disappear on a second panel after type was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(2), 0,
                "Error message 'Need to Fill Real Estate Type' did not disappear on a third panel after type was chosen");


        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(0), 0,
                "Error message 'Need to Fill Real Estate Type' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(1), 0,
                "Error message 'Need to Fill Real Estate Type' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillRealEstateType(0), 0,
                "Error message 'Need to Fill Real Estate Type' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillDateErrorMessage() throws Exception {
        log.info("Check the error message 'need to fill date'");

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(0), 1,
                "Error message 'Need to Fill Date' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(1), 1,
                "Error message 'Need to Fill Date' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(2), 1,
                "Error message 'Need to Fill Date' did not appear on a third panel");

        realEstate.pickDayMonthYear(0, "12", MARCH, "2020");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(0), 0,
                "Error message 'Need to Fill Date' did not disappear on a first panel after date was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(1), 1,
                "Error message 'Need to Fill Date' disappear on a second panel after date was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(2), 1,
                "Error message 'Need to Fill Date' disappear on a third panel after date was chosen on a first panel");


        realEstate.pickDayMonthYear(2, "28", FEBRUARY, "2019");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(0), 0,
                "Error message 'Need to Fill Date' re-appear on a first panel after date was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(1), 1,
                "Error message 'Need to Fill Date' disappear on a second panel after date was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(2), 0,
                "Error message 'Need to Fill Date' did not disappear on a third panel after date was chosen");


        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(0), 0,
                "Error message 'Need to Fill Date' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(1), 0,
                "Error message 'Need to Fill Date' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillDate(0), 0,
                "Error message 'Need to Fill Date' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillPropertyAreaErrorMessage() {
        log.info("Check the error message 'need to fill property area'");

        String firstCorrectPropertyArea =  "123";
        String thirdCorrectPropertyArea =  "456";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(0), 1,
                "Error message 'Need to Fill property area' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(1), 1,
                "Error message 'Need to Fill property area' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(2), 1,
                "Error message 'Need to Fill property area' did not appear on a third panel");

        realEstate.enterRealEstatePropertyArea(0, firstCorrectPropertyArea);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(0), 0,
                "Error message 'Need to Fill property area' did not disappear on a first panel after property area was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(1), 1,
                "Error message 'Need to Fill property area' disappear on a second panel after property area was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(2), 1,
                "Error message 'Need to Fill property area' disappear on a third panel after property area was entered on a first panel");


        realEstate.enterRealEstatePropertyArea(2, thirdCorrectPropertyArea);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(0), 0,
                "Error message 'Need to Fill property area' re-appear on a first panel after property area was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(1), 1,
                "Error message 'Need to Fill property area' disappear on a second panel after property area was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(2), 0,
                "Error message 'Need to Fill property area' did not disappear on a third panel after property area was entered");


        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(0), 0,
                "Error message 'Need to Fill property area' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(1), 0,
                "Error message 'Need to Fill property area' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertyArea(0), 0,
                "Error message 'Need to Fill property area' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillOwnershipPercentageErrorMessage() {
        log.info("Check the error message 'need to fill ownership percentage'");

        String firstCorrectOwnershipPercentage =  "123";
        String thirdCorrectOwnershipPercentage = "456";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(0), 1,
                "Error message 'Need to Fill Ownership Percentage' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(1), 1,
                "Error message 'Need to Fill Ownership Percentage' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(2), 1,
                "Error message 'Need to Fill Ownership Percentage' did not appear on a third panel");

        realEstate.deleteRealEstateOwnershipPercentage(0);
        realEstate.enterRealEstateOwnershipPercentage(0, firstCorrectOwnershipPercentage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(0), 0,
                "Error message 'Need to Fill Ownership Percentage' did not disappear on a first panel after Ownership Percentage was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(1), 1,
                "Error message 'Need to Fill Ownership Percentage' disappear on a second panel after Ownership Percentage was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(2), 1,
                "Error message 'Need to Fill Ownership Percentage' disappear on a third panel after Ownership Percentage was entered on a first panel");

        realEstate.deleteRealEstateOwnershipPercentage(2);
        realEstate.enterRealEstateOwnershipPercentage(2, thirdCorrectOwnershipPercentage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(0), 0,
                "Error message 'Need to Fill Ownership Percentage' re-appear on a first panel after Ownership Percentage was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(1), 1,
                "Error message 'Need to Fill Ownership Percentage' disappear on a second panel after Ownership Percentage was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(2), 0,
                "Error message 'Need to Fill Ownership Percentage' did not disappear on a third panel after Ownership Percentage was entered");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(0), 0,
                "Error message 'Need to Fill Ownership Percentage' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(1), 0,
                "Error message 'Need to Fill Ownership Percentage' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillOwnershipPercentage(0), 0,
                "Error message 'Need to Fill Ownership Percentage' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillGushErrorMessage() {
        log.info("Check the error message 'need to fill Block (Gush)'");

        String firstCorrectBlock =  "123";
        String thirdCorrectBlock = "456";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateAssetGushHalka(0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(0), 1,
                "Error message 'Need to Fill Gush' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateInIsrael(1);
        realEstate.chooseRealEstateAssetGushHalka(1);
        realEstate.chooseRealEstateInIsrael(2);
        realEstate.chooseRealEstateAssetGushHalka(2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(1), 1,
                "Error message 'Need to Fill Gush' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(2), 1,
                "Error message 'Need to Fill Gush' did not appear on a third panel");

        realEstate.deleteRealEstateBlock(0);
        realEstate.enterRealEstateBlock(0, firstCorrectBlock);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(0), 0,
                "Error message 'Need to Fill Gush' did not disappear on a first panel after Gush was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(1), 1,
                "Error message 'Need to Fill Gush' disappear on a second panel after Gush was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(2), 1,
                "Error message 'Need to Fill Gush' disappear on a third panel after Gush was entered on a first panel");

        realEstate.deleteRealEstateBlock(2);
        realEstate.enterRealEstateBlock(2, thirdCorrectBlock);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(0), 0,
                "Error message 'Need to Fill Gush' re-appear on a first panel after Gush was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(1), 1,
                "Error message 'Need to Fill Gush' disappear on a second panel after Gush was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(2), 0,
                "Error message 'Need to Fill Gush' did not disappear on a third panel after Gush was entered");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(0), 0,
                "Error message 'Need to Fill Gush' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(1), 0,
                "Error message 'Need to Fill Gush' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillBlock(0), 0,
                "Error message 'Need to Fill Gush' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillHelkaErrorMessage() {
        log.info("Check the error message 'need to fill Plot (Helka)'");

        String firstCorrectPlot =  "123";
        String thirdCorrectPlot = "456";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateAssetGushHalka(0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(0), 1,
                "Error message 'Need to Fill Helka' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateInIsrael(1);
        realEstate.chooseRealEstateAssetGushHalka(1);
        realEstate.chooseRealEstateInIsrael(2);
        realEstate.chooseRealEstateAssetGushHalka(2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(1), 1,
                "Error message 'Need to Fill Helka' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(2), 1,
                "Error message 'Need to Fill Helka' did not appear on a third panel");

        realEstate.deleteRealEstatePlot(0);
        realEstate.enterRealEstatePlot(0, firstCorrectPlot);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(0), 0,
                "Error message 'Need to Fill Helka' did not disappear on a first panel after Helka was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(1), 1,
                "Error message 'Need to Fill Helka' disappear on a second panel after Helka was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(2), 1,
                "Error message 'Need to Fill Helka' disappear on a third panel after Helka was entered on a first panel");

        realEstate.deleteRealEstatePlot(2);
        realEstate.enterRealEstatePlot(2, thirdCorrectPlot);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(0), 0,
                "Error message 'Need to Fill Helka' re-appear on a first panel after Helka was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(1), 1,
                "Error message 'Need to Fill Helka' disappear on a second panel after Helka was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(2), 0,
                "Error message 'Need to Fill Helka' did not disappear on a third panel Helka Gush was entered");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(0), 0,
                "Error message 'Need to Fill Helka' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(1), 0,
                "Error message 'Need to Fill Helka' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPlot(0), 0,
                "Error message 'Need to Fill Helka' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillCityIsraeliErrorMessage() {
        log.info("Check the error message 'need to fill city' for Israel property");

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateAssetAddress(0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(0), 1,
                "Error message 'Need to Fill City' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateInIsrael(1);
        realEstate.chooseRealEstateAssetAddress(1);
        realEstate.chooseRealEstateInIsrael(2);
        realEstate.chooseRealEstateAssetAddress(2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(1), 1,
                "Error message 'Need to Fill City' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(2), 1,
                "Error message 'Need to Fill City' did not appear on a third panel");

        realEstate.selectCityFromDropDownListByIndex(0, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(0), 0,
                "Error message 'Need to Fill City' did not disappear on a first panel after City was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(1), 1,
                "Error message 'Need to Fill City' disappear on a second panel after City was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(2), 1,
                "Error message 'Need to Fill City' disappear on a third panel after City was chosen on a first panel");


        realEstate.selectCityFromDropDownListByIndex(2, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(0), 0,
                "Error message 'Need to Fill City' re-appear on a first panel after City was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(1), 1,
                "Error message 'Need to Fill City' disappear on a second panel after City was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(2), 0,
                "Error message 'Need to Fill City' did not disappear on a third panel after City was chosen");


        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(0), 0,
                "Error message 'Need to Fill City' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(1), 0,
                "Error message 'Need to Fill City' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(0), 0,
                "Error message 'Need to Fill City' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillStreetIsraeliErrorMessage() {
        log.info("Check the error message 'need to fill street' for Israel property");

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateAssetAddress(0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(0), 1,
                "Error message 'Need to Fill Street' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateInIsrael(1);
        realEstate.chooseRealEstateAssetAddress(1);
        realEstate.chooseRealEstateInIsrael(2);
        realEstate.chooseRealEstateAssetAddress(2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(1), 1,
                "Error message 'Need to Fill Street' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(2), 1,
                "Error message 'Need to Fill Street' did not appear on a third panel");

        realEstate.selectCityFromDropDownListByIndex(0, 0);
        realEstate.selectStreetFromDropDownListByIndex(0, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(0), 0,
                "Error message 'Need to Fill Street' did not disappear on a first panel after Street was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(1), 1,
                "Error message 'Need to Fill Street' disappear on a second panel after Street was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(2), 1,
                "Error message 'Need to Fill Street' disappear on a third panel after Street was chosen on a first panel");


        realEstate.selectCityFromDropDownListByIndex(2, 0);
        realEstate.selectStreetFromDropDownListByIndex(2, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(0), 0,
                "Error message 'Need to Fill Street' re-appear on a first panel after Street was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(1), 1,
                "Error message 'Need to Fill Street' disappear on a second panel after Street was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(2), 0,
                "Error message 'Need to Fill Street' did not disappear on a third panel after Street was chosen");


        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(0), 0,
                "Error message 'Need to Fill Street' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(1), 0,
                "Error message 'Need to Fill Street' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(0), 0,
                "Error message 'Need to Fill Street' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillHouseNumberIsraeliErrorMessage() {
        log.info("Check the error message 'need to fill house number' for Israeli house");

        String firstCorrectHouseNumber =  "123";
        String thirdCorrectHouseNumber = "60a";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateAssetAddress(0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(0), 1,
                "Error message 'Need to Fill House Number' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateInIsrael(1);
        realEstate.chooseRealEstateAssetAddress(1);
        realEstate.chooseRealEstateInIsrael(2);
        realEstate.chooseRealEstateAssetAddress(2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(1), 1,
                "Error message 'Need to Fill House Number' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(2), 1,
                "Error message 'Need to Fill House Number' did not appear on a third panel");

        realEstate.deleteHouseNum(0);
        realEstate.enterHouseNum(0, firstCorrectHouseNumber);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(0), 0,
                "Error message 'Need to Fill House Number' did not disappear on a first panel after House Number was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(1), 1,
                "Error message 'Need to Fill House Number' disappear on a second panel after House Number was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(2), 1,
                "Error message 'Need to Fill House Number' disappear on a third panel after House Number was entered on a first panel");

        realEstate.deleteHouseNum(2);
        realEstate.enterHouseNum(2, thirdCorrectHouseNumber);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(0), 0,
                "Error message 'Need to Fill House Number' re-appear on a first panel after House Number was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(1), 1,
                "Error message 'Need to Fill House Number' disappear on a second panel after House Number was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(2), 0,
                "Error message 'Need to Fill House Number' did not disappear on a third panel after House Number was entered");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(0), 0,
                "Error message 'Need to Fill House Number' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(1), 0,
                "Error message 'Need to Fill House Number' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(0), 0,
                "Error message 'Need to Fill House Number' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillCountryOverseaErrorMessage() {
        log.info("Check the error message 'need to fill country' for Oversea property");

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateOversea(0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(0), 1,
                "Error message 'Need to Fill Country' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateOversea(1);
        realEstate.chooseRealEstateOversea(2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(1), 1,
                "Error message 'Need to Fill Country' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(2), 1,
                "Error message 'Need to Fill Country' did not appear on a third panel");

        realEstate.selectCountryFromDropDownListByIndex(0, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(0), 0,
                "Error message 'Need to Fill Country' did not disappear on a first panel after Country was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(1), 1,
                "Error message 'Need to Fill Country' disappear on a second panel after Country was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(2), 1,
                "Error message 'Need to Fill Country' disappear on a third panel after Country was chosen on a first panel");


        realEstate.selectCountryFromDropDownListByIndex(2, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(0), 0,
                "Error message 'Need to Fill Country' re-appear on a first panel after Country was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(1), 1,
                "Error message 'Need to Fill Country' disappear on a second panel after Country was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(2), 0,
                "Error message 'Need to Fill Country' did not disappear on a third panel after Country was chosen");


        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(0), 0,
                "Error message 'Need to Fill Country' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(1), 0,
                "Error message 'Need to Fill Country' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCountry(0), 0,
                "Error message 'Need to Fill Country' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillCityOverseaErrorMessage() {
        log.info("Check the error message 'need to fill city' for Oversea property");

        String firstCity = "First City";
        String thirdCity = "Third City";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateOversea(0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(0), 1,
                "Error message 'Need to Fill City' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateOversea(1);
        realEstate.chooseRealEstateOversea(2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(1), 1,
                "Error message 'Need to Fill City' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(2), 1,
                "Error message 'Need to Fill City' did not appear on a third panel");

        realEstate.enterCity(0, firstCity);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(0), 0,
                "Error message 'Need to Fill City' did not disappear on a first panel after City was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(1), 1,
                "Error message 'Need to Fill City' disappear on a second panel after City was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(2), 1,
                "Error message 'Need to Fill City' disappear on a third panel after City was entered on a first panel");


        realEstate.enterCity(2, thirdCity);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(0), 0,
                "Error message 'Need to Fill City' re-appear on a first panel after City was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(1), 1,
                "Error message 'Need to Fill City' disappear on a second panel after City was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(2), 0,
                "Error message 'Need to Fill City' did not disappear on a third panel after City was entered");


        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(0), 0,
                "Error message 'Need to Fill City' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(1), 0,
                "Error message 'Need to Fill City' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillCity(0), 0,
                "Error message 'Need to Fill City' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillStreetOverseaErrorMessage() {
        log.info("Check the error message 'need to fill street' for Oversea property");

        String firstStreet = "First Street";
        String thirdStreet = "Third Street";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateOversea(0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(0), 1,
                "Error message 'Need to Fill Street' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateOversea(1);
        realEstate.chooseRealEstateOversea(2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(1), 1,
                "Error message 'Need to Fill Street' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(2), 1,
                "Error message 'Need to Fill Street' did not appear on a third panel");

        realEstate.enterStreet(0, firstStreet);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(0), 0,
                "Error message 'Need to Fill Street' did not disappear on a first panel after Street was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(1), 1,
                "Error message 'Need to Fill Street' disappear on a second panel after Street was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(2), 1,
                "Error message 'Need to Fill Street' disappear on a third panel after Street was entered on a first panel");


        realEstate.enterStreet(2, thirdStreet);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(0), 0,
                "Error message 'Need to Fill Street' re-appear on a first panel after Street was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(1), 1,
                "Error message 'Need to Fill Street' disappear on a second panel after Street was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(2), 0,
                "Error message 'Need to Fill Street' did not disappear on a third panel after Street was entered");


        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(0), 0,
                "Error message 'Need to Fill Street' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(1), 0,
                "Error message 'Need to Fill Street' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillStreet(0), 0,
                "Error message 'Need to Fill Street' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillHouseNumberOverseaErrorMessage() {
        log.info("Check the error message 'need to fill house number' for Oversea house");

        String firstCorrectHouseNumber =  "123";
        String thirdCorrectHouseNumber = "60a";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateOversea(0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(0), 1,
                "Error message 'Need to Fill House Number' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateOversea(1);
        realEstate.chooseRealEstateOversea(2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(1), 1,
                "Error message 'Need to Fill House Number' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(2), 1,
                "Error message 'Need to Fill House Number' did not appear on a third panel");

        realEstate.deleteHouseNum(0);
        realEstate.enterHouseNum(0, firstCorrectHouseNumber);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(0), 0,
                "Error message 'Need to Fill House Number' did not disappear on a first panel after House Number was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(1), 1,
                "Error message 'Need to Fill House Number' disappear on a second panel after House Number was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(2), 1,
                "Error message 'Need to Fill House Number' disappear on a third panel after House Number was entered on a first panel");

        realEstate.deleteHouseNum(2);
        realEstate.enterHouseNum(2, thirdCorrectHouseNumber);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(0), 0,
                "Error message 'Need to Fill House Number' re-appear on a first panel after House Number was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(1), 1,
                "Error message 'Need to Fill House Number' disappear on a second panel after House Number was entered on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(2), 0,
                "Error message 'Need to Fill House Number' did not disappear on a third panel after House Number was entered");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(0), 0,
                "Error message 'Need to Fill House Number' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(1), 0,
                "Error message 'Need to Fill House Number' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillHouseNumber(0), 0,
                "Error message 'Need to Fill House Number' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillUsageRealEstateErrorMessage() {
        log.info("Check the error message 'need to fill usage real estate'");

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(0), 1,
                "Error message 'Need to Fill Usage Real Estate' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(1), 1,
                "Error message 'Need to Fill Usage Real Estate' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(2), 1,
                "Error message 'Need to Fill Usage Real Estate' did not appear on a third panel");

        realEstate.chooseRealEstatePersonalUsage(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(0), 0,
                "Error message 'Need to Fill Usage Real Estate' did not disappear on a first panel after Personal Usage was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(1), 1,
                "Error message 'Need to Fill Usage Real Estate' disappear on a second panel after usage was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(2), 1,
                "Error message 'Need to Fill Usage Real Estate' disappear on a third panel after usage was chosen on a first panel");

        realEstate.chooseRealEstateFamilyUsage(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(0), 0,
                "Error message 'Need to Fill Usage Real Estate' did not disappear on a first panel after Family Usage was chosen");

        realEstate.chooseRealEstateRentingUsage(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(0), 0,
                "Error message 'Need to Fill Usage Real Estate' did not disappear on a first panel after Renting Usage was chosen");

        realEstate.chooseRealEstateNotUsing(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(0), 0,
                "Error message 'Need to Fill Usage Real Estate' did not disappear on a first panel after Not Using was chosen");

        realEstate.chooseRealEstateAnotherUsage(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(0), 0,
                "Error message 'Need to Fill Usage Real Estate' did not disappear on a first panel after Another Usage was chosen");

        realEstate.chooseRealEstatePersonalUsage(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(0), 0,
                "Error message 'Need to Fill Usage Real Estate' re-appear on a first panel after Personal Usage was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(1), 1,
                "Error message 'Need to Fill Usage Real Estate' disappear on a second panel after Personal Usage was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(2), 0,
                "Error message 'Need to Fill Usage Real Estate' did not disappear on a third panel after Personal Usage was chosen");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(0), 0,
                "Error message 'Need to Fill Usage Real Estate' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(1), 0,
                "Error message 'Need to Fill Usage Real Estate' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageRealEstate(0), 0,
                "Error message 'Need to Fill Usage Real Estate' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillUsageDetailsErrorMessage() {
        log.info("Check the error message 'need to fill usage details'");

        String firstUsage = "First Usage";
        String thirdUsage = "Third Usage";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateAnotherUsage(0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(0), 1,
                "Error message 'Need to Fill Usage Details' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateAnotherUsage(1);
        realEstate.chooseRealEstateAnotherUsage(2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(1), 1,
                "Error message 'Need to Fill Usage Details' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(2), 1,
                "Error message 'Need to Fill Usage Details' did not appear on a third panel");

        realEstate.deleteExplainUsage(0);
        realEstate.enterExplainUsage(0, firstUsage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(0), 0,
                "Error message 'Need to Fill Usage Details' did not disappear on a first panel after Usage Details was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(1), 1,
                "Error message 'Need to Fill Usage Details' disappear on a second panel after Usage Details was entered on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(2), 1,
                "Error message 'Need to Fill Usage Details' disappear on a third panel after Usage Details was entered on a first panel");

        realEstate.deleteExplainUsage(2);
        realEstate.enterExplainUsage(2, thirdUsage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(0), 0,
                "Error message 'Need to Fill Usage Details' re-appear on a first panel after Usage Details was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(1), 1,
                "Error message 'Need to Fill Usage Details' disappear on a second panel after Usage Details was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(2), 0,
                "Error message 'Need to Fill Usage Details' did not disappear on a third panel after Usage Details was chosen");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(0), 0,
                "Error message 'Need to Fill Usage Details' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(1), 0,
                "Error message 'Need to Fill Usage Details' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillUsageDetails(0), 0,
                "Error message 'Need to Fill Usage Details' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillPropertySplitErrorMessage() {
        log.info("Check the error message 'need to fill property split'");

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstatePersonalUsage(0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(0), 1,
                "Error message 'Need to Fill Property Split' did not appear on a first panel");

        realEstate.addRealEstate();
        realEstate.addRealEstate();
        realEstate.chooseRealEstateFamilyUsage(1);
        realEstate.chooseRealEstateRentingUsage(2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(1), 1,
                "Error message 'Need to Fill Property Split' did not appear on a second panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(2), 1,
                "Error message 'Need to Fill Property Split' did not appear on a third panel");

        realEstate.chooseRealEstateSplit(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(0), 0,
                "Error message 'Need to Fill Property Split' did not disappear on a first panel after Split was chosen");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(1), 1,
                "Error message 'Need to Fill Property Split' disappear on a second panel after Split was chosen on a first panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(2), 1,
                "Error message 'Need to Fill Property Split' disappear on a third panel after Split was chosen on a first panel");

        realEstate.chooseRealEstateNotSplit(2);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(0), 0,
                "Error message 'Need to Fill Property Split' re-appear on a first panel after not Split was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(1), 1,
                "Error message 'Need to Fill Property Split' disappear on a second panel after not Split was chosen on a third panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(2), 0,
                "Error message 'Need to Fill Property Split' did not disappear on a third panel after not Split was chosen");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(0), 0,
                "Error message 'Need to Fill Property Split' re-appear on a first panel after second panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(1), 0,
                "Error message 'Need to Fill Property Split' re-appear on a third panel after second panel was deleted");

        realEstate.deleteRealEstate(1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillPropertySplit(0), 0,
                "Error message 'Need to Fill Property Split' re-appear on a first panel after a last panel was deleted");
    }

    protected void needFillTenantIDErrorMessage() {
        log.info("Check the error message 'need to fill tenant ID' for tenant israeli");

        String firstTenantID = "123456789";
        String thirdTenantID = "987654321";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateRentingUsage(0);
        realEstate.chooseTenantFromIsrael(0, 0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0, 0), 1,
                "Error message 'Need to Fill Tenant ID' did not appear on a first tenant panel");

        realEstate.addTenant(0);
        realEstate.addTenant(0);
        realEstate.chooseTenantFromIsrael(0, 1);
        realEstate.chooseTenantFromIsrael(0, 2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0, 1), 1,
                "Error message 'Need to Fill Tenant ID' did not appear on a second tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0, 2), 1,
                "Error message 'Need to Fill Tenant ID' did not appear on a third tenant panel");

        realEstate.enterTenantId(0, 0, firstTenantID);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0, 0), 0,
                "Error message 'Need to Fill Tenant ID' did not disappear on a first tenant panel after Tenant ID was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0, 1), 1,
                "Error message 'Need to Fill Tenant ID' disappear on a second tenant panel after Tenant ID was entered on a first tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0, 2), 1,
                "Error message 'Need to Fill Tenant ID' disappear on a third tenant panel after Tenant ID was entered on a first tenant panel");

        realEstate.enterTenantId(0, 2, thirdTenantID);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0, 0), 0,
                "Error message 'Need to Fill Tenant ID' re-appear on a first tenant panel after Tenant ID was entered on a third tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0, 1), 1,
                "Error message 'Need to Fill Tenant ID' disappear on a second tenant panel after Tenant ID was entered on a third tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0, 2), 0,
                "Error message 'Need to Fill Tenant ID' did not disappear on a third tenant panel after Tenant ID was entered");

        realEstate.deleteTenant(0, 1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0,0), 0,
                "Error message 'Need to Fill Tenant ID' re-appear on a first tenant panel after second tenant panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0, 1), 0,
                "Error message 'Need to Fill Tenant ID' re-appear on a third tenant panel after second tenant panel was deleted");

        realEstate.deleteTenant(0, 1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantID(0, 0), 0,
                "Error message 'Need to Fill Tenant ID' re-appear on a first tenant panel after a last tenant panel was deleted");
    }

    protected void needFillTenantCountryErrorMessage() {
        log.info("Check the error message 'need to fill tenant country' for tenant abroad");

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateRentingUsage(0);
        realEstate.chooseTenantFromAbroad(0, 0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0, 0), 1,
                "Error message 'Need to Fill Tenant Country' did not appear on a first tenant panel");

        realEstate.addTenant(0);
        realEstate.addTenant(0);
        realEstate.chooseTenantFromAbroad(0, 1);
        realEstate.chooseTenantFromAbroad(0, 2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0, 1), 1,
                "Error message 'Need to Fill Tenant Country' did not appear on a second tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0, 2), 1,
                "Error message 'Need to Fill Tenant Country' did not appear on a third tenant panel");

        realEstate.selectCountryTenantFromDropDownListByIndex(0, 0, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0, 0), 0,
                "Error message 'Need to Fill Tenant Country' did not disappear on a first tenant panel after Tenant Country was selected");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0, 1), 1,
                "Error message 'Need to Fill Tenant Country' disappear on a second tenant panel after Tenant Country was selected on a first tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0, 2), 1,
                "Error message 'Need to Fill Tenant Country' disappear on a third tenant panel after Tenant Country was selected on a first tenant panel");

        realEstate.selectCountryTenantFromDropDownListByIndex(0, 2, 0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0, 0), 0,
                "Error message 'Need to Fill Tenant Country' re-appear on a first tenant panel after Tenant Country was selected on a third tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0, 1), 1,
                "Error message 'Need to Fill Tenant Country' disappear on a second tenant panel after Tenant Country was selected on a third tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0, 2), 0,
                "Error message 'Need to Fill Tenant Country' did not disappear on a third tenant panel after Tenant Country was selected");

        realEstate.deleteTenant(0, 1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0,0), 0,
                "Error message 'Need to Fill Tenant Country' re-appear on a first tenant panel after second tenant panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0, 1), 0,
                "Error message 'Need to Fill Tenant Country' re-appear on a third tenant panel after second tenant panel was deleted");

        realEstate.deleteTenant(0, 1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantCountry(0, 0), 0,
                "Error message 'Need to Fill Tenant Country' re-appear on a first tenant panel after a last tenant panel was deleted");
    }

    protected void needFillTenantPassportErrorMessage() {
        log.info("Check the error message 'need to fill tenant passport' for tenant abroad");

        String firstTenantPassport = "123456789";
        String thirdTenantPassport = "987654321";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateRentingUsage(0);
        realEstate.chooseTenantFromAbroad(0, 0);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0, 0), 1,
                "Error message 'Need to Fill Tenant Passport' did not appear on a first tenant panel");

        realEstate.addTenant(0);
        realEstate.addTenant(0);
        realEstate.chooseTenantFromAbroad(0, 1);
        realEstate.chooseTenantFromAbroad(0, 2);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0, 1), 1,
                "Error message 'Need to Fill Tenant Passport' did not appear on a second tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0, 2), 1,
                "Error message 'Need to Fill Tenant Passport' did not appear on a third tenant panel");

        realEstate.deleteTenantPassport(0, 0);
        realEstate.enterTenantPassport(0, 0, firstTenantPassport);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0, 0), 0,
                "Error message 'Need to Fill Tenant Passport' did not disappear on a first tenant panel after Tenant Passport was entered");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0, 1), 1,
                "Error message 'Need to Fill Tenant Passport' disappear on a second tenant panel after Tenant Passport was entered on a first tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0, 2), 1,
                "Error message 'Need to Fill Tenant Passport' disappear on a third tenant panel after Tenant Passport was entered on a first tenant panel");

        realEstate.deleteTenantPassport(0, 2);
        realEstate.enterTenantPassport(0, 2, thirdTenantPassport);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0, 0), 0,
                "Error message 'Need to Fill Tenant Passport' re-appear on a first tenant panel after Tenant Passport was entered on a third tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0, 1), 1,
                "Error message 'Need to Fill Tenant Passport' disappear on a second tenant panel after Tenant Passport was entered on a third tenant panel");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0, 2), 0,
                "Error message 'Need to Fill Tenant Passport' did not disappear on a third tenant panel after Tenant Passport was entered");

        realEstate.deleteTenant(0, 1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0,0), 0,
                "Error message 'Need to Fill Tenant Passport' re-appear on a first tenant panel after second tenant panel was deleted");

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0, 1), 0,
                "Error message 'Need to Fill Tenant Passport' re-appear on a third tenant panel after second tenant panel was deleted");

        realEstate.deleteTenant(0, 1);
        basePage.clickMenuWage();
        realEstate = basePage.clickMenuRealEstate();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillTenantPassport(0, 0), 0,
                "Error message 'Need to Fill Tenant Passport' re-appear on a first tenant panel after a last tenant panel was deleted");
    }







    protected void propertyAreaContainsDigitsOnlyErrorMessage() {
        log.info("Check the error message 'property area contains digits only'");

        String correctPropertyArea = "123";
        String incorrectPropertyArea = "abc";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();

        realEstate.deleteRealEstatePropertyArea(0);
        realEstate.enterRealEstatePropertyArea(0, incorrectPropertyArea);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessagePropertyAreaContainsDigitalOnly(0), 1,
                String.format("Error message 'Property Area contains digits only' did not appear when incorrect value %s was entered", incorrectPropertyArea));

        realEstate.deleteRealEstatePropertyArea(0);
        realEstate.enterRealEstatePropertyArea(0, correctPropertyArea);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessagePropertyAreaContainsDigitalOnly(0), 0,
                String.format("Error message 'Property Area contains digits only' appear when correct value %s was entered", correctPropertyArea));
    }

    protected void ownershipPercentageIncorrectFormat() {
        log.info("Check that Ownership Percentage allows digits only, from 1 to 100");

        String nonDigitPercentage = "abc";
        String tooBigPercentage = "101";
        String tooSmallPercentage = "0";
        String maxPercentage = "100";
        String minPercentage = "1";
        String correctPercentage = "50";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();

        realEstate.deleteRealEstateOwnershipPercentage(0);
        realEstate.enterRealEstateOwnershipPercentage(0, nonDigitPercentage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageContainsDigitalOnly(0), 1,
                String.format("Error message 'Ownership Percentage contains digits only' did not appear when incorrect value %s was entered", nonDigitPercentage));

        realEstate.deleteRealEstateOwnershipPercentage(0);
        realEstate.enterRealEstateOwnershipPercentage(0, tooBigPercentage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageHundredMax(0), 1,
                String.format("Error message 'Ownership Percentage 100 percents max' did not appear when incorrect value %s was entered", tooBigPercentage));

        realEstate.deleteRealEstateOwnershipPercentage(0);
        realEstate.enterRealEstateOwnershipPercentage(0, tooSmallPercentage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageOneMin(0), 1,
                String.format("Error message 'Ownership Percentage 1 percent min' did not appear when incorrect value %s was entered", tooSmallPercentage));

        realEstate.deleteRealEstateOwnershipPercentage(0);
        realEstate.enterRealEstateOwnershipPercentage(0, maxPercentage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageContainsDigitalOnly(0), 0,
                String.format("Error message 'Ownership Percentage contains digits only' appears when correct value %s was entered", maxPercentage));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageHundredMax(0), 0,
                String.format("Error message 'Ownership Percentage 100 percents max' appears when correct value %s was entered", maxPercentage));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageOneMin(0), 0,
                String.format("Error message 'Ownership Percentage 1 percent min' appears when correct value %s was entered", maxPercentage));

        realEstate.deleteRealEstateOwnershipPercentage(0);
        realEstate.enterRealEstateOwnershipPercentage(0, minPercentage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageContainsDigitalOnly(0), 0,
                String.format("Error message 'Ownership Percentage contains digits only' appears when correct value %s was entered", minPercentage));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageHundredMax(0), 0,
                String.format("Error message 'Ownership Percentage 100 percents max' appears when correct value %s was entered", minPercentage));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageOneMin(0), 0,
                String.format("Error message 'Ownership Percentage 1 percent min' appears when correct value %s was entered", minPercentage));

        realEstate.deleteRealEstateOwnershipPercentage(0);
        realEstate.enterRealEstateOwnershipPercentage(0, correctPercentage);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageContainsDigitalOnly(0), 0,
                String.format("Error message 'Ownership Percentage contains digits only' appears when correct value %s was entered", correctPercentage));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageHundredMax(0), 0,
                String.format("Error message 'Ownership Percentage 100 percents max' appears when correct value %s was entered", correctPercentage));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageOwnershipPercentageOneMin(0), 0,
                String.format("Error message 'Ownership Percentage 1 percent min' appears when correct value %s was entered", correctPercentage));
    }

    protected void gushContainsDigitsOnlyErrorMessage() {
        log.info("Check the error message 'Gush contains digits only'");

        String correctBlock = "123";
        String incorrectBlock = "abc";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateAssetGushHalka(0);

        realEstate.deleteRealEstateBlock(0);
        realEstate.enterRealEstateBlock(0, incorrectBlock);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageBlockContainsDigitalOnly(0), 1,
                String.format("Error message 'Gush contains digits only' did not appear when incorrect value %s was entered", incorrectBlock));

        realEstate.deleteRealEstateBlock(0);
        realEstate.enterRealEstateBlock(0, correctBlock);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageBlockContainsDigitalOnly(0), 0,
                String.format("Error message 'Gush contains digits only' appear when correct value %s was entered", correctBlock));
    }

    protected void helkaContainsDigitsOnlyErrorMessage() {
        log.info("Check the error message 'Helka contains digits only'");

        String correctPlot = "123";
        String incorrectPlot = "abc";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateAssetGushHalka(0);

        realEstate.deleteRealEstatePlot(0);
        realEstate.enterRealEstatePlot(0, incorrectPlot);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessagePlotContainsDigitalOnly(0), 1,
                String.format("Error message 'Helka contains digits only' did not appear when incorrect value %s was entered", incorrectPlot));

        realEstate.deleteRealEstatePlot(0);
        realEstate.enterRealEstatePlot(0, correctPlot);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessagePlotContainsDigitalOnly(0), 0,
                String.format("Error message 'Helka contains digits only' appear when correct value %s was entered", correctPlot));
    }

    protected void tatHelkaIncorrectFormat() {
        log.info("Check the error messages 'Tat-Helka incorrect format'");

        String correctSubPlot = "12";
        String nonDigitSubPlot = "ab";
        String tooLongSubPlot = "456";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateAssetGushHalka(0);

        realEstate.deleteRealEstateSubPlot(0);
        realEstate.enterRealEstateSubPlot(0, nonDigitSubPlot);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageSubPlotContainsDigitalOnly(0), 1,
                String.format("Error message 'Tat-Helka contains digits only' did not appear when incorrect value %s was entered", nonDigitSubPlot));

        realEstate.deleteRealEstateSubPlot(0);
        realEstate.enterRealEstateSubPlot(0, tooLongSubPlot);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageSubPlotTooLong(0), 1,
                String.format("Error message 'Tat-Helka too long' did not appear when incorrect value %s was entered", tooLongSubPlot));

        realEstate.deleteRealEstateSubPlot(0);
        realEstate.enterRealEstateSubPlot(0, correctSubPlot);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageSubPlotContainsDigitalOnly(0), 0,
                String.format("Error message 'Tat-Helka contains digits only' appear when correct value %s was entered", correctSubPlot));
    }

    protected void forbiddenCharactersHouseNumber(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a House Number field, find an error message", forbiddenChar));

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateAssetAddress(0);

        realEstate.enterHouseNum(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageHouseNumberContainsCharacters(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into a House Number field", forbiddenChar));
    }

    protected void forbiddenCharactersState(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a State field, find an error message", forbiddenChar));

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateOversea(0);

        realEstate.enterState(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageStateContainsCharacters(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into a State field", forbiddenChar));
    }

    protected void forbiddenCharactersCity(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a City field, find an error message", forbiddenChar));

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateOversea(0);

        realEstate.enterCity(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageCityContainsCharacters(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into a City field", forbiddenChar));
    }

    protected void forbiddenCharactersStreet(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Street field, find an error message", forbiddenChar));

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateOversea(0);

        realEstate.enterStreet(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageStreetContainsCharacters(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into a Street field", forbiddenChar));
    }

    protected void forbiddenCharactersExplainUsage(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to an Explain Usage field, find an error message", forbiddenChar));

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateAnotherUsage(0);

        realEstate.deleteExplainUsage(0);
        realEstate.enterExplainUsage(0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageUsageDetailsContainsCharacters(0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into an Explain Usage field", forbiddenChar));
    }

    protected void monthlyRentTwentyCharsMaxErrorMessage() {
        log.info("Check the error message 'Monthly Rent field - max 20 characters'");

        String tooLongMonthlyRent = "1234567890123456";
        String correctLongMonthlyRent = "123456789012345";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateRentingUsage(0);

        realEstate.deleteMonthlyRent(0);
        realEstate.enterMonthlyRent(0, tooLongMonthlyRent);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageMonthlyRentTwentyMax(0), 1,
                String.format("Error message 'Monthly Rent field - max 20 characters' did not appear on a panel after a too long value %s was entered",
                        tooLongMonthlyRent));

        realEstate.deleteMonthlyRent(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageMonthlyRentTwentyMax(0), 0,
                "Error message 'Monthly Rent field - max 20 characters' did not disappear from a panel after a too long value was deleted");

        realEstate.enterMonthlyRent(0, correctLongMonthlyRent);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageMonthlyRentTwentyMax(0), 0,
                String.format("Error message 'Monthly Rent field - max 20 characters' appeared on a panel after a correct value %s was entered",
                        correctLongMonthlyRent));
    }

    protected void amountPartitionsErrorMessages() {
        log.info("Check error messages for Amount Partitions");

        int expectedAmountPartitions = 2;
        String tooSmallAmountPartitions = "1";
        String tooLongAmountPartitions = "12345678901";
        String correctAmountPartitions = "50";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateSplit(0);

        int defaultAmountPartitions = realEstate.getAmountPartitionsOfDividedRealEstate(0);

        Assert.assertEquals(defaultAmountPartitions, expectedAmountPartitions, String.format("Expected %d default amount partitions, found %d",
                expectedAmountPartitions, defaultAmountPartitions));

        realEstate.deleteAmountPartitionsOfDividedRealEstate(0);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillAmountPartitions(0), 1,
                "Error message 'need to fill amount partitions' did not appeared when partitions were deleted");

        realEstate.enterAmountPartitionsOfDividedRealEstate(0, tooSmallAmountPartitions);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageAmountPartitionsTwoMin(0), 1,
                String.format("Error message 'Amount Partitions minimum 2' did not appear on a panel after a too small value %s was entered",
                        tooSmallAmountPartitions));

        realEstate.deleteAmountPartitionsOfDividedRealEstate(0);
        realEstate.enterAmountPartitionsOfDividedRealEstate(0, tooLongAmountPartitions);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageAmountPartitionsTenCharsMax(0), 1,
                String.format("Error message 'Amount Partitions 10 chars max' did not appear on a panel after a too long value %s was entered",
                        tooLongAmountPartitions));

        realEstate.deleteAmountPartitionsOfDividedRealEstate(0);
        realEstate.enterAmountPartitionsOfDividedRealEstate(0, correctAmountPartitions);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageNeedFillAmountPartitions(0), 0,
                String.format("Error message 'need to fill amount partitions' appeared when correct amount partitions %s were entered",
                        correctAmountPartitions));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageAmountPartitionsTwoMin(0), 0,
                String.format("Error message 'Amount Partitions minimum 2' appeared on a panel after a correct value %s was entered",
                        correctAmountPartitions));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageAmountPartitionsTenCharsMax(0), 0,
                String.format("Error message 'Amount Partitions 10 chars max' appeared on a panel after a correct value %s was entered",
                        correctAmountPartitions));
    }

    protected void tenantIDErrorMessages() {
        log.info("Error messages Tenant ID");

        String nonDigitTenantID = "abc";
        String tooLongTenantID = "1234567890";
        String correctTenantID = "123456789";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateRentingUsage(0);
        realEstate.chooseTenantFromIsrael(0, 0);

        realEstate.deleteTenantId(0, 0);
        realEstate.enterTenantId(0, 0, nonDigitTenantID);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageTenantIDDigitsOnly(0, 0), 1,
                String.format("Error message 'Tenant Id digits only' did not appear on a tenant panel after an incorrect value %s was entered",
                        nonDigitTenantID));

        realEstate.deleteTenantId(0, 0);
        realEstate.enterTenantId(0, 0, tooLongTenantID);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageTenantIDNineDigitsMax(0, 0), 1,
                String.format("Error message 'Tenant Id 9 digits max' did not appear on a tenant panel after an incorrect value %s was entered",
                        tooLongTenantID));

        realEstate.deleteTenantId(0, 0);
        realEstate.enterTenantId(0, 0, correctTenantID);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageTenantIDDigitsOnly(0, 0), 0,
                String.format("Error message 'Tenant Id digits only' appeared on a tenant panel after a correct value %s was entered",
                        correctTenantID));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageTenantIDNineDigitsMax(0, 0), 0,
                String.format("Error message 'Tenant Id 9 digits max' appeared on a tenant panel after a correct value %s was entered",
                        correctTenantID));
    }

    protected void forbiddenCharactersTenantState(String forbiddenChar) {
        log.info(String.format("Enter the characters '%s' to a Tenant State field, find an error message", forbiddenChar));

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateRentingUsage(0);
        realEstate.chooseTenantFromAbroad(0, 0);

        realEstate.deleteTenantState(0, 0);
        realEstate.enterTenantState(0, 0, forbiddenChar);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageTenantStateContainsCharacters(0, 0), 1,
                String.format("Error message 'allowed characters' did not appeared when '%s' was entered into an Tenant State field", forbiddenChar));
    }

    protected void tenantPassportErrorMessages() {
        log.info("Error messages Tenant Passport");

        String incorrectTenantPassport = "Passport";
        String tooLongTenantPassport = "1234567890123456";
        String correctTenantPassport = "123456789012345";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();
        realEstate.chooseRealEstateRentingUsage(0);
        realEstate.chooseTenantFromAbroad(0, 0);

        realEstate.deleteTenantPassport(0, 0);
        realEstate.enterTenantPassport(0, 0, incorrectTenantPassport);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageTenantPassportIncorrect(0, 0), 1,
                String.format("Error message 'Tenant Passport incorrect' did not appear on a tenant panel after an incorrect value %s was entered",
                        incorrectTenantPassport));

        realEstate.deleteTenantPassport(0, 0);
        realEstate.enterTenantPassport(0, 0, tooLongTenantPassport);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageTenantPassportFifteenDigitsMax(0, 0), 1,
                String.format("Error message 'Tenant Passport 15 digits max' did not appear on a tenant panel after an incorrect value %s was entered",
                        tooLongTenantPassport));

        realEstate.deleteTenantPassport(0, 0);
        realEstate.enterTenantPassport(0, 0, correctTenantPassport);

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageTenantPassportIncorrect(0, 0), 0,
                String.format("Error message 'Tenant Passport incorrect' appeared on a tenant panel after a correct value %s was entered",
                        correctTenantPassport));

        AssertionsHarchavat.assertListContainsExactNumberOfElements(realEstate.getErrorMessageTenantPassportFifteenDigitsMax(0, 0), 0,
                String.format("Error message 'Tenant Passport 15 digits max' appeared on a tenant panel after an correct value %s was entered",
                        correctTenantPassport));
    }

}
