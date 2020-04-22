package tests.scenarious;

import assertions.AssertionsHarchavat;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pom.forms.realestates.RealEstate;
import pom.forms.sendform.SendForm;
import tests.TestBase;

import static constants.EnglishHebrewConstants.*;

public class SendFormRealEstateTests extends TestBase {
    private static final Logger log = Logger.getLogger(SendFormRealEstateTests.class);

    protected void multiRealEstateWithoutTenants() throws Exception {
        log.info("Add and delete real estates, check that data does not loss");

        String thirdRealEstateAnotherType ="Another Real Estate Type";

        String firstDateStarting;
        String secondDateStarting;
        String thirdDateStarting;

        String firstBlock = "9";
        String firstPlot = "8";
        String firstSubPlot = "7";
        String secondCity;
        String secondStreet;
        String secondHouseNum = "15a";
        String thirdCountry;
        String thirdState = "Third State";
        String thirdCity = "Third City";
        String thirdStreet = "Third Street";
        String thirdHouseNum = "25";

        String firstPropertyArea = "123";
        String secondPropertyArea = "456";
        String thirdPropertyArea = "789";

        String firstOwnershipPercentage = "1";
        String secondOwnershipPercentage = "100";
        String thirdOwnershipPercentage = "56";

        String secondAnotherUsage = "Second Another Usage";

        String thirdAmountPartitions = "4";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();

        // add two real estates
        realEstate.addRealEstate();
        realEstate.addRealEstate();

        // fill types
        realEstate.chooseRealEstateTypeFarm(0);
        realEstate.chooseRealEstateTypeApartment(1);
        realEstate.chooseRealEstateTypeAnother(2);
        realEstate.enterExplainPropertyType(2, thirdRealEstateAnotherType);

        // fill dates
        firstDateStarting = realEstate.pickDayMonthYear(0, "19", JUNE, "2020");
        secondDateStarting = realEstate.pickDayMonthYear(1, "1", JANUARY, "2018");
        thirdDateStarting = realEstate.pickDayMonthYear(2, "28", FEBRUARY, "2019");

        // fill property areas
        realEstate.enterRealEstatePropertyArea(0, firstPropertyArea);
        realEstate.enterRealEstatePropertyArea(1, secondPropertyArea);
        realEstate.enterRealEstatePropertyArea(2, thirdPropertyArea);

        // fill ownership percentage
        realEstate.enterRealEstateOwnershipPercentage(0, firstOwnershipPercentage);
        realEstate.enterRealEstateOwnershipPercentage(1, secondOwnershipPercentage);
        realEstate.enterRealEstateOwnershipPercentage(2, thirdOwnershipPercentage);

        // fill addresses
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateInIsrael(1);
        realEstate.chooseRealEstateOversea(2);

        realEstate.chooseRealEstateAssetGushHalka(0);
        realEstate.chooseRealEstateAssetAddress(1);

        realEstate.enterRealEstateBlock(0, firstBlock);
        realEstate.enterRealEstatePlot(0, firstPlot);
        realEstate.enterRealEstateSubPlot(0, firstSubPlot);

        secondCity = realEstate.selectCityFromDropDownListByIndex(1, 0);
        secondStreet = realEstate.selectStreetFromDropDownListByIndex(1, 0);
        realEstate.enterHouseNum(1, secondHouseNum);

        thirdCountry = realEstate.selectCountryFromDropDownListByIndex(2, 0);
        realEstate.enterState(2, thirdState);
        realEstate.enterCity(2, thirdCity);
        realEstate.enterStreet(2, thirdStreet);
        realEstate.enterHouseNum(2, thirdHouseNum);

        // choose real estate usage
        realEstate.chooseRealEstateNotUsing(0);
        realEstate.chooseRealEstateAnotherUsage(1);
        realEstate.enterExplainUsage(1, secondAnotherUsage);
        realEstate.chooseRealEstateFamilyUsage(2);

        // splitting apartments
        realEstate.chooseRealEstateNotSplit(0);
        realEstate.chooseRealEstateNotSplit(1);
        realEstate.chooseRealEstateSplit(2);

        realEstate.deleteAmountPartitionsOfDividedRealEstate(2);
        realEstate.enterAmountPartitionsOfDividedRealEstate(2, thirdAmountPartitions);


        // go to Send Form, check data
        SendForm sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getRealEstate(), 3,
                String.format("Expected %d Real Estates on Send Form page, but found %d", 3, sendForm.getRealEstate().size()));

