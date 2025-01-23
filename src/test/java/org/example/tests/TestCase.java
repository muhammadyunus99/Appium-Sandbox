package org.example.tests;

import org.example.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;



public class TestCase extends BaseTest {
    @Test
    public void initialTest() {
        homePage.navigateToViewsTab();
        viewsPage.navigateToSpinnerTab();
        Assert.assertTrue(spinnerPage.isColorFieldDisplayed(), "The color field is not displayed");
        Assert.assertTrue(spinnerPage.isPlanetFieldDisplayed(), "The planet field is not displayed");
    }
}
