package org.example.setup;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.example.utils.PropertyReader;

public class AppiumServiceManager {

    public static AppiumDriverLocalService getService(String configPath) {
        PropertyReader propertyReader = new PropertyReader(configPath);

        return new AppiumServiceBuilder()
                .withIPAddress(propertyReader.getProperty("ipAddress"))
                .usingPort(Integer.parseInt(propertyReader.getProperty("port")))
                .withArgument(() -> "--use-drivers", propertyReader.getProperty("driver"))
                .withArgument(() -> "--log-level", propertyReader.getProperty("logLevel"))
                .build();
    }
}