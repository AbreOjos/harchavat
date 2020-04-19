package tests.scenarious;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import pom.forms.realestates.RealEstate;
import tests.TestBase;

import static constants.EnglishHebrewConstants.MARCH;

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
        realEstate.enterRealEstateSize(0, realEstateSize);
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
}
