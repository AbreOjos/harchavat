package utils.helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.focusElement;
import static automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors.scrollElementIntoView;

public class ActionsHelper {

    private ActionsHelper() { }

    /**
     * Clear element (for using instead of Selenium clear() method)
     *
     * @param driver web-driver
     * @param webElement web-element need to be cleared
     */
    public static void clear(WebDriver driver, WebElement webElement) {

        org.openqa.selenium.interactions.Actions navigator = new org.openqa.selenium.interactions.Actions(driver);
        navigator.click(webElement)
//                .keyDown(Keys.CONTROL).keyDown(Keys.LEFT_SHIFT)
//                .keyUp(Keys.CONTROL).keyUp(Keys.LEFT_SHIFT)
                .keyDown(Keys.CONTROL).sendKeys(Keys.HOME)
//                .keyUp(Keys.CONTROL)
                .keyDown(Keys.LEFT_SHIFT).sendKeys(Keys.END)
                .keyUp(Keys.CONTROL).keyUp(Keys.LEFT_SHIFT)
//                .sendKeys(Keys.DELETE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .perform();

//        navigator.moveToElement(webElement)
//                .clickAndHold().sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.LEFT_SHIFT))
//                .pause(500)
//                .release()
//                .clickAndHold().sendKeys(Keys.chord(Keys.CONTROL, "a"))
//                .moveByOffset(1, 1)
//                .pause(1000)
//                .release()
//                .sendKeys(Keys.BACK_SPACE)
//                .build()
//                .perform();

//        int textLength = webElement.getAttribute("value").length();
//        while (textLength > 0) {
//            navigator.click(webElement)
//                    .clickAndHold().sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.HOME))
//                    .release()
//                    .sendKeys(Keys.DELETE)
////                    .sendKeys("")
//                    .perform();
//
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            textLength--;

//            textLength = webElement.getAttribute("value").length();
//        }

//        webElement.sendKeys("");
//
//        navigator.click(webElement)
//                .clickAndHold().sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.END))
//                .release()
//                .sendKeys(Keys.BACK_SPACE)
////                .sendKeys("")
//                .perform();
//
//        textLength = webElement.getAttribute("value").length();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }


    /**
     * Scrolling a Web Element into view
     * move focus to the Web element
     * and click the Web Element
     *
     * @param driver webdriver
     * @param webElement webelement need to be clicked
     * @throws InterruptedException standard exception
     * @deprecated This method will be removed in near future. Use same method from automation.tests.infra.helpers.javascripthelpers.JavascriptExecutors instead
     */
    @Deprecated
    public static void scrollIntoViewMoveFocusAndClick(WebDriver driver, WebElement webElement) throws InterruptedException {
        scrollElementIntoView(driver, webElement);
        focusElement(driver, webElement);
        webElement.click();
        Thread.sleep(500);
    }

    /**
     * Get text from a Web Element and trim
     *
     * @param webElement web element that contains a text
     * @return text from the web element
     */
    public static String getTextContentFromWebElementAndTrim(WebElement webElement) {
        return webElement.getAttribute("textContent").trim();
    }


    /**
     * Get text from list web elements and store into list of strings
     * (example: get every Case Numbers on page)
     *
     * @param webElementList list of web elements
     * @return list of strings with text from web elements
     */
    public static List<String> getTextFromWebElementsList(List<WebElement> webElementList) {
        return webElementList.stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * get text content from WebElements in list
     * and trim it
     *
     * @param webElements -- list web-elements
     * @return -- new list contains values of attribute
     */
    public static List<String> getAttributeTextContentFromWebElementsListAndTrim(List<WebElement> webElements) {

        return webElements.stream()
                .map(we -> we.getAttribute("textContent").trim())
                .collect(Collectors.toList());
    }

    /**
     * Click every web element from a list
     * (example: open every expanded panel on Represents page)
     *
     *
     * @param driver
     * @param webElementList list of web elements for clicking
     * @throws InterruptedException standard exception
     */
    public static void clickEveryElementInList(WebDriver driver, List<WebElement> webElementList) throws InterruptedException {
        for (WebElement webElement : webElementList) {
            scrollElementIntoView(driver, webElement);
            webElement.click();

            Thread.sleep(500);

//            // wait while text "wait" disappeared
//            wait.until(ExpectedConditions.not(
//                    CreateExpectedConditions.textPresentedInPageSource(
//                            driver.getPageSource(), WAIT_FEW_SECONDS
//                    )
//            ));

        }
    }
}
