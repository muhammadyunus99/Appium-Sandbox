package org.example.utils;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;

public class ElementActions {

    /**
     * Sends keys to an element. It will first try to wait for the element to be visible.
     * If that fails, it will attempt to execute JavaScript to set the value.
     * If that also fails, it will ignore visibility and try one more time.
     *
     * @param locator the By locator used to find the element
     * @param driver  the WebDriver instance
     * @param keys    the keys to send to the element
     */
    public static void type(final By locator, final WebDriver driver, String... keys) {
        try {
            ElementFinder.findElementVisibility(locator, driver).sendKeys(keys);
        } catch (NoSuchElementException e) {
            executeJavaScriptSetValue(locator, driver, keys);
        } catch (Exception e) {
            executeJavaScriptSetValue(locator, driver, keys);
        }
    }

    /**
     * Clicks on an element. It will first try to wait for the element to be visible.
     * If that fails, it will attempt to execute JavaScript to click the element.
     * If that also fails, it will ignore visibility and try one more time.
     *
     * @param locator the By locator used to find the element
     * @param driver  the WebDriver instance
     */
    public static void click(final By locator, final WebDriver driver) {
        try {
            ElementFinder.findElementVisibility(locator, driver).click();
        } catch (ElementClickInterceptedException | NoSuchElementException e) {
            executeJavaScriptClick(locator, driver);
        }
    }

    /**
     * Retrieves the text of an element. It will first try to wait for the element to be visible.
     * If that fails, it will attempt to retrieve the text without waiting for visibility.
     *
     * @param locator the By locator used to find the element
     * @param driver  the WebDriver instance
     * @return the text of the element
     */
    public static String getText(final By locator, final WebDriver driver) {
        try {
            return ElementFinder.findElementVisibility(locator, driver).getText();
        } catch (NoSuchElementException e) {
            return ElementFinder.findElementPresence(locator, driver).getText();
        }
    }

    /**
     * Checks if an element is displayed.
     *
     * @param locator the By locator used to find the element
     * @param driver  the WebDriver instance
     * @return true if the element is displayed, false otherwise
     */
    public static boolean isDisplayed(final By locator, final WebDriver driver) {
        return ElementFinder.findElementVisibility(locator, driver).isDisplayed();
    }

    /**
     * Scrolls to an element using UiScrollable.
     *
     * @param text   the text to locate the element by
     * @param driver the WebDriver instance
     */
    public static void scrollToText(final WebDriver driver, final String text) {
        ElementFinder.findElementPresence(AppiumBy.androidUIAutomator(String.format(
                        "new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));", text)),
                driver);
    }

    /**
     * Executes JavaScript to set the value of an element.
     *
     * @param locator the By locator used to find the element
     * @param driver  the WebDriver instance
     * @param keys    the keys to send to the element
     */
    private static void executeJavaScriptSetValue(final By locator, final WebDriver driver, String... keys) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].value = arguments[1];",
                ElementFinder.findElementVisibility(locator, driver), String.join("", keys));
    }

    /**
     * Executes JavaScript to click an element.
     *
     * @param locator the By locator used to find the element
     * @param driver  the WebDriver instance
     */
    private static void executeJavaScriptClick(final By locator, final WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",
                ElementFinder.findElementPresence(locator, driver));
    }
}