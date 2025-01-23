package org.example.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.ElementActions;
import org.openqa.selenium.By;

public class HomePage {
    private AndroidDriver driver;
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By preferenceTab = AppiumBy.accessibilityId("Preference");
    private final By viewsTab = AppiumBy.accessibilityId("Views");


    // Actions
    public HomePage navigateToPreferenceTab() {
        ElementActions.click(preferenceTab, driver);
        return this;
    }

    public HomePage navigateToViewsTab() {
        ElementActions.click(viewsTab, driver);
        return this;
    }
}
