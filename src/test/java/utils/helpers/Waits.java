package utils.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.time.Duration;

public class Waits {

    // == constructors ==
    private Waits() {
    }

    // == static methods ==

    /**
     * Fluent wait for presents of element
     *
     * @param driver web-driver
     * @param by     element locator
     * @deprecated This method will be removed in near future. Use same method from automation.tests.infra.helpers.waits.Waits instead
     */
    @Deprecated
    public static void fluentWaitElementExists(WebDriver driver, By by) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * Fluent wait for element to be clickable.
     *
     * @param driver web-driver
     * @param by     element locator
     * @deprecated This method will be removed in near future. Use same method from automation.tests.infra.helpers.waits.Waits instead
     */
    @Deprecated
    public static void fluentWaitElementClickable(WebDriver driver, By by) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Fluent wait for element to be clickable.
     *
     * @param driver     web-driver
     * @param webElement web-element
     * @deprecated This method will be removed in near future. Use same method from automation.tests.infra.helpers.waits.Waits instead
     */
    @Deprecated
    public static void fluentWaitElementClickable(WebDriver driver, WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Fluent wait until element found
     *
     * @param driver web-driver
     * @param by element locator
     * @deprecated This method will be removed in near future. Use same method from automation.tests.infra.helpers.waits.Waits instead
     */
    @Deprecated
    public static void fluentWaitExpectedCondition(WebDriver driver, By by) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(600))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        wait.until(drvr -> drvr.findElement(by));
    }

    public static void fluentWaitElementClickable(WebDriver driver, WebElement webElement, long maxTimeOutSeconds) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(maxTimeOutSeconds))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void fluentWaitFileDownload(WebDriver driver, File file, long maxTimeOutSeconds) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(maxTimeOutSeconds))
                .pollingEvery(Duration.ofMillis(200));

        wait.until((drvr) -> file.exists());
    }

    public static void fluentWaitFileDownload(WebDriver driver, String filename, long maxTimeOutSeconds) {
        File file = new File(filename);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(maxTimeOutSeconds))
                .pollingEvery(Duration.ofMillis(200));

        wait.until((drvr) -> file.exists());
    }

}
