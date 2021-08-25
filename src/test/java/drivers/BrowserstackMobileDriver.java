package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static config.Project.deviceConfig;

public class BrowserstackMobileDriver implements WebDriverProvider {


    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {

        // Set your access credentials
        capabilities.setCapability("browserstack.user", deviceConfig.userLogin());
        capabilities.setCapability("browserstack.key", deviceConfig.userKey());

        // Set URL of the application under test
        capabilities.setCapability("app", deviceConfig.androidAppUrl());

        // Specify device and os_version for testing
        capabilities.setCapability("device", deviceConfig.device());
        capabilities.setCapability("os_version", deviceConfig.os_version());

        // Set other BrowserStack capabilities
        capabilities.setCapability("project", "First Java Project");
        capabilities.setCapability("build", "Java Android");
        capabilities.setCapability("name", "first_test");

        return new AndroidDriver<>(getBrowserstackUrl(), capabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(
                    String.format(
                    deviceConfig.webUrl(),
                    deviceConfig.userLogin(),
                    deviceConfig.userKey())
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
