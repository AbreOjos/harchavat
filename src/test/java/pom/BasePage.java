package pom;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.forms.*;
import pom.forms.vehicles.Vehicle;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.clickElementWithJavaScript;
import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static utils.helpers.Waits.fluentWaitElementClickable;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

    // == PRIVATE FIELDS (web-elements) ==

    // == header elements ==
    @FindBy(xpath = "//*[@id='layersContainer']//a[@id='signOut']")
    private WebElement btnLogout;

    // side menu
    @FindBy(xpath = "(//*[@class='side-menu']/div)[1]")
    private WebElement menuPersonalDetails;
    @FindBy(xpath = "(//*[@class='side-menu']/div)[2]")
    private WebElement menuVehicle;
    @FindBy(xpath = "(//*[@class='side-menu']/div)[3]")
    private WebElement menuWage;
    @FindBy(xpath = "(//*[@class='side-menu']/div)[4]")
    private WebElement menuRealEstate;
    @FindBy(xpath = "(//*[@class='side-menu']/div)[5]")
    private WebElement menuVarious;
    @FindBy(xpath = "(//*[@class='side-menu']/div)[6]")
    private WebElement menuSendForm;

    // buttons
    @FindBy(xpath = "//i[contains(text(),'print')]/ancestor::button")
    private WebElement btnPrint;
    @FindBy(xpath = "//i[contains(text(),'save')]/ancestor::button")
    private WebElement btnSave;
    @FindBy(xpath = "//i[contains(., 'chevron_left')]")
    private WebElement btnContinue;
    @FindBy(xpath = "//i[contains(., 'chevron_right')]")
    private WebElement btnReturn;

    // yes-no boxes
    @FindBy(xpath = "//*[@class='yes-no-box']")
    protected List<WebElement> yesNoBoxes;

    // drop-down
    @FindBy(xpath = "//*[contains(@class,'menuable__content__active')]//*[@role='listitem']")
    protected List<WebElement> dropDownListItemsActive;

    // sub-pages common web-elements
    @FindBy(xpath = "//button[@value='true']")
    private WebElement btnHave;
    @FindBy(xpath = "//button[@value='false']")
    private WebElement btnDontHave;
    @FindBy(xpath = "//span[contains(., 'delete')]")
    private List<WebElement> btnsDelete;
    @FindBy(xpath = "//div[@class='add-item w-inline-block']//img")
    private WebElement btnAdd;

    // == getters ==
    public WebElement getBtnLogout() {
        return btnLogout;
    }

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

    public List<WebElement> getDropDownListItemsActive() {
        return dropDownListItemsActive;
    }

    public WebElement getBtnContinue() {
        return btnContinue;
    }

    public WebElement getBtnReturn() {
        return btnReturn;
    }

    public WebElement getBtnSave() {
        return btnSave;
    }

    public WebElement getBtnPrint() {
        return btnPrint;
    }

    public WebElement getBtnHave() {
        return btnHave;
    }

    public WebElement getBtnDontHave() {
        return btnDontHave;
    }

    public List<WebElement> getBtnsDelete() {
        return btnsDelete;
    }

    public WebElement getBtnAdd() {
        return btnAdd;
    }


    // == public methods ==
    public void clickButtonLogOut() {
        btnLogout.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickBtnPrint() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnPrint);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickBtnSave() {
        fluentWaitElementClickable(driver, btnSave, 10);
        btnSave.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickBtnContinue() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnContinue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickBtnReturn() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnReturn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // == protected methods ==
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

    protected void clickDropDownList(WebElement list, int option) {
        clickElementWithJavaScript(driver, list);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PageFactory.initElements(driver, this);

        dropDownListItemsActive.get(option).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PageFactory.initElements(driver, this);
    }

    protected void fillFormField(WebElement field, String text) {
        fluentWaitElementClickable(driver, field, 10);
        field.sendKeys(text);
    }

    protected void chooseHave() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnHave);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void chooseDontHave() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnDontHave);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void delete(int index) {
        if (btnsDelete.isEmpty()) {
            throw new WrongArgumentException(String.format("Impossible to delete a vehicle #%d," +
                    "the list of vehicles is empty", index));
        } else if (index == 0) {
            throw new WrongArgumentException(String.format("Impossible to delete a vehicle #%d", index));
        } else if (index<0 || index> btnsDelete.size()) {
            throw new WrongArgumentException(String.format("Impossible to delete a vehicle #%d. " +
                    "The number need to be between 1 and %d inclusive", index, btnsDelete.size()));
        }

        btnsDelete.get(index-1).click();
    }

    protected void add() {
        btnAdd.click();
    }

}
