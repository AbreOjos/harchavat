package utils.utilitiesForInfra;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.*;

public class JavaScriptHelpersHarchavat {

//    /**
//     *
//     * @param driver web-driver
//     * @param webElement web-element that need to be clicked
//     * @deprecated This method will be removed in near future. Use same method from JavascriptExecutors instead.
//     */
//    @Deprecated
//    public static void clickElementWithJavaScript(WebDriver driver, WebElement webElement) {
//        JavascriptExecutor executor =
//                (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", webElement);
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    /**
//     *
//     * @param driver  web-driver
//     * @param webElement web-element that need to be moved into ficus
//     * @throws InterruptedException standard exception
//     * @deprecated This method will be removed in near future. Use same method from JavascriptExecutors instead.
//     */
//    @Deprecated
//    public static void focusElement(WebDriver driver, WebElement webElement) throws InterruptedException {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", webElement);
//        Thread.sleep(500);
//    }


    /**
     * send text to an element (in case 'unreachable' and so on )
     *
     * @param driver web-driver
     * @param webElement web-element that need to get a text
     * @param text text that need to be send to web-element
     */
    public static void sendText(WebDriver driver, WebElement webElement, String text) {
        String command = String.format("arguments[0].value='%s';", text);
        ((JavascriptExecutor) driver).executeScript(command, webElement);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Scroll an element into a focus and click
     *
     * @param driver web-driver
     * @param webElement web-element that need to be clicked
     * @throws InterruptedException if something goes wrong
     */
    public static void scrollIntoViewMoveFocusAndClickWithJavaScript(WebDriver driver, WebElement webElement)
            throws InterruptedException {
        scrollElementIntoView(driver, webElement);
        focusElement(driver, webElement);
        clickElementWithJavaScript(driver, webElement);
        Thread.sleep(500);
    }

    public static int getDownloadPercentageChrome(WebDriver driver) {

        driver.get("chrome://downloads");

        return (int) ((JavascriptExecutor) driver).executeScript(
                "return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#progress').value"
        );
    }

}
