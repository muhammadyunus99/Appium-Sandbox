package org.example.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.example.pages.HomePage;
import org.example.pages.SpinnerPage;
import org.example.pages.ViewsPage;
import org.example.setup.AppiumDriverBuilder;
import org.example.setup.AppiumServiceManager;
import org.testng.annotations.*;

public class BaseTest {

    protected AndroidDriver driver; // Accessible to subclasses
    private AppiumDriverLocalService service;
    private final String props = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";

    // Page Objects - Accessible in test classes
    protected HomePage homePage;
    protected ViewsPage viewsPage;
    protected SpinnerPage spinnerPage;

    //////////////////////////// Configuration Methods //////////////////////////////
    @BeforeClass
    public void setUpAppiumService() {
        // Start the Appium service
        service = AppiumServiceManager.getService(props);
        service.start();
    }

    @BeforeMethod
    public void setUpDriver() {
        // Initialize the driver
        driver = AppiumDriverBuilder.createDriver(service, props);
    }

    @BeforeMethod(dependsOnMethods = "setUpDriver")
    public void initializePages() {
        // Initialize page objects ONLY after the driver is ready
        homePage = new HomePage(driver);
        viewsPage = new ViewsPage(driver);
        spinnerPage = new SpinnerPage(driver);

    }

    @AfterMethod
    public void tearDownDriver() {
        // Quit the driver after each test
        if (driver != null) driver.quit();
    }

    @AfterClass
    public void tearDownAppiumService() {
        // Stop the Appium service
        if (service != null) service.stop();
    }
}