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

}
