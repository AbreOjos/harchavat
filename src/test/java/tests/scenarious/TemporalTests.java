package tests.scenarious;

import org.apache.log4j.Logger;
import pom.forms.*;
import tests.TestBase;

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

    protected void fillPersonalDetails() throws InterruptedException {
        log.info("open page, click Fill Form upper link, click Personal Details side menus, fill fields");

        PersonalDetails personalDetails = basePage.clickMenuPersonalDetails();

        // check all checkboxes
        personalDetails = personalDetails.checkAgreement();
        personalDetails = personalDetails.checkCanSendEmail();

        // uncheck agreement
        personalDetails = personalDetails.uncheckAgreement();

        personalDetails = personalDetails.enterIdentity("123456789");
        personalDetails = personalDetails.enterLastName("Gindin");
        personalDetails.chooseMaritalStatusWidow();
        String maritalStatus = personalDetails.getChosenMaritalStatus();
        System.out.println("Marital status Widow: " + maritalStatus);
        personalDetails.chooseMaritalStatusDivorced();

        personalDetails = personalDetails.enterCellular("0523798168");
        maritalStatus = personalDetails.getChosenMaritalStatus();
        System.out.println("Marital status Divorced: " + maritalStatus);

        personalDetails.clickBtnSave();

        personalDetails.clickBtnPrint();

    }

}
