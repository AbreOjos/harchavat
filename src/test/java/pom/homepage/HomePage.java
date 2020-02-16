package pom.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

public class HomePage extends BasePage {

    // == constructors==
    public HomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }
}