        // first real estate
        Assert.assertTrue(sendForm.realEstateTypeContainsText(0, FARM),
                String.format("Real Estate type incorrect, expected %s", FARM));
        Assert.assertTrue(sendForm.realEstateDateOwnershipContainsText(0, firstDateStarting),
                String.format("Real Estate starting date incorrect, expected %s", firstDateStarting));
        Assert.assertTrue(sendForm.realEstateAreaSizeContainsText(0, firstPropertyArea),
                String.format("Real Estate size incorrect, expected %s", firstPropertyArea));
        Assert.assertTrue(sendForm.realEstateOwnershipPercentageContainsText(0, firstOwnershipPercentage),
                String.format("Real Estate ownership percentage incorrect, expected %s", firstOwnershipPercentage));
        Assert.assertTrue(sendForm.realEstateIsraeli(0),
                "Real Estate jurisdiction incorrect, expected Israeli");
        Assert.assertTrue(sendForm.realEstateUsageContainsText(0, NOT_USING),
                String.format("Real Estate usage incorrect, expected %s", NOT_USING));

        // second real estate
        Assert.assertTrue(sendForm.realEstateTypeContainsText(1, APARTMENT),
                String.format("Real Estate type incorrect, expected %s", APARTMENT));
        Assert.assertTrue(sendForm.realEstateDateOwnershipContainsText(1, secondDateStarting),
                String.format("Real Estate starting date incorrect, expected %s", secondDateStarting));
        Assert.assertTrue(sendForm.realEstateAreaSizeContainsText(1, secondPropertyArea),
                String.format("Real Estate size incorrect, expected %s", secondPropertyArea));
        Assert.assertTrue(sendForm.realEstateOwnershipPercentageContainsText(1, secondOwnershipPercentage),
                String.format("Real Estate ownership percentage incorrect, expected %s", secondOwnershipPercentage));
        Assert.assertTrue(sendForm.realEstateIsraeli(1),
                "Real Estate jurisdiction incorrect, expected Israeli");
        Assert.assertTrue(sendForm.realEstateUsageContainsText(1, secondAnotherUsage),
                String.format("Real Estate usage incorrect, expected %s", secondAnotherUsage));

        // third real estate
        Assert.assertTrue(sendForm.realEstateTypeContainsText(2, thirdRealEstateAnotherType),
                String.format("Real Estate type incorrect, expected %s", thirdRealEstateAnotherType));
        Assert.assertTrue(sendForm.realEstateDateOwnershipContainsText(2, thirdDateStarting),
                String.format("Real Estate starting date incorrect, expected %s", thirdDateStarting));
        Assert.assertTrue(sendForm.realEstateAreaSizeContainsText(2, thirdPropertyArea),
                String.format("Real Estate size incorrect, expected %s", thirdPropertyArea));
        Assert.assertTrue(sendForm.realEstateOwnershipPercentageContainsText(2, thirdOwnershipPercentage),
                String.format("Real Estate ownership percentage incorrect, expected %s", thirdOwnershipPercentage));
        Assert.assertTrue(sendForm.realEstateAbroad(2),
                "Real Estate jurisdiction incorrect, expected Oversea");
        Assert.assertTrue(sendForm.realEstateCountryContainsText(2, thirdCountry),
                String.format("Real Estate country incorrect, expected %s", thirdCountry));
        Assert.assertTrue(sendForm.realEstateStateContainsText(2, thirdState),
                String.format("Real Estate state incorrect, expected %s", thirdState));
        Assert.assertTrue(sendForm.realEstateUsageContainsText(2, FAMILY_USAGE),
                String.format("Real Estate usage incorrect, expected %s", FAMILY_USAGE));


