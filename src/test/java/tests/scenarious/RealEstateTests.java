package tests.scenarious;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
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

}
