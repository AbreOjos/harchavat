package pom;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.forms.PersonalDetails;
import pom.forms.SendForm;
import pom.forms.realestates.RealEstate;
import pom.forms.various.Various;
import pom.forms.vehicles.Vehicle;
import pom.forms.wages.Wage;

import java.util.List;
import java.util.stream.Collectors;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.*;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.waitFewSecondsWarningDisabled;
import static constants.VariousConstants.dropDownListItems;
import static utils.helpers.ActionsHelper.clear;
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
    @FindBy(xpath = "//*[contains(@class, 'yes-no-box')]//button[@value='true']")
    private WebElement btnHave;
    @FindBy(xpath = "//*[contains(@class, 'yes-no-box')]//button[@value='false']")
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
//        try {
//            scrollIntoViewMoveFocusAndClick(driver, btnContinue);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        scrollElementIntoView(driver, btnContinue);

        btnContinue.click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    public void clickBtnReturn() {
//        try {
//            scrollIntoViewMoveFocusAndClick(driver, btnReturn);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        scrollElementIntoView(driver, btnReturn);

        btnReturn.click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    public PersonalDetails clickMenuPersonalDetails() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuPersonalDetails);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        return new PersonalDetails(driver);
    }

    public Wage clickMenuWage() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuWage);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        return new Wage(driver);
    }

    public RealEstate clickMenuRealEstate() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuRealEstate);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        return new RealEstate(driver);
    }

    public Various clickMenuVarious() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuVarious);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        return new Various(driver);
    }

    public Vehicle clickMenuVehicle() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuVehicle);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        return new Vehicle(driver);
    }

    public SendForm clickMenuSendForm() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, menuSendForm);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        return new SendForm(driver);
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

        PageFactory.initElements(driver, this);
    }

    protected void cleanFormField(WebElement field) {
        clear(driver, field);

        PageFactory.initElements(driver, this);
    }

    protected void chooseHave() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnHave);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseDontHave() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnDontHave);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void delete(int index) {
        if (btnsDelete.isEmpty()) {
            throw new WrongArgumentException(String.format("Impossible to delete a panel #%d," +
                    "the list of panels is empty", index));
        } else if (index == 0) {
            throw new WrongArgumentException(String.format("Impossible to delete a panel #%d", index));
        } else if (index<0 || index> btnsDelete.size()) {
            throw new WrongArgumentException(String.format("Impossible to delete a vehicle #%d. " +
                    "The number need to be between 1 and %d inclusive", index, btnsDelete.size()));
        }

        btnsDelete.get(index-1).click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void add() {
        btnAdd.click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void selectItemFromDropDownListByName(WebElement dropDown, String item) {

        clickElementWithJavaScript(driver, dropDown);

        List<WebElement> dropDownListsItems = getDropDownListsItems();

        // create list items from drop-down menu
        List<String> listItems = dropDownListsItems.stream().
                map(WebElement::getText).map(String::trim).collect(Collectors.toList());

        int index = listItems.indexOf(item);

        if (index < 0)
            throw new IllegalArgumentException(String.format("Item '%s' not found in drop-down list", item));

        // find and click Status by index
        dropDownListsItems.get(index).click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(this.driver, this);
    }

    protected List<WebElement> getDropDownListsItems() {
        return driver.findElements(dropDownListItems);
    }

}
