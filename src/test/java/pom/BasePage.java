package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.filledforms.FilledForms;
import pom.fillform.FillForm;
import pom.homepage.HomePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.clickElementWithJavaScript;
import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;

public abstract class BasePage {

    protected WebDriver driver;

    // == PRIVATE FIELDS (web-elements) ==

    // == header elements ==
    @FindBy(xpath = "//*[@id='layersContainer']//a[@href='#/']")
    private WebElement linkHomePage;
    @FindBy(xpath = "//*[@id='layersContainer']//a[@href='#/fillform']")
    private WebElement linkFillForm;
    @FindBy(xpath = "//*[@id='layersContainer']//a[@href='#/filledforms']")
    private WebElement linkFilledForms;
    @FindBy(xpath = "//*[@id='layersContainer']//a[@id='signOut']")
    private WebElement btnLogout;

    // drop-down
    @FindBy(xpath = "//*[contains(@class,'menuable__content__active')]//*[@role='listitem']")
    protected List<WebElement> dropDownListItemsActive;

    // == getters ==
    public WebElement getLinkHomePage() {
        return linkHomePage;
    }

    public WebElement getLinkFillForm() {
        return linkFillForm;
    }

    public WebElement getLinkFilledForms() {
        return linkFilledForms;
    }

    public WebElement getBtnLogout() {
        return btnLogout;
    }

    // == public methods ==
    public HomePage clickLinkHomePage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, linkHomePage);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new HomePage(driver);
    }

    public FillForm clickLinkFillForm() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, linkFillForm);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new FillForm(driver);
    }

    public FilledForms clickLinkFilledForms() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, linkFilledForms);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new FilledForms(driver);
    }

    public void clickButtonLogOut() {
        btnLogout.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // == protected methods ==
    protected void clickDropDownList(WebElement list, int option) {
        clickElementWithJavaScript(driver, list);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PageFactory.initElements(driver, this);

//        clickElementWithJavaScript(driver, dropDownListItemsActive.get(option));
        dropDownListItemsActive.get(option).click();

        PageFactory.initElements(driver, this);
    }


}
