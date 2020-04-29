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

    protected void enterAmountUsed(String amountUsed) {
        fillFormField(getTxtAmountUsed(), amountUsed);
    }

    protected void deleteAmountUsed() {
        cleanFormField(getTxtAmountUsed());
    }

    protected void enterUsedValue(String usedValue) {
        fillFormField(getTxtUsedValue(), usedValue);
    }

    protected void deleteUsedValue() {
        cleanFormField(getTxtUsedValue());
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

    private WebElement getTxtAmountUsed() {
        return details.findElement(txtAmountUsedSubElementDigitalCoinsDetails);
    }

    private WebElement getTxtUsedValue() {
        return details.findElement(txtUsedValueSubElementDigitalCoinsDetails);
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

    protected List<WebElement> getNeedFillHowManyCoinsUsedErrorMessage() {
        return details.findElements(errorMessageNeedFillHowManyCoinsUsedSubElementDetails);
    }

    protected List<WebElement> getNeedFillTotalUsedValueErrorMessage() {
        return details.findElements(errorMessageNeedFillTotalUsedValueSubElementDetails);
    }

    protected List<WebElement> getNumberOfCoinsDigitsOnlyErrorMessage() {
        return details.findElements(errorMessageNumberOfCoinsDigitsOnlySubElementDetails);
    }

    protected List<WebElement> getNumberOfCoinsThirtyCharsMaxErrorMessage() {
        return details.findElements(errorMessageNumberOfCoinsThirtyCharsMaxSubElementDetails);
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

    protected List<WebElement> getHowManyCoinsUsedDigitsOnlyErrorMessage() {
        return details.findElements(errorMessageHowManyCoinsUsedDigitsOnlySubElementDetails);
    }

    protected List<WebElement> getHowManyCoinsUsedThirtyCharsMaxErrorMessage() {
        return details.findElements(errorMessageHowManyCoinsUsedThirtyCharsMaxSubElementDetails);
    }

    protected List<WebElement> getTotalUsedTwentyCharsMaxErrorMessage() {
        return details.findElements(errorMessageTotalUsedTwentyCharsMaxSubElementDetails);
    }

}
