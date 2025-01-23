package org.example.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.ElementActions;
import org.openqa.selenium.By;

public class SpinnerPage {
    private AndroidDriver driver;

    private final By colorField = AppiumBy.accessibilityId("Color:");
    private final By planetField = AppiumBy.accessibilityId("Planet:");

    public SpinnerPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isColorFieldDisplayed() {
        return ElementActions.isDisplayed(colorField, driver);
    }
    public boolean isPlanetFieldDisplayed() {
        return ElementActions.isDisplayed(planetField, driver);
    }
}
