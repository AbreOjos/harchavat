package tests.scenarious;

import org.apache.log4j.Logger;
import pom.forms.*;
import pom.forms.realestates.RealEstate;
import pom.forms.various.Various;
import pom.forms.vehicles.Vehicle;
import pom.forms.wages.Wage;
import readresources.documents.FileAttachments;
import tests.TestBase;

import java.net.URISyntaxException;

public class TemporalTests extends TestBase {
    private static final Logger log = Logger.getLogger(TemporalTests.class);

    protected void clickSideMenu() {
        log.info("open page, click Fill Form upper link, click all side menus");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        Wage wage = basePage.clickMenuWage();

        RealEstate realEstate = basePage.clickMenuRealEstate();

        Various various = basePage.clickMenuVarious();

        Vehicle vehicle = basePage.clickMenuVehicle();

        SendForm sendForm = basePage.clickMenuSendForm();

    }

    protected void clickNextPreviousButtons() {
        log.info("open page, click Fill Form upper link, cycle with Next / Previous buttons");

        PersonalDetails personalDetails = new PersonalDetails(driver);
        personalDetails.clickBtnContinue();

        Wage wage = new Wage(driver);
        wage.clickBtnContinue();

        RealEstate realEstate = new RealEstate(driver);
        realEstate.clickBtnContinue();

        Various various = new Various(driver);
        various.clickBtnContinue();

        Vehicle vehicle = new Vehicle(driver);
        vehicle.clickBtnContinue();

        SendForm sendForm = new SendForm(driver);
        sendForm.clickBtnReturn();

        vehicle = new Vehicle(driver);
        vehicle.clickBtnReturn();

        various = new Various(driver);
        various.clickBtnReturn();

        realEstate = new RealEstate(driver);
        realEstate.clickBtnReturn();

        wage = new Wage(driver);
        wage.clickBtnReturn();
    }

    protected void fillPersonalDetails() throws InterruptedException, URISyntaxException {
        log.info("open page, click Fill Form upper link, click Personal Details side menus, fill fields");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        personalDetails.checkAgreement();

        personalDetails.enterIdentity("123456789");
        personalDetails.enterFirstName("Igor");
        personalDetails.enterLastName("Gindin");
        personalDetails.enterCellular("0523798168");
        personalDetails.enterPhone("0506585162");
        personalDetails.enterEmail("jgjhg@jhgjhg.gov");

        personalDetails.checkCanSendEmail();
        personalDetails.uncheckCanSendEmail();

        personalDetails.chooseExpatriate();
        personalDetails.chooseIsraeli();

        personalDetails.chooseMaritalStatusBachelor();
        personalDetails.chooseMaritalStatusMarried();

        personalDetails.chooseSpouseExpatriate();

        personalDetails.enterSpousePassport("123321123");
        personalDetails.chooseStateSpouseIsrael();
        personalDetails.chooseStateSpouseZambia();
        personalDetails.chooseStateSpouseUsa();
        personalDetails.enterSpouseState("AAAAAAAAAAAA");

        personalDetails.chooseSpouseIsraeli();

        personalDetails.enterSpouseIdentity("321258549");

        personalDetails.chooseMaritalStatusDivorced();
        personalDetails.chooseMaritalStatusWidow();
        personalDetails.chooseMaritalStatusSpousalAlliance();
        personalDetails.chooseMaritalStatusSeparated();

        personalDetails.attachFileSeparated(FileAttachments.getDocumentPdf().toString());

        personalDetails.chooseMaritalStatusPolygamy();

        basePage.clickBtnSave();
        basePage.clickBtnPrint();
        basePage.clickButtonLogOut();
    }

    protected void fillVehiclesDetails() {

        Vehicle vehicle = basePage.clickMenuVehicle();

        vehicle.chooseDontHaveVehicle();
        vehicle.chooseHaveVehicle();

        vehicle.addVehicle();
        vehicle.addVehicle();

        vehicle.enterCarLicense(0, "rytrytrytr");
        vehicle.enterCarLicense(2, "123456");
//        vehicle.enterCarLicense(2,"bbb");


        vehicle.chooseAnotherUsage(0);
        vehicle.deleteVehicle(1);

        vehicle.enterCarLicense(0,"aaaaa");
        vehicle.chooseCommercialVehicle(0);
        vehicle.chooseAircraftVehicle(1);
        vehicle.chooseCommercialUsage(1);
        vehicle.chooseAnotherUsage(0);
        vehicle.enterAnotherUsageDetails(0, "spam");

        vehicle.chooseHeavyVehicle(1);
        vehicle.chooseCommercialUsage(1);

        vehicle.addVehicle();
        vehicle.chooseAnotherVehicle(2);
        vehicle.enterAnotherCarTypeDetails(2, "Just my another car");
    }

    protected void fillWagesDetails() {
        Wage wage = basePage.clickMenuWage();

        wage.chooseDontHaveWage();
        wage.chooseHaveWage();

        wage.addWage();
        wage.addWage();

        wage.enterAnnualIncome(0, "1000");
        wage.enterEmployerAddress(2, "Ramat Gan");

        wage.deleteWage(1);

        wage.enterEmployerName(0,"Moshe");
        wage.enterTikNikuim(1, "123456");

        wage.addWage();
        wage.enterTikNikuim(2,"aaaa");
        wage.enterEmployerName(2, "BBB");
        wage.enterEmployerAddress(2, "cccc");
        wage.enterAnnualIncome(2, "0");

    }

    protected void fillRealEstateDetails() throws URISyntaxException {
        RealEstate realEstate = basePage.clickMenuRealEstate();

        realEstate.chooseDontHaveRealEstate();
        realEstate.chooseHaveRealEstate();

        realEstate.addRealEstate();
        realEstate.addRealEstate();

        realEstate.deleteRealEstate(1);

        realEstate.addRealEstate();

        realEstate.chooseRealEstateTypeHousingUnit(1);
        realEstate.chooseRealEstateTypeAnother(0);

        realEstate.enterRealEstateSize(0, "10");
        realEstate.enterRealEstateOwnershipPercentage(0, "15");

        realEstate.enterRealEstateSize(1, "20");
        realEstate.enterRealEstateOwnershipPercentage(1, "25");

        realEstate.chooseRealEstateInIsrael(0);
        realEstate.chooseRealEstateOversea(1);

        realEstate.enterRealEstateAddress(0, "AAA");
        realEstate.enterRealEstateBlock(0, "BBB");
        realEstate.enterRealEstatePlot(0, "CCC");

        realEstate.chooseRealEstateFamilyUsage(0);
        realEstate.chooseRealEstateRenting(1);

        realEstate.chooseRealEstateBusinessPurpose(1);

        realEstate.chooseRealEstateDivided(1);
        realEstate.setAmountPartitionsOfDividedRealEstate(1, 5);
        System.out.println("Amount of partitions " + realEstate.amountPartitionsOfDividedRealEstate(1));

        realEstate.chooseRealEstateTenantNotIsraeli(1);
        realEstate.enterRenterCountry(1, "USA");
        realEstate.enterRenterPassword(1, "123456789");
        realEstate.enterMonthlyRent(1, "3000");

        realEstate.attachContractFile(1, FileAttachments.getDocumentPdf().toString());
    }

}
