package pom.forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.BasePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static constants.BaseConstants.checkCircleIconSubElementMenu;
import static constants.BaseConstants.errorIconSubElementMenu;
import static constants.SendFormConstants.*;

public class SendForm extends BasePage {

    // == constructors==
    public SendForm(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(this.driver, this);
    }

    // == web-elements ==
    @FindBy(xpath = "(//*[@class='info-box'])[1]")
    private WebElement infoBoxPersonalDetails;
    @FindBy(xpath = "(//*[@class='info-box'])[2]")
    private WebElement infoBoxVehicles;
    @FindBy(xpath = "(//*[@class='info-box'])[3]")
    private WebElement infoBoxWages;
    @FindBy(xpath = "(//*[@class='info-box'])[4]")
    private WebElement infoBoxRealEstate;
    @FindBy(xpath = "(//*[@class='info-box'])[5]")
    private WebElement infoBoxVarious;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    // == getters ==
    public WebElement getBtnSubmit() {
        return btnSubmit;
    }

    // == pubic methods ==

    // menu icons
    public List<WebElement> getErrorIconMenu() {
        return getMenuSendForm().findElements(errorIconSubElementMenu);
    }

    public List<WebElement> getCheckCircleIconMenu() {
        return getMenuSendForm().findElements(checkCircleIconSubElementMenu);
    }

    // methods info-box Personal Details
    public boolean emailContains(String email) {
        return infoBoxPersonalDetails
                .findElement(emailSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(email);
    }

    public boolean landlinesPhoneContains(String landlinesPhone) {
        return infoBoxPersonalDetails
                .findElement(landlinesPhoneSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(landlinesPhone);
    }

    public boolean cellularPhoneContains(String cellularPhone) {
        return infoBoxPersonalDetails
                .findElement(cellularPhoneSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(cellularPhone);
    }

    public boolean idContains(String id) {
        return infoBoxPersonalDetails
                .findElement(idSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(id);
    }

    public boolean familyNameContains(String familyName) {
        return infoBoxPersonalDetails
                .findElement(familyNameSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(familyName);
    }

    public boolean firstNameContains(String firstName) {
        return infoBoxPersonalDetails
                .findElement(firstNameSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(firstName);
    }

    public boolean israelCitizenContains(String israelCitizen) {
        return infoBoxPersonalDetails
                .findElement(israelCitizenSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(israelCitizen);
    }

    public boolean disclaimerContains(String disclaimer) {
        return infoBoxPersonalDetails
                .findElement(disclaimerSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(disclaimer);
    }

    public boolean martialStatusContains(String martialStatus) {
        return infoBoxPersonalDetails
                .findElement(martialStatusSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(martialStatus);
    }

    public boolean spouseCountryContains(String spouseCountry) {
        return infoBoxPersonalDetails
                .findElement(spouseCountryAndStateSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(spouseCountry);
    }

    public boolean spouseIsraelCitizenContains(String spouseIsraelCitizen) {
        return infoBoxPersonalDetails
                .findElement(spouseIsraelCitizenSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(spouseIsraelCitizen);
    }

    public boolean spouseIdContains(String spouseId) {
        return infoBoxPersonalDetails
                .findElement(spouseIdSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(spouseId);
    }

    public boolean spousePassportContains(String spousePassport) {
        return infoBoxPersonalDetails
                .findElement(spousePassportSubElementInfoBoxPersonalDetails)
                .getText().trim()
                .contains(spousePassport);
    }


    public void clickBtnSubmit() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, btnSubmit);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
