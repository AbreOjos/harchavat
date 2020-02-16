package pom.filledforms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

public class FilledForms extends BasePage {

    // == constructors==
    public FilledForms(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }
}
