package pom.forms.various;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.List;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollIntoViewMoveFocusAndClick;
import static automation.tests.infra.helpers.waits.Waits.fluentWaitElementExists;
import static constants.BaseConstants.waitFewSecondsWarningDisabled;
import static constants.VariousConstants.*;

public class DigitalCoinsDetails extends BasePage {

    private final WebElement details;

    public DigitalCoinsDetails(WebDriver driver, WebElement details) {
        super(driver);
        this.details = details;
    }

    // == protected methods ==
    // choose digital coin type
    protected void chooseBitcoin() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnBitcoin());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseNano() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnNano());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseSteem() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnSteem());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseCardano() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnCardano());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseAnotherCoin() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnAnotherCoin());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void enterAnotherCoin(String anotherCoinName) {
        fillFormField(getTxtAnotherCoin(), anotherCoinName);
    }

    protected void deleteAnotherCoin() {
        cleanFormField(getTxtAnotherCoin());
    }

    protected void enterCoinAmount(String anotherCoinName) {
        fillFormField(getTxtCoinAmount(), anotherCoinName);
    }

    protected void deleteCoinAmount() {
        cleanFormField(getTxtCoinAmount());
    }

    protected void enterPublicKey(String publicKey) {
        fillFormField(getTxtPublicKey(), publicKey);
    }

    protected void deletePublicKey() {
        cleanFormField(getTxtPublicKey());
    }

    protected void chooseCoinsMaterialized() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnCoinsMaterialized());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseCoinsDontMaterialized() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnCoinsDontMaterialized());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void enterAmountMaterialized(String amountMaterialized) {
        fillFormField(getTxtAmountMaterialized(), amountMaterialized);
    }

    protected void deleteAmountMaterialized() {
        cleanFormField(getTxtAmountMaterialized());
    }

    protected void enterMaterializationValue(String materializationValue) {
        fillFormField(getTxtMaterializationValue(), materializationValue);
    }

    protected void deleteMaterializationValue() {
        cleanFormField(getTxtMaterializationValue());
    }

    protected void choosePurchasedWithCoins() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnPurchasedWithCoins());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void chooseDontPurchasedWithCoins() {
        try {
            scrollIntoViewMoveFocusAndClick(driver, getBtnDontPurchasedWithCoins());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fluentWaitElementExists(driver, waitFewSecondsWarningDisabled);
    }

    protected void enterAmountSold(String amountSold) {
        fillFormField(getTxtAmountSold(), amountSold);
    }

    protected void deleteAmountSold() {
        cleanFormField(getTxtAmountSold());
    }

    protected void enterSoldValue(String soldValue) {
        fillFormField(getTxtSoldValue(), soldValue);
    }

    protected void deleteSoldValue() {
        cleanFormField(getTxtSoldValue());
    }



    // == private methods ==
    // coins types
    private WebElement getBtnBitcoin() {
        return details.findElements(btnsTypeOfIncomeSubElementDigitalCoinsDetails).get(0);
    }

    private WebElement getBtnNano() {
        return details.findElements(btnsTypeOfIncomeSubElementDigitalCoinsDetails).get(1);
    }

    private WebElement getBtnSteem() {
        return details.findElements(btnsTypeOfIncomeSubElementDigitalCoinsDetails).get(2);
    }

    private WebElement getBtnCardano() {
        return details.findElements(btnsTypeOfIncomeSubElementDigitalCoinsDetails).get(3);
    }

    private WebElement getBtnAnotherCoin() {
        return details.findElements(btnsTypeOfIncomeSubElementDigitalCoinsDetails).get(4);
    }

    private WebElement getTxtAnotherCoin() {
        return details.findElement(txtAnotherCoinSubElementDigitalCoinsDetails);
    }

    private WebElement getTxtCoinAmount() {
        return details.findElement(txtCoinAmountSubElementDigitalCoinsDetails);
    }

    private WebElement getTxtPublicKey() {
        return details.findElement(txtPublicKeySubElementDigitalCoinsDetails);
    }

    private WebElement getBtnCoinsMaterialized() {
        return details.findElement(btnCoinsMaterializedSubElementDigitalCoinsDetails);
    }

    private WebElement getBtnCoinsDontMaterialized() {
        return details.findElement(btnCoinsDontMaterializedSubElementDigitalCoinsDetails);
    }

    private WebElement getTxtAmountMaterialized() {
        return details.findElement(txtAmountMaterializedSubElementDigitalCoinsDetails);
    }

    private WebElement getTxtMaterializationValue() {
        return details.findElement(txtMaterializationValueSubElementDigitalCoinsDetails);
    }

    private WebElement getBtnPurchasedWithCoins() {
        return details.findElement(btnPurchasedWithCoinsSubElementDigitalCoinsDetails);
    }

    private WebElement getBtnDontPurchasedWithCoins() {
        return details.findElement(btnDontPurchasedWithCoinsSubElementDigitalCoinsDetails);
    }

    private WebElement getTxtAmountSold() {
        return details.findElement(txtAmountSoldSubElementDigitalCoinsDetails);
    }

    private WebElement getTxtSoldValue() {
        return details.findElement(txtSoldValueSubElementDigitalCoinsDetails);
    }

    // digital coins errors
    protected List<WebElement> getNeedFillCoinTypeErrorMessage() {
        return details.findElements(errorMessageNeedFillCoinTypeSubElementDetails);
    }

    protected List<WebElement> getNeedFillAnotherCoinErrorMessage() {
        return details.findElements(errorMessageNeedFillAnotherCoinSubElementDetails);
    }

    protected List<WebElement> getNeedFillNumberOfCoinsErrorMessage() {
        return details.findElements(errorMessageNeedFillNumberOfCoinsSubElementDetails);
    }

    protected List<WebElement> getNeedFillPublicKeyDigitalWalletErrorMessage() {
        return details.findElements(errorMessageNeedFillPublicKeyDigitalWalletSubElementDetails);
    }

    protected List<WebElement> getNeedFillDidYouSellCoinsErrorMessage() {
        return details.findElements(errorMessageNeedDidYouSellCoinsSubElementDetails);
    }

    protected List<WebElement> getNeedFillHowManyCoinsSoldErrorMessage() {
        return details.findElements(errorMessageNeedFillHowManyCoinsSoldSubElementDetails);
    }

    protected List<WebElement> getNeedFillTotalSalesErrorMessage() {
        return details.findElements(errorMessageNeedFillTotalSalesSubElementDetails);
    }

    protected List<WebElement> getNeedFillDidYouBuyWithCoinsErrorMessage() {
        return details.findElements(errorMessageNeedFillDidYouBuyWithCoinsSubElementDetails);
    }

    protected List<WebElement> getNeedFillHowMuchCoinsUsedErrorMessage() {
        return details.findElements(errorMessageNeedFillHowMuchCoinsUsedSubElementDetails);
    }

    protected List<WebElement> getNeedFillTotalUsedErrorMessage() {
        return details.findElements(errorMessageNeedFillTotalUsedSubElementDetails);
    }

    protected List<WebElement> getNumberOfCoinsDigitsOnlyErrorMessage() {
        return details.findElements(errorMessageNumberOfCoinsDigitsOnlySubElementDetails);
    }

    protected List<WebElement> getPublicKeyDigitsAndLettersOnlyErrorMessage() {
        return details.findElements(errorMessagePublicKeyDigitsAndLettersOnlySubElementDetails);
    }

    protected List<WebElement> getCoinsSellDigitsOnlyErrorMessage() {
        return details.findElements(errorMessageCoinsSellDigitsOnlySubElementDetails);
    }

    protected List<WebElement> getTotalSalesTwentyCharsMaxErrorMessage() {
        return details.findElements(errorMessageTotalSalesTwentyCharsMaxSubElementDetails);
    }

    protected List<WebElement> getHowMuchCoinsUsedDigitsOnlyErrorMessage() {
        return details.findElements(errorMessageHowMuchCoinsUsedDigitsOnlySubElementDetails);
    }

    protected List<WebElement> getTotalUsedTwentyCharsMaxErrorMessage() {
        return details.findElements(errorMessageTotalUsedTwentyCharsMaxSubElementDetails);
    }

}
