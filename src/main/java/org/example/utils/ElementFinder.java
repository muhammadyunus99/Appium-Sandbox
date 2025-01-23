package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementFinder {

    // Default wait timeout in seconds
    private static final int DEFAULT_WAIT_TIMEOUT = 30;

    /**
     * Waits for the element to be present in the DOM.
     *
     * @param locator the By locator used to find the element
     * @param driver  the WebDriver instance
     * @return the WebElement once it is found
     */
    protected static WebElement findElementPresence(final By locator, final WebDriver driver) {
        return createWebDriverWait(driver).until(driver1 -> driver.findElement(locator));
    }

    /**
     * Waits for the element to be present in the DOM and visible on the screen.
     *
     * @param locator the By locator used to find the element
     * @param driver  the WebDriver instance
     * @return the WebElement once it is found and visible
     */
    protected static WebElement findElementVisibility(final By locator, final WebDriver driver) {
        return createWebDriverWait(driver).until(driver1 -> {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed() ? element : null;
        });
    }

    /**
     * Creates a WebDriverWait instance with the default timeout.
     *
     * @param driver the WebDriver instance
     * @return a WebDriverWait instance
     */
    private static WebDriverWait createWebDriverWait(final WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIMEOUT));
    }
}