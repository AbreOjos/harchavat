package tests.scenarious;

import org.apache.log4j.Logger;
import pom.filledforms.FilledForms;
import pom.fillform.FillForm;
import pom.fillform.forms.*;
import tests.TestBase;

public class TemporalTests extends TestBase {
    private static final Logger log = Logger.getLogger(TemporalTests.class);

    protected void clickHeaderLinks() {
        log.info("open page, click all upper links, logout");

        homePage = homePage.clickLinkHomePage();

        FillForm fillForm = homePage.clickLinkFillForm();

        FilledForms filledForms = fillForm.clickLinkFilledForms();

        homePage.clickButtonLogOut();
    }

    protected void clickSideMenu() {
        log.info("open page, click Fill Form upper link, click all side menus");

        FillForm fillForm = homePage.clickLinkFillForm();

        PersonalDetails personalDetails = fillForm.clickMenuPersonalDetails();

        Wage wage = personalDetails.clickMenuWage();

        RealEstate realEstate = wage.clickMenuRealEstate();

        Various various = realEstate.clickMenuVarious();

        Vehicle vehicle = various.clickMenuVehicle();

        SendForm sendForm = vehicle.clickMenuSendForm();

    }

    protected void clickNextPreviousButtons() {
        log.info("open page, click Fill Form upper link, cycle with Next / Previous buttons");

        homePage.clickLinkFillForm();

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

        FillForm fillForm = homePage.clickLinkFillForm();

        PersonalDetails personalDetails = fillForm.clickMenuPersonalDetails();

        // check all checkboxes
        personalDetails = personalDetails.checkAgreement();
        personalDetails = personalDetails.checkCanSendEmail();
        personalDetails = personalDetails.checkHaveSpouse();
        personalDetails = personalDetails.checkSpouseIsraeli();

        // uncheck agreement
        personalDetails = personalDetails.uncheckAgreement();

        personalDetails = personalDetails.enterIdentity("123456789");
        personalDetails = personalDetails.enterLastName("Gindin");
        personalDetails.chooseMaritalStatusWidow();
        String maritalStatus = personalDetails.getChoosenMaritalStatus();
        System.out.println("Marital status Widow: " + maritalStatus);
        personalDetails.chooseMaritalStatusDivorced();

        personalDetails = personalDetails.enterCellular("0523798168");
        maritalStatus = personalDetails.getChoosenMaritalStatus();
        System.out.println("Marital status Divorced: " + maritalStatus);

        personalDetails.chooseNumOfChildren(0);
        String numOfChildren = personalDetails.getChoosenNumberOfChildren();
        System.out.println("Number of children 0: " + numOfChildren);
        personalDetails.chooseNumOfChildren(3);
        numOfChildren = personalDetails.getChoosenNumberOfChildren();
        System.out.println("Number of children 3: " + numOfChildren);
        personalDetails.chooseNumOfChildren(19);
        numOfChildren = personalDetails.getChoosenNumberOfChildren();
        System.out.println("Number of children 19: " + numOfChildren);
        personalDetails.chooseRegisteredSelectionSpouse();
        String registeredSelection = personalDetails.getChoosenRegisterySelection();
        System.out.println("Choosen registered selection Spouse: " + registeredSelection);

        personalDetails = personalDetails.enterSpouseBirthYear("1923");

    }

}
