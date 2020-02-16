package pom.fillform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

public class FillForm extends BasePage {

    // == constructors==
    public FillForm(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }
}
