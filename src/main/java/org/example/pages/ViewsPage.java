package org.example.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.utils.ElementActions;
import org.openqa.selenium.By;

public class ViewsPage {
    private AndroidDriver driver;
    public ViewsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By spinnerTab = AppiumBy.accessibilityId("Spinner");


    // Actions
    public ViewsPage navigateToSpinnerTab() {
        ElementActions.scrollToText(driver, "Spinner");
        ElementActions.click(spinnerTab, driver);
        return this;
    }

}
