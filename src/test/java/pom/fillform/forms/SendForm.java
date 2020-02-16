package pom.fillform.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.fillform.FillForm;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;

public class SendForm extends FillForm {

    // == constructors==
    public SendForm(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

    // == web-elements ==
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    // == getters ==
    public WebElement getBtnSubmit() {
        return btnSubmit;
    }

    // == pubic methods ==
    public void clickBtnSubmit() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnSubmit);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
