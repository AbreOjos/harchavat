package pom;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.forms.PersonalDetails;
import pom.forms.realestates.RealEstate;
import pom.forms.sendform.SendForm;
import pom.forms.various.Various;
import pom.forms.vehicles.Vehicle;
import pom.forms.wages.Wage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.*;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.*;
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
    @FindBy(xpath = "//h2[@class='heading']")
    private WebElement header;
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
    @FindBy(xpath = "//i[contains(text(),'picture_as_pdf')]/ancestor::button")
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
    private List<WebElement> btnAdd;
    @FindBy(xpath = "//div[@class='v-btn__content']//input[@type='file']")
    private WebElement attachFileInput;


    // == getters ==
    public WebElement getHeader() {
        return header;
    }

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

    public WebElement getBtnAddWage() {
        return btnAdd.get(btnAdd.size()-1);
    }


    // == public methods ==
    public String getHeaderText() {
        return header.getText().trim();
    }

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

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
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
        field.click();
        field.sendKeys(text);

        PageFactory.initElements(driver, this);
    }

    protected void cleanFormField(WebElement field) {
        clear(driver, field);

        PageFactory.initElements(driver, this);
    }

    protected void chooseHave() {

        chooseHave(btnHave);
    }

    protected void chooseHave(WebElement btnHave) {
        if (elementHasClass(btnHave, "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, btnHave);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseDontHave() {

        chooseDontHave(btnDontHave);
    }

    protected void chooseDontHave(WebElement btnDontHave) {
        if (elementHasClass(btnDontHave, "active"))
            return;

        try {
            scrollIntoViewMoveFocusAndClick(driver, btnDontHave);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void deletePanel(int index) {

        deletePanel(index, getBtnsDelete());
    }

    protected void deletePanel(int index, List<WebElement> listBtnDelete) {
        if (listBtnDelete.isEmpty()) {
            throw new WrongArgumentException(String.format("Impossible to deletePanel a panel #%d," +
                    "the list of panels is empty", index));
        } else if (index == 0) {
            throw new WrongArgumentException(String.format("Impossible to deletePanel a panel #%d", index));
        } else if (index<0 || index> listBtnDelete.size()) {
            throw new WrongArgumentException(String.format("Impossible to deletePanel a vehicle #%d. " +
                    "The number need to be between 1 and %d inclusive", index, listBtnDelete.size()));
        }

        listBtnDelete.get(index-1).click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void deleteAllPanels() {
        for (WebElement btn : btnsDelete) {
            btn.click();
            fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
        }
    }

    protected void addPanel() {
//        getBtnAdd().click();
//
//        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        addPanel(getBtnAddWage());
    }

    protected void addPanel(WebElement btnAdd) {
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

    protected String selectItemFromDropDownListByIndex(WebElement dropDown, int index) {

        clickElementWithJavaScript(driver, dropDown);

        List<WebElement> dropDownListsItems = getDropDownListsItems();

        if (index < 0 || index >= dropDownListsItems.size())
            throw new IllegalArgumentException(String.format("Index of an element in a drop-down list must be between 0 and %d not inclusive",
                    dropDownListsItems.size()));

        // create list items from drop-down menu
        List<String> listItems = dropDownListsItems.stream().
                map(WebElement::getText).map(String::trim).collect(Collectors.toList());

        dropDownListsItems.get(index).click();

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(this.driver, this);

        return listItems.get(index);
    }

    protected WebElement getDropDownCity(WebElement details) {
        return details.findElement(dropDownCitySubElementDetails);
    }

    protected WebElement getDropDownStreet(WebElement details) {
        return details.findElement(dropDownStreetSubElementDetails);
    }

    protected WebElement getTxtCity(WebElement details) {
        return details.findElement(txtCitySubElementDetail);
    }

    protected WebElement getTxtState(WebElement details) {
        return details.findElement(txtStateSubElementDetails);
    }

    protected WebElement getTxtStreet(WebElement details) {
        return details.findElement(txtStreetSubElementDetails);
    }

    protected WebElement getTxtHouseNum(WebElement details) {
        return details.findElement(txtHouseNumSubElementDetails);
    }

    protected List<WebElement> getDropDownListsItems() {
        return driver.findElements(dropDownListItems);
    }

    protected boolean subElementContainsText(WebElement details, String text) {
        return details.getText().contains(text);
    }

    public void attachFile(String filename) {
        attachFileInput.sendKeys(filename);

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);

        PageFactory.initElements(this.driver, this);
    }

    // check if an element contains a specific class
    protected boolean elementHasClass(WebElement element, String active) {
        return Arrays.asList(element.getAttribute("class").split(" ")).contains(active);
    }

    protected <T> void checkNumber(int number, String panel, Map<Integer, T> integerDetailsMap) {
        if (number<0 || number>=integerDetailsMap.size()) {
            String IMPOSSIBLE_ADD_DETAILS =
                    String.format("Impossible to add details for a %s ", panel)
                            + "#%d. The number need to be between 0 and %d not inclusive";
            throw new WrongArgumentException(String.format(IMPOSSIBLE_ADD_DETAILS, number, integerDetailsMap.size()));
        }
    }

    protected <T> void checkNumber(int number, String sendForm, String panel, Map<Integer, T> integerDetailsMap) {
        if (number<0 || number>=integerDetailsMap.size()) {
            String IMPOSSIBLE_GET_DETAILS =
                    String.format("Impossible to get %s from a %s ", sendForm, panel)
                            + "#%d. The number need to be between 0 and %d not inclusive";
            throw new WrongArgumentException(String.format(IMPOSSIBLE_GET_DETAILS, number, integerDetailsMap.size()));
        }
    }

    protected <T> void checkNumber(int number, String subPanel, List<T> listDetails) {
        if (number<0 || number>=listDetails.size()) {
            String IMPOSSIBLE_GET_DETAILS =
                    String.format("Impossible to get details about a %s ", subPanel)
                            + "#%d. The number need to be between 0 and %d not inclusive";
            throw new WrongArgumentException(String.format(IMPOSSIBLE_GET_DETAILS, number, listDetails.size()));
        }
    }

}
