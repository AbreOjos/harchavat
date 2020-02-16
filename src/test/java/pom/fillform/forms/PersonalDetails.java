package pom.fillform.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.fillform.FillForm;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;

public class PersonalDetails extends FillForm {

    // == constructors==
    public PersonalDetails(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

    // == public methods ==

}

