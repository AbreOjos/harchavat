package pom.fillform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;
import pom.fillform.forms.*;
import pom.homepage.HomePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;

public class FillForm extends BasePage {

    // == constructors==
    public FillForm(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

    protected FillForm() {
    }


    // == FIELDS (web-elements) ==

    // side menu
    @FindBy(xpath = "(//*[@class='side-menu']/div)[1]")
    private WebElement menuPersonalDetails;
    @FindBy(xpath = "(//*[@class='side-menu']/div)[2]")
    private WebElement menuWage;
    @FindBy(xpath = "(//*[@class='side-menu']/div)[3]")
    private WebElement menuRealEstate;
    @FindBy(xpath = "(//*[@class='side-menu']/div)[4]")
    private WebElement menuVarious;
    @FindBy(xpath = "(//*[@class='side-menu']/div)[5]")
    private WebElement menuVehicle;
    @FindBy(xpath = "(//*[@class='side-menu']/div)[6]")
    private WebElement menuSendForm;

    // buttons
    @FindBy(xpath = "//a[@class='btn light left w-button']")
    private WebElement btnContinue;
    @FindBy(xpath = "//a[@class='btn light right w-button']")
    private WebElement btnReturn;

    // yes-no boxes
    @FindBy(xpath = "//*[@class='yes-no-box']")
    protected List<WebElement> yesNoBoxes;


    // == getters ==
    public WebElement getMenuPersonalDetails() {
        return menuPersonalDetails;
    }

    public WebElement getMenuWage() {
        return menuWage;
    }

    public WebElement getMenuRealEstate() {
        return menuRealEstate;
    }

    public WebElement getMenuVarious() {
        return menuVarious;
    }

    public WebElement getMenuVehicle() {
        return menuVehicle;
    }

    public WebElement getMenuSendForm() {
        return menuSendForm;
    }

    public WebElement getBtnContinue() {
        return btnContinue;
    }

    public WebElement getBtnReturn() {
        return btnReturn;
    }


    // == public methods ==
    public PersonalDetails clickMenuPersonalDetails() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuPersonalDetails);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new PersonalDetails(driver);
    }

    public Wage clickMenuWage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuWage);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Wage(driver);
    }

    public RealEstate clickMenuRealEstate() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuRealEstate);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new RealEstate(driver);
    }

    public Various clickMenuVarious() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuVarious);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Various(driver);
    }

    public Vehicle clickMenuVehicle() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuVehicle);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Vehicle(driver);
    }

    public SendForm clickMenuSendForm() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuSendForm);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new SendForm(driver);
    }

    public void clickBtnContinue() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnContinue);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickBtnReturn() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnReturn);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
