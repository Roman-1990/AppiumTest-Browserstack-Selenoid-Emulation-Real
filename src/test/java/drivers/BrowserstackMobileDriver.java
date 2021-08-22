package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static config.BrowserstackProject.browserstackConfig;

public class BrowserstackMobileDriver implements WebDriverProvider {


    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {

        // Set your access credentials
        capabilities.setCapability("browserstack.user", browserstackConfig.userLogin());
        capabilities.setCapability("browserstack.key", browserstackConfig.userKey());

        // Set URL of the application under test
        capabilities.setCapability("app", browserstackConfig.androidAppUrl());

        // Specify device and os_version for testing
        capabilities.setCapability("device", browserstackConfig.device());
        capabilities.setCapability("os_version", browserstackConfig.os_version());

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
                    browserstackConfig.webUrl(),
                    browserstackConfig.userLogin(),
                    browserstackConfig.userKey())
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