        // return to Real Estate, delete the second real estate
        realEstate = basePage.clickMenuRealEstate();
        realEstate.deleteRealEstate(1);


        // return to Send Form, check successful deleting
        sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getRealEstate(), 2,
                String.format("Expected %d Real Estates on Send Form page, but found %d", 2, sendForm.getRealEstate().size()));

        // first real estate
        Assert.assertTrue(sendForm.realEstateTypeContainsText(0, FARM),
                String.format("Real Estate type incorrect, expected %s", FARM));
        Assert.assertTrue(sendForm.realEstateDateOwnershipContainsText(0, firstDateStarting),
                String.format("Real Estate starting date incorrect, expected %s", firstDateStarting));
        Assert.assertTrue(sendForm.realEstateAreaSizeContainsText(0, firstPropertyArea),
                String.format("Real Estate size incorrect, expected %s", firstPropertyArea));
        Assert.assertTrue(sendForm.realEstateOwnershipPercentageContainsText(0, firstOwnershipPercentage),
                String.format("Real Estate ownership percentage incorrect, expected %s", firstOwnershipPercentage));
        Assert.assertTrue(sendForm.realEstateIsraeli(0),
                "Real Estate jurisdiction incorrect, expected Israeli");
        Assert.assertTrue(sendForm.realEstateUsageContainsText(0, NOT_USING),
                String.format("Real Estate usage incorrect, expected %s", NOT_USING));

        // second real estate (former third)
        Assert.assertTrue(sendForm.realEstateTypeContainsText(1, thirdRealEstateAnotherType),
                String.format("Real Estate type incorrect, expected %s", thirdRealEstateAnotherType));
        Assert.assertTrue(sendForm.realEstateDateOwnershipContainsText(1, thirdDateStarting),
                String.format("Real Estate starting date incorrect, expected %s", thirdDateStarting));
        Assert.assertTrue(sendForm.realEstateAreaSizeContainsText(1, thirdPropertyArea),
                String.format("Real Estate size incorrect, expected %s", thirdPropertyArea));
        Assert.assertTrue(sendForm.realEstateOwnershipPercentageContainsText(1, thirdOwnershipPercentage),
                String.format("Real Estate ownership percentage incorrect, expected %s", thirdOwnershipPercentage));
        Assert.assertTrue(sendForm.realEstateAbroad(1),
                "Real Estate jurisdiction incorrect, expected Oversea");
        Assert.assertTrue(sendForm.realEstateCountryContainsText(1, thirdCountry),
                String.format("Real Estate country incorrect, expected %s", thirdCountry));
        Assert.assertTrue(sendForm.realEstateStateContainsText(1, thirdState),
                String.format("Real Estate state incorrect, expected %s", thirdState));
        Assert.assertTrue(sendForm.realEstateUsageContainsText(1, FAMILY_USAGE),
                String.format("Real Estate usage incorrect, expected %s", FAMILY_USAGE));
    }

    protected void realEstateWithMultiTenants() throws Exception {
        log.info("Add and delete tenants, check that data does not loss");

        String dateStarting;
        String propertyArea = "123";
        String ownershipPercentage = "1";
        String block = "9";
        String plot = "8";
        String subPlot = "7";
        String firstTenantID = "123456789";
        String secondTenantID = "987654321";
        String thirdTenantPassport = "1233210123321";
        String thirdTenantCountry;
        String thirdTenantState = "State";

        RealEstate realEstate = basePage.clickMenuRealEstate();
        realEstate.chooseHaveRealEstate();

        realEstate.chooseRealEstateTypeApartment(0);
        dateStarting = realEstate.pickDayMonthYear(0, "19", JUNE, "2020");
        realEstate.enterRealEstatePropertyArea(0, propertyArea);
        realEstate.enterRealEstateOwnershipPercentage(0, ownershipPercentage);
        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateAssetGushHalka(0);
        realEstate.enterRealEstateBlock(0, block);
        realEstate.enterRealEstatePlot(0, plot);
        realEstate.enterRealEstateSubPlot(0, subPlot);
        realEstate.chooseRealEstateRentingUsage(0);
        realEstate.chooseRealEstateNotSplit(0);

        // add two more tenants
        realEstate.addTenant(0);
        realEstate.addTenant(0);

        // choose tenants jurisdiction
        realEstate.chooseTenantFromIsrael(0, 0);
        realEstate.chooseTenantFromIsrael(0, 1);
        realEstate.chooseTenantFromAbroad(0, 2);

        // enter tenants IDs and passports
        realEstate.enterTenantId(0, 0, firstTenantID);
        realEstate.enterTenantId(0, 1, secondTenantID);
        realEstate.enterTenantPassport(0, 2, thirdTenantPassport);

        // enter tenants addresses
        thirdTenantCountry = realEstate.selectCountryTenantFromDropDownListByIndex(0, 2, 0);
        realEstate.enterTenantState(0, 2, thirdTenantState);

        // go to Send Form, check data
        SendForm sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getTenantsList(0), 3,
                String.format("Expected %d tenants of first real estate on a Send Form page, but found %d", 3, sendForm.getTenantsList(0).size()));

        // first tenant
        Assert.assertTrue(sendForm.tenantIsraeli(0, 0),
                "Tenant jurisdiction incorrect, expected Israeli");
        Assert.assertTrue(sendForm.tenantIdContains(0, 0, firstTenantID),
                String.format("Tenant ID incorrect, expected %s", firstTenantID));

        // second tenant
        Assert.assertTrue(sendForm.tenantIsraeli(0, 1),
                "Tenant jurisdiction incorrect, expected Israeli");
        Assert.assertTrue(sendForm.tenantIdContains(0, 1, secondTenantID),
                String.format("Tenant ID incorrect, expected %s", secondTenantID));

        // third tenant
        Assert.assertTrue(sendForm.tenantAbroad(0, 2),
                "Tenant jurisdiction incorrect, expected Abroad");
        Assert.assertTrue(sendForm.tenantPassportContains(0, 2, thirdTenantPassport),
                String.format("Tenant Passport incorrect, expected %s", thirdTenantPassport));
        Assert.assertTrue(sendForm.tenantCountryContains(0, 2, thirdTenantCountry),
                String.format("Tenant Country incorrect, expected %s", thirdTenantCountry));
        Assert.assertTrue(sendForm.tenantStateContains(0, 2, thirdTenantState),
                String.format("Tenant State incorrect, expected %s", thirdTenantState));

        // return to Real Estate, delete one of the tenant
        realEstate = basePage.clickMenuRealEstate();
        realEstate.deleteTenant(0, 1);

        // return to Send Form, recheck data
        sendForm = basePage.clickMenuSendForm();

        AssertionsHarchavat.assertListContainsExactNumberOfElements(sendForm.getTenantsList(0), 2,
                String.format("Expected %d tenants of first real estate on a Send Form page, but found %d", 2, sendForm.getTenantsList(0).size()));

        // first tenant
        Assert.assertTrue(sendForm.tenantIsraeli(0, 0),
                "Tenant jurisdiction incorrect, expected Israeli");
        Assert.assertTrue(sendForm.tenantIdContains(0, 0, firstTenantID),
                String.format("Tenant ID incorrect, expected %s", firstTenantID));

        // second tenant (former third)
        Assert.assertTrue(sendForm.tenantAbroad(0, 1),
                "Tenant jurisdiction incorrect, expected Abroad");
        Assert.assertTrue(sendForm.tenantPassportContains(0, 1, thirdTenantPassport),
                String.format("Tenant Passport incorrect, expected %s", thirdTenantPassport));
        Assert.assertTrue(sendForm.tenantCountryContains(0, 1, thirdTenantCountry),
                String.format("Tenant Country incorrect, expected %s", thirdTenantCountry));
        Assert.assertTrue(sendForm.tenantStateContains(0, 1, thirdTenantState),
                String.format("Tenant State incorrect, expected %s", thirdTenantState));
    }
}
