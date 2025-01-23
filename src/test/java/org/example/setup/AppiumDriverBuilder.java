package org.example.setup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.example.utils.PropertyReader;
import org.openqa.selenium.Platform;

public class AppiumDriverBuilder {

    public static AndroidDriver createDriver(AppiumDriverLocalService service, String configPath) {
        PropertyReader propertyReader = new PropertyReader(configPath);
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(Platform.ANDROID.name())
                .setDeviceName(propertyReader.getProperty("deviceName"))
                .setPlatformVersion(propertyReader.getProperty("platformVersion"))
                // .setAppPackage("")
                // .setAppActivity("")
                .setAutomationName(propertyReader.getProperty("driver"))
                .setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\" + propertyReader.getProperty("app"));
                // .noReset(); // Prevents reinstalling the app for every test run

        return new AndroidDriver(service.getUrl(), options);
    }
}