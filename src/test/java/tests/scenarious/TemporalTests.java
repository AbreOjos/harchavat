package tests.scenarious;

import org.apache.log4j.Logger;
import pom.forms.*;
import pom.forms.vehicles.Vehicle;
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
    }

}
