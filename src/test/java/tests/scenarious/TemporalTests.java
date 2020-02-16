package tests.scenarious;

import org.apache.log4j.Logger;
import pom.filledforms.FilledForms;
import pom.fillform.FillForm;
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

}
